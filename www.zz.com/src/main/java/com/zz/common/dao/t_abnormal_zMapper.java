package com.zz.common.dao;

import com.zz.common.model.t_abnormal_z;
import com.zz.common.model.t_abnormal_zExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface t_abnormal_zMapper {
    int countByExample(t_abnormal_zExample example);

    int deleteByExample(t_abnormal_zExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(t_abnormal_z record);

    int insertSelective(t_abnormal_z record);

    List<t_abnormal_z> selectByExample(t_abnormal_zExample example);

    t_abnormal_z selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") t_abnormal_z record, @Param("example") t_abnormal_zExample example);

    int updateByExample(@Param("record") t_abnormal_z record, @Param("example") t_abnormal_zExample example);

    int updateByPrimaryKeySelective(t_abnormal_z record);

    int updateByPrimaryKey(t_abnormal_z record);
}