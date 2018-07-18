package com.zz.fault.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.common.dao.FaultInfoMapper;
import com.zz.common.model.CodeInfo;
import com.zz.common.model.FaultInfo;
import com.zz.common.model.FaultRendering;
import com.zz.common.model.FaultSource;
import com.zz.common.model.TopoErrorInfo;
import com.zz.common.model.TopoErrorRelInfo;
import com.zz.core.mybatis.BaseMybatisDao;
import com.zz.core.mybatis.page.Pagination;
import com.zz.fault.service.FaultService;

@Service
public class FaultServiceImpl extends BaseMybatisDao<FaultInfoMapper> implements FaultService {

	@Autowired
	FaultInfoMapper faultInfoMapper;

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<FaultInfo> findByPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}

	public List<CodeInfo> selectTypeList(List<String> codeTypeList) {
		return faultInfoMapper.selectTypeList(codeTypeList);  
	}

	public List<FaultRendering> selectFaultByRootId(Map<String, Object> map) {
		return faultInfoMapper.selectFaultByRootId(map);
	}

	public List<FaultRendering> selectFaultNews(Map<String, Object> map) {
		return faultInfoMapper.selectFaultNews(map);
	}

	public List<TopoErrorInfo> selectBranchboxErrorByKeys(Map<String, Object> map) {
		return faultInfoMapper.selectBranchboxErrorByKeys(map);
	}

	public List<TopoErrorRelInfo> selectMeterboxErrorByKeys(Map<String, Object> map) {
		return faultInfoMapper.selectMeterboxErrorByKeys(map);
	}

	public Map<String, Object> getFaultSourceMap(String fault_base_id) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<FaultSource> list = faultInfoMapper.getFaultSourceList(fault_base_id);
		Map<String, String> map = new HashMap<String, String>();
		Map<String, List<String>> listMap = new LinkedHashMap<String, List<String>>();
		List<String> recordList = null;
		for (FaultSource faultSource : list) {
			{
				String table_name = faultSource.getTable_name();
				if (map.get(table_name) == null) {
					recordList = new ArrayList<String>();
					map.put(table_name, table_name);
				} else {
					recordList = (List<String>) listMap.get(table_name);
				}
				recordList.add(faultSource.getRecord_id());
				listMap.put(table_name, recordList);
			}
		}
		//1表示t_short_i，2表示t_leakage_i，3表示t_ableakage_i，4表示t_abnormal_u,5表示t_abnormal_z，6表示t_power_quality
		resultMap.put("1", "");//短路电流t_short_i     1
		resultMap.put("2", ""); //周期漏电t_leakage_i  2
		resultMap.put("3", ""); //异常漏电t_ableakage_i  3
		resultMap.put("4", ""); //异常电压t_abnormal_u  4
		resultMap.put("5", "");//异常阻抗t_abnormal_z   5
		resultMap.put("6", "");//电源质量t_power_quality   6
		for (String key : listMap.keySet()) {
			List<String>  tempList = listMap.get(key);
			resultMap.put(key,  StringUtils.join(tempList, ","));
		}
		return resultMap;
	}
}
