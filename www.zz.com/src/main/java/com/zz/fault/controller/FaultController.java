package com.zz.fault.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zz.analysisAndDisplay.service.WSMessageService;
import com.zz.common.controller.BaseController;
import com.zz.common.model.CodeInfo;
import com.zz.common.model.FaultInfo;
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
	 //websocket服务层调用类
    @Autowired
    private WSMessageService wsMessageService;
	@RequestMapping(value="init")
	public ModelAndView init(ModelMap modelMap){	
		
		ModelAndView modelAndView = new  ModelAndView("fault/index");
		modelAndView.addObject("leftMenuview", "7");//显示左侧菜单 0 个人中心 1用户中心 2 权限管理 3用电曲线数据 4设备管理 5实时监控7故障定位
		UUser token =  userService.selectByPrimaryKey(TokenManager.getToken().getId());
		modelAndView.addObject("token", token);//左侧上方管理员信息
//		wsMessageService.sendToAllTerminal(token.getId()+"", "falut");
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
			if(null != strKeyArray && !"".equals(strKeyArray)){
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
	

	@RequestMapping("faultTypeList")
	@ResponseBody
	public Object faultTypeList(String codeTypes, HttpSession session) {
		List<String> codeTypeList = new ArrayList<String>();
		if(null != codeTypes && !"".equals(codeTypes)){
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
}
