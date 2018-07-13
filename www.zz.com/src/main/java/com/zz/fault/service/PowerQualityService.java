package com.zz.fault.service;

import java.util.List;
import java.util.Map;

import com.zz.common.model.PowerQuality;
import com.zz.core.mybatis.page.Pagination;

public interface PowerQualityService {
	Pagination<PowerQuality> findByPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);
	
	
	public List<PowerQuality> selectBranchboxUIPQ(String outgoingCabinetIds);
}
