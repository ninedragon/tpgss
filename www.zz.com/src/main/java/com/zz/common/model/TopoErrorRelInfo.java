package com.zz.common.model;

public class TopoErrorRelInfo {
	private String id;
	private String epuName;
	private String type;
	private String key;
	private String fault_point;
	private String branchbox_error_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEpuName() {
		return epuName;
	}
	public void setEpuName(String epuName) {
		this.epuName = epuName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getFault_point() {
		return fault_point;
	}
	public void setFault_point(String fault_point) {
		this.fault_point = fault_point;
	}
	public String getBranchbox_error_id() {
		return branchbox_error_id;
	}
	public void setBranchbox_error_id(String branchbox_error_id) {
		this.branchbox_error_id = branchbox_error_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((branchbox_error_id == null) ? 0 : branchbox_error_id.hashCode());
		result = prime * result + ((epuName == null) ? 0 : epuName.hashCode());
		result = prime * result + ((fault_point == null) ? 0 : fault_point.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TopoErrorRelInfo other = (TopoErrorRelInfo) obj;
		if (branchbox_error_id == null) {
			if (other.branchbox_error_id != null)
				return false;
		} else if (!branchbox_error_id.equals(other.branchbox_error_id))
			return false;
		if (epuName == null) {
			if (other.epuName != null)
				return false;
		} else if (!epuName.equals(other.epuName))
			return false;
		if (fault_point == null) {
			if (other.fault_point != null)
				return false;
		} else if (!fault_point.equals(other.fault_point))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TopoErrorRelInfo [id=" + id + ", epuName=" + epuName + ", type=" + type + ", key=" + key
				+ ", fault_point=" + fault_point + ", branchbox_error_id=" + branchbox_error_id + "]";
	}
	
	
}
