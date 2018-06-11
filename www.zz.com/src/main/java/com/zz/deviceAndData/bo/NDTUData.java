package com.zz.deviceAndData.bo;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class NDTUData {
	private String notifyType;

	private String deviceId;

	private String gatewayId;

	private String requestId;

	private Service service;

	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}

	public String getNotifyType() {
		return this.notifyType;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceId() {
		return this.deviceId;
	}

	public void setGatewayId(String gatewayId) {
		this.gatewayId = gatewayId;
	}

	public String getGatewayId() {
		return this.gatewayId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getRequestId() {
		return this.requestId;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Service getService() {
		return this.service;
	}

	public static NDTUData fill(JSONObject jo) {
		NDTUData o = new NDTUData();
		if (jo.containsKey("notifyType")) {
			o.setNotifyType(jo.getString("notifyType"));
		}
		if (jo.containsKey("deviceId")) {
			o.setDeviceId(jo.getString("deviceId"));
		}
		if (jo.containsKey("gatewayId")) {
			o.setGatewayId(jo.getString("gatewayId"));
		}
		if (jo.containsKey("requestId")) {
			o.setRequestId(jo.getString("requestId"));
		}
		if (jo.containsKey("service")) {
			o.setService((Service) jo.get("service"));
		}
		return o;
	}

	public static List<NDTUData> fillList(JSONArray ja) {
		if (ja == null || ja.size() == 0)
			return null;
		List<NDTUData> sqs = new ArrayList<NDTUData>();
		for (int i = 0; i < ja.size(); i++) {
			sqs.add(fill(ja.getJSONObject(i)));
		}
		return sqs;
	}

}