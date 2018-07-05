package com.zz.common.dao;

import com.zz.common.model.t_substain;
import com.zz.common.model.t_substainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface t_substainMapper {
    int countByExample(t_substainExample example);

    int deleteByExample(t_substainExample example);

    int deleteByPrimaryKey(String substainId);

    int insert(t_substain record);

    int insertSelective(t_substain record);

    List<t_substain> selectByExample(t_substainExample example);

    t_substain selectByPrimaryKey(String substainId);

    int updateByExampleSelective(@Param("record") t_substain record, @Param("example") t_substainExample example);

    int updateByExample(@Param("record") t_substain record, @Param("example") t_substainExample example);

    int updateByPrimaryKeySelective(t_substain record);

    int updateByPrimaryKey(t_substain record);
}