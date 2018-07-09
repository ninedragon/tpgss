package com.zz.common.model;

import java.util.Date;

public class LeakageI {
    private Integer id;

    private String cDistrictbcdid;

    private Integer cAddressid;

    private Integer cChannelid;

    private Integer cFaultid;

    private Integer tsegmentid;

    private String cFramecmdid;

    private Integer recorddatebcd;

    private Float i;

    private Date cRecordinserttime;
    
    private String strCRecordinserttime;

    public String getStrCRecordinserttime() {
		return strCRecordinserttime;
	}

	public void setStrCRecordinserttime(String strCRecordinserttime) {
		this.strCRecordinserttime = strCRecordinserttime;
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

    public Integer getTsegmentid() {
        return tsegmentid;
    }

    public void setTsegmentid(Integer tsegmentid) {
        this.tsegmentid = tsegmentid;
    }

    public String getcFramecmdid() {
        return cFramecmdid;
    }

    public void setcFramecmdid(String cFramecmdid) {
        this.cFramecmdid = cFramecmdid == null ? null : cFramecmdid.trim();
    }

    public Integer getRecorddatebcd() {
        return recorddatebcd;
    }

    public void setRecorddatebcd(Integer recorddatebcd) {
        this.recorddatebcd = recorddatebcd;
    }

    public Float getI() {
        return i;
    }

    public void setI(Float i) {
        this.i = i;
    }

    public Date getcRecordinserttime() {
        return cRecordinserttime;
    }

    public void setcRecordinserttime(Date cRecordinserttime) {
        this.cRecordinserttime = cRecordinserttime;
    }
}