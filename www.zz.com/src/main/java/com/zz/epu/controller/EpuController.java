package com.zz.epu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.StringUtils;
import com.zz.ammeter.service.AmmeterService;
import com.zz.common.controller.BaseController;
import  com.zz.common.model.Item;
import com.zz.common.model.TAmmeterInfo;
import com.zz.common.model.TEpuInfo;
import com.zz.common.model.TSyCityInfoBean;
import com.zz.common.model.TSyprovincesInfoBean;
import com.zz.common.model.UUser;
import com.zz.common.utils.LoggerUtils;
import com.zz.core.mybatis.page.Pagination;
import com.zz.core.shiro.session.CustomSessionManager;
import com.zz.core.shiro.token.manager.TokenManager;
import com.zz.epu.service.EpuService;
import com.zz.user.service.UUserService;

@Controller
@Scope(value = "prototype")
@RequestMapping("epu")
public class EpuController extends BaseController {
	

	/***
	 * 用户手动操作Session
	 * */
	@Autowired
	CustomSessionManager customSessionManager;
	@Autowired
	UUserService userService;
	@Autowired
	EpuService epuService;
	@Autowired
	AmmeterService ammeterService;

	/**
	 * 查询设备列表管理
	 * @return
	 */
	@RequestMapping("queryEpuList")
	public @ResponseBody Map<String,Object> queryEpuList(Integer pageNo,Integer pageSize,HttpServletRequest request,ModelMap map,TEpuInfo epuinfo) {
		map.put("epuProvince", epuinfo.getEpuProvince());
		map.put("epuCity", epuinfo.getEpuCity());
		map.put("epuDistrict", epuinfo.getEpuDistrict());
		map.put("epuType", epuinfo.getEpuType());
		map.put("epuName", epuinfo.getEpuName());
		map.put("findContent", epuinfo.getDistrictId());
		Pagination<TEpuInfo> page = epuService.findByPage(map,pageNo,pageSize);
		Map<String, Object> mapReturn  = new HashMap<String, Object>();
		mapReturn.put("page", page);
		return mapReturn;
	}
	
/*	@RequestMapping(value="mapMark")
	public ModelAndView mapMark(ModelMap map){		
		return new ModelAndView("epu/mapMark");
	}*/
	@RequestMapping(value="showSubstainList")
	public ModelAndView showSubstainList(ModelMap map){	
		
		ModelAndView modelAndView = new  ModelAndView("substain/showList");
		modelAndView.addObject("leftMenuview", "4");//显示左侧菜单 0 个人中心 1用户中心 2 权限管理 3用电曲线数据 4设备管理 5实时监控
		UUser token =  userService.selectByPrimaryKey(TokenManager.getToken().getId());
		modelAndView.addObject("token", token);//左侧上方管理员信息
		return modelAndView;
	}
	
	@RequestMapping(value="showOutgoingcabinetList")
	public ModelAndView showOutgoingcabinetList(ModelMap map){	
		
		ModelAndView modelAndView = new  ModelAndView("outgoingcabinet/showList");
		modelAndView.addObject("leftMenuview", "4");//显示左侧菜单 0 个人中心 1用户中心 2 权限管理 3用电曲线数据 4设备管理 5实时监控
		UUser token =  userService.selectByPrimaryKey(TokenManager.getToken().getId());
		modelAndView.addObject("token", token);//左侧上方管理员信息
		return modelAndView;
	}
	
	
	@RequestMapping(value="showBranchboxList")
	public ModelAndView showBranchboxList(ModelMap map){	
		
		ModelAndView modelAndView = new  ModelAndView("branchbox/showList");
		modelAndView.addObject("leftMenuview", "4");//显示左侧菜单 0 个人中心 1用户中心 2 权限管理 3用电曲线数据 4设备管理 5实时监控
		UUser token =  userService.selectByPrimaryKey(TokenManager.getToken().getId());
		modelAndView.addObject("token", token);//左侧上方管理员信息
		return modelAndView;
	}
	
	
	@RequestMapping(value="showMeterboxList")
	public ModelAndView showMeterboxList(ModelMap map){	
		
		ModelAndView modelAndView = new  ModelAndView("meterbox/showList");
		modelAndView.addObject("leftMenuview", "4");//显示左侧菜单 0 个人中心 1用户中心 2 权限管理 3用电曲线数据 4设备管理 5实时监控
		UUser token =  userService.selectByPrimaryKey(TokenManager.getToken().getId());
		modelAndView.addObject("token", token);//左侧上方管理员信息
		return modelAndView;
	}
	
