package com.zz.common.model;

import java.util.Date;

public class CalZInfo {

	private String id;
	private String key;
	private String epuName;
	private String za;
	private String zb;
	private String zc;
	private Date record_date;
	private String is_valid;
	

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getEpuName() {
		return epuName;
	}
	public void setEpuName(String epuName) {
		this.epuName = epuName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getZa() {
		return za;
	}
	public void setZa(String za) {
		this.za = za;
	}
	public String getZb() {
		return zb;
	}
	public void setZb(String zb) {
		this.zb = zb;
	}
	public String getZc() {
		return zc;
	}
	public void setZc(String zc) {
		this.zc = zc;
	}
	public Date getRecord_date() {
		return record_date;
	}
	public void setRecord_date(Date record_date) {
		this.record_date = record_date;
	}
	public String getIs_valid() {
		return is_valid;
	}
	public void setIs_valid(String is_valid) {
		this.is_valid = is_valid;
	}
		
}
