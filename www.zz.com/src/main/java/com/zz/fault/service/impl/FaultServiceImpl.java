package com.zz.fault.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.common.dao.FaultInfoMapper;
import com.zz.common.model.CodeInfo;
import com.zz.common.model.FaultInfo;
import com.zz.common.model.FaultRendering;
import com.zz.core.mybatis.BaseMybatisDao;
import com.zz.core.mybatis.page.Pagination;
import com.zz.fault.service.FaultService;

@Service
public class FaultServiceImpl extends BaseMybatisDao<FaultInfoMapper> implements FaultService {
	
	@Autowired
	FaultInfoMapper faultInfoMapper;
	
	@SuppressWarnings("unchecked")
	@Override
	public Pagination<FaultInfo> findByPage(Map<String, Object> resultMap,
			Integer pageNo, Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}
	
    public List<CodeInfo> selectTypeList(List<String> codeTypeList){
    	return faultInfoMapper.selectTypeList(codeTypeList);
    }
    
    public List<FaultRendering> selectFaultByRootId(Map<String, Object> map){
    	return faultInfoMapper.selectFaultByRootId(map);
    }
    public List<FaultRendering> selectFaultNews(Map<String, Object> map){
    	return faultInfoMapper.selectFaultNews(map);
    }
	
}