	@RequestMapping(value="allShowList", method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView allShowList(HttpServletRequest request,ModelMap map){	
		String substainRowId = request.getParameter("substainRowId");
		String action = request.getParameter("action");
		ModelAndView modelAndView = new  ModelAndView("show/allShowList");
		modelAndView.addObject("leftMenuview", "5");//显示左侧菜单 0 个人中心 1用户中心 2 权限管理 3用电曲线数据 4设备管理 5实时监控
		UUser token =  userService.selectByPrimaryKey(TokenManager.getToken().getId());
		modelAndView.addObject("token", token);//左侧上方管理员信息
		modelAndView.addObject("substainRowId", substainRowId);//左侧上方管理员信息
		modelAndView.addObject("action", action);//执行动作 falut 表示默认展示topo错误数据
		return modelAndView;
	}
	
/*	@RequestMapping(value="add")
	public ModelAndView addEpu(ModelMap map){
		ModelAndView modelAndView = new  ModelAndView("epu/add");
		modelAndView.addObject("leftMenuview", "4");//显示左侧菜单 0 个人中心 1用户中心 2 权限管理 3用电曲线数据 4设备管理 5实时监控
		return  modelAndView;
	}*/
	
/*	@RequestMapping("linkMap")
	public String linkMap(ModelMap map,HttpServletRequest request,HttpSession session,String rowId) {
		List <TEpuInfo> epuInfos= epuService.selectEpuInfoByRowId(rowId);
		map.put("epuInfo", epuInfos.get(0));
		return "epu/edit";
	}*/
	
	@RequestMapping("editInit")
	@ResponseBody
	public Object editInit(HttpServletRequest request,HttpSession session,String rowId) {
		List <TEpuInfo> epuInfo= epuService.selectEpuInfoByRowId(rowId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("epuInfo", epuInfo.get(0));
		return map;
	}
	
	@RequestMapping("queryEpu")
	@ResponseBody
	public Object queryEpu(HttpServletRequest request,HttpSession session,TEpuInfo epuinfo) {		 
		List <TEpuInfo> epuInfos = epuService.selectEpuInfoByMark(epuinfo);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("epuInfos", epuInfos);
		return map;
	}
	
	@RequestMapping("queryEpuByRowId")
	@ResponseBody
	public Object queryEpuByRowId(HttpServletRequest request,HttpSession session,String rowId) {		 
		List <TEpuInfo> epuInfos = epuService.selectEpuInfoByRowId(rowId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("epuInfos", epuInfos);
		return map;
	}
	@RequestMapping("chanceAllType")
	@ResponseBody
	public Object getAllChanceType(ModelMap map,
			TEpuInfo tEpuInfo, HttpServletRequest request)
			throws Exception {
		Map<String, Object> allChanceType = epuService.getAllChanceType();
		return allChanceType;
	}
	
	@RequestMapping("getEpuCodeByCode")
	@ResponseBody
	public Object getEpuCodeByCode(ModelMap map,
			 HttpServletRequest request,String code)
			throws Exception {
		Map<String, Object> epuMap = epuService.getEpuCodeByCode(code);
		return epuMap;
	}
	
	@RequestMapping("getParentEpu")
	@ResponseBody
	public Object getParentEpu(ModelMap map,
			 HttpServletRequest request,String epuType,String epuDistrict)
			throws Exception {
		Map<String, Object> epuMap = epuService.getParentEpu(epuType, epuDistrict);
		return epuMap;
	}
	
@RequestMapping("getProvinces")
	@ResponseBody
	public Object getProvinces(String regionId, HttpSession session) {
		Long userId = TokenManager.getUserId();
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId+"");
		return epuService.getProvinces(map);
	}
	
	

	@RequestMapping("getCity")
	@ResponseBody
	public Object getCity(String provinceId, String districtFlag,
			HttpSession session) {
		Long userId = TokenManager.getUserId();
		Map<String, String> map = new HashMap<String, String>();
		map.put("provinceId", provinceId);
		map.put("districtFlag", districtFlag);
		map.put("userId", userId+"");
		return epuService.getCity(map);
	}
	


	@RequestMapping("getCityDistrict")
	@ResponseBody
	public Object getCityDistrict(String cityId) {
		return epuService.getCityDistrict(cityId);
	}
	
	@RequestMapping("selectBdtuDistrictId")
	@ResponseBody
	public Object selectBdtuDistrictId() {
		return epuService.selectBdtuDistrictId();
	}
	
	@RequestMapping("selectBdtuAddressIdByDistrictId")
	@ResponseBody
	public Object selectBdtuAddressIdByDistrictId(String districtId) {
		return epuService.selectBdtuAddressIdByDistrictId(districtId);
	}
	
	@RequestMapping("selectBdtuDIstinctByChannelId")
	@ResponseBody
	public Object selectBdtuDIstinctByChannelId(String districtId,String addressId)
 {
		return epuService.selectBdtuDIstinctByChannelId(districtId, addressId);
	}
	
	
	@RequestMapping("selectNdtuDistrictId")
	@ResponseBody
	public Object selectNdtuDistrictId() {
		return epuService.selectNdtuDistrictId();
	}
	
	@RequestMapping("selectNdtuAddressIdByDistrictId")
	@ResponseBody
	public Object selectNdtuAddressIdByDistrictId(String districtId) {
		return epuService.selectNdtuAddressIdByDistrictId(districtId);
	}
	
	@RequestMapping("selectNdtuDIstinctByChannelId")
	@ResponseBody
	public Object selectNdtuDIstinctByChannelId(String districtId,String addressId)
 {
		return epuService.selectNdtuDIstinctByChannelId(districtId, addressId);
	}
	/**
	 * 插入数据
	 * @return
	 */
	@RequestMapping("updateEpuInfo")
	@ResponseBody
	public Map<String,Object> updateEpuInfo(TEpuInfo tEpuInfo, HttpServletRequest request){
		 Map<String, Object> retureMap=new HashMap<String,Object>();
		try {
			Long userId = TokenManager.getUserId();
			String rowId=tEpuInfo.getRowId();
			String flag="0";//0:插入 1：更新
			if(StringUtils.isEmpty(rowId))
			{
				rowId=UUID.randomUUID().toString();
				tEpuInfo.setCreateId(userId+"");
				tEpuInfo.setUpdateId(userId+"");
				tEpuInfo.setRowId(rowId);
			}
			else
			{
				flag="1";
				tEpuInfo.setUpdateId(userId+"");
			}
			
			 retureMap=epuService.updateEpuInfo(tEpuInfo,flag);
			 retureMap.put("rowId", rowId);
		} catch (Exception e) {
			retureMap.put("status", 0);
			logger.error("errorMessage:" + e.getMessage());
			LoggerUtils.fmtError(getClass(), e, "更新数据失败，%s。", e.getMessage());
		}
		return retureMap;
	}
	
	@RequestMapping("delEpuInfo")
	@ResponseBody
	public Map<String,Object> delEpuInfo(String rowId, String  epuType,HttpServletRequest request){
		 Map<String, Object> retureMap=new HashMap<String,Object>();
		try {
			TEpuInfo tEpuInfo=new TEpuInfo();
			tEpuInfo.setRowId(rowId);
			tEpuInfo.setEpuType(epuType);
			retureMap=epuService.delEpuInfo(tEpuInfo);
			
		} catch (Exception e) {
			retureMap.put("status", 0);
			logger.error("errorMessage:" + e.getMessage());
			LoggerUtils.fmtError(getClass(), e, "删除数据失败，%s。", e.getMessage());
		}
		return retureMap;
	}

	
	/*
	 * 设备名称区域性校验，保证同区域下设备名车下的唯一性
	 */
	@RequestMapping("checkEpName")
	@ResponseBody
	public Map<String,Object> checkEpName(String rowId, HttpServletRequest request ,String epuName,String epuDistrict,String epuType){
		 Map<String, Object> retureMap=new HashMap<String,Object>();
		try {
			retureMap=epuService.checkEpName(epuName,epuDistrict,epuType);
			
		} catch (Exception e) {
			retureMap.put("status", "");
			logger.error("errorMessage:" + e.getMessage());
			LoggerUtils.fmtError(getClass(), e, "删除数据失败，%s。", e.getMessage());
		}
		return retureMap;
	}
	
	@RequestMapping("delMark")
	@ResponseBody
	public Map<String,Object> delMark(String rowId, HttpServletRequest request){
		 Map<String, Object> retureMap=new HashMap<String,Object>();
		try {
			retureMap=epuService.delMark(rowId);
			
		} catch (Exception e) {
			retureMap.put("status", 0);
			logger.error("errorMessage:" + e.getMessage());
			LoggerUtils.fmtError(getClass(), e, "删除数据失败，%s。", e.getMessage());
		}
		return retureMap;
	}
/*	 private static void ListSort(List<Object> list) {
	        Collections.sort(list, new Comparator<Object>() {
	            @Override
	            public int compare(Object o1, Object o2) {
	                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	                try {
	                	
	                    Date dt1 = format.parse(o1.updateTime);
	                    Date dt2 = format.parse(o2.getBirthday());
	                    if (dt1.getTime() > dt2.getTime()) {
	                        return 1;
	                    } else if (dt1.getTime() < dt2.getTime()) {
	                        return -1;
	                    } else {
	                        return 0;
	                    }
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                return 0;
	            }
	        });
	    }*/
	
	@RequestMapping("getEupInfosTree")
	@ResponseBody
	public  List  getEupInfosTree( String rowId,String rootId,String epuProvince,String epuCity,String epuDistrict)
 {
		List<Object> objectAllList=new ArrayList<Object>();
		 TEpuInfo tEpuInfo=new TEpuInfo();
		////通过箱变的Id,获取所有的设备信息以及电表信息
		if(rootId!=null && rootId!="")
		{
			
			tEpuInfo.setEpuParentId(rootId);
			List<TEpuInfo> epuInfoList= epuService.selectEpuInfos(tEpuInfo);
			objectAllList.addAll(epuInfoList);
			//通过parentID获取电表信息
			for(int i=0;i<epuInfoList.size();i++)
			{				
				if("M0004".equals(epuInfoList.get(i).getEpuType()))
				{
					String amEquId=epuInfoList.get(i).getRowId().toString();
					List <TAmmeterInfo> amInfoList= ammeterService.selectEpuInfoByRowId("",amEquId);
					if(amInfoList!=null && amInfoList.size()>0)
					{
						objectAllList.addAll(amInfoList);
					}
				}
			}
			
		}
		//通过区域获取 箱变信息，再通过遍历箱变获取每一个箱变的遍历 设备信息和电表信息
/*		if(epuDistrict!=null && epuDistrict!="")
		{
			TEpuInfo tEpuInfoAll=new TEpuInfo();
			tEpuInfoAll.setEpuProvince(epuProvince);
			tEpuInfoAll.setEpuCity(epuCity);
			tEpuInfoAll.setEpuDistrict(epuDistrict);
			tEpuInfoAll.setEpuType("M0001");
			List<TEpuInfo> epuInfoListTmp= epuService.selectEpuInfos(tEpuInfoAll);
			for(int j=0;j<epuInfoListTmp.size();j++)
			{
				String epuParentIdTmp=epuInfoListTmp.get(j).getRowId();
				if(epuParentIdTmp!=null && epuParentIdTmp!="")
				{
					//通过箱变的Id,获取所有的设备信息以及电表信息				
					tEpuInfo.setEpuParentId(epuParentIdTmp);
					List<TEpuInfo> epuInfoListDistrict= epuService.selectEpuInfos(tEpuInfo);
					objectAllList.addAll(epuInfoListDistrict);
					//通过parentID获取电表信息
					for(int i=0;i<epuInfoListDistrict.size();i++)
					{				
						if("M0004".equals(epuInfoListDistrict.get(i).getEpuType()))
						{
							String amEquId=epuInfoListDistrict.get(i).getRowId().toString();
							List <TAmmeterInfo> amInfoList= ammeterService.selectEpuInfoByRowId("",amEquId);
							if(amInfoList!=null && amInfoList.size()>0)
							{
								objectAllList.addAll(amInfoList);
							}
						}
					}
				}
				
			}
			
		}*/
		
		return objectAllList;
		
	}
	

	
	
	@RequestMapping("showProvince") 
	@ResponseBody
	public List<Item> showProvince(HttpServletRequest request){ 
		
		Map<String, String> map = new HashMap<String, String>();
		List<TSyprovincesInfoBean> allList=(List<TSyprovincesInfoBean>)epuService.getProvincesByEp(map);
	    List<Item> list = new ArrayList<Item>(allList.size());
	    for(TSyprovincesInfoBean p : allList){
	        Item item = new Item();
	        item.setId(p.getProvinceId());
	        item.setpId("0");
	        item.setpName("");
	        item.setName(p.getProvinceNameCn());
	        item.setIsParent("true");
	        item.setType(0);
	        list.add(item);
	    }
	       return list; 
	  }
	
	@RequestMapping("showCity") 
	@ResponseBody
	public List<Item> showCity(HttpServletRequest request,String pId,String pName){ 
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("provinceId", pId);
		map.put("districtFlag", "0");
		List<TSyCityInfoBean> allList=(List<TSyCityInfoBean>)epuService.getCityByEp(map);
	    List<Item> list = new ArrayList<Item>(allList.size());
	    for(TSyCityInfoBean p : allList){
	        Item item = new Item();
	        item.setId(p.getCityCode());
	        item.setpId(pId);
	        item.setpName(pName);
	        item.setName(p.getCityNameCn());
	        item.setIsParent("true");
	        item.setType(1);
	        list.add(item);
	    }
	       return list; 
	  }
	
	@RequestMapping("showCounty") 
	@ResponseBody
	public List<Item> showCounty(HttpServletRequest request,String pId,String pName){ 
		
		List<TSyCityInfoBean> allList=(List<TSyCityInfoBean>)epuService.getCityDistrictByEp(pId);
	    List<Item> list = new ArrayList<Item>(allList.size());
	    for(TSyCityInfoBean p : allList){
	        Item item = new Item();
	        item.setId(p.getCityCode());
	        item.setpId(pId);
	        item.setpName(pName);
	        item.setName(p.getCityNameCn());
	        item.setIsParent("true");
	        item.setType(2);
	        list.add(item);
	    }
	       return list; 
	  }
	
	
	@RequestMapping("showEpuInfo") 
	@ResponseBody
	public List<Item> showEpuInfo(HttpServletRequest request,String pId){ 
		 TEpuInfo tEpuInfo=new TEpuInfo();
		 tEpuInfo.setEpuDistrict(pId);
		 List <TEpuInfo> epuInfoList = epuService.selectEpuInfoByMark(tEpuInfo);
	    List<Item> list = new ArrayList<Item>(epuInfoList.size());
	    for(TEpuInfo p : epuInfoList){
	        Item item = new Item();
	        item.setId(p.getRowId());
	        item.setpId(pId);
	        item.setName(p.getEpuName());
	        item.setIsParent("false");
	        item.setType(3);
	        item.setCityCode(p.getEpuCity());
	        item.setCityName(p.getEpuCityName());
	        item.setEpuProvince(p.getEpuProvince());
	        item.setEpuDistrict(p.getEpuDistrict());
	        item.setEpuLocal(p.getEpuLocal());
	        item.setEpuXscale(p.getEpuXscale().toString());
	        item.setEpuYscale(p.getEpuYscale().toString());
	        list.add(item);
	    }
	       return list; 
	  }
	
	
	
	@ResponseBody
	@RequestMapping(value = "renderTree")
	public List<Item> renderTree(String id, String type) {
		Map<String, String> map = new HashMap<String, String>();
		List<TSyprovincesInfoBean> allList=(List<TSyprovincesInfoBean>)epuService.getProvincesByEp(map);
	    List<Item> list = new ArrayList<Item>(allList.size());
	    //4层遍历城市，省份，区域，以及设备
	    for(TSyprovincesInfoBean p : allList){
	        Item item = new Item();
	        item.setId(p.getProvinceId());
	        item.setpId("0");
	        item.setpName("");
	        item.setName(p.getProvinceNameCn());
	        item.setIsParent("true");
	        item.setType(0);
	        list.add(item);
	        
	        Map<String, String> map1 = new HashMap<String, String>();
			map.put("provinceId", p.getProvinceId());
			map.put("districtFlag", "0");
			List<TSyCityInfoBean> allList1=(List<TSyCityInfoBean>)epuService.getCityByEp(map);
		    for(TSyCityInfoBean p1 : allList1){
		        Item item1 = new Item();
		        item1.setId(p1.getCityCode());
		        item1.setpId(p.getProvinceId());
		        item1.setpName(p.getProvinceNameCn());
		        item1.setName(p1.getCityNameCn());
		        item1.setIsParent("true");
		        item1.setType(1);
		        list.add(item1);
		        List<TSyCityInfoBean> allList2=(List<TSyCityInfoBean>)epuService.getCityDistrictByEp(p1.getCityCode());
			    for(TSyCityInfoBean p2 : allList2){
			        Item item2 = new Item();
			        item2.setId(p2.getCityCode());
			        item2.setpId(p1.getCityCode());
			        item2.setpName(p1.getCityNameCn());
			        item2.setName(p2.getCityNameCn());
			        item2.setIsParent("true");
			        item2.setType(2);
			        list.add(item2);
			        TEpuInfo tEpuInfo=new TEpuInfo();
					 tEpuInfo.setEpuDistrict(p2.getCityCode());
					 List <TEpuInfo> epuInfoList = epuService.selectEpuInfoByMark(tEpuInfo);
				    for(TEpuInfo p3 : epuInfoList){
				        Item item3 = new Item();
				        item3.setId(p3.getRowId());
				        item3.setpId(p2.getCityCode());
				        item3.setName(p3.getEpuName());
				        item3.setIsParent("false");
				        item3.setType(3);
				        item3.setCityCode(p3.getEpuCity());
				        item3.setCityName(p3.getEpuCityName());
				        item3.setEpuProvince(p3.getEpuProvince());
				        item3.setEpuDistrict(p3.getEpuDistrict());
				        item3.setEpuLocal(p3.getEpuLocal());
				        item3.setEpuXscale(p3.getEpuXscale().toString());
				        item3.setEpuYscale(p3.getEpuYscale().toString());
				        list.add(item3);
				    }
			        
			    }
		        
		    }
	        
	    }
				
	    return list;
	}
	
	
	
	@RequestMapping("selectEpuAddressIdByDistrictId")
	@ResponseBody
	public Object selectEpuAddressIdByDistrictId(String epuType,String districtId) {
		return epuService.selectEpuAddressIdByDistrictId(epuType,districtId);
	}
}
