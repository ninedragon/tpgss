package com.zz.common.dao;

import java.util.HashMap;
import java.util.List;

import com.zz.analysisAndDisplay.bo.WarnBO;
import com.zz.common.model.LeakageI;

public interface LeakageIMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LeakageI record);

    int insertSelective(LeakageI record);

    LeakageI selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LeakageI record);

    int updateByPrimaryKey(LeakageI record);

	List<HashMap<String, Object>> listLeakageI(WarnBO warnBO);

	List<HashMap<String, Object>> listPowerQuality(WarnBO warnBO);
}