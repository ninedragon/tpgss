package com.zz.analysisAndDisplay.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.analysisAndDisplay.bo.WarnBO;
import com.zz.analysisAndDisplay.service.BoxWarnService;
import com.zz.common.dao.AbleakageIMapper;
import com.zz.common.dao.AbnormalUMapper;
import com.zz.common.dao.AbnormalZMapper;
import com.zz.common.dao.LeakageIMapper;
import com.zz.common.dao.PowerQualityMapper;
import com.zz.common.dao.ShortIMapper;
@Service
public class BoxWarnServiceImpl implements BoxWarnService {
	@Autowired
	ShortIMapper shortIMapper;
	@Autowired
	LeakageIMapper leakageIMapper;
	@Autowired
	AbleakageIMapper ableakageIMapper;
	@Autowired
	AbnormalUMapper abnormalUMapper;
	@Autowired
	AbnormalZMapper abnormalZMapper;
	@Autowired
	PowerQualityMapper powerQualityMapper;
	/* 列出警告数据
	 * @see com.zz.analysisAndDisplay.service.BoxWarnService#listWarns()
	 */
	@Override
	public List<HashMap<String, Object>> listWarns(WarnBO warnBO) {
		return shortIMapper.listWarns(warnBO);
	}
	@Override
	public List<HashMap<String, Object>> listShortI(WarnBO warnBO) {
		return shortIMapper.listShortI(warnBO);
	}
	@Override
	public List<HashMap<String, Object>> listLeakageI(WarnBO warnBO) {
		return leakageIMapper.listLeakageI(warnBO);
	}
	@Override
	public List<HashMap<String, Object>> listAbleakageI(WarnBO warnBO) {
		return ableakageIMapper.listAbleakageI(warnBO);
	}
	@Override
	public List<HashMap<String, Object>> listAbnormalU(WarnBO warnBO) {
		return abnormalUMapper.listAbnormalU(warnBO);
	}
	@Override
	public List<HashMap<String, Object>> listAbnormalZ(WarnBO warnBO) {
		return powerQualityMapper.listAbnormalZ(warnBO);
	}
	@Override
	public List<HashMap<String, Object>> listPowerQuality(WarnBO warnBO) {
		return leakageIMapper.listPowerQuality(warnBO);
	}

}
