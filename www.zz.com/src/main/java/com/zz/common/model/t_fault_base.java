package com.zz.common.model;

import java.util.Date;

public class t_fault_base {
    private Long id;

    private Integer type;

    private String key_id;

    private Integer fault_type;

    private Date occur_time;

    private Integer is_cancelled;

    private Date repair_time;

    private Integer is_repaired;

    private String substain_id;

    private Boolean is_same;

    private String fault_base_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id == null ? null : key_id.trim();
    }

    public Integer getFault_type() {
        return fault_type;
    }

    public void setFault_type(Integer fault_type) {
        this.fault_type = fault_type;
    }

    public Date getOccur_time() {
        return occur_time;
    }

    public void setOccur_time(Date occur_time) {
        this.occur_time = occur_time;
    }

    public Integer getIs_cancelled() {
        return is_cancelled;
    }

    public void setIs_cancelled(Integer is_cancelled) {
        this.is_cancelled = is_cancelled;
    }

    public Date getRepair_time() {
        return repair_time;
    }

    public void setRepair_time(Date repair_time) {
        this.repair_time = repair_time;
    }

    public Integer getIs_repaired() {
        return is_repaired;
    }

    public void setIs_repaired(Integer is_repaired) {
        this.is_repaired = is_repaired;
    }

    public String getSubstain_id() {
        return substain_id;
    }

    public void setSubstain_id(String substain_id) {
        this.substain_id = substain_id == null ? null : substain_id.trim();
    }

    public Boolean getIs_same() {
        return is_same;
    }

    public void setIs_same(Boolean is_same) {
        this.is_same = is_same;
    }

    public String getFault_base_id() {
        return fault_base_id;
    }

    public void setFault_base_id(String fault_base_id) {
        this.fault_base_id = fault_base_id == null ? null : fault_base_id.trim();
    }
}