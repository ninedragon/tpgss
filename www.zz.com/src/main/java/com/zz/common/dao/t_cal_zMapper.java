package com.zz.common.dao;

import com.zz.common.model.t_cal_z;
import com.zz.common.model.t_cal_zExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface t_cal_zMapper {
    int countByExample(t_cal_zExample example);

    int deleteByExample(t_cal_zExample example);

    int deleteByPrimaryKey(Long id);

    int insert(t_cal_z record);

    int insertSelective(t_cal_z record);

    List<t_cal_z> selectByExample(t_cal_zExample example);

    t_cal_z selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") t_cal_z record, @Param("example") t_cal_zExample example);

    int updateByExample(@Param("record") t_cal_z record, @Param("example") t_cal_zExample example);

    int updateByPrimaryKeySelective(t_cal_z record);

    int updateByPrimaryKey(t_cal_z record);
}