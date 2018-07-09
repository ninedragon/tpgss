package com.zz.fault.service;

import java.util.List;
import java.util.Map;

import com.zz.common.model.AbnormalZ;
import com.zz.core.mybatis.page.Pagination;

public interface AbnormalZService {
	Pagination<AbnormalZ> findByPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);
	
	public List<AbnormalZ>  selectMeterUIPQ(String meterBoxId);
	
	public List<AbnormalZ> selectmeterBoxUIPQ(String meterBoxId);
}
