package com.zz.deviceAndData.bo;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


public class Service {
	private String serviceId;

	private String serviceType;

	private Data data;

	private String eventTime;

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceId() {
		return this.serviceId;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceType() {
		return this.serviceType;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public Data getData() {
		return this.data;
	}

	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}

	public String getEventTime() {
		return this.eventTime;
	}

	public static Service fill(JSONObject jo) {
		Service o = new Service();
		if (jo.containsKey("serviceId")) {
			o.setServiceId(jo.getString("serviceId"));
		}
		if (jo.containsKey("serviceType")) {
			o.setServiceType(jo.getString("serviceType"));
		}
		if (jo.containsKey("data")) {
			o.setData((Data) jo.get("data"));
		}
		if (jo.containsKey("eventTime")) {
			o.setEventTime(jo.getString("eventTime"));
		}
		return o;
	}

	public static List<Service> fillList(JSONArray ja) {
		if (ja == null || ja.size() == 0)
			return null;
		List<Service> sqs = new ArrayList<Service>();
		for (int i = 0; i < ja.size(); i++) {
			sqs.add(fill(ja.getJSONObject(i)));
		}
		return sqs;
	}

}