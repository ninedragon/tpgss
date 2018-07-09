package com.zz.fault.service;

import java.util.Map;

import com.zz.common.model.AbnormalU;
import com.zz.core.mybatis.page.Pagination;

public interface AbnormalUService {
	Pagination<AbnormalU> findByPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);
	
}
