package com.zz.common.dao;

import java.util.HashMap;
import java.util.List;

import com.zz.analysisAndDisplay.bo.WarnBO;
import com.zz.common.model.ShortI;

public interface ShortIMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShortI record);

    int insertSelective(ShortI record);

    ShortI selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShortI record);

    int updateByPrimaryKey(ShortI record);

	List<HashMap<String, Object>> listWarns(WarnBO warnBO);

	List<HashMap<String, Object>> listShortI(WarnBO warnBO);

	List<HashMap<String, Object>> listLeakageI(WarnBO warnBO);
}