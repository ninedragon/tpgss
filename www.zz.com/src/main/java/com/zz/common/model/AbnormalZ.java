package com.zz.common.model;

import java.util.Date;

public class AbnormalZ {
    private Integer id;

    private String cDistrictbcdid;//

    private Integer cAddressid;//

    private Integer cChannelid;

    private String cFramecmdid;//

    private Date cRecordinserttime;//

    private Float ua;//

    private Float ub;//

    private Float uc;//

    private Float p;//

    private Float q;//

    private Float i;//

    private Integer cFaultid;

    private Integer tsegmentid;//

    private Integer recorddatebcd;

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

    public String getcFramecmdid() {
        return cFramecmdid;
    }

    public void setcFramecmdid(String cFramecmdid) {
        this.cFramecmdid = cFramecmdid == null ? null : cFramecmdid.trim();
    }

    public Date getcRecordinserttime() {
        return cRecordinserttime;
    }

    public void setcRecordinserttime(Date cRecordinserttime) {
        this.cRecordinserttime = cRecordinserttime;
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

    public Float getP() {
        return p;
    }

    public void setP(Float p) {
        this.p = p;
    }

    public Float getQ() {
        return q;
    }

    public void setQ(Float q) {
        this.q = q;
    }

    public Float getI() {
        return i;
    }

    public void setI(Float i) {
        this.i = i;
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

    public Integer getRecorddatebcd() {
        return recorddatebcd;
    }

    public void setRecorddatebcd(Integer recorddatebcd) {
        this.recorddatebcd = recorddatebcd;
    }
}