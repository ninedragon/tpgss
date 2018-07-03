package com.zz.fault.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
	private Map<String,Object> getFalutReason(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("0", "短路");
		map.put("1", "异常漏电");
		map.put("2", "缺相");
		map.put("3", "停电");
		return map;
	}
	
	private Map<String,Object> getIsFalut(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("0", "否");
		map.put("1", "是");
		return map;
	}
	private Map<String,Object> isCancelled(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("0", "否");
		map.put("1", "是");
		return map;
	}
	
	@RequestMapping(value="init")
	public ModelAndView init(ModelMap modelMap){	
		
		ModelAndView modelAndView = new  ModelAndView("fault/index");
		modelAndView.addObject("leftMenuview", "7");//显示左侧菜单 0 个人中心 1用户中心 2 权限管理 3用电曲线数据 4设备管理 5实时监控7故障定位
		UUser token =  userService.selectByPrimaryKey(TokenManager.getToken().getId());
		modelAndView.addObject("token", token);//左侧上方管理员信息
		Map<String, Object> falutReasonMap  = this.getFalutReason();
		modelAndView.addObject("falutReasonMap", falutReasonMap);
//		modelAndView.addObject("isFalutMap", this.getIsFalut());
//		modelAndView.addObject("isCancelledMap", this.isCancelled());
		Set<String> kedySet = falutReasonMap.keySet();
		JSONArray jsonArrayFalutReason = new JSONArray();
		for (String key : kedySet) {
			JSONObject json = new JSONObject();
			json.put("key", key);
			json.put("value", falutReasonMap.get(key));
			jsonArrayFalutReason.add(json);
		}
		modelMap.put("jsonArrayFalutReason", jsonArrayFalutReason);
//		modelMap.put("isFalutMap", this.getIsFalut());
//		modelMap.put("isCancelledMap", this.isCancelled());
		return modelAndView;
	}
	
}
