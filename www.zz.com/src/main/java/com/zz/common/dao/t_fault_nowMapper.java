package com.zz.common.dao;

import com.zz.common.model.t_fault_now;
import com.zz.common.model.t_fault_nowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface t_fault_nowMapper {
    int countByExample(t_fault_nowExample example);

    int deleteByExample(t_fault_nowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(t_fault_now record);

    int insertSelective(t_fault_now record);

    List<t_fault_now> selectByExample(t_fault_nowExample example);

    t_fault_now selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") t_fault_now record, @Param("example") t_fault_nowExample example);

    int updateByExample(@Param("record") t_fault_now record, @Param("example") t_fault_nowExample example);

    int updateByPrimaryKeySelective(t_fault_now record);

    int updateByPrimaryKey(t_fault_now record);
}