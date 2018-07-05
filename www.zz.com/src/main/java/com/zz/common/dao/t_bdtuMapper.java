package com.zz.common.dao;

import com.zz.common.model.t_bdtu;
import com.zz.common.model.t_bdtuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface t_bdtuMapper {
    int countByExample(t_bdtuExample example);

    int deleteByExample(t_bdtuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(t_bdtu record);

    int insertSelective(t_bdtu record);

    List<t_bdtu> selectByExample(t_bdtuExample example);

    t_bdtu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") t_bdtu record, @Param("example") t_bdtuExample example);

    int updateByExample(@Param("record") t_bdtu record, @Param("example") t_bdtuExample example);

    int updateByPrimaryKeySelective(t_bdtu record);

    int updateByPrimaryKey(t_bdtu record);
}