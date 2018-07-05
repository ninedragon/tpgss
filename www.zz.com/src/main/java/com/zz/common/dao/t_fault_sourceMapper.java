package com.zz.common.dao;

import com.zz.common.model.t_fault_source;
import com.zz.common.model.t_fault_sourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface t_fault_sourceMapper {
    int countByExample(t_fault_sourceExample example);

    int deleteByExample(t_fault_sourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(t_fault_source record);

    int insertSelective(t_fault_source record);

    List<t_fault_source> selectByExample(t_fault_sourceExample example);

    t_fault_source selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") t_fault_source record, @Param("example") t_fault_sourceExample example);

    int updateByExample(@Param("record") t_fault_source record, @Param("example") t_fault_sourceExample example);

    int updateByPrimaryKeySelective(t_fault_source record);

    int updateByPrimaryKey(t_fault_source record);
}