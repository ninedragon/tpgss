package com.zz.deviceAndData.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zz.common.controller.BaseController;
import com.zz.deviceAndData.bo.CmdBO;
import com.zz.deviceAndData.service.na.service.appAccessSecurity.Authentication;
import com.zz.deviceAndData.service.na.service.dataCollection.SubscribeNotification;
import com.zz.deviceAndData.service.na.service.signalingDelivery.PostAsynCommandV4;
import com.zz.edata.service.EdataService;
import com.zz.user.service.UUserService;

@Controller
@Scope(value = "prototype")
@RequestMapping("dad")
public class DADController extends BaseController {

	private static final int SUCCESS = 0;
	private static final int FAIL = 1;
	@Autowired
	EdataService edataService;
	@Autowired
	UUserService userService;
	private String filename;

	/**
	 * 
	 * @param modelMap
	 * @param pageNo
	 * @param findContent
	 * @return
	 */

	// 【1】北向应用controller
	@RequestMapping(value = "appSet")
	public ModelAndView na(ModelMap modelMap) {
		System.out.println("appSet");

		return new ModelAndView("dad/appSet");
	}

	// 【1.1】应用鉴权controller
	@RequestMapping(value = "authentication", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> authentication() {
		// Map<String, Object> msgmap =new HashMap<>();

		Map<String, Object> msgmap = null;
		try {
			msgmap = new Authentication().authentication();
		} catch (Exception e) {
			e.printStackTrace();
			msgmap.put("isSuccess", "鉴权出现异常");
			return msgmap;
		}
		msgmap.put("isSuccess", "鉴权正常");
		return msgmap;
		
		
	}
    
	// 【1.2】basecallback controller
	@RequestMapping(value = "callUrl", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> callUrl(String callbackBaseUrl, HttpServletRequest request) {
		Map<String, Object> msgmap = new HashMap<String ,Object>();
		try {
			msgmap = new SubscribeNotification().subscribeNotification(callbackBaseUrl);
		} catch (Exception e) {
			e.printStackTrace();
			msgmap.put("isSuccess", "设置回调url出现异常");
			return msgmap;
		}
		msgmap.put("isSuccess", "设置回调url正常");
		return msgmap;
		
	}
	// 【1.3】postAsynCommandV4 controller
	@RequestMapping(value = "postAsynCommandV4", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> postAsynCommandV4(CmdBO cmdBO, HttpServletRequest request) {
		 Map<String, Object> msgmap =new HashMap<>();
//		Map<String, Object> msgmap = null;
		try {
			msgmap = new PostAsynCommandV4().postAsynCommandV4(cmdBO);
		} catch (Exception e) {
			e.printStackTrace();
			msgmap.put("isSuccess", "发送命令异常");
			return msgmap;
		}
		msgmap.put("isSuccess", "发送命令正常");
		return msgmap;
		
	}
}
