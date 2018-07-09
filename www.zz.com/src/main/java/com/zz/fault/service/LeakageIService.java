package com.zz.fault.service;

import java.util.Map;

import com.zz.common.model.LeakageI;
import com.zz.core.mybatis.page.Pagination;

public interface LeakageIService {
	Pagination<LeakageI> findByPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);
}
