package com.zz.common.model;

import java.io.Serializable;

public class FaultInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String row_id;
	private String row_name;
	private String fault_type;
	private String  occur_time;
	private String  is_cancelled;
	private String  is_cancelled_name;
	private String  is_repaired;
	private String  is_repaired_name;
	private String  repair_time;
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
	public String getRepair_time() {
		return repair_time;
	}
	public void setRepair_time(String repair_time) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((epu_city == null) ? 0 : epu_city.hashCode());
		result = prime * result
				+ ((epu_city_name == null) ? 0 : epu_city_name.hashCode());
		result = prime * result
				+ ((epu_district == null) ? 0 : epu_district.hashCode());
		result = prime
				* result
				+ ((epu_district_name == null) ? 0 : epu_district_name
						.hashCode());
		result = prime * result
				+ ((epu_name == null) ? 0 : epu_name.hashCode());
		result = prime * result
				+ ((epu_province == null) ? 0 : epu_province.hashCode());
		result = prime
				* result
				+ ((epu_province_name == null) ? 0 : epu_province_name
						.hashCode());
		result = prime * result
				+ ((epu_type_name == null) ? 0 : epu_type_name.hashCode());
		result = prime * result
				+ ((faultTypeName == null) ? 0 : faultTypeName.hashCode());
		result = prime * result
				+ ((fault_base_id == null) ? 0 : fault_base_id.hashCode());
		result = prime * result
				+ ((fault_type == null) ? 0 : fault_type.hashCode());
		result = prime * result
				+ ((is_cancelled == null) ? 0 : is_cancelled.hashCode());
		result = prime
				* result
				+ ((is_cancelled_name == null) ? 0 : is_cancelled_name
						.hashCode());
		result = prime * result
				+ ((is_repaired == null) ? 0 : is_repaired.hashCode());
		result = prime
				* result
				+ ((is_repaired_name == null) ? 0 : is_repaired_name.hashCode());
		result = prime * result
				+ ((occur_time == null) ? 0 : occur_time.hashCode());
		result = prime * result
				+ ((repair_time == null) ? 0 : repair_time.hashCode());
		result = prime * result + ((row_id == null) ? 0 : row_id.hashCode());
		result = prime * result
				+ ((row_name == null) ? 0 : row_name.hashCode());
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
		FaultInfo other = (FaultInfo) obj;
		if (epu_city == null) {
			if (other.epu_city != null)
				return false;
		} else if (!epu_city.equals(other.epu_city))
			return false;
		if (epu_city_name == null) {
			if (other.epu_city_name != null)
				return false;
		} else if (!epu_city_name.equals(other.epu_city_name))
			return false;
		if (epu_district == null) {
			if (other.epu_district != null)
				return false;
		} else if (!epu_district.equals(other.epu_district))
			return false;
		if (epu_district_name == null) {
			if (other.epu_district_name != null)
				return false;
		} else if (!epu_district_name.equals(other.epu_district_name))
			return false;
		if (epu_name == null) {
			if (other.epu_name != null)
				return false;
		} else if (!epu_name.equals(other.epu_name))
			return false;
		if (epu_province == null) {
			if (other.epu_province != null)
				return false;
		} else if (!epu_province.equals(other.epu_province))
			return false;
		if (epu_province_name == null) {
			if (other.epu_province_name != null)
				return false;
		} else if (!epu_province_name.equals(other.epu_province_name))
			return false;
		if (epu_type_name == null) {
			if (other.epu_type_name != null)
				return false;
		} else if (!epu_type_name.equals(other.epu_type_name))
			return false;
		if (faultTypeName == null) {
			if (other.faultTypeName != null)
				return false;
		} else if (!faultTypeName.equals(other.faultTypeName))
			return false;
		if (fault_base_id == null) {
			if (other.fault_base_id != null)
				return false;
		} else if (!fault_base_id.equals(other.fault_base_id))
			return false;
		if (fault_type == null) {
			if (other.fault_type != null)
				return false;
		} else if (!fault_type.equals(other.fault_type))
			return false;
		if (is_cancelled == null) {
			if (other.is_cancelled != null)
				return false;
		} else if (!is_cancelled.equals(other.is_cancelled))
			return false;
		if (is_cancelled_name == null) {
			if (other.is_cancelled_name != null)
				return false;
		} else if (!is_cancelled_name.equals(other.is_cancelled_name))
			return false;
		if (is_repaired == null) {
			if (other.is_repaired != null)
				return false;
		} else if (!is_repaired.equals(other.is_repaired))
			return false;
		if (is_repaired_name == null) {
			if (other.is_repaired_name != null)
				return false;
		} else if (!is_repaired_name.equals(other.is_repaired_name))
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
		if (row_id == null) {
			if (other.row_id != null)
				return false;
		} else if (!row_id.equals(other.row_id))
			return false;
		if (row_name == null) {
			if (other.row_name != null)
				return false;
		} else if (!row_name.equals(other.row_name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FaultInfo [row_id=" + row_id + ", row_name=" + row_name
				+ ", fault_type=" + fault_type + ", occur_time=" + occur_time
				+ ", is_cancelled=" + is_cancelled + ", is_cancelled_name="
				+ is_cancelled_name + ", is_repaired=" + is_repaired
				+ ", is_repaired_name=" + is_repaired_name + ", repair_time="
				+ repair_time + ", faultTypeName=" + faultTypeName
				+ ", epu_province=" + epu_province + ", epu_city=" + epu_city
				+ ", epu_district=" + epu_district + ", epu_name=" + epu_name
				+ ", epu_province_name=" + epu_province_name
				+ ", epu_city_name=" + epu_city_name + ", epu_district_name="
				+ epu_district_name + ", epu_type_name=" + epu_type_name
				+ ", fault_base_id=" + fault_base_id + "]";
	}
	

}