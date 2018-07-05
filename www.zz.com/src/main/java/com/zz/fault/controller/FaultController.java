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
	
	@RequestMapping(value="init")
	public ModelAndView init(ModelMap modelMap){	
		
		ModelAndView modelAndView = new  ModelAndView("fault/index");
		modelAndView.addObject("leftMenuview", "7");//显示左侧菜单 0 个人中心 1用户中心 2 权限管理 3用电曲线数据 4设备管理 5实时监控7故障定位
		UUser token =  userService.selectByPrimaryKey(TokenManager.getToken().getId());
		modelAndView.addObject("token", token);//左侧上方管理员信息
		return modelAndView;
	}
	
	
	/**
	 * 查询故障列表管理
	 * @return
	 */
	@RequestMapping("queryList")
	public @ResponseBody Map<String,Object> queryList(Integer pageNo,Integer pageSize,HttpServletRequest request,ModelMap map,FaultInfo faultInfo) {
		map.put("row_name", faultInfo.getRow_name());
		map.put("fault_type", faultInfo.getFault_type());
		Pagination<FaultInfo> page = faultService.findByPage(map,pageNo,pageSize);
		Map<String, Object> mapReturn  = new HashMap<String, Object>();
		mapReturn.put("page", page);
		return mapReturn;
	}
	

	@RequestMapping("faultTypeList")
	@ResponseBody
	public Object getProvinces(String regionId, HttpSession session) {
		List<String> codeTypeList = new ArrayList<String>();
		codeTypeList.add("F0001");
		codeTypeList.add("F0002");
		codeTypeList.add("F0003");
		codeTypeList.add("F0004");
		List<CodeInfo> typeList = faultService.selectTypeList(codeTypeList);
		for (CodeInfo codeInfo : typeList) {
			if(null != codeInfo.getREMARK() && !"".equals(codeInfo.getREMARK()))
				codeInfo.setCODE_NAME(codeInfo.getREMARK()+codeInfo.getCODE_NAME());
		}
		return typeList;
	}
}
