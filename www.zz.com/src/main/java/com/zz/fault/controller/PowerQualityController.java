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
import com.zz.common.model.PowerQuality;
import com.zz.core.mybatis.page.Pagination;
import com.zz.fault.service.PowerQualityService;

@Controller
@Scope(value = "prototype")
@RequestMapping("powerQuality")
public class PowerQualityController extends BaseController{
	@Autowired
	PowerQualityService powerQualityService;
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
		Pagination<PowerQuality> page = powerQualityService.findByPage(map,pageNo,pageSize);
		Map<String, Object> mapReturn  = new HashMap<String, Object>();
		mapReturn.put("page", page);
		return mapReturn;
	}
	
	
	/**
	 * 获取当前出线柜下的分支箱UIPQ
	 * @param meterBoxId
	 * @return
	 */
	@RequestMapping("selectBranchboxUIPQ")
	@ResponseBody
	public List<PowerQuality>  selectBranchboxUIPQ(String outgoingCabinetIds)
	{
		List<PowerQuality> branchboxList =this.powerQualityService.selectBranchboxUIPQ(outgoingCabinetIds);
		return branchboxList;
	}
}
