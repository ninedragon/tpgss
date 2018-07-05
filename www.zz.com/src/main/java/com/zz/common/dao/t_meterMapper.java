package com.zz.common.dao;

import com.zz.common.model.t_meter;
import com.zz.common.model.t_meterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface t_meterMapper {
    int countByExample(t_meterExample example);

    int deleteByExample(t_meterExample example);

    int deleteByPrimaryKey(String meterId);

    int insert(t_meter record);

    int insertSelective(t_meter record);

    List<t_meter> selectByExample(t_meterExample example);

    t_meter selectByPrimaryKey(String meterId);

    int updateByExampleSelective(@Param("record") t_meter record, @Param("example") t_meterExample example);

    int updateByExample(@Param("record") t_meter record, @Param("example") t_meterExample example);

    int updateByPrimaryKeySelective(t_meter record);

    int updateByPrimaryKey(t_meter record);
}