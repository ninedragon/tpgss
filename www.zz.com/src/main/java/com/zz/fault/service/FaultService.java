package com.zz.fault.service;

import java.util.List;
import java.util.Map;

import com.zz.common.model.CodeInfo;
import com.zz.common.model.FaultInfo;
import com.zz.common.model.FaultRendering;
import com.zz.common.model.TopoErrorInfo;
import com.zz.common.model.TopoErrorRelInfo;
import com.zz.core.mybatis.page.Pagination;

public interface FaultService {
	Pagination<FaultInfo> findByPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);
	
    public List<CodeInfo> selectTypeList(List<String> codeTypeList);
    
    public List<FaultRendering> selectFaultByRootId(Map<String, Object> map);
    
    public List<FaultRendering> selectFaultNews(Map<String, Object> map);
    
    public List<TopoErrorInfo> selectBranchboxErrorByKeys(Map<String, Object> map);
    
    public List<TopoErrorRelInfo> selectMeterboxErrorByKeys(Map<String, Object> map);
    
    /**
     * 查询故障来源信息表记录
     * @param fault_base_id
     * @return
     */
    public Map<String, Object>  getFaultSourceMap(String  fault_base_id);
    
}
