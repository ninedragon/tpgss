package com.zz.common.model;

import java.io.Serializable;
import java.util.Date;

public class FaultInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String row_id;
	private String row_name;
	private String fault_type;
	private Date  occur_time;
	private String  is_cancelled;
	private String  is_cancelled_name;
	private String  is_repaired;
	private String  is_repaired_name;
	private Date  repair_time;
	private String  faultTypeName;
	private String  epu_province;
	private String  epu_city;
	private String  epu_district;
	private String  epu_name;
	private String  epu_province_name;
	private String  epu_city_name;
	private String  epu_district_name;
	private String  epu_type_name;
	private String  fault_base_id;
	public String getRow_id() {
		return row_id;
	}
	public void setRow_id(String row_id) {
		this.row_id = row_id;
	}
	public String getRow_name() {
		return row_name;
	}
	public void setRow_name(String row_name) {
		this.row_name = row_name;
	}
	public String getFault_type() {
		return fault_type;
	}
	public void setFault_type(String fault_type) {
		this.fault_type = fault_type;
	}
	public Date getOccur_time() {
		return occur_time;
	}
	public void setOccur_time(Date occur_time) {
		this.occur_time = occur_time;
	}
	public String getIs_cancelled() {
		return is_cancelled;
	}
	public void setIs_cancelled(String is_cancelled) {
		this.is_cancelled = is_cancelled;
	}
	public String getIs_cancelled_name() {
		return is_cancelled_name;
	}
	public void setIs_cancelled_name(String is_cancelled_name) {
		this.is_cancelled_name = is_cancelled_name;
	}
	public String getIs_repaired() {
		return is_repaired;
	}
	public void setIs_repaired(String is_repaired) {
		this.is_repaired = is_repaired;
	}
	public String getIs_repaired_name() {
		return is_repaired_name;
	}
	public void setIs_repaired_name(String is_repaired_name) {
		this.is_repaired_name = is_repaired_name;
	}
	public Date getRepair_time() {
		return repair_time;
	}
	public void setRepair_time(Date repair_time) {
		this.repair_time = repair_time;
	}
	public String getFaultTypeName() {
		return faultTypeName;
	}
	public void setFaultTypeName(String faultTypeName) {
		this.faultTypeName = faultTypeName;
	}
	public String getEpu_province() {
		return epu_province;
	}
	public void setEpu_province(String epu_province) {
		this.epu_province = epu_province;
	}
	public String getEpu_city() {
		return epu_city;
	}
	public void setEpu_city(String epu_city) {
		this.epu_city = epu_city;
	}
	public String getEpu_district() {
		return epu_district;
	}
	public void setEpu_district(String epu_district) {
		this.epu_district = epu_district;
	}
	public String getEpu_name() {
		return epu_name;
	}
	public void setEpu_name(String epu_name) {
		this.epu_name = epu_name;
	}
	public String getEpu_province_name() {
		return epu_province_name;
	}
	public void setEpu_province_name(String epu_province_name) {
		this.epu_province_name = epu_province_name;
	}
	public String getEpu_city_name() {
		return epu_city_name;
	}
	public void setEpu_city_name(String epu_city_name) {
		this.epu_city_name = epu_city_name;
	}
	public String getEpu_district_name() {
		return epu_district_name;
	}
	public void setEpu_district_name(String epu_district_name) {
		this.epu_district_name = epu_district_name;
	}
	public String getEpu_type_name() {
		return epu_type_name;
	}
	public void setEpu_type_name(String epu_type_name) {
		this.epu_type_name = epu_type_name;
	}
	public String getFault_base_id() {
		return fault_base_id;
	}
	public void setFault_base_id(String fault_base_id) {
		this.fault_base_id = fault_base_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}