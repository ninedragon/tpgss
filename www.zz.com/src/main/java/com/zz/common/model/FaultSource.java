package com.zz.common.model;

public class FaultSource {
	private String id;
	private String fault_id;
	private String table_name;
	private String record_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFault_id() {
		return fault_id;
	}
	public void setFault_id(String fault_id) {
		this.fault_id = fault_id;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getRecord_id() {
		return record_id;
	}
	public void setRecord_id(String record_id) {
		this.record_id = record_id;
	}
	
	
}
