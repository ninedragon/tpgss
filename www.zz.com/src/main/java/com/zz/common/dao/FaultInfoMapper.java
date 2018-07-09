package com.zz.common.dao;

import java.util.List;
import java.util.Map;

import com.zz.common.model.CodeInfo;
import com.zz.common.model.FaultRendering;
import com.zz.common.model.FaultSource;
import com.zz.common.model.TopoErrorInfo;
import com.zz.common.model.TopoErrorRelInfo;

public interface FaultInfoMapper {
	 public List<CodeInfo> selectTypeList(List<String> codeTypeList);
	 
	 public List<FaultRendering> selectFaultByRootId(Map<String, Object> map);
	 
	 public List<FaultRendering> selectFaultNews(Map<String, Object> map);
	 
	 public List<TopoErrorInfo> selectBranchboxErrorByKeys(Map<String, Object> map);
	 
	 public List<TopoErrorRelInfo> selectMeterboxErrorByKeys(Map<String, Object> map);
	 
	 public List<FaultSource> getFaultSourceList(String fault_base_id);
	 
}