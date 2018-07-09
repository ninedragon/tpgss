package com.zz.fault.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	 //websocket服务层调用类
    @Autowired
    private WSMessageService wsMessageService;
	@RequestMapping(value="init")
	public ModelAndView init(ModelMap modelMap){	
		
		ModelAndView modelAndView = new  ModelAndView("fault/index");
		modelAndView.addObject("leftMenuview", "7");//显示左侧菜单 0 个人中心 1用户中心 2 权限管理 3用电曲线数据 4设备管理 5实时监控7故障定位
		UUser token =  userService.selectByPrimaryKey(TokenManager.getToken().getId());
		modelAndView.addObject("token", token);//左侧上方管理员信息
//		wsMessageService.sendToAllTerminal(token.getId()+"","{\"name\":\"falutNews\",\"key\":\"\"}");
//		wsMessageService.sendToAllTerminal(token.getId()+"","{\"name\":\"faultRendering\",\"key\":\"38f04bc0-6c40-4535-ba36-7dbc1d6d2536\"}");
		return modelAndView;
	}
	
	
	/**
	 * 查询故障列表管理
	 * @return
	 */
	@RequestMapping("queryList")
	public @ResponseBody Map<String,Object> queryList(String strKeyArray,String action,Integer pageNo,Integer pageSize,HttpServletRequest request,ModelMap map,FaultInfo faultInfo) {
		if(!"all".equals(action)){
			List<String> keyList = new ArrayList<String>();
			String sql = "";
			if(StringUtils.isNotEmpty(strKeyArray)){
				String[] arr = (strKeyArray +",").split(",");
				 sql = "  AND ( ";
				String temp = "";
				for (String key : arr) {
					if(null != key && !"".equals(key)){
						keyList.add(key);
						temp  += " temp.key_id = '"+key+"' OR ";
					}
				}
				temp = temp.substring(0, temp.lastIndexOf("OR "));
				sql += temp +"  ) ";
			}
			map.put("paramSQL", sql);
	//		map.put("keyList", keyList);
		}
		map.put("row_name", faultInfo.getRow_name());
		map.put("fault_type", faultInfo.getFault_type());
		Pagination<FaultInfo> page = faultService.findByPage(map,pageNo,pageSize);
		Map<String, Object> mapReturn  = new HashMap<String, Object>();
		mapReturn.put("page", page);
		return mapReturn;
	}
	

	/**
	 * 获取故障类型信息
	 * @param codeTypes
	 * @param session
	 * @return
	 */
	@RequestMapping("faultTypeList")
	@ResponseBody
	public Object faultTypeList(String codeTypes, HttpSession session) {
		List<String> codeTypeList = new ArrayList<String>();
		if(StringUtils.isNotEmpty(codeTypes)){
			String[] arr = (codeTypes +",").split(",");
			for (String codeType : arr) {
				codeTypeList.add(codeType);
			}
		}
		List<CodeInfo> typeList = faultService.selectTypeList(codeTypeList);
		for (CodeInfo codeInfo : typeList) {
			if(null != codeInfo.getREMARK() && !"".equals(codeInfo.getREMARK()))
				codeInfo.setCODE_NAME(codeInfo.getREMARK()+codeInfo.getCODE_NAME());
		}
		return typeList;
	}
	
	/**
	 * 根据箱变ID获取当前箱变下所有故障信息
	 * @param rootId
	 */
	@RequestMapping("selectFaultByRootId")
	@ResponseBody
	public  List<FaultRendering>  selectFaultByRootId(String strKeyArray)
	{
		String sql = "";
		if(StringUtils.isNotEmpty(strKeyArray)){
			String[] arr = (strKeyArray +",").split(",");
			 sql = "  AND ( ";
			String temp = "";
			for (String key : arr) {
				if(null != key && !"".equals(key)){
					temp  += " fault.key_id = '"+key+"' OR ";
				}
			}
			temp = temp.substring(0, temp.lastIndexOf("OR "));
			sql += temp +"  ) ";
		}
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("paramSQL", sql);
		List<FaultRendering> list = this.faultService.selectFaultByRootId(paramMap);
		return list;
	}
	
	/**
	 * 根据传递的KEY获取TOPO错误信息
	 * @param rootId
	 */
	@RequestMapping("selectTopoErrorByKeys")
	@ResponseBody
	public  List<TopoErrorInfo>  selectTopoErrorByKeys(HttpServletRequest request)
	{
		List<TopoErrorInfo>  list = new ArrayList<TopoErrorInfo>();
		String strBranchboxIDArray = request.getParameter("strBranchboxIDArray");
		String branchbox_sql = "";
		if(StringUtils.isNotEmpty(strBranchboxIDArray)){
			String[] arr = (strBranchboxIDArray +",").split(",");
			branchbox_sql = "  AND ( ";
			String temp = "";
			for (String key : arr) {
				if(null != key && !"".equals(key)){
					temp  += " key_id = '"+key+"' OR ";
				}
			}
			temp = temp.substring(0, temp.lastIndexOf("OR "));
			branchbox_sql += temp +"  ) ";
		}
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("paramSQL", branchbox_sql);
		List<TopoErrorInfo> listBranchbox = this.faultService.selectBranchboxErrorByKeys(paramMap);
		for (TopoErrorInfo topoErrorInfo : listBranchbox) {
			Map<String, Object> meterbox_map = new HashMap<String, Object>();
			meterbox_map.put("branchbox_error_id", topoErrorInfo.getKey());
			List<TopoErrorRelInfo> meterboxList =this.faultService.selectMeterboxErrorByKeys(meterbox_map);
			topoErrorInfo.setRel(meterboxList);
			list.add(topoErrorInfo);
		}
		return list;
	}
	
	
	/**
	 * 根据箱变ID获取当前箱变下所有故障信息
	 * @param rootId
	 */
	@RequestMapping("selectFaultNews")
	@ResponseBody
	public  List<FaultRendering>  selectFaultNews()
	{
		List<FaultRendering> list = this.faultService.selectFaultNews(null);
		return list;
	}
	/**
	 * 获取故障来源信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value="ajax_faultDetails",method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView ajax_faultDetails(String fault_base_id,String cation){
		ModelAndView modelAndView = new ModelAndView("fault/faultDetails");
		Map<String, Object> faultSourceMap = this.faultService.getFaultSourceMap(fault_base_id);
		modelAndView.addObject("faultSourceMap", faultSourceMap);
		modelAndView.addObject("cation", cation);
		return modelAndView;
	}
}
