package com.zz.fault.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.zz.common.dao.AbnormalUMapper;
import com.zz.common.model.AbnormalU;
import com.zz.core.mybatis.BaseMybatisDao;
import com.zz.core.mybatis.page.Pagination;
import com.zz.fault.service.AbnormalUService;
@Service
public class AbnormalUServiceImpl  extends BaseMybatisDao<AbnormalUMapper> implements AbnormalUService{
	@SuppressWarnings("unchecked")
	@Override
	public Pagination<AbnormalU> findByPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}
}
