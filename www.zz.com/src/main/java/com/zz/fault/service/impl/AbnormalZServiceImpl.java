package com.zz.fault.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.common.dao.AbnormalZMapper;
import com.zz.common.model.AbnormalZ;
import com.zz.common.utils.TimesegmentUtils;
import com.zz.core.mybatis.BaseMybatisDao;
import com.zz.core.mybatis.page.Pagination;
import com.zz.fault.service.AbnormalZService;

@Service
public class AbnormalZServiceImpl extends BaseMybatisDao<AbnormalZMapper> implements AbnormalZService {

	@Autowired
	AbnormalZMapper abnormalZMapper;

	@SuppressWarnings("unchecked")
	@Override
	public Pagination<AbnormalZ> findByPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}

	@SuppressWarnings("static-access")
	public List<AbnormalZ> selectMeterUIPQ(String meterBoxId) {
		int tSegmentId = new TimesegmentUtils().getTimesegment(new Date());// 所处的时间段次数
//		 tSegmentId = 251;//测试专用 update t_abnormal_z set RecordDateBCD=180709 where id in ('10002','521')
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("tSegmentId", tSegmentId);
		paramMap.put("meterBoxId", meterBoxId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		paramMap.put("recordDateBCD", sdf.format(new Date()));
		List<AbnormalZ> list = abnormalZMapper.selectMeterUIPQ(paramMap);
		return list;
	}

	@SuppressWarnings("static-access")
	public List<AbnormalZ> selectmeterBoxUIPQ(String meterBoxId) {
		List<AbnormalZ> meterBoxList = new ArrayList<AbnormalZ>();
		int tSegmentId = new TimesegmentUtils().getTimesegment(new Date());// 所处的时间段次数
//		 tSegmentId = 251;//测试专用 update t_abnormal_z set RecordDateBCD=180709 where id in ('10002','521')
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("tSegmentId", tSegmentId);
		paramMap.put("meterBoxId", meterBoxId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		paramMap.put("recordDateBCD", sdf.format(new Date()));
		List<AbnormalZ> list = abnormalZMapper.selectMeterUIPQ(paramMap);
		 Map<String, String> map = new HashMap<String, String>();
	        Map<String, List<AbnormalZ>> listMap = new LinkedHashMap<String, List<AbnormalZ>>();
	        List<AbnormalZ> modelList = null;
	        for (AbnormalZ abnormalZ : list)
	        {
	        	String phaseRemark = abnormalZ.getPhaseRemark();//1:A 2:B 3:C
	        	if(StringUtils.isNotEmpty(phaseRemark)){
	        		phaseRemark = phaseRemark.toUpperCase();
	        		if("A".equals(phaseRemark)){
	        			abnormalZ.setPhaseRemark("1");
	        		}else if("B".equals(phaseRemark)){
	        			abnormalZ.setPhaseRemark("2");
	        		}else if("C".equals(phaseRemark)){
	        			abnormalZ.setPhaseRemark("3");
	        		}
	        	}
	            if (map.get(phaseRemark) == null)
	            {
	                modelList = new ArrayList<AbnormalZ>();
	                map.put(phaseRemark, phaseRemark);
	            }
	            else
	            {
	                modelList = (List<AbnormalZ>) listMap.get(phaseRemark);
	            }
	            modelList.add(abnormalZ);
	            listMap.put(phaseRemark, modelList);
	        }
	        for (String key : listMap.keySet()) {
	        	List<AbnormalZ> tempList = listMap.get(key);
	        	double u = 0;
	        	double i = 0;
	        	double p = 0;
	        	double q = 0;
	        	for (AbnormalZ abnormalZ : tempList) {
	        		if("1".equals(key)){//A
	        			u += Double.valueOf(StringUtils.isEmpty(abnormalZ.getUa()) ? "0.00" :abnormalZ.getUa());
	        		}else if("2".equals(key)){//B
	        			u += Double.valueOf(StringUtils.isEmpty(abnormalZ.getUb()) ? "0.00" :abnormalZ.getUb());
	        		}else if("3".equals(key)){//C
	        			u += Double.valueOf(StringUtils.isEmpty(abnormalZ.getUc()) ? "0.00" :abnormalZ.getUc());
	        		}
	        		i += Double.valueOf(abnormalZ.getI());
	        		p += Double.valueOf(abnormalZ.getP());
	        		q += Double.valueOf(abnormalZ.getQ());
				}
	        	AbnormalZ abnormalZ = new AbnormalZ();
	        	abnormalZ.setPhaseRemark(key);
	        	abnormalZ.setU(String.valueOf(u));
	        	abnormalZ.setI(String.valueOf(i));
	        	abnormalZ.setP(String.valueOf(p));
	        	abnormalZ.setQ(String.valueOf(q));
	        	meterBoxList.add(abnormalZ);
	        }
		return meterBoxList;
	}
}
