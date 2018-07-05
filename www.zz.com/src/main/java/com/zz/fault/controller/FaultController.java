package com.zz.fault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zz.ammeter.service.AmmeterService;
import com.zz.common.controller.BaseController;
import com.zz.common.model.UUser;
import com.zz.core.shiro.token.manager.TokenManager;
import com.zz.epu.service.EpuService;
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
	AmmeterService ammeterService;
	
	@RequestMapping(value="init")
	public ModelAndView init(ModelMap modelMap){	
		
		ModelAndView modelAndView = new  ModelAndView("fault/index");
		modelAndView.addObject("leftMenuview", "7");//显示左侧菜单 0 个人中心 1用户中心 2 权限管理 3用电曲线数据 4设备管理 5实时监控7故障定位
		UUser token =  userService.selectByPrimaryKey(TokenManager.getToken().getId());
		modelAndView.addObject("token", token);//左侧上方管理员信息
		return modelAndView;
	}
	
}
