package com.zz.fault.service;

import java.util.List;

import com.zz.common.model.PowerQuality;

public interface PowerQualityService {
	public List<PowerQuality> selectBranchboxUIPQ(String outgoingCabinetIds);
}
