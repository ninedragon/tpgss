package com.zz.common.dao;

import com.zz.common.model.t_outgoingcabinet;
import com.zz.common.model.t_outgoingcabinetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface t_outgoingcabinetMapper {
    int countByExample(t_outgoingcabinetExample example);

    int deleteByExample(t_outgoingcabinetExample example);

    int deleteByPrimaryKey(String outgoingCabinetId);

    int insert(t_outgoingcabinet record);

    int insertSelective(t_outgoingcabinet record);

    List<t_outgoingcabinet> selectByExample(t_outgoingcabinetExample example);

    t_outgoingcabinet selectByPrimaryKey(String outgoingCabinetId);

    int updateByExampleSelective(@Param("record") t_outgoingcabinet record, @Param("example") t_outgoingcabinetExample example);

    int updateByExample(@Param("record") t_outgoingcabinet record, @Param("example") t_outgoingcabinetExample example);

    int updateByPrimaryKeySelective(t_outgoingcabinet record);

    int updateByPrimaryKey(t_outgoingcabinet record);
}