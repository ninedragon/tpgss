package com.zz.common.model;

import java.util.Date;

public class AbnormalU {
    private Integer id;

    private String cDistrictbcdid;

    private Integer cAddressid;

    private String cFramecmdid;

    private Float ua;

    private Float ub;

    private Float uc;

    private Date cRecordinserttime;

    private Date occurtime;
    private Integer cFaultid;

    private Boolean isAbnormal;

    

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

    public String getcFramecmdid() {
        return cFramecmdid;
    }

    public void setcFramecmdid(String cFramecmdid) {
        this.cFramecmdid = cFramecmdid == null ? null : cFramecmdid.trim();
    }

    public Float getUa() {
        return ua;
    }

    public void setUa(Float ua) {
        this.ua = ua;
    }

    public Float getUb() {
        return ub;
    }

    public void setUb(Float ub) {
        this.ub = ub;
    }

    public Float getUc() {
        return uc;
    }

    public void setUc(Float uc) {
        this.uc = uc;
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

    public Integer getcFaultid() {
        return cFaultid;
    }

    public void setcFaultid(Integer cFaultid) {
        this.cFaultid = cFaultid;
    }

    public Boolean getIsAbnormal() {
        return isAbnormal;
    }

    public void setIsAbnormal(Boolean isAbnormal) {
        this.isAbnormal = isAbnormal;
    }
}