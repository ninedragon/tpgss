package com.zz.common.model;

import java.util.List;

public class TopoErrorInfo {

	private String id;
	private String type;
	private String epuName;
	private String key;
	private String fault_type;
	private String error_num;
	private List<TopoErrorRelInfo> rel;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEpuName() {
		return epuName;
	}
	public void setEpuName(String epuName) {
		this.epuName = epuName;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getFault_type() {
		return fault_type;
	}
	public void setFault_type(String fault_type) {
		this.fault_type = fault_type;
	}
	public String getError_num() {
		return error_num;
	}
	public void setError_num(String error_num) {
		this.error_num = error_num;
	}
	public List<TopoErrorRelInfo> getRel() {
		return rel;
	}
	public void setRel(List<TopoErrorRelInfo> rel) {
		this.rel = rel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((epuName == null) ? 0 : epuName.hashCode());
		result = prime * result + ((error_num == null) ? 0 : error_num.hashCode());
		result = prime * result + ((fault_type == null) ? 0 : fault_type.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((rel == null) ? 0 : rel.hashCode());
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
		TopoErrorInfo other = (TopoErrorInfo) obj;
		if (epuName == null) {
			if (other.epuName != null)
				return false;
		} else if (!epuName.equals(other.epuName))
			return false;
		if (error_num == null) {
			if (other.error_num != null)
				return false;
		} else if (!error_num.equals(other.error_num))
			return false;
		if (fault_type == null) {
			if (other.fault_type != null)
				return false;
		} else if (!fault_type.equals(other.fault_type))
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
		if (rel == null) {
			if (other.rel != null)
				return false;
		} else if (!rel.equals(other.rel))
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
		return "TopoErrorInfo [id=" + id + ", type=" + type + ", epuName=" + epuName + ", key=" + key + ", fault_type="
				+ fault_type + ", error_num=" + error_num + ", rel=" + rel + "]";
	}
	
}
