package com.zz.common.model;

import java.util.Date;

public class t_branchbox {
    private String branchBoxId;

    private String outgoingCabinetId;

    private String epu_name;

    private String epu_local;

    private String c_DistrictBCDId;

    private String c_AddressId;

    private Integer c_ChannelId;

    private Integer c_ChannelId_b;

    private Integer c_ChannelId_c;

    private String line_id;

    private Date CREATE_TIME;

    private String CREATE_ID;

    private Date UPDATE_TIME;

    private String UPDATE_ID;

    private String DEL_FLAG;

    private String epu_province;

    private String epu_city;

    private String epu_district;

    public String getBranchBoxId() {
        return branchBoxId;
    }

    public void setBranchBoxId(String branchBoxId) {
        this.branchBoxId = branchBoxId == null ? null : branchBoxId.trim();
    }

    public String getOutgoingCabinetId() {
        return outgoingCabinetId;
    }

    public void setOutgoingCabinetId(String outgoingCabinetId) {
        this.outgoingCabinetId = outgoingCabinetId == null ? null : outgoingCabinetId.trim();
    }

    public String getEpu_name() {
        return epu_name;
    }

    public void setEpu_name(String epu_name) {
        this.epu_name = epu_name == null ? null : epu_name.trim();
    }

    public String getEpu_local() {
        return epu_local;
    }

    public void setEpu_local(String epu_local) {
        this.epu_local = epu_local == null ? null : epu_local.trim();
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

    public Integer getC_ChannelId_b() {
        return c_ChannelId_b;
    }

    public void setC_ChannelId_b(Integer c_ChannelId_b) {
        this.c_ChannelId_b = c_ChannelId_b;
    }

    public Integer getC_ChannelId_c() {
        return c_ChannelId_c;
    }

    public void setC_ChannelId_c(Integer c_ChannelId_c) {
        this.c_ChannelId_c = c_ChannelId_c;
    }

    public String getLine_id() {
        return line_id;
    }

    public void setLine_id(String line_id) {
        this.line_id = line_id == null ? null : line_id.trim();
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

    public String getEpu_province() {
        return epu_province;
    }

    public void setEpu_province(String epu_province) {
        this.epu_province = epu_province == null ? null : epu_province.trim();
    }

    public String getEpu_city() {
        return epu_city;
    }

    public void setEpu_city(String epu_city) {
        this.epu_city = epu_city == null ? null : epu_city.trim();
    }

    public String getEpu_district() {
        return epu_district;
    }

    public void setEpu_district(String epu_district) {
        this.epu_district = epu_district == null ? null : epu_district.trim();
    }
}