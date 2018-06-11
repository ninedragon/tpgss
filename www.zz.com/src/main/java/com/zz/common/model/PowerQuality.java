package com.zz.common.model;

import java.util.Date;

public class PowerQuality {
    private Integer id;

    private String cDistrictbcdid;

    private Integer cAddressid;

    private String cFramecmdid;

    private Date cRecordinserttime;

    private Integer cFaultid;

    private Float ua;

    private Float ub;

    private Float uc;

    private Integer recorddatebcd;

    private Integer tsegmentid;

    private Integer cChannelid;

    private Float p;

    private Float q;

    private Float i1;

    private Float i2;

    private Float i3;

    private Float i4;

    private Float i5;

    private Float i6;

    private Float i7;

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

    public Date getcRecordinserttime() {
        return cRecordinserttime;
    }

    public void setcRecordinserttime(Date cRecordinserttime) {
        this.cRecordinserttime = cRecordinserttime;
    }

    public Integer getcFaultid() {
        return cFaultid;
    }

    public void setcFaultid(Integer cFaultid) {
        this.cFaultid = cFaultid;
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

    public Integer getRecorddatebcd() {
        return recorddatebcd;
    }

    public void setRecorddatebcd(Integer recorddatebcd) {
        this.recorddatebcd = recorddatebcd;
    }

    public Integer getTsegmentid() {
        return tsegmentid;
    }

    public void setTsegmentid(Integer tsegmentid) {
        this.tsegmentid = tsegmentid;
    }

    public Integer getcChannelid() {
        return cChannelid;
    }

    public void setcChannelid(Integer cChannelid) {
        this.cChannelid = cChannelid;
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

    public Float getI1() {
        return i1;
    }

    public void setI1(Float i1) {
        this.i1 = i1;
    }

    public Float getI2() {
        return i2;
    }

    public void setI2(Float i2) {
        this.i2 = i2;
    }

    public Float getI3() {
        return i3;
    }

    public void setI3(Float i3) {
        this.i3 = i3;
    }

    public Float getI4() {
        return i4;
    }

    public void setI4(Float i4) {
        this.i4 = i4;
    }

    public Float getI5() {
        return i5;
    }

    public void setI5(Float i5) {
        this.i5 = i5;
    }

    public Float getI6() {
        return i6;
    }

    public void setI6(Float i6) {
        this.i6 = i6;
    }

    public Float getI7() {
        return i7;
    }

    public void setI7(Float i7) {
        this.i7 = i7;
    }
}