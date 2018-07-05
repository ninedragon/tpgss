package com.zz.common.model;

import java.util.Date;

public class t_substain {
    private String substainId;

    private String epu_name;

    private String epu_local;

    private String epu_province;

    private String epu_city;

    private String epu_district;

    private Double epu_xscale;

    private Double epu_yscale;

    private Date CREATE_TIME;

    private String CREATE_ID;

    private Date UPDATE_TIME;

    private String UPDATE_ID;

    private String DEL_FLAG;

    public String getSubstainId() {
        return substainId;
    }

    public void setSubstainId(String substainId) {
        this.substainId = substainId == null ? null : substainId.trim();
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

    public Double getEpu_xscale() {
        return epu_xscale;
    }

    public void setEpu_xscale(Double epu_xscale) {
        this.epu_xscale = epu_xscale;
    }

    public Double getEpu_yscale() {
        return epu_yscale;
    }

    public void setEpu_yscale(Double epu_yscale) {
        this.epu_yscale = epu_yscale;
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