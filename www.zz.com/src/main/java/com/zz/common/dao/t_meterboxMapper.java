package com.zz.common.dao;

import com.zz.common.model.t_meterbox;
import com.zz.common.model.t_meterboxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface t_meterboxMapper {
    int countByExample(t_meterboxExample example);

    int deleteByExample(t_meterboxExample example);

    int deleteByPrimaryKey(String meterBoxId);

    int insert(t_meterbox record);

    int insertSelective(t_meterbox record);

    List<t_meterbox> selectByExample(t_meterboxExample example);

    t_meterbox selectByPrimaryKey(String meterBoxId);

    int updateByExampleSelective(@Param("record") t_meterbox record, @Param("example") t_meterboxExample example);

    int updateByExample(@Param("record") t_meterbox record, @Param("example") t_meterboxExample example);

    int updateByPrimaryKeySelective(t_meterbox record);

    int updateByPrimaryKey(t_meterbox record);
}