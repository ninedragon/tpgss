package com.zz.analysisAndDisplay.service;

import java.util.HashMap;
import java.util.List;

import com.zz.analysisAndDisplay.bo.WarnBO;

public interface BoxWarnService {

	List<HashMap<String, Object>> listWarns(WarnBO warnBO);

	List<HashMap<String, Object>> listShortI(WarnBO warnBO);

	List<HashMap<String, Object>> listLeakageI(WarnBO warnBO);

	List<HashMap<String, Object>> listAbleakageI(WarnBO warnBO);

	List<HashMap<String, Object>> listAbnormalU(WarnBO warnBO);

	List<HashMap<String, Object>> listAbnormalZ(WarnBO warnBO);

	List<HashMap<String, Object>> listPowerQuality(WarnBO warnBO);

}
