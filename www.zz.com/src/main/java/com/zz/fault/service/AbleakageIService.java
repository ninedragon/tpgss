package com.zz.fault.service;

import java.util.Map;

import com.zz.common.model.AbleakageI;
import com.zz.core.mybatis.page.Pagination;

public interface AbleakageIService {
	Pagination<AbleakageI> findByPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);
}
