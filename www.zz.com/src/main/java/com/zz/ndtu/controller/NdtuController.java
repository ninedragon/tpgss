package com.zz.ndtu.controller;

import java.util.HashMap;
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
import com.zz.common.model.Dtu;
import com.zz.common.model.UUser;
import com.zz.common.utils.LoggerUtils;
import com.zz.core.mybatis.page.Pagination;
import com.zz.core.shiro.session.CustomSessionManager;
import com.zz.core.shiro.token.manager.TokenManager;
import com.zz.ndtu.service.NdtuService;
import com.zz.user.service.UUserService;

@Controller
@Scope(value = "prototype")
@RequestMapping("nDtu")
public class NdtuController extends BaseController {
	

	/***
	 * 用户手动操作Session
	 * */
	@Autowired
	CustomSessionManager customSessionManager;
	@Autowired
	UUserService userService;
	@Autowired
	NdtuService dtuService;

	@RequestMapping(value="showDtuList")
	public ModelAndView showDtuList(ModelMap map){	
		
		ModelAndView modelAndView = new  ModelAndView("woodare/dtu/showNdtuList");
		modelAndView.addObject("leftMenuview", "6");//显示左侧菜单 0 个人中心 1用户中心 2 权限管理 3用电曲线数据 4设备管理 5实时监控 6终端管理
		UUser token =  userService.selectByPrimaryKey(TokenManager.getToken().getId());
		modelAndView.addObject("token", token);//左侧上方管理员信息
		return modelAndView;
	}
	
	/**
	 * 查询设备管理
	 * @return
	 */
	@RequestMapping("queryDtuList")
	public @ResponseBody Map<String,Object> queryDtuList(Integer pageNo,Integer pageSize,HttpServletRequest request,ModelMap map,Dtu dtu) {
		
		map.put("cDistrictbcdid", dtu.getcDistrictbcdid());
		map.put("cAddressid", dtu.getcAddressid());
		map.put("cInstalldateBegin", dtu.getcInstalldateBegin());
		map.put("cInstalldateEnd", dtu.getcInstalldateEnd());
		Pagination<Dtu> page = dtuService.findByPage(map,pageNo,pageSize);
		Map<String, Object> mapReturn  = new HashMap<String, Object>();
		mapReturn.put("page", page);
		return mapReturn;
	}
	
	/**
	 * 插入数据
	 * @return
	 */
	@RequestMapping("updateDtu")
	@ResponseBody
	public Map<String,Object> updateDtu(Dtu dtu, HttpServletRequest request){
		 Map<String, Object> retureMap=new HashMap<String,Object>();
		try {
			Long userId = TokenManager.getUserId();
			Integer id=dtu.getId();
			String flag="0";//0:插入 1：更新
			if(id!=null)
			{
				flag="1";
			}			
			 retureMap=dtuService.updateDtu(dtu,flag);
			 //如果是更新，使用当前更新的Id，如果是插入，使用插入的Id
			 if(id!=null)
				{
				 retureMap.put("id", id);
				}
			
		} catch (Exception e) {
			retureMap.put("status", 0);
			logger.error("errorMessage:" + e.getMessage());
			LoggerUtils.fmtError(getClass(), e, "更新数据失败，%s。", e.getMessage());
		}
		return retureMap;
	}
	
	@RequestMapping("delDtu")
	@ResponseBody
	public Map<String,Object> delDtu(String id, String  epuType,HttpServletRequest request){
		 Map<String, Object> retureMap=new HashMap<String,Object>();
		try {
			
			retureMap=dtuService.delDtu(Integer.valueOf(id));
			
		} catch (Exception e) {
			retureMap.put("status", 0);
			logger.error("errorMessage:" + e.getMessage());
			LoggerUtils.fmtError(getClass(), e, "删除数据失败，%s。", e.getMessage());
		}
		return retureMap;
	}
	@RequestMapping("editInit")
	@ResponseBody
	public Object editInit(HttpServletRequest request,HttpSession session,String id) {
		Dtu dtu= dtuService.selectDtuByRowId(Integer.valueOf(id));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dtu", dtu);
		return map;
	}

}
