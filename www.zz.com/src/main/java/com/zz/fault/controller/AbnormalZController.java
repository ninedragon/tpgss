package com.zz.fault.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zz.common.controller.BaseController;
import com.zz.common.model.AbnormalZ;
import com.zz.core.mybatis.page.Pagination;
import com.zz.fault.service.AbnormalZService;
@Controller
@Scope(value = "prototype")
@RequestMapping("abnormalZ")
public class AbnormalZController  extends BaseController{
	@Autowired
	AbnormalZService abnormalZService;
	/**
	 * 查询列表管理
	 * @return
	 */
	@RequestMapping("queryList")
	public @ResponseBody Map<String,Object> queryList(Integer pageNo,Integer pageSize,HttpServletRequest request,ModelMap map) {
		String record_ids = request.getParameter("record_ids");
		String sql = "";
		if(StringUtils.isNotEmpty(record_ids)){
			String[] arr = (record_ids +",").split(",");
			 sql = "  AND ( ";
			String temp = "";
			for (String key : arr) {
				if(null != key && !"".equals(key)){
					temp  += " id = '"+key+"' OR ";
				}
			}
			temp = temp.substring(0, temp.lastIndexOf("OR "));
			sql += temp +"  ) ";
		}
		map.put("paramSQL", sql);
		Pagination<AbnormalZ> page = abnormalZService.findByPage(map,pageNo,pageSize);
		Map<String, Object> mapReturn  = new HashMap<String, Object>();
		mapReturn.put("page", page);
		return mapReturn;
	}
	
	/**
	 * 获取当前表箱下的电表和表箱UIPQ
	 * @param meterBoxId
	 * @return
	 */
	@RequestMapping("selectMeterAndMeterBoxUIPQ")
	@ResponseBody
	public Map<String, Object>  selectMeterAndMeterBoxUIPQ(String meterBoxId)
	{
		Map<String, Object>  resultMap = new HashMap<String, Object>(); 
		List<AbnormalZ> meterList = this.abnormalZService.selectMeterUIPQ(meterBoxId);
		List<AbnormalZ> meterBoxList =this.abnormalZService.selectmeterBoxUIPQ(meterBoxId);
		resultMap.put("meterList", meterList);
		resultMap.put("meterBoxList", meterBoxList);
		return resultMap;
	}
	
	/**
	 * 获取当前表箱下的表箱UIPQ
	 * @param meterBoxId
	 * @return
	 */
	@RequestMapping("selectMeterBoxUIPQ")
	@ResponseBody
	public List<AbnormalZ>  selectMeterBoxUIPQ(String meterBoxId)
	{
		List<AbnormalZ> meterBoxList =this.abnormalZService.selectmeterBoxUIPQ(meterBoxId);
		return meterBoxList;
	}
}
