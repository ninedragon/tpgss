package com.zz.user.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zz.common.controller.BaseController;
import com.zz.common.model.UUser;
import com.zz.common.utils.LoggerUtils;
import com.zz.core.shiro.token.manager.TokenManager;
import com.zz.user.manager.UserManager;
import com.zz.user.service.UUserService;

import net.sf.json.JSONObject;


@Controller
@Scope(value="prototype")
@RequestMapping("user")
public class UserCoreController extends BaseController {

	@Resource
	UUserService userService;
	/**
	 * 个人资料
	 * @return
	 */
	@RequestMapping(value="index",method=RequestMethod.GET)
	public ModelAndView userIndex(HttpServletRequest request){
		//张智 woodareCode begin 
		String action = request.getParameter("action");
			ModelAndView modelAndView = new ModelAndView("user/index");
			modelAndView.addObject("leftMenuview", "0");//显示左侧菜单 0 个人中心 1用户中心 2 权限管理 3用电曲线数据 4设备管理 5实时监控
			return modelAndView;
	}
	
	
	/**
	 * 偷懒一下，通用页面跳转
	 * @param page
	 * @return
	 */
	@RequestMapping(value="{page}",method=RequestMethod.GET)
	public ModelAndView toPage(@PathVariable("page")String page,HttpServletRequest request){
//		张智 woodareCode begin
/*		String action = request.getParameter("action");
		if("yes".equals(action)){//原始
		return new ModelAndView(String.format("user/%s", page));
		}else{
			ModelAndView modelAndView = new ModelAndView(String.format("woodare/user/%s", page));
			UUser token =  userService.selectByPrimaryKey(TokenManager.getToken().getId());
			modelAndView.addObject("token", token);
			modelAndView.addObject("leftMenuview", "0");//显示左侧菜单 0 个人中心 1用户中心 2 权限管理 3用电曲线数据 4设备管理 5实时监控
			return modelAndView;
		}*/
		//张智 woodareCode end
		
		ModelAndView modelAndView = new ModelAndView(String.format("user/%s", page));
		UUser token =  userService.selectByPrimaryKey(TokenManager.getToken().getId());
		modelAndView.addObject("token", token);
		modelAndView.addObject("leftMenuview", "0");//显示左侧菜单 0 个人中心 1用户中心 2 权限管理 3用电曲线数据 4设备管理 5实时监控
		return modelAndView;
	}
	/**
	 * 密码修改
	 * @return
	 */
	@RequestMapping(value="updatePswd",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updatePswd(String pswd,String newPswd){
		//根据当前登录的用户帐号 + 老密码，查询。
		String email = TokenManager.getToken().getEmail();
				pswd = UserManager.md5Pswd(email, pswd);
		UUser	user = userService.login(email, pswd);
		
		if("admin".equals(email)){
			resultMap.put("status", 300);
			resultMap.put("message", "管理员不准修改密码。");
			return resultMap;
		}
		
		if(null == user){
			resultMap.put("status", 300);
			resultMap.put("message", "密码不正确！");
		}else{
			user.setPswd(newPswd);
			//加工密码
			user = UserManager.md5Pswd(user);
			//修改密码
			userService.updateByPrimaryKeySelective(user);
			resultMap.put("status", 200);
			resultMap.put("message", "修改成功!");
			//重新登录一次
			TokenManager.login(user, Boolean.TRUE);
		}
		return resultMap;
	}
	/**
	 * 个人资料修改
	 * @return
	 */
	@RequestMapping(value="updateSelf",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> updateSelf(UUser entity){
		try {
			userService.updateByPrimaryKeySelective(entity);
			resultMap.put("status", 200);
			resultMap.put("message", "修改成功!");
		} catch (Exception e) {
			resultMap.put("status", 500);
			resultMap.put("message", "修改失败!");
			LoggerUtils.fmtError(getClass(), e, "修改个人资料出错。[%s]", JSONObject.fromObject(entity).toString());
		}
		return resultMap;
	}
}
