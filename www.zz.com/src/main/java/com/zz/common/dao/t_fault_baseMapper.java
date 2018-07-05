package com.zz.common.dao;

import com.zz.common.model.t_fault_base;
import com.zz.common.model.t_fault_baseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface t_fault_baseMapper {
    int countByExample(t_fault_baseExample example);

    int deleteByExample(t_fault_baseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(t_fault_base record);

    int insertSelective(t_fault_base record);

    List<t_fault_base> selectByExample(t_fault_baseExample example);

    t_fault_base selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") t_fault_base record, @Param("example") t_fault_baseExample example);

    int updateByExample(@Param("record") t_fault_base record, @Param("example") t_fault_baseExample example);

    int updateByPrimaryKeySelective(t_fault_base record);

    int updateByPrimaryKey(t_fault_base record);
}