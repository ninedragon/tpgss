package com.zz.fault.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zz.common.controller.BaseController;
import com.zz.common.model.PowerQuality;
import com.zz.fault.service.PowerQualityService;

@Controller
@Scope(value = "prototype")
@RequestMapping("powerQuality")
public class PowerQualityController extends BaseController{
	@Autowired
	PowerQualityService powerQualityService;
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
