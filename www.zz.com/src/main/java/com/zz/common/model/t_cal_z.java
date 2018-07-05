package com.zz.common.model;

public class t_cal_z {
    private Long id;

    private String c_DistrictBCDId;

    private Integer c_AddressId;

    private Integer c_ChannelId;

    private Float za;

    private Float zb;

    private Float zc;

    private Integer record_date;

    private Boolean is_valid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Float getZa() {
        return za;
    }

    public void setZa(Float za) {
        this.za = za;
    }

    public Float getZb() {
        return zb;
    }

    public void setZb(Float zb) {
        this.zb = zb;
    }

    public Float getZc() {
        return zc;
    }

    public void setZc(Float zc) {
        this.zc = zc;
    }

    public Integer getRecord_date() {
        return record_date;
    }

    public void setRecord_date(Integer record_date) {
        this.record_date = record_date;
    }

    public Boolean getIs_valid() {
        return is_valid;
    }

    public void setIs_valid(Boolean is_valid) {
        this.is_valid = is_valid;
    }
}