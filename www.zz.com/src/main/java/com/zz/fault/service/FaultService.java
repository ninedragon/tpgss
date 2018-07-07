package com.zz.fault.service;

import java.util.List;
import java.util.Map;

import com.zz.common.model.CodeInfo;
import com.zz.common.model.FaultInfo;
import com.zz.common.model.FaultRendering;
import com.zz.core.mybatis.page.Pagination;

public interface FaultService {
	Pagination<FaultInfo> findByPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);
	
    public List<CodeInfo> selectTypeList(List<String> codeTypeList);
    public List<FaultRendering> selectFaultByRootId(Map<String, Object> map);
    public List<FaultRendering> selectFaultNews(Map<String, Object> map);
}
