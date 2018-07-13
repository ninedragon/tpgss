package com.zz.fault.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.common.dao.PowerQualityMapper;
import com.zz.common.model.PowerQuality;
import com.zz.common.utils.TimesegmentUtils;
import com.zz.core.mybatis.BaseMybatisDao;
import com.zz.core.mybatis.page.Pagination;
import com.zz.fault.service.PowerQualityService;
@Service
public class PowerQualityServiceImpl extends BaseMybatisDao<PowerQualityMapper> implements PowerQualityService {
	@Autowired
	PowerQualityMapper owerQualityMapper;
	@SuppressWarnings("unchecked")
	@Override
	public Pagination<PowerQuality> findByPage(Map<String, Object> resultMap, Integer pageNo, Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}
	
	
	@SuppressWarnings("static-access")
	public List<PowerQuality> selectBranchboxUIPQ(String outgoingCabinetIds) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String sql = "";
		if(StringUtils.isNotEmpty(outgoingCabinetIds)){
			String[] arr = (outgoingCabinetIds +",").split(",");
			 sql = "  AND ( ";
			String temp = "";
			for (String key : arr) {
				if(null != key && !"".equals(key)){
					temp  += " t_branchbox.outgoingCabinetId = '"+key+"' OR ";
				}
			}
			temp = temp.substring(0, temp.lastIndexOf("OR "));
			sql += temp +"  ) ";
		}
		paramMap.put("paramSQL", sql);
		int tSegmentId = new TimesegmentUtils().getTimesegment(new Date());// 所处的时间段次数
		paramMap.put("tSegmentId", tSegmentId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
		paramMap.put("recordDateBCD", sdf.format(new Date()));
		
		
		List<PowerQuality> list = new ArrayList<>();
		
//		tSegmentId = 248;//测试专用 update t_power_quality set RecordDateBCD=180709 where id in ('141','142','143')
//		paramMap.put("tSegmentId", tSegmentId);
		PowerQuality powerQualityA = owerQualityMapper.branchboxUIPQByChannelA(paramMap);
		if(null != powerQualityA){
			list.add(powerQualityA);
		}
//		tSegmentId = 253;//测试专用 update t_power_quality set RecordDateBCD=180709 where id in ('141','142','143')
//		paramMap.put("tSegmentId", tSegmentId);
		PowerQuality powerQualityB = owerQualityMapper.branchboxUIPQByChannelB(paramMap);
		if(null != powerQualityB){
			list.add(powerQualityB);
		}
//		tSegmentId = 2;//测试专用 update t_power_quality set RecordDateBCD=180709 where id in ('141','142','143')
//		paramMap.put("tSegmentId", tSegmentId);
		PowerQuality powerQualityC = owerQualityMapper.branchboxUIPQByChannelC(paramMap);
		if(null != powerQualityC){
			list.add(powerQualityC);
		}
		return list;
	}
}
