package com.zz.common.dao;

import java.util.List;
import java.util.Map;

import com.zz.common.model.AbnormalZ;

public interface AbnormalZMapper {
	public List<AbnormalZ> selectMeterUIPQ(Map<String, Object> map);
}
