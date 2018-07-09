package com.zz.fault.service;

import java.util.Map;

import com.zz.common.model.ShortI;
import com.zz.core.mybatis.page.Pagination;

public interface ShortIService {
	Pagination<ShortI> findByPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);
}
