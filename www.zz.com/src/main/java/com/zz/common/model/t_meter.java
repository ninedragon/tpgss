package com.zz.common.model;

import java.util.Date;

public class t_meter {
    private String meterId;

    private String meterBoxId;

    private String meter_name;

    private String house_id;

    private String phase_remark;

    private String c_DistrictBCDId;

    private String c_AddressId;

    private Integer c_ChannelId;

    private Date CREATE_TIME;

    private String CREATE_ID;

    private Date UPDATE_TIME;

    private String UPDATE_ID;

    private String DEL_FLAG;

    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId == null ? null : meterId.trim();
    }

    public String getMeterBoxId() {
        return meterBoxId;
    }

    public void setMeterBoxId(String meterBoxId) {
        this.meterBoxId = meterBoxId == null ? null : meterBoxId.trim();
    }

    public String getMeter_name() {
        return meter_name;
    }

    public void setMeter_name(String meter_name) {
        this.meter_name = meter_name == null ? null : meter_name.trim();
    }

    public String getHouse_id() {
        return house_id;
    }

    public void setHouse_id(String house_id) {
        this.house_id = house_id == null ? null : house_id.trim();
    }

    public String getPhase_remark() {
        return phase_remark;
    }

    public void setPhase_remark(String phase_remark) {
        this.phase_remark = phase_remark == null ? null : phase_remark.trim();
    }

    public String getC_DistrictBCDId() {
        return c_DistrictBCDId;
    }

    public void setC_DistrictBCDId(String c_DistrictBCDId) {
        this.c_DistrictBCDId = c_DistrictBCDId == null ? null : c_DistrictBCDId.trim();
    }

    public String getC_AddressId() {
        return c_AddressId;
    }

    public void setC_AddressId(String c_AddressId) {
        this.c_AddressId = c_AddressId == null ? null : c_AddressId.trim();
    }

    public Integer getC_ChannelId() {
        return c_ChannelId;
    }

    public void setC_ChannelId(Integer c_ChannelId) {
        this.c_ChannelId = c_ChannelId;
    }

    public Date getCREATE_TIME() {
        return CREATE_TIME;
    }

    public void setCREATE_TIME(Date CREATE_TIME) {
        this.CREATE_TIME = CREATE_TIME;
    }

    public String getCREATE_ID() {
        return CREATE_ID;
    }

    public void setCREATE_ID(String CREATE_ID) {
        this.CREATE_ID = CREATE_ID == null ? null : CREATE_ID.trim();
    }

    public Date getUPDATE_TIME() {
        return UPDATE_TIME;
    }

    public void setUPDATE_TIME(Date UPDATE_TIME) {
        this.UPDATE_TIME = UPDATE_TIME;
    }

    public String getUPDATE_ID() {
        return UPDATE_ID;
    }

    public void setUPDATE_ID(String UPDATE_ID) {
        this.UPDATE_ID = UPDATE_ID == null ? null : UPDATE_ID.trim();
    }

    public String getDEL_FLAG() {
        return DEL_FLAG;
    }

    public void setDEL_FLAG(String DEL_FLAG) {
        this.DEL_FLAG = DEL_FLAG == null ? null : DEL_FLAG.trim();
    }
}