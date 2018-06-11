package com.zz.common.dao;

import com.zz.common.model.Topo;

public interface TopoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Topo record);

    int insertSelective(Topo record);

    Topo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Topo record);

    int updateByPrimaryKey(Topo record);
}