package com.zz.fault.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.zz.common.dao.LeakageIMapper;
import com.zz.common.model.LeakageI;
import com.zz.core.mybatis.BaseMybatisDao;
import com.zz.core.mybatis.page.Pagination;
import com.zz.fault.service.LeakageIService;
@Service
public class LeakageIServiceImpl  extends BaseMybatisDao<LeakageIMapper> implements LeakageIService{
	@SuppressWarnings("unchecked")
	@Override
	public Pagination<LeakageI> findByPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}
}
