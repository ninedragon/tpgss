package com.zz.common.model;

public class Topo {
    private Long id;

    private String type;

    private Long pid;

    private String cDistrictbcdid;

    private String cAddressid;

    private Integer cChannelnum;

    private String cHardwarever;

    private String cSoftwarever;

    private String cFixip;

    private String cSoftupdatedate;

    private String cInstalldate;

    private String cDesp;

    private String nbdeviceid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getcDistrictbcdid() {
        return cDistrictbcdid;
    }

    public void setcDistrictbcdid(String cDistrictbcdid) {
        this.cDistrictbcdid = cDistrictbcdid == null ? null : cDistrictbcdid.trim();
    }

    public String getcAddressid() {
        return cAddressid;
    }

    public void setcAddressid(String cAddressid) {
        this.cAddressid = cAddressid == null ? null : cAddressid.trim();
    }

    public Integer getcChannelnum() {
        return cChannelnum;
    }

    public void setcChannelnum(Integer cChannelnum) {
        this.cChannelnum = cChannelnum;
    }

    public String getcHardwarever() {
        return cHardwarever;
    }

    public void setcHardwarever(String cHardwarever) {
        this.cHardwarever = cHardwarever == null ? null : cHardwarever.trim();
    }

    public String getcSoftwarever() {
        return cSoftwarever;
    }

    public void setcSoftwarever(String cSoftwarever) {
        this.cSoftwarever = cSoftwarever == null ? null : cSoftwarever.trim();
    }

    public String getcFixip() {
        return cFixip;
    }

    public void setcFixip(String cFixip) {
        this.cFixip = cFixip == null ? null : cFixip.trim();
    }

    public String getcSoftupdatedate() {
        return cSoftupdatedate;
    }

    public void setcSoftupdatedate(String cSoftupdatedate) {
        this.cSoftupdatedate = cSoftupdatedate == null ? null : cSoftupdatedate.trim();
    }

    public String getcInstalldate() {
        return cInstalldate;
    }

    public void setcInstalldate(String cInstalldate) {
        this.cInstalldate = cInstalldate == null ? null : cInstalldate.trim();
    }

    public String getcDesp() {
        return cDesp;
    }

    public void setcDesp(String cDesp) {
        this.cDesp = cDesp == null ? null : cDesp.trim();
    }

    public String getNbdeviceid() {
        return nbdeviceid;
    }

    public void setNbdeviceid(String nbdeviceid) {
        this.nbdeviceid = nbdeviceid == null ? null : nbdeviceid.trim();
    }
}