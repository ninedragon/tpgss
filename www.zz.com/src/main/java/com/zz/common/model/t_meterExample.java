package com.zz.common.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class t_meterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public t_meterExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMeterIdIsNull() {
            addCriterion("meterId is null");
            return (Criteria) this;
        }

        public Criteria andMeterIdIsNotNull() {
            addCriterion("meterId is not null");
            return (Criteria) this;
        }

        public Criteria andMeterIdEqualTo(String value) {
            addCriterion("meterId =", value, "meterId");
            return (Criteria) this;
        }

        public Criteria andMeterIdNotEqualTo(String value) {
            addCriterion("meterId <>", value, "meterId");
            return (Criteria) this;
        }

        public Criteria andMeterIdGreaterThan(String value) {
            addCriterion("meterId >", value, "meterId");
            return (Criteria) this;
        }

        public Criteria andMeterIdGreaterThanOrEqualTo(String value) {
            addCriterion("meterId >=", value, "meterId");
            return (Criteria) this;
        }

        public Criteria andMeterIdLessThan(String value) {
            addCriterion("meterId <", value, "meterId");
            return (Criteria) this;
        }

        public Criteria andMeterIdLessThanOrEqualTo(String value) {
            addCriterion("meterId <=", value, "meterId");
            return (Criteria) this;
        }

        public Criteria andMeterIdLike(String value) {
            addCriterion("meterId like", value, "meterId");
            return (Criteria) this;
        }

        public Criteria andMeterIdNotLike(String value) {
            addCriterion("meterId not like", value, "meterId");
            return (Criteria) this;
        }

        public Criteria andMeterIdIn(List<String> values) {
            addCriterion("meterId in", values, "meterId");
            return (Criteria) this;
        }

        public Criteria andMeterIdNotIn(List<String> values) {
            addCriterion("meterId not in", values, "meterId");
            return (Criteria) this;
        }

        public Criteria andMeterIdBetween(String value1, String value2) {
            addCriterion("meterId between", value1, value2, "meterId");
            return (Criteria) this;
        }

        public Criteria andMeterIdNotBetween(String value1, String value2) {
            addCriterion("meterId not between", value1, value2, "meterId");
            return (Criteria) this;
        }

        public Criteria andMeterBoxIdIsNull() {
            addCriterion("meterBoxId is null");
            return (Criteria) this;
        }

        public Criteria andMeterBoxIdIsNotNull() {
            addCriterion("meterBoxId is not null");
            return (Criteria) this;
        }

        public Criteria andMeterBoxIdEqualTo(String value) {
            addCriterion("meterBoxId =", value, "meterBoxId");
            return (Criteria) this;
        }

        public Criteria andMeterBoxIdNotEqualTo(String value) {
            addCriterion("meterBoxId <>", value, "meterBoxId");
            return (Criteria) this;
        }

        public Criteria andMeterBoxIdGreaterThan(String value) {
            addCriterion("meterBoxId >", value, "meterBoxId");
            return (Criteria) this;
        }

        public Criteria andMeterBoxIdGreaterThanOrEqualTo(String value) {
            addCriterion("meterBoxId >=", value, "meterBoxId");
            return (Criteria) this;
        }

        public Criteria andMeterBoxIdLessThan(String value) {
            addCriterion("meterBoxId <", value, "meterBoxId");
            return (Criteria) this;
        }

        public Criteria andMeterBoxIdLessThanOrEqualTo(String value) {
            addCriterion("meterBoxId <=", value, "meterBoxId");
            return (Criteria) this;
        }

        public Criteria andMeterBoxIdLike(String value) {
            addCriterion("meterBoxId like", value, "meterBoxId");
            return (Criteria) this;
        }

        public Criteria andMeterBoxIdNotLike(String value) {
            addCriterion("meterBoxId not like", value, "meterBoxId");
            return (Criteria) this;
        }

        public Criteria andMeterBoxIdIn(List<String> values) {
            addCriterion("meterBoxId in", values, "meterBoxId");
            return (Criteria) this;
        }

        public Criteria andMeterBoxIdNotIn(List<String> values) {
            addCriterion("meterBoxId not in", values, "meterBoxId");
            return (Criteria) this;
        }

        public Criteria andMeterBoxIdBetween(String value1, String value2) {
            addCriterion("meterBoxId between", value1, value2, "meterBoxId");
            return (Criteria) this;
        }

        public Criteria andMeterBoxIdNotBetween(String value1, String value2) {
            addCriterion("meterBoxId not between", value1, value2, "meterBoxId");
            return (Criteria) this;
        }

        public Criteria andMeter_nameIsNull() {
            addCriterion("meter_name is null");
            return (Criteria) this;
        }

        public Criteria andMeter_nameIsNotNull() {
            addCriterion("meter_name is not null");
            return (Criteria) this;
        }

        public Criteria andMeter_nameEqualTo(String value) {
            addCriterion("meter_name =", value, "meter_name");
            return (Criteria) this;
        }

        public Criteria andMeter_nameNotEqualTo(String value) {
            addCriterion("meter_name <>", value, "meter_name");
            return (Criteria) this;
        }

        public Criteria andMeter_nameGreaterThan(String value) {
            addCriterion("meter_name >", value, "meter_name");
            return (Criteria) this;
        }

        public Criteria andMeter_nameGreaterThanOrEqualTo(String value) {
            addCriterion("meter_name >=", value, "meter_name");
            return (Criteria) this;
        }

        public Criteria andMeter_nameLessThan(String value) {
            addCriterion("meter_name <", value, "meter_name");
            return (Criteria) this;
        }

        public Criteria andMeter_nameLessThanOrEqualTo(String value) {
            addCriterion("meter_name <=", value, "meter_name");
            return (Criteria) this;
        }

        public Criteria andMeter_nameLike(String value) {
            addCriterion("meter_name like", value, "meter_name");
            return (Criteria) this;
        }

        public Criteria andMeter_nameNotLike(String value) {
            addCriterion("meter_name not like", value, "meter_name");
            return (Criteria) this;
        }

        public Criteria andMeter_nameIn(List<String> values) {
            addCriterion("meter_name in", values, "meter_name");
            return (Criteria) this;
        }

        public Criteria andMeter_nameNotIn(List<String> values) {
            addCriterion("meter_name not in", values, "meter_name");
            return (Criteria) this;
        }

        public Criteria andMeter_nameBetween(String value1, String value2) {
            addCriterion("meter_name between", value1, value2, "meter_name");
            return (Criteria) this;
        }

        public Criteria andMeter_nameNotBetween(String value1, String value2) {
            addCriterion("meter_name not between", value1, value2, "meter_name");
            return (Criteria) this;
        }

        public Criteria andMeter_noIsNull() {
            addCriterion("meter_no is null");
            return (Criteria) this;
        }

        public Criteria andMeter_noIsNotNull() {
            addCriterion("meter_no is not null");
            return (Criteria) this;
        }

        public Criteria andMeter_noEqualTo(String value) {
            addCriterion("meter_no =", value, "meter_no");
            return (Criteria) this;
        }

        public Criteria andMeter_noNotEqualTo(String value) {
            addCriterion("meter_no <>", value, "meter_no");
            return (Criteria) this;
        }

        public Criteria andMeter_noGreaterThan(String value) {
            addCriterion("meter_no >", value, "meter_no");
            return (Criteria) this;
        }

        public Criteria andMeter_noGreaterThanOrEqualTo(String value) {
            addCriterion("meter_no >=", value, "meter_no");
            return (Criteria) this;
        }

        public Criteria andMeter_noLessThan(String value) {
            addCriterion("meter_no <", value, "meter_no");
            return (Criteria) this;
        }

        public Criteria andMeter_noLessThanOrEqualTo(String value) {
            addCriterion("meter_no <=", value, "meter_no");
            return (Criteria) this;
        }

        public Criteria andMeter_noLike(String value) {
            addCriterion("meter_no like", value, "meter_no");
            return (Criteria) this;
        }

        public Criteria andMeter_noNotLike(String value) {
            addCriterion("meter_no not like", value, "meter_no");
            return (Criteria) this;
        }

        public Criteria andMeter_noIn(List<String> values) {
            addCriterion("meter_no in", values, "meter_no");
            return (Criteria) this;
        }

        public Criteria andMeter_noNotIn(List<String> values) {
            addCriterion("meter_no not in", values, "meter_no");
            return (Criteria) this;
        }

        public Criteria andMeter_noBetween(String value1, String value2) {
            addCriterion("meter_no between", value1, value2, "meter_no");
            return (Criteria) this;
        }

        public Criteria andMeter_noNotBetween(String value1, String value2) {
            addCriterion("meter_no not between", value1, value2, "meter_no");
            return (Criteria) this;
        }

        public Criteria andHouse_idIsNull() {
            addCriterion("house_id is null");
            return (Criteria) this;
        }

        public Criteria andHouse_idIsNotNull() {
            addCriterion("house_id is not null");
            return (Criteria) this;
        }

        public Criteria andHouse_idEqualTo(String value) {
            addCriterion("house_id =", value, "house_id");
            return (Criteria) this;
        }

        public Criteria andHouse_idNotEqualTo(String value) {
            addCriterion("house_id <>", value, "house_id");
            return (Criteria) this;
        }

        public Criteria andHouse_idGreaterThan(String value) {
            addCriterion("house_id >", value, "house_id");
            return (Criteria) this;
        }

        public Criteria andHouse_idGreaterThanOrEqualTo(String value) {
            addCriterion("house_id >=", value, "house_id");
            return (Criteria) this;
        }

        public Criteria andHouse_idLessThan(String value) {
            addCriterion("house_id <", value, "house_id");
            return (Criteria) this;
        }

        public Criteria andHouse_idLessThanOrEqualTo(String value) {
            addCriterion("house_id <=", value, "house_id");
            return (Criteria) this;
        }

        public Criteria andHouse_idLike(String value) {
            addCriterion("house_id like", value, "house_id");
            return (Criteria) this;
        }

        public Criteria andHouse_idNotLike(String value) {
            addCriterion("house_id not like", value, "house_id");
            return (Criteria) this;
        }

        public Criteria andHouse_idIn(List<String> values) {
            addCriterion("house_id in", values, "house_id");
            return (Criteria) this;
        }

        public Criteria andHouse_idNotIn(List<String> values) {
            addCriterion("house_id not in", values, "house_id");
            return (Criteria) this;
        }

        public Criteria andHouse_idBetween(String value1, String value2) {
            addCriterion("house_id between", value1, value2, "house_id");
            return (Criteria) this;
        }

        public Criteria andHouse_idNotBetween(String value1, String value2) {
            addCriterion("house_id not between", value1, value2, "house_id");
            return (Criteria) this;
        }

        public Criteria andPhase_remarkIsNull() {
            addCriterion("phase_remark is null");
            return (Criteria) this;
        }

        public Criteria andPhase_remarkIsNotNull() {
            addCriterion("phase_remark is not null");
            return (Criteria) this;
        }

        public Criteria andPhase_remarkEqualTo(String value) {
            addCriterion("phase_remark =", value, "phase_remark");
            return (Criteria) this;
        }

        public Criteria andPhase_remarkNotEqualTo(String value) {
            addCriterion("phase_remark <>", value, "phase_remark");
            return (Criteria) this;
        }

        public Criteria andPhase_remarkGreaterThan(String value) {
            addCriterion("phase_remark >", value, "phase_remark");
            return (Criteria) this;
        }

        public Criteria andPhase_remarkGreaterThanOrEqualTo(String value) {
            addCriterion("phase_remark >=", value, "phase_remark");
            return (Criteria) this;
        }

        public Criteria andPhase_remarkLessThan(String value) {
            addCriterion("phase_remark <", value, "phase_remark");
            return (Criteria) this;
        }

        public Criteria andPhase_remarkLessThanOrEqualTo(String value) {
            addCriterion("phase_remark <=", value, "phase_remark");
            return (Criteria) this;
        }

        public Criteria andPhase_remarkLike(String value) {
            addCriterion("phase_remark like", value, "phase_remark");
            return (Criteria) this;
        }

        public Criteria andPhase_remarkNotLike(String value) {
            addCriterion("phase_remark not like", value, "phase_remark");
            return (Criteria) this;
        }

        public Criteria andPhase_remarkIn(List<String> values) {
            addCriterion("phase_remark in", values, "phase_remark");
            return (Criteria) this;
        }

        public Criteria andPhase_remarkNotIn(List<String> values) {
            addCriterion("phase_remark not in", values, "phase_remark");
            return (Criteria) this;
        }

        public Criteria andPhase_remarkBetween(String value1, String value2) {
            addCriterion("phase_remark between", value1, value2, "phase_remark");
            return (Criteria) this;
        }

        public Criteria andPhase_remarkNotBetween(String value1, String value2) {
            addCriterion("phase_remark not between", value1, value2, "phase_remark");
            return (Criteria) this;
        }

        public Criteria andC_DistrictBCDIdIsNull() {
            addCriterion("C_DistrictBCDId is null");
            return (Criteria) this;
        }

        public Criteria andC_DistrictBCDIdIsNotNull() {
            addCriterion("C_DistrictBCDId is not null");
            return (Criteria) this;
        }

        public Criteria andC_DistrictBCDIdEqualTo(String value) {
            addCriterion("C_DistrictBCDId =", value, "c_DistrictBCDId");
            return (Criteria) this;
        }

        public Criteria andC_DistrictBCDIdNotEqualTo(String value) {
            addCriterion("C_DistrictBCDId <>", value, "c_DistrictBCDId");
            return (Criteria) this;
        }

        public Criteria andC_DistrictBCDIdGreaterThan(String value) {
            addCriterion("C_DistrictBCDId >", value, "c_DistrictBCDId");
            return (Criteria) this;
        }

        public Criteria andC_DistrictBCDIdGreaterThanOrEqualTo(String value) {
            addCriterion("C_DistrictBCDId >=", value, "c_DistrictBCDId");
            return (Criteria) this;
        }

        public Criteria andC_DistrictBCDIdLessThan(String value) {
            addCriterion("C_DistrictBCDId <", value, "c_DistrictBCDId");
            return (Criteria) this;
        }

        public Criteria andC_DistrictBCDIdLessThanOrEqualTo(String value) {
            addCriterion("C_DistrictBCDId <=", value, "c_DistrictBCDId");
            return (Criteria) this;
        }

        public Criteria andC_DistrictBCDIdLike(String value) {
            addCriterion("C_DistrictBCDId like", value, "c_DistrictBCDId");
            return (Criteria) this;
        }

        public Criteria andC_DistrictBCDIdNotLike(String value) {
            addCriterion("C_DistrictBCDId not like", value, "c_DistrictBCDId");
            return (Criteria) this;
        }

        public Criteria andC_DistrictBCDIdIn(List<String> values) {
            addCriterion("C_DistrictBCDId in", values, "c_DistrictBCDId");
            return (Criteria) this;
        }

        public Criteria andC_DistrictBCDIdNotIn(List<String> values) {
            addCriterion("C_DistrictBCDId not in", values, "c_DistrictBCDId");
            return (Criteria) this;
        }

        public Criteria andC_DistrictBCDIdBetween(String value1, String value2) {
            addCriterion("C_DistrictBCDId between", value1, value2, "c_DistrictBCDId");
            return (Criteria) this;
        }

        public Criteria andC_DistrictBCDIdNotBetween(String value1, String value2) {
            addCriterion("C_DistrictBCDId not between", value1, value2, "c_DistrictBCDId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdIsNull() {
            addCriterion("C_AddressId is null");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdIsNotNull() {
            addCriterion("C_AddressId is not null");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdEqualTo(String value) {
            addCriterion("C_AddressId =", value, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdNotEqualTo(String value) {
            addCriterion("C_AddressId <>", value, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdGreaterThan(String value) {
            addCriterion("C_AddressId >", value, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdGreaterThanOrEqualTo(String value) {
            addCriterion("C_AddressId >=", value, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdLessThan(String value) {
            addCriterion("C_AddressId <", value, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdLessThanOrEqualTo(String value) {
            addCriterion("C_AddressId <=", value, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdLike(String value) {
            addCriterion("C_AddressId like", value, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdNotLike(String value) {
            addCriterion("C_AddressId not like", value, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdIn(List<String> values) {
            addCriterion("C_AddressId in", values, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdNotIn(List<String> values) {
            addCriterion("C_AddressId not in", values, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdBetween(String value1, String value2) {
            addCriterion("C_AddressId between", value1, value2, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdNotBetween(String value1, String value2) {
            addCriterion("C_AddressId not between", value1, value2, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_ChannelIdIsNull() {
            addCriterion("C_ChannelId is null");
            return (Criteria) this;
        }

        public Criteria andC_ChannelIdIsNotNull() {
            addCriterion("C_ChannelId is not null");
            return (Criteria) this;
        }

        public Criteria andC_ChannelIdEqualTo(Integer value) {
            addCriterion("C_ChannelId =", value, "c_ChannelId");
            return (Criteria) this;
        }

        public Criteria andC_ChannelIdNotEqualTo(Integer value) {
            addCriterion("C_ChannelId <>", value, "c_ChannelId");
            return (Criteria) this;
        }

        public Criteria andC_ChannelIdGreaterThan(Integer value) {
            addCriterion("C_ChannelId >", value, "c_ChannelId");
            return (Criteria) this;
        }

        public Criteria andC_ChannelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("C_ChannelId >=", value, "c_ChannelId");
            return (Criteria) this;
        }

        public Criteria andC_ChannelIdLessThan(Integer value) {
            addCriterion("C_ChannelId <", value, "c_ChannelId");
            return (Criteria) this;
        }

        public Criteria andC_ChannelIdLessThanOrEqualTo(Integer value) {
            addCriterion("C_ChannelId <=", value, "c_ChannelId");
            return (Criteria) this;
        }

        public Criteria andC_ChannelIdIn(List<Integer> values) {
            addCriterion("C_ChannelId in", values, "c_ChannelId");
            return (Criteria) this;
        }

        public Criteria andC_ChannelIdNotIn(List<Integer> values) {
            addCriterion("C_ChannelId not in", values, "c_ChannelId");
            return (Criteria) this;
        }

        public Criteria andC_ChannelIdBetween(Integer value1, Integer value2) {
            addCriterion("C_ChannelId between", value1, value2, "c_ChannelId");
            return (Criteria) this;
        }

        public Criteria andC_ChannelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("C_ChannelId not between", value1, value2, "c_ChannelId");
            return (Criteria) this;
        }

        public Criteria andCREATE_TIMEIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCREATE_TIMEIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCREATE_TIMEEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "CREATE_TIME");
            return (Criteria) this;
        }

        public Criteria andCREATE_TIMENotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "CREATE_TIME");
            return (Criteria) this;
        }

        public Criteria andCREATE_TIMEGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "CREATE_TIME");
            return (Criteria) this;
        }

        public Criteria andCREATE_TIMEGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "CREATE_TIME");
            return (Criteria) this;
        }

        public Criteria andCREATE_TIMELessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "CREATE_TIME");
            return (Criteria) this;
        }

        public Criteria andCREATE_TIMELessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "CREATE_TIME");
            return (Criteria) this;
        }

        public Criteria andCREATE_TIMEIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "CREATE_TIME");
            return (Criteria) this;
        }

        public Criteria andCREATE_TIMENotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "CREATE_TIME");
            return (Criteria) this;
        }

        public Criteria andCREATE_TIMEBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "CREATE_TIME");
            return (Criteria) this;
        }

        public Criteria andCREATE_TIMENotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "CREATE_TIME");
            return (Criteria) this;
        }

        public Criteria andCREATE_IDIsNull() {
            addCriterion("CREATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andCREATE_IDIsNotNull() {
            addCriterion("CREATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCREATE_IDEqualTo(String value) {
            addCriterion("CREATE_ID =", value, "CREATE_ID");
            return (Criteria) this;
        }

        public Criteria andCREATE_IDNotEqualTo(String value) {
            addCriterion("CREATE_ID <>", value, "CREATE_ID");
            return (Criteria) this;
        }

        public Criteria andCREATE_IDGreaterThan(String value) {
            addCriterion("CREATE_ID >", value, "CREATE_ID");
            return (Criteria) this;
        }

        public Criteria andCREATE_IDGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_ID >=", value, "CREATE_ID");
            return (Criteria) this;
        }

        public Criteria andCREATE_IDLessThan(String value) {
            addCriterion("CREATE_ID <", value, "CREATE_ID");
            return (Criteria) this;
        }

        public Criteria andCREATE_IDLessThanOrEqualTo(String value) {
            addCriterion("CREATE_ID <=", value, "CREATE_ID");
            return (Criteria) this;
        }

        public Criteria andCREATE_IDLike(String value) {
            addCriterion("CREATE_ID like", value, "CREATE_ID");
            return (Criteria) this;
        }

        public Criteria andCREATE_IDNotLike(String value) {
            addCriterion("CREATE_ID not like", value, "CREATE_ID");
            return (Criteria) this;
        }

        public Criteria andCREATE_IDIn(List<String> values) {
            addCriterion("CREATE_ID in", values, "CREATE_ID");
            return (Criteria) this;
        }

        public Criteria andCREATE_IDNotIn(List<String> values) {
            addCriterion("CREATE_ID not in", values, "CREATE_ID");
            return (Criteria) this;
        }

        public Criteria andCREATE_IDBetween(String value1, String value2) {
            addCriterion("CREATE_ID between", value1, value2, "CREATE_ID");
            return (Criteria) this;
        }

        public Criteria andCREATE_IDNotBetween(String value1, String value2) {
            addCriterion("CREATE_ID not between", value1, value2, "CREATE_ID");
            return (Criteria) this;
        }

        public Criteria andUPDATE_TIMEIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUPDATE_TIMEIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUPDATE_TIMEEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "UPDATE_TIME");
            return (Criteria) this;
        }

        public Criteria andUPDATE_TIMENotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "UPDATE_TIME");
            return (Criteria) this;
        }

        public Criteria andUPDATE_TIMEGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "UPDATE_TIME");
            return (Criteria) this;
        }

        public Criteria andUPDATE_TIMEGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "UPDATE_TIME");
            return (Criteria) this;
        }

        public Criteria andUPDATE_TIMELessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "UPDATE_TIME");
            return (Criteria) this;
        }

        public Criteria andUPDATE_TIMELessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "UPDATE_TIME");
            return (Criteria) this;
        }

        public Criteria andUPDATE_TIMEIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "UPDATE_TIME");
            return (Criteria) this;
        }

        public Criteria andUPDATE_TIMENotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "UPDATE_TIME");
            return (Criteria) this;
        }

        public Criteria andUPDATE_TIMEBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "UPDATE_TIME");
            return (Criteria) this;
        }

        public Criteria andUPDATE_TIMENotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "UPDATE_TIME");
            return (Criteria) this;
        }

        public Criteria andUPDATE_IDIsNull() {
            addCriterion("UPDATE_ID is null");
            return (Criteria) this;
        }

        public Criteria andUPDATE_IDIsNotNull() {
            addCriterion("UPDATE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUPDATE_IDEqualTo(String value) {
            addCriterion("UPDATE_ID =", value, "UPDATE_ID");
            return (Criteria) this;
        }

        public Criteria andUPDATE_IDNotEqualTo(String value) {
            addCriterion("UPDATE_ID <>", value, "UPDATE_ID");
            return (Criteria) this;
        }

        public Criteria andUPDATE_IDGreaterThan(String value) {
            addCriterion("UPDATE_ID >", value, "UPDATE_ID");
            return (Criteria) this;
        }

        public Criteria andUPDATE_IDGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_ID >=", value, "UPDATE_ID");
            return (Criteria) this;
        }

        public Criteria andUPDATE_IDLessThan(String value) {
            addCriterion("UPDATE_ID <", value, "UPDATE_ID");
            return (Criteria) this;
        }

        public Criteria andUPDATE_IDLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_ID <=", value, "UPDATE_ID");
            return (Criteria) this;
        }

        public Criteria andUPDATE_IDLike(String value) {
            addCriterion("UPDATE_ID like", value, "UPDATE_ID");
            return (Criteria) this;
        }

        public Criteria andUPDATE_IDNotLike(String value) {
            addCriterion("UPDATE_ID not like", value, "UPDATE_ID");
            return (Criteria) this;
        }

        public Criteria andUPDATE_IDIn(List<String> values) {
            addCriterion("UPDATE_ID in", values, "UPDATE_ID");
            return (Criteria) this;
        }

        public Criteria andUPDATE_IDNotIn(List<String> values) {
            addCriterion("UPDATE_ID not in", values, "UPDATE_ID");
            return (Criteria) this;
        }

        public Criteria andUPDATE_IDBetween(String value1, String value2) {
            addCriterion("UPDATE_ID between", value1, value2, "UPDATE_ID");
            return (Criteria) this;
        }

        public Criteria andUPDATE_IDNotBetween(String value1, String value2) {
            addCriterion("UPDATE_ID not between", value1, value2, "UPDATE_ID");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGIsNull() {
            addCriterion("DEL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGIsNotNull() {
            addCriterion("DEL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGEqualTo(String value) {
            addCriterion("DEL_FLAG =", value, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGNotEqualTo(String value) {
            addCriterion("DEL_FLAG <>", value, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGGreaterThan(String value) {
            addCriterion("DEL_FLAG >", value, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGGreaterThanOrEqualTo(String value) {
            addCriterion("DEL_FLAG >=", value, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGLessThan(String value) {
            addCriterion("DEL_FLAG <", value, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGLessThanOrEqualTo(String value) {
            addCriterion("DEL_FLAG <=", value, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGLike(String value) {
            addCriterion("DEL_FLAG like", value, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGNotLike(String value) {
            addCriterion("DEL_FLAG not like", value, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGIn(List<String> values) {
            addCriterion("DEL_FLAG in", values, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGNotIn(List<String> values) {
            addCriterion("DEL_FLAG not in", values, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGBetween(String value1, String value2) {
            addCriterion("DEL_FLAG between", value1, value2, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andDEL_FLAGNotBetween(String value1, String value2) {
            addCriterion("DEL_FLAG not between", value1, value2, "DEL_FLAG");
            return (Criteria) this;
        }

        public Criteria andLeak_channel_idIsNull() {
            addCriterion("leak_channel_id is null");
            return (Criteria) this;
        }

        public Criteria andLeak_channel_idIsNotNull() {
            addCriterion("leak_channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andLeak_channel_idEqualTo(Integer value) {
            addCriterion("leak_channel_id =", value, "leak_channel_id");
            return (Criteria) this;
        }

        public Criteria andLeak_channel_idNotEqualTo(Integer value) {
            addCriterion("leak_channel_id <>", value, "leak_channel_id");
            return (Criteria) this;
        }

        public Criteria andLeak_channel_idGreaterThan(Integer value) {
            addCriterion("leak_channel_id >", value, "leak_channel_id");
            return (Criteria) this;
        }

        public Criteria andLeak_channel_idGreaterThanOrEqualTo(Integer value) {
            addCriterion("leak_channel_id >=", value, "leak_channel_id");
            return (Criteria) this;
        }

        public Criteria andLeak_channel_idLessThan(Integer value) {
            addCriterion("leak_channel_id <", value, "leak_channel_id");
            return (Criteria) this;
        }

        public Criteria andLeak_channel_idLessThanOrEqualTo(Integer value) {
            addCriterion("leak_channel_id <=", value, "leak_channel_id");
            return (Criteria) this;
        }

        public Criteria andLeak_channel_idIn(List<Integer> values) {
            addCriterion("leak_channel_id in", values, "leak_channel_id");
            return (Criteria) this;
        }

        public Criteria andLeak_channel_idNotIn(List<Integer> values) {
            addCriterion("leak_channel_id not in", values, "leak_channel_id");
            return (Criteria) this;
        }

        public Criteria andLeak_channel_idBetween(Integer value1, Integer value2) {
            addCriterion("leak_channel_id between", value1, value2, "leak_channel_id");
            return (Criteria) this;
        }

        public Criteria andLeak_channel_idNotBetween(Integer value1, Integer value2) {
            addCriterion("leak_channel_id not between", value1, value2, "leak_channel_id");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}