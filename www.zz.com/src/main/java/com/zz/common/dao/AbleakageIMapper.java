package com.zz.common.dao;

import java.util.HashMap;
import java.util.List;

import com.zz.analysisAndDisplay.bo.WarnBO;
import com.zz.common.model.AbleakageI;

public interface AbleakageIMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AbleakageI record);

    int insertSelective(AbleakageI record);

    AbleakageI selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AbleakageI record);

    int updateByPrimaryKey(AbleakageI record);

	List<HashMap<String, Object>> listAbleakageI(WarnBO warnBO);
}