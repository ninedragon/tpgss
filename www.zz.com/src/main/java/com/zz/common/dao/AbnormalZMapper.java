package com.zz.common.dao;

import com.zz.common.model.AbnormalZ;

public interface AbnormalZMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AbnormalZ record);

    int insertSelective(AbnormalZ record);

    AbnormalZ selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AbnormalZ record);

    int updateByPrimaryKey(AbnormalZ record);
}