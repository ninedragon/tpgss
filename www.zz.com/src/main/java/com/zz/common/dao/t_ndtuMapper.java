package com.zz.common.dao;

import com.zz.common.model.t_ndtu;
import com.zz.common.model.t_ndtuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface t_ndtuMapper {
    int countByExample(t_ndtuExample example);

    int deleteByExample(t_ndtuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(t_ndtu record);

    int insertSelective(t_ndtu record);

    List<t_ndtu> selectByExample(t_ndtuExample example);

    t_ndtu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") t_ndtu record, @Param("example") t_ndtuExample example);

    int updateByExample(@Param("record") t_ndtu record, @Param("example") t_ndtuExample example);

    int updateByPrimaryKeySelective(t_ndtu record);

    int updateByPrimaryKey(t_ndtu record);
}