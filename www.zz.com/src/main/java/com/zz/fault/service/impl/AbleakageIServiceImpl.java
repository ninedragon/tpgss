package com.zz.fault.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.zz.common.dao.AbleakageIMapper;
import com.zz.common.model.AbleakageI;
import com.zz.core.mybatis.BaseMybatisDao;
import com.zz.core.mybatis.page.Pagination;
import com.zz.fault.service.AbleakageIService;
@Service
public class AbleakageIServiceImpl extends BaseMybatisDao<AbleakageIMapper> implements AbleakageIService{
	@SuppressWarnings("unchecked")
	@Override
	public Pagination<AbleakageI> findByPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}
}
