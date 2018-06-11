package com.zz.common.dao;

import java.util.HashMap;
import java.util.List;

import com.zz.analysisAndDisplay.bo.WarnBO;
import com.zz.common.model.AbnormalU;

public interface AbnormalUMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AbnormalU record);

    int insertSelective(AbnormalU record);

    AbnormalU selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AbnormalU record);

    int updateByPrimaryKey(AbnormalU record);

	List<HashMap<String, Object>> listAbnormalU(WarnBO warnBO);
}