package com.zz.fault.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zz.ammeter.service.AmmeterService;
import com.zz.analysisAndDisplay.service.WSMessageService;
import com.zz.common.controller.BaseController;
import com.zz.common.model.CalZInfo;
import com.zz.common.model.CodeInfo;
import com.zz.common.model.FaultInfo;
import com.zz.common.model.FaultRendering;
import com.zz.common.model.TopoErrorInfo;
import com.zz.common.model.TopoErrorRelInfo;
import com.zz.common.model.UUser;
import com.zz.core.mybatis.page.Pagination;
import com.zz.core.shiro.token.manager.TokenManager;
import com.zz.epu.service.EpuService;
import com.zz.fault.service.FaultService;
import com.zz.user.service.UUserService;

@Controller
@Scope(value = "prototype")
@RequestMapping("fault")
public class FaultController extends BaseController {
	@Autowired
	UUserService userService;
	@Autowired
	EpuService epuService;
	@Autowired
	FaultService faultService;

	@Autowired
	AmmeterService ammeterService;
	// websocket服务层调用类
	@Autowired
	private WSMessageService wsMessageService;

	@RequestMapping(value = "init")
	public ModelAndView init(ModelMap modelMap) {

		ModelAndView modelAndView = new ModelAndView("fault/index");
		modelAndView.addObject("leftMenuview", "7");// 显示左侧菜单 0 个人中心 1用户中心 2
													// 权限管理 3用电曲线数据 4设备管理
													// 5实时监控7故障定位
		UUser token = userService.selectByPrimaryKey(TokenManager.getToken().getId());
		modelAndView.addObject("token", token);// 左侧上方管理员信息
		// wsMessageService.sendToAllTerminal(token.getId()+"","{\"name\":\"falutNews\",\"key\":\"\"}");
		// wsMessageService.sendToAllTerminal(token.getId()+"","{\"name\":\"faultRendering\",\"key\":\"8bfa662e-f506-4d8c-8d4a-912a6b61dd06\"}");
		return modelAndView;
	}

	/**
	 * 查询故障列表管理
	 * 
	 * @return
	 */
	@RequestMapping("queryList")
	public @ResponseBody Map<String, Object> queryList(String strKeyArray, String action, Integer pageNo,
			Integer pageSize, HttpServletRequest request, ModelMap map, FaultInfo faultInfo) {
		String sql = "";
		if (!"all".equals(action)) {
			List<String> keyList = new ArrayList<String>();
			if (StringUtils.isNotEmpty(strKeyArray)) {
				String[] arr = (strKeyArray + ",").split(",");
				sql = "  AND ( ";
				String temp = "";
				for (String key : arr) {
					if (null != key && !"".equals(key)) {
						keyList.add(key);
						temp += " temp.key_id = '" + key + "' OR ";
					}
				}
				temp = temp.substring(0, temp.lastIndexOf("OR "));
				sql += temp + "  ) ";
			}
		}
		map.put("row_name", faultInfo.getRow_name());
		if(StringUtils.isNotEmpty(faultInfo.getFault_type())){
			List<String> faultTypeList = new ArrayList<String>();
			String[] arr = faultInfo.getFault_type().split(",");
			sql += "  AND ( ";
			String temp = "";
			for (String faultType : arr) {
				temp += "  temp.fault_type = '" + faultType + "' OR ";
			}
			temp = temp.substring(0, temp.lastIndexOf("OR "));
			sql += temp + "  ) ";
			map.put("faultTypeList", faultTypeList);
		}
		map.put("paramSQL", sql);
		map.put("is_repaired", faultInfo.getIs_repaired());
		map.put("str_occur_time", faultInfo.getStr_occur_time());
		Pagination<FaultInfo> page = faultService.findByPage(map, pageNo, pageSize);
		Map<String, Object> mapReturn = new HashMap<String, Object>();
		mapReturn.put("page", page);
		return mapReturn;
	}

