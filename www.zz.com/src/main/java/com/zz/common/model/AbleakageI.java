package com.zz.common.model;

import java.util.Date;

public class AbleakageI {
    private Integer id;

    private String cDistrictbcdid;

    private Integer cAddressid;

    private Integer cChannelid;

    private Integer cFaultid;

    private String cFramecmdid;

    private Float i;

    private Boolean isAbnormal;

    private Date cRecordinserttime;
    private String strCRecordinserttime;
    private Date occurtime;
    private String strOccurTime;
    
    public String getStrCRecordinserttime() {
		return strCRecordinserttime;
	}

	public void setStrCRecordinserttime(String strCRecordinserttime) {
		this.strCRecordinserttime = strCRecordinserttime;
	}

	public String getStrOccurTime() {
		return strOccurTime;
	}

	public void setStrOccurTime(String strOccurTime) {
		this.strOccurTime = strOccurTime;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getcDistrictbcdid() {
        return cDistrictbcdid;
    }

    public void setcDistrictbcdid(String cDistrictbcdid) {
        this.cDistrictbcdid = cDistrictbcdid == null ? null : cDistrictbcdid.trim();
    }

    public Integer getcAddressid() {
        return cAddressid;
    }

    public void setcAddressid(Integer cAddressid) {
        this.cAddressid = cAddressid;
    }

    public Integer getcChannelid() {
        return cChannelid;
    }

    public void setcChannelid(Integer cChannelid) {
        this.cChannelid = cChannelid;
    }

    public Integer getcFaultid() {
        return cFaultid;
    }

    public void setcFaultid(Integer cFaultid) {
        this.cFaultid = cFaultid;
    }

    public String getcFramecmdid() {
        return cFramecmdid;
    }

    public void setcFramecmdid(String cFramecmdid) {
        this.cFramecmdid = cFramecmdid == null ? null : cFramecmdid.trim();
    }

    public Float getI() {
        return i;
    }

    public void setI(Float i) {
        this.i = i;
    }

    public Boolean getIsAbnormal() {
        return isAbnormal;
    }

    public void setIsAbnormal(Boolean isAbnormal) {
        this.isAbnormal = isAbnormal;
    }

    public Date getcRecordinserttime() {
        return cRecordinserttime;
    }

    public void setcRecordinserttime(Date cRecordinserttime) {
        this.cRecordinserttime = cRecordinserttime;
    }

    public Date getOccurtime() {
        return occurtime;
    }

    public void setOccurtime(Date occurtime) {
        this.occurtime = occurtime;
    }
}