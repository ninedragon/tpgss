package com.zz.fault.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.zz.common.dao.ShortIMapper;
import com.zz.common.model.ShortI;
import com.zz.core.mybatis.BaseMybatisDao;
import com.zz.core.mybatis.page.Pagination;
import com.zz.fault.service.ShortIService;
@Service
public class ShortIServiceImpl  extends BaseMybatisDao<ShortIMapper> implements ShortIService{
	@SuppressWarnings("unchecked")
	@Override
	public Pagination<ShortI> findByPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}
}
