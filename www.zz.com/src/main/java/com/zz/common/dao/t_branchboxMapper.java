package com.zz.common.dao;

import com.zz.common.model.t_branchbox;
import com.zz.common.model.t_branchboxExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface t_branchboxMapper {
    int countByExample(t_branchboxExample example);

    int deleteByExample(t_branchboxExample example);

    int deleteByPrimaryKey(String branchBoxId);

    int insert(t_branchbox record);

    int insertSelective(t_branchbox record);

    List<t_branchbox> selectByExample(t_branchboxExample example);

    t_branchbox selectByPrimaryKey(String branchBoxId);

    int updateByExampleSelective(@Param("record") t_branchbox record, @Param("example") t_branchboxExample example);

    int updateByExample(@Param("record") t_branchbox record, @Param("example") t_branchboxExample example);

    int updateByPrimaryKeySelective(t_branchbox record);

    int updateByPrimaryKey(t_branchbox record);
}