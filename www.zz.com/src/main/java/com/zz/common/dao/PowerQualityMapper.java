package com.zz.common.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zz.analysisAndDisplay.bo.WarnBO;
import com.zz.common.model.PowerQuality;

public interface PowerQualityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PowerQuality record);

    int insertSelective(PowerQuality record);

    PowerQuality selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PowerQuality record);

    int updateByPrimaryKey(PowerQuality record);

	List<HashMap<String, Object>> listAbnormalZ(WarnBO warnBO);
	
	PowerQuality branchboxUIPQByChannelA(Map<String, Object> map);
	
	PowerQuality branchboxUIPQByChannelB(Map<String, Object> map);
	
	PowerQuality branchboxUIPQByChannelC(Map<String, Object> map);

}