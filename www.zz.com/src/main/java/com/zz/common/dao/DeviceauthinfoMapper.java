package com.zz.common.dao;

import com.zz.common.model.Deviceauthinfo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeviceauthinfoMapper {


    int insert(Deviceauthinfo record);

    int insertSelective(Deviceauthinfo record);



}