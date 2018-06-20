package com.zz.fault.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zz.ammeter.service.AmmeterService;
import com.zz.common.controller.BaseController;
import com.zz.common.model.TAmmeterInfo;
import com.zz.common.model.TEpuInfo;
import com.zz.common.model.UUser;
import com.zz.core.mybatis.page.Pagination;
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
	
	

	/**
	 * 查询设备列表管理
	 * @return
	 */
	@RequestMapping("queryEpuList")
	public @ResponseBody Map<String,Object> queryEpuList(Integer pageNo,Integer pageSize,HttpServletRequest request,ModelMap map) {
		String param_epuName = request.getParameter("epuName");
		String param_falutOccurrenceTime = request.getParameter("falutOccurrenceTime");
		String param_falutReason = request.getParameter("falutReason");
		String param_isFalut = request.getParameter("isFalut");
		String param_falutRepairTime = request.getParameter("falutRepairTime");
		String param_isCancelled = request.getParameter("isCancelled");
		Pagination page =  new Pagination();
		Map<String, Object> mapReturn  = new HashMap<String, Object>();
		
		String stringData = request.getParameter("stringData");
		net.sf.json.JSONArray jsonarray = net.sf.json.JSONArray.fromObject(stringData);
		
		net.sf.json.JSONArray newArray = new net.sf.json.JSONArray();
		if(jsonarray.size()>0){
		  Map<String, Object> mapFalutReason = this.getFalutReason();
		  Map<String, Object> mapIsFalut = this.getIsFalut();
		  Map<String, Object> mapIsCancelled = this.isCancelled();
		  for(int i = 0;i < jsonarray.size();i++){
		    JSONObject json = jsonarray.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
		    String type = (String)json.get("type");//类型
		    String key = (String)json.get("key");//ID
			String epuName = "";
		    if("meter".equals(type)){
		    	List <TAmmeterInfo> amInfoList= ammeterService.selectEpuInfoByRowId(key,"");
		    	if(null != amInfoList && amInfoList.size() > 0){
					epuName = amInfoList.get(0).getAmmeterName();
				}
		    }else{
				List <TEpuInfo> epuInfos = epuService.selectEpuInfoByRowId(key);
				if(null != epuInfos && epuInfos.size() > 0){
					epuName = epuInfos.get(0).getEpuName();
				}
		    }
		    json.put("epuName", epuName);
		    String faultType = (String)json.get("faultType");
		    String falutReason= (String) mapFalutReason.get(faultType);
		    json.put("falutReason", falutReason);
		    String isFalut= (String) mapIsFalut.get(json.get("is_repaired"));
		    json.put("isFalut", isFalut);
		    String isCancelled= (String) mapIsCancelled.get(json.get("is_cancelled"));
		    json.put("isCancelled", isCancelled);
		    if(("".equals(param_epuName) || null == param_epuName) && ("".equals(param_falutReason) || null == param_falutReason)){
		    	newArray.add(json); 
		    }else if((!"".equals(param_epuName) && null != param_epuName) && (!"".equals(param_falutReason) && null != param_falutReason)){
		    	 if((faultType.equals(param_falutReason) || faultType == param_falutReason) && epuName.indexOf(param_epuName) !=-1){
				    	newArray.add(json);
				  }
		    }else if(("".equals(param_epuName) || null == param_epuName) && (!"".equals(param_falutReason) && null != param_falutReason)){
		    	if(faultType.equals(param_falutReason) || faultType == param_falutReason){
			    	newArray.add(json);
			    }
		    }else if((!"".equals(param_epuName) && null != param_epuName) && ("".equals(param_falutReason)  || null == param_falutReason)){
		    	if(epuName.indexOf(param_epuName) !=-1 ){
			    	newArray.add(json);
			    }
		    }
		  }
		}
		page.setList(newArray);
//		pageNo = null == pageNo ?0: pageNo;
//	  page.setPageNo(pageNo);
	  page.setPageSize(pageSize);
	  page.setFilterNo(0);
		mapReturn.put("page", page);
		return mapReturn;
	}
}
