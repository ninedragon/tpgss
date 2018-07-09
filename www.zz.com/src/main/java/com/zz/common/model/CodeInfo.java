package com.zz.common.model;

public class CodeInfo {
	private String  CODE;
	private String  CODE_NAME;
	private String  CODE_TYPE;
	private String  CODE_TYPE_CN;
	private String  REMARK;
	public String getCODE() {
		return CODE;
	}
	public void setCODE(String cODE) {
		CODE = cODE;
	}
	public String getCODE_NAME() {
		return CODE_NAME;
	}
	public void setCODE_NAME(String cODE_NAME) {
		CODE_NAME = cODE_NAME;
	}
	public String getCODE_TYPE() {
		return CODE_TYPE;
	}
	public void setCODE_TYPE(String cODE_TYPE) {
		CODE_TYPE = cODE_TYPE;
	}
	public String getCODE_TYPE_CN() {
		return CODE_TYPE_CN;
	}
	public void setCODE_TYPE_CN(String cODE_TYPE_CN) {
		CODE_TYPE_CN = cODE_TYPE_CN;
	}
	public String getREMARK() {
		return REMARK;
	}
	public void setREMARK(String rEMARK) {
		REMARK = rEMARK;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CODE == null) ? 0 : CODE.hashCode());
		result = prime * result + ((CODE_NAME == null) ? 0 : CODE_NAME.hashCode());
		result = prime * result + ((CODE_TYPE == null) ? 0 : CODE_TYPE.hashCode());
		result = prime * result + ((CODE_TYPE_CN == null) ? 0 : CODE_TYPE_CN.hashCode());
		result = prime * result + ((REMARK == null) ? 0 : REMARK.hashCode());
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
		CodeInfo other = (CodeInfo) obj;
		if (CODE == null) {
			if (other.CODE != null)
				return false;
		} else if (!CODE.equals(other.CODE))
			return false;
		if (CODE_NAME == null) {
			if (other.CODE_NAME != null)
				return false;
		} else if (!CODE_NAME.equals(other.CODE_NAME))
			return false;
		if (CODE_TYPE == null) {
			if (other.CODE_TYPE != null)
				return false;
		} else if (!CODE_TYPE.equals(other.CODE_TYPE))
			return false;
		if (CODE_TYPE_CN == null) {
			if (other.CODE_TYPE_CN != null)
				return false;
		} else if (!CODE_TYPE_CN.equals(other.CODE_TYPE_CN))
			return false;
		if (REMARK == null) {
			if (other.REMARK != null)
				return false;
		} else if (!REMARK.equals(other.REMARK))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CodeInfo [CODE=" + CODE + ", CODE_NAME=" + CODE_NAME + ", CODE_TYPE=" + CODE_TYPE + ", CODE_TYPE_CN="
				+ CODE_TYPE_CN + ", REMARK=" + REMARK + "]";
	}
	
}
