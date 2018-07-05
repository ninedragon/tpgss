package com.zz.common.model;

public class t_fault_source {
    private Long id;

    private String fault_id;

    private String table_name;

    private String record_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFault_id() {
        return fault_id;
    }

    public void setFault_id(String fault_id) {
        this.fault_id = fault_id == null ? null : fault_id.trim();
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name == null ? null : table_name.trim();
    }

    public String getRecord_id() {
        return record_id;
    }

    public void setRecord_id(String record_id) {
        this.record_id = record_id == null ? null : record_id.trim();
    }
}