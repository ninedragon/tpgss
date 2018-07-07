package com.zz.common.dao;

import java.util.List;
import java.util.Map;

import com.zz.common.model.CodeInfo;
import com.zz.common.model.FaultRendering;

public interface FaultInfoMapper {
	 public List<CodeInfo> selectTypeList(List<String> codeTypeList);
	 
	 public List<FaultRendering> selectFaultByRootId(Map<String, Object> map);
	 
	 public List<FaultRendering> selectFaultNews(Map<String, Object> map);
}