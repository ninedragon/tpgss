package com.zz.deviceAndData.bo;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author 90807
 *表示电信云平台采集到的数据的data项
 */

public class Data {
	private String reportData;

	public void setReportData(String reportData) {
		this.reportData = reportData;
	}

	public String getReportData() {
		return this.reportData;
	}

	public static Data fill(JSONObject jo) {
		Data o = new Data();
		if (jo.containsKey("reportData")) {
			o.setReportData(jo.getString("reportData"));
		}
		return o;
	}

	public static List<Data> fillList(JSONArray ja) {
		if (ja == null || ja.size() == 0)
			return null;
		List<Data> sqs = new ArrayList<Data>();
		for (int i = 0; i < ja.size(); i++) {
			sqs.add(fill(ja.getJSONObject(i)));
		}
		return sqs;
	}

}