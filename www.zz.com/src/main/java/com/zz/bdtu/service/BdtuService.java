package com.zz.bdtu.service;

import java.util.Map;

import com.zz.common.model.Dtu;
import com.zz.core.mybatis.page.Pagination;

public interface BdtuService {
	Pagination<Dtu> findByPage(Map<String, Object> resultMap, Integer pageNo,
			Integer pageSize);
	
     // 获取所有查询条件
    public Map<String, Object> updateDtu(Dtu dtu,String flag);
	
	// 删除 设备
    public Map<String, Object> delDtu(int  id);
    
    public Dtu selectDtuByRowId(int  id);


}