	/**
	 * 获取故障类型信息
	 * 
	 * @param codeTypes
	 * @param session
	 * @return
	 */
	@RequestMapping("faultTypeList")
	@ResponseBody
	public Object faultTypeList(String codeTypes, String edit_type) {
		List<String> codeTypeList = new ArrayList<String>();
		if (StringUtils.isNotEmpty(codeTypes)) {
			String[] arr = (codeTypes + ",").split(",");
			for (String codeType : arr) {
				codeTypeList.add(codeType);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("codeTypeList", codeTypeList);
		if (StringUtils.isNotEmpty(edit_type)) {
			map.put("paramSQL", " AND EDIT_TYPE='" + edit_type + "' ");
		} else {
			map.put("paramSQL", " AND EDIT_TYPE IS NULL");
		}
		List<CodeInfo> typeList = faultService.selectTypeList(map);
		return typeList;
	}

	/**
	 * 根据箱变ID获取当前箱变下所有故障信息
	 * 
	 * @param rootId
	 */
	@RequestMapping("selectFaultByRootId")
	@ResponseBody
	public List<FaultRendering> selectFaultByRootId(String strKeyArray) {
		String sql = "";
		if (StringUtils.isNotEmpty(strKeyArray)) {
			String[] arr = (strKeyArray + ",").split(",");
			sql = "  AND ( ";
			String temp = "";
			for (String key : arr) {
				if (null != key && !"".equals(key)) {
					temp += " fault.key_id = '" + key + "' OR ";
				}
			}
			temp = temp.substring(0, temp.lastIndexOf("OR "));
			sql += temp + "  ) ";
		}
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("paramSQL", sql);
		List<FaultRendering> list = this.faultService.selectFaultByRootId(paramMap);
		return list;
	}
	

	/**
	 * 根据分支箱查询当前分支箱下所有表箱阻抗信息
	 * 
	 * @param rootId
	 */
	@RequestMapping("queryCalZList")
	@ResponseBody
	public List<CalZInfo> queryCalZList(String strKeyArray) {
		String sql = "";
		if (StringUtils.isNotEmpty(strKeyArray)) {
			String[] arr = (strKeyArray + ",").split(",");
			sql = "  AND ( ";
			String temp = "";
			for (String key : arr) {
				if (null != key && !"".equals(key)) {
					temp += " t_meterbox.branchBoxId = '" + key + "' OR ";
				}
			}
			temp = temp.substring(0, temp.lastIndexOf("OR "));
			sql += temp + "  ) ";
		}
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("paramSQL", sql);
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		paramMap.put("record_date", sdf.format(new Date()));
		List<CalZInfo> list = this.faultService.queryCalZList(paramMap);
		return list;
	}
	
	
	/**
	 * 根据传递的KEY获取TOPO错误信息
	 * 
	 * @param rootId
	 * @throws ParseException 
	 */
	@RequestMapping("selectTopoErrorByKeys")
	@ResponseBody
	public List<TopoErrorInfo> selectTopoErrorByKeys(HttpServletRequest request) throws ParseException {
		List<TopoErrorInfo> list = new ArrayList<TopoErrorInfo>();
		String strBranchboxIDArray = request.getParameter("strBranchboxIDArray");
		String branchbox_sql = "";
		if (StringUtils.isNotEmpty(strBranchboxIDArray)) {
			String[] arr = (strBranchboxIDArray + ",").split(",");
			branchbox_sql = "  AND ( ";
			String temp = "";
			for (String key : arr) {
				if (null != key && !"".equals(key)) {
					temp += " key_id = '" + key + "' OR ";
				}
			}
			temp = temp.substring(0, temp.lastIndexOf("OR "));
			branchbox_sql += temp + "  ) ";
		}
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("paramSQL", branchbox_sql);
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		Date beginDate = new Date();
		Calendar date = Calendar.getInstance();
		date.setTime(beginDate);
		date.set(Calendar.DATE, date.get(Calendar.DATE) - 1);//topo错误查询异常数据时，找前一天数据
		Date endDate = sdf.parse(sdf.format(date.getTime()));
		String record_date = sdf.format(endDate);
		paramMap.put("record_date", record_date);
		List<TopoErrorInfo> listBranchbox = this.faultService.selectBranchboxErrorByKeys(paramMap);
		for (TopoErrorInfo topoErrorInfo : listBranchbox) {
			Map<String, Object> meterbox_map = new HashMap<String, Object>();
			meterbox_map.put("branchbox_error_id", topoErrorInfo.getId());
			meterbox_map.put("record_date", record_date);
			List<TopoErrorRelInfo> meterboxList = this.faultService.selectMeterboxErrorByKeys(meterbox_map);
			topoErrorInfo.setRel(meterboxList);
			list.add(topoErrorInfo);
		}
		return list;
	}

	/**
	 * 根据箱变ID获取当前箱变下所有故障信息
	 * 
	 * @param rootId
	 */
	@RequestMapping("selectFaultNews")
	@ResponseBody
	public List<FaultRendering> selectFaultNews() {
		List<FaultRendering> list = this.faultService.selectFaultNews(null);
		return list;
	}

	/**
	 * 获取故障来源信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "ajax_faultDetails", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView ajax_faultDetails(String fault_base_id, String cation) {
		ModelAndView modelAndView = new ModelAndView("fault/faultDetails");
		Map<String, Object> faultSourceMap = this.faultService.getFaultSourceMap(fault_base_id);
		modelAndView.addObject("faultSourceMap", faultSourceMap);
		modelAndView.addObject("cation", cation);
		return modelAndView;
	}
}
