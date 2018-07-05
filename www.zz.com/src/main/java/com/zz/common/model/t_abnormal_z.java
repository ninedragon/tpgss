package com.zz.common.model;

import java.util.Date;

public class t_abnormal_z {
    private Integer id;

    private String c_DistrictBCDId;

    private Integer c_AddressId;

    private Integer c_ChannelId;

    private String c_FrameCmdId;

    private Date c_RecordInsertTime;

    private Float ua;

    private Float ub;

    private Float uc;

    private Float p;

    private Float q;

    private Float i;

    private Integer c_FaultId;

    private Integer TSegmentId;

    private Integer recordDateBCD;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getC_DistrictBCDId() {
        return c_DistrictBCDId;
    }

    public void setC_DistrictBCDId(String c_DistrictBCDId) {
        this.c_DistrictBCDId = c_DistrictBCDId == null ? null : c_DistrictBCDId.trim();
    }

    public Integer getC_AddressId() {
        return c_AddressId;
    }

    public void setC_AddressId(Integer c_AddressId) {
        this.c_AddressId = c_AddressId;
    }

    public Integer getC_ChannelId() {
        return c_ChannelId;
    }

    public void setC_ChannelId(Integer c_ChannelId) {
        this.c_ChannelId = c_ChannelId;
    }

    public String getC_FrameCmdId() {
        return c_FrameCmdId;
    }

    public void setC_FrameCmdId(String c_FrameCmdId) {
        this.c_FrameCmdId = c_FrameCmdId == null ? null : c_FrameCmdId.trim();
    }

    public Date getC_RecordInsertTime() {
        return c_RecordInsertTime;
    }

    public void setC_RecordInsertTime(Date c_RecordInsertTime) {
        this.c_RecordInsertTime = c_RecordInsertTime;
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

    public Integer getC_FaultId() {
        return c_FaultId;
    }

    public void setC_FaultId(Integer c_FaultId) {
        this.c_FaultId = c_FaultId;
    }

    public Integer getTSegmentId() {
        return TSegmentId;
    }

    public void setTSegmentId(Integer TSegmentId) {
        this.TSegmentId = TSegmentId;
    }

    public Integer getRecordDateBCD() {
        return recordDateBCD;
    }

    public void setRecordDateBCD(Integer recordDateBCD) {
        this.recordDateBCD = recordDateBCD;
    }
}