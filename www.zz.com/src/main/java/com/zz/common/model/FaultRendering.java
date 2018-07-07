package com.zz.common.model;

public class FaultRendering {

	private String id;
	private String type;
	private String key;
	private String epuName;
	private String faultType;
	private String faultTypeName;
	private String occur_time;
	private String is_cancelled;
	private String is_repaired;
	private String repair_time;
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
	public String getFaultType() {
		return faultType;
	}
	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}
	public String getFaultTypeName() {
		return faultTypeName;
	}
	public void setFaultTypeName(String faultTypeName) {
		this.faultTypeName = faultTypeName;
	}
	public String getOccur_time() {
		return occur_time;
	}
	public void setOccur_time(String occur_time) {
		this.occur_time = occur_time;
	}
	public String getIs_cancelled() {
		return is_cancelled;
	}
	public void setIs_cancelled(String is_cancelled) {
		this.is_cancelled = is_cancelled;
	}
	public String getIs_repaired() {
		return is_repaired;
	}
	public void setIs_repaired(String is_repaired) {
		this.is_repaired = is_repaired;
	}
	public String getRepair_time() {
		return repair_time;
	}
	public void setRepair_time(String repair_time) {
		this.repair_time = repair_time;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((epuName == null) ? 0 : epuName.hashCode());
		result = prime * result + ((faultType == null) ? 0 : faultType.hashCode());
		result = prime * result + ((faultTypeName == null) ? 0 : faultTypeName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((is_cancelled == null) ? 0 : is_cancelled.hashCode());
		result = prime * result + ((is_repaired == null) ? 0 : is_repaired.hashCode());
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((occur_time == null) ? 0 : occur_time.hashCode());
		result = prime * result + ((repair_time == null) ? 0 : repair_time.hashCode());
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
		FaultRendering other = (FaultRendering) obj;
		if (epuName == null) {
			if (other.epuName != null)
				return false;
		} else if (!epuName.equals(other.epuName))
			return false;
		if (faultType == null) {
			if (other.faultType != null)
				return false;
		} else if (!faultType.equals(other.faultType))
			return false;
		if (faultTypeName == null) {
			if (other.faultTypeName != null)
				return false;
		} else if (!faultTypeName.equals(other.faultTypeName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (is_cancelled == null) {
			if (other.is_cancelled != null)
				return false;
		} else if (!is_cancelled.equals(other.is_cancelled))
			return false;
		if (is_repaired == null) {
			if (other.is_repaired != null)
				return false;
		} else if (!is_repaired.equals(other.is_repaired))
			return false;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (occur_time == null) {
			if (other.occur_time != null)
				return false;
		} else if (!occur_time.equals(other.occur_time))
			return false;
		if (repair_time == null) {
			if (other.repair_time != null)
				return false;
		} else if (!repair_time.equals(other.repair_time))
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
		return "FaultRendering [id=" + id + ", type=" + type + ", key=" + key + ", epuName=" + epuName + ", faultType="
				+ faultType + ", faultTypeName=" + faultTypeName + ", occur_time=" + occur_time + ", is_cancelled="
				+ is_cancelled + ", is_repaired=" + is_repaired + ", repair_time=" + repair_time + "]";
	}
	
}
