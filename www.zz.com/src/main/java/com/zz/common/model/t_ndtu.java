package com.zz.common.model;

public class t_ndtu {
    private Long id;

    private String c_DistrictBCDId;

    private String c_AddressId;

    private Integer c_ChannelNum;

    private String c_HardwareVer;

    private String c_SoftwareVer;

    private String c_FixIP;

    private String c_LastComTime;

    private String c_SoftUpdateDate;

    private String c_InstallDate;

    private String c_Desp;

    private String nbDeviceId;

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

    public String getC_AddressId() {
        return c_AddressId;
    }

    public void setC_AddressId(String c_AddressId) {
        this.c_AddressId = c_AddressId == null ? null : c_AddressId.trim();
    }

    public Integer getC_ChannelNum() {
        return c_ChannelNum;
    }

    public void setC_ChannelNum(Integer c_ChannelNum) {
        this.c_ChannelNum = c_ChannelNum;
    }

    public String getC_HardwareVer() {
        return c_HardwareVer;
    }

    public void setC_HardwareVer(String c_HardwareVer) {
        this.c_HardwareVer = c_HardwareVer == null ? null : c_HardwareVer.trim();
    }

    public String getC_SoftwareVer() {
        return c_SoftwareVer;
    }

    public void setC_SoftwareVer(String c_SoftwareVer) {
        this.c_SoftwareVer = c_SoftwareVer == null ? null : c_SoftwareVer.trim();
    }

    public String getC_FixIP() {
        return c_FixIP;
    }

    public void setC_FixIP(String c_FixIP) {
        this.c_FixIP = c_FixIP == null ? null : c_FixIP.trim();
    }

    public String getC_LastComTime() {
        return c_LastComTime;
    }

    public void setC_LastComTime(String c_LastComTime) {
        this.c_LastComTime = c_LastComTime == null ? null : c_LastComTime.trim();
    }

    public String getC_SoftUpdateDate() {
        return c_SoftUpdateDate;
    }

    public void setC_SoftUpdateDate(String c_SoftUpdateDate) {
        this.c_SoftUpdateDate = c_SoftUpdateDate == null ? null : c_SoftUpdateDate.trim();
    }

    public String getC_InstallDate() {
        return c_InstallDate;
    }

    public void setC_InstallDate(String c_InstallDate) {
        this.c_InstallDate = c_InstallDate == null ? null : c_InstallDate.trim();
    }

    public String getC_Desp() {
        return c_Desp;
    }

    public void setC_Desp(String c_Desp) {
        this.c_Desp = c_Desp == null ? null : c_Desp.trim();
    }

    public String getNbDeviceId() {
        return nbDeviceId;
    }

    public void setNbDeviceId(String nbDeviceId) {
        this.nbDeviceId = nbDeviceId == null ? null : nbDeviceId.trim();
    }
}