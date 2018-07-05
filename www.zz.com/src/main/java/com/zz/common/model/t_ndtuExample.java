package com.zz.common.model;

import java.util.ArrayList;
import java.util.List;

public class t_ndtuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public t_ndtuExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andC_ChannelNumIsNull() {
            addCriterion("C_ChannelNum is null");
            return (Criteria) this;
        }

        public Criteria andC_ChannelNumIsNotNull() {
            addCriterion("C_ChannelNum is not null");
            return (Criteria) this;
        }

        public Criteria andC_ChannelNumEqualTo(Integer value) {
            addCriterion("C_ChannelNum =", value, "c_ChannelNum");
            return (Criteria) this;
        }

        public Criteria andC_ChannelNumNotEqualTo(Integer value) {
            addCriterion("C_ChannelNum <>", value, "c_ChannelNum");
            return (Criteria) this;
        }

        public Criteria andC_ChannelNumGreaterThan(Integer value) {
            addCriterion("C_ChannelNum >", value, "c_ChannelNum");
            return (Criteria) this;
        }

        public Criteria andC_ChannelNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("C_ChannelNum >=", value, "c_ChannelNum");
            return (Criteria) this;
        }

        public Criteria andC_ChannelNumLessThan(Integer value) {
            addCriterion("C_ChannelNum <", value, "c_ChannelNum");
            return (Criteria) this;
        }

        public Criteria andC_ChannelNumLessThanOrEqualTo(Integer value) {
            addCriterion("C_ChannelNum <=", value, "c_ChannelNum");
            return (Criteria) this;
        }

        public Criteria andC_ChannelNumIn(List<Integer> values) {
            addCriterion("C_ChannelNum in", values, "c_ChannelNum");
            return (Criteria) this;
        }

        public Criteria andC_ChannelNumNotIn(List<Integer> values) {
            addCriterion("C_ChannelNum not in", values, "c_ChannelNum");
            return (Criteria) this;
        }

        public Criteria andC_ChannelNumBetween(Integer value1, Integer value2) {
            addCriterion("C_ChannelNum between", value1, value2, "c_ChannelNum");
            return (Criteria) this;
        }

        public Criteria andC_ChannelNumNotBetween(Integer value1, Integer value2) {
            addCriterion("C_ChannelNum not between", value1, value2, "c_ChannelNum");
            return (Criteria) this;
        }

        public Criteria andC_HardwareVerIsNull() {
            addCriterion("C_HardwareVer is null");
            return (Criteria) this;
        }

        public Criteria andC_HardwareVerIsNotNull() {
            addCriterion("C_HardwareVer is not null");
            return (Criteria) this;
        }

        public Criteria andC_HardwareVerEqualTo(String value) {
            addCriterion("C_HardwareVer =", value, "c_HardwareVer");
            return (Criteria) this;
        }

        public Criteria andC_HardwareVerNotEqualTo(String value) {
            addCriterion("C_HardwareVer <>", value, "c_HardwareVer");
            return (Criteria) this;
        }

        public Criteria andC_HardwareVerGreaterThan(String value) {
            addCriterion("C_HardwareVer >", value, "c_HardwareVer");
            return (Criteria) this;
        }

        public Criteria andC_HardwareVerGreaterThanOrEqualTo(String value) {
            addCriterion("C_HardwareVer >=", value, "c_HardwareVer");
            return (Criteria) this;
        }

        public Criteria andC_HardwareVerLessThan(String value) {
            addCriterion("C_HardwareVer <", value, "c_HardwareVer");
            return (Criteria) this;
        }

        public Criteria andC_HardwareVerLessThanOrEqualTo(String value) {
            addCriterion("C_HardwareVer <=", value, "c_HardwareVer");
            return (Criteria) this;
        }

        public Criteria andC_HardwareVerLike(String value) {
            addCriterion("C_HardwareVer like", value, "c_HardwareVer");
            return (Criteria) this;
        }

        public Criteria andC_HardwareVerNotLike(String value) {
            addCriterion("C_HardwareVer not like", value, "c_HardwareVer");
            return (Criteria) this;
        }

        public Criteria andC_HardwareVerIn(List<String> values) {
            addCriterion("C_HardwareVer in", values, "c_HardwareVer");
            return (Criteria) this;
        }

        public Criteria andC_HardwareVerNotIn(List<String> values) {
            addCriterion("C_HardwareVer not in", values, "c_HardwareVer");
            return (Criteria) this;
        }

        public Criteria andC_HardwareVerBetween(String value1, String value2) {
            addCriterion("C_HardwareVer between", value1, value2, "c_HardwareVer");
            return (Criteria) this;
        }

        public Criteria andC_HardwareVerNotBetween(String value1, String value2) {
            addCriterion("C_HardwareVer not between", value1, value2, "c_HardwareVer");
            return (Criteria) this;
        }

        public Criteria andC_SoftwareVerIsNull() {
            addCriterion("C_SoftwareVer is null");
            return (Criteria) this;
        }

        public Criteria andC_SoftwareVerIsNotNull() {
            addCriterion("C_SoftwareVer is not null");
            return (Criteria) this;
        }

        public Criteria andC_SoftwareVerEqualTo(String value) {
            addCriterion("C_SoftwareVer =", value, "c_SoftwareVer");
            return (Criteria) this;
        }

        public Criteria andC_SoftwareVerNotEqualTo(String value) {
            addCriterion("C_SoftwareVer <>", value, "c_SoftwareVer");
            return (Criteria) this;
        }

        public Criteria andC_SoftwareVerGreaterThan(String value) {
            addCriterion("C_SoftwareVer >", value, "c_SoftwareVer");
            return (Criteria) this;
        }

        public Criteria andC_SoftwareVerGreaterThanOrEqualTo(String value) {
            addCriterion("C_SoftwareVer >=", value, "c_SoftwareVer");
            return (Criteria) this;
        }

        public Criteria andC_SoftwareVerLessThan(String value) {
            addCriterion("C_SoftwareVer <", value, "c_SoftwareVer");
            return (Criteria) this;
        }

        public Criteria andC_SoftwareVerLessThanOrEqualTo(String value) {
            addCriterion("C_SoftwareVer <=", value, "c_SoftwareVer");
            return (Criteria) this;
        }

        public Criteria andC_SoftwareVerLike(String value) {
            addCriterion("C_SoftwareVer like", value, "c_SoftwareVer");
            return (Criteria) this;
        }

        public Criteria andC_SoftwareVerNotLike(String value) {
            addCriterion("C_SoftwareVer not like", value, "c_SoftwareVer");
            return (Criteria) this;
        }

        public Criteria andC_SoftwareVerIn(List<String> values) {
            addCriterion("C_SoftwareVer in", values, "c_SoftwareVer");
            return (Criteria) this;
        }

        public Criteria andC_SoftwareVerNotIn(List<String> values) {
            addCriterion("C_SoftwareVer not in", values, "c_SoftwareVer");
            return (Criteria) this;
        }

        public Criteria andC_SoftwareVerBetween(String value1, String value2) {
            addCriterion("C_SoftwareVer between", value1, value2, "c_SoftwareVer");
            return (Criteria) this;
        }

        public Criteria andC_SoftwareVerNotBetween(String value1, String value2) {
            addCriterion("C_SoftwareVer not between", value1, value2, "c_SoftwareVer");
            return (Criteria) this;
        }

        public Criteria andC_FixIPIsNull() {
            addCriterion("C_FixIP is null");
            return (Criteria) this;
        }

        public Criteria andC_FixIPIsNotNull() {
            addCriterion("C_FixIP is not null");
            return (Criteria) this;
        }

        public Criteria andC_FixIPEqualTo(String value) {
            addCriterion("C_FixIP =", value, "c_FixIP");
            return (Criteria) this;
        }

        public Criteria andC_FixIPNotEqualTo(String value) {
            addCriterion("C_FixIP <>", value, "c_FixIP");
            return (Criteria) this;
        }

        public Criteria andC_FixIPGreaterThan(String value) {
            addCriterion("C_FixIP >", value, "c_FixIP");
            return (Criteria) this;
        }

        public Criteria andC_FixIPGreaterThanOrEqualTo(String value) {
            addCriterion("C_FixIP >=", value, "c_FixIP");
            return (Criteria) this;
        }

        public Criteria andC_FixIPLessThan(String value) {
            addCriterion("C_FixIP <", value, "c_FixIP");
            return (Criteria) this;
        }

        public Criteria andC_FixIPLessThanOrEqualTo(String value) {
            addCriterion("C_FixIP <=", value, "c_FixIP");
            return (Criteria) this;
        }

        public Criteria andC_FixIPLike(String value) {
            addCriterion("C_FixIP like", value, "c_FixIP");
            return (Criteria) this;
        }

        public Criteria andC_FixIPNotLike(String value) {
            addCriterion("C_FixIP not like", value, "c_FixIP");
            return (Criteria) this;
        }

        public Criteria andC_FixIPIn(List<String> values) {
            addCriterion("C_FixIP in", values, "c_FixIP");
            return (Criteria) this;
        }

        public Criteria andC_FixIPNotIn(List<String> values) {
            addCriterion("C_FixIP not in", values, "c_FixIP");
            return (Criteria) this;
        }

        public Criteria andC_FixIPBetween(String value1, String value2) {
            addCriterion("C_FixIP between", value1, value2, "c_FixIP");
            return (Criteria) this;
        }

        public Criteria andC_FixIPNotBetween(String value1, String value2) {
            addCriterion("C_FixIP not between", value1, value2, "c_FixIP");
            return (Criteria) this;
        }

        public Criteria andC_LastComTimeIsNull() {
            addCriterion("C_LastComTime is null");
            return (Criteria) this;
        }

        public Criteria andC_LastComTimeIsNotNull() {
            addCriterion("C_LastComTime is not null");
            return (Criteria) this;
        }

        public Criteria andC_LastComTimeEqualTo(String value) {
            addCriterion("C_LastComTime =", value, "c_LastComTime");
            return (Criteria) this;
        }

        public Criteria andC_LastComTimeNotEqualTo(String value) {
            addCriterion("C_LastComTime <>", value, "c_LastComTime");
            return (Criteria) this;
        }

        public Criteria andC_LastComTimeGreaterThan(String value) {
            addCriterion("C_LastComTime >", value, "c_LastComTime");
            return (Criteria) this;
        }

        public Criteria andC_LastComTimeGreaterThanOrEqualTo(String value) {
            addCriterion("C_LastComTime >=", value, "c_LastComTime");
            return (Criteria) this;
        }

        public Criteria andC_LastComTimeLessThan(String value) {
            addCriterion("C_LastComTime <", value, "c_LastComTime");
            return (Criteria) this;
        }

        public Criteria andC_LastComTimeLessThanOrEqualTo(String value) {
            addCriterion("C_LastComTime <=", value, "c_LastComTime");
            return (Criteria) this;
        }

        public Criteria andC_LastComTimeLike(String value) {
            addCriterion("C_LastComTime like", value, "c_LastComTime");
            return (Criteria) this;
        }

        public Criteria andC_LastComTimeNotLike(String value) {
            addCriterion("C_LastComTime not like", value, "c_LastComTime");
            return (Criteria) this;
        }

        public Criteria andC_LastComTimeIn(List<String> values) {
            addCriterion("C_LastComTime in", values, "c_LastComTime");
            return (Criteria) this;
        }

        public Criteria andC_LastComTimeNotIn(List<String> values) {
            addCriterion("C_LastComTime not in", values, "c_LastComTime");
            return (Criteria) this;
        }

        public Criteria andC_LastComTimeBetween(String value1, String value2) {
            addCriterion("C_LastComTime between", value1, value2, "c_LastComTime");
            return (Criteria) this;
        }

        public Criteria andC_LastComTimeNotBetween(String value1, String value2) {
            addCriterion("C_LastComTime not between", value1, value2, "c_LastComTime");
            return (Criteria) this;
        }

        public Criteria andC_SoftUpdateDateIsNull() {
            addCriterion("C_SoftUpdateDate is null");
            return (Criteria) this;
        }

        public Criteria andC_SoftUpdateDateIsNotNull() {
            addCriterion("C_SoftUpdateDate is not null");
            return (Criteria) this;
        }

        public Criteria andC_SoftUpdateDateEqualTo(String value) {
            addCriterion("C_SoftUpdateDate =", value, "c_SoftUpdateDate");
            return (Criteria) this;
        }

        public Criteria andC_SoftUpdateDateNotEqualTo(String value) {
            addCriterion("C_SoftUpdateDate <>", value, "c_SoftUpdateDate");
            return (Criteria) this;
        }

        public Criteria andC_SoftUpdateDateGreaterThan(String value) {
            addCriterion("C_SoftUpdateDate >", value, "c_SoftUpdateDate");
            return (Criteria) this;
        }

        public Criteria andC_SoftUpdateDateGreaterThanOrEqualTo(String value) {
            addCriterion("C_SoftUpdateDate >=", value, "c_SoftUpdateDate");
            return (Criteria) this;
        }

        public Criteria andC_SoftUpdateDateLessThan(String value) {
            addCriterion("C_SoftUpdateDate <", value, "c_SoftUpdateDate");
            return (Criteria) this;
        }

        public Criteria andC_SoftUpdateDateLessThanOrEqualTo(String value) {
            addCriterion("C_SoftUpdateDate <=", value, "c_SoftUpdateDate");
            return (Criteria) this;
        }

        public Criteria andC_SoftUpdateDateLike(String value) {
            addCriterion("C_SoftUpdateDate like", value, "c_SoftUpdateDate");
            return (Criteria) this;
        }

        public Criteria andC_SoftUpdateDateNotLike(String value) {
            addCriterion("C_SoftUpdateDate not like", value, "c_SoftUpdateDate");
            return (Criteria) this;
        }

        public Criteria andC_SoftUpdateDateIn(List<String> values) {
            addCriterion("C_SoftUpdateDate in", values, "c_SoftUpdateDate");
            return (Criteria) this;
        }

        public Criteria andC_SoftUpdateDateNotIn(List<String> values) {
            addCriterion("C_SoftUpdateDate not in", values, "c_SoftUpdateDate");
            return (Criteria) this;
        }

        public Criteria andC_SoftUpdateDateBetween(String value1, String value2) {
            addCriterion("C_SoftUpdateDate between", value1, value2, "c_SoftUpdateDate");
            return (Criteria) this;
        }

        public Criteria andC_SoftUpdateDateNotBetween(String value1, String value2) {
            addCriterion("C_SoftUpdateDate not between", value1, value2, "c_SoftUpdateDate");
            return (Criteria) this;
        }

        public Criteria andC_InstallDateIsNull() {
            addCriterion("C_InstallDate is null");
            return (Criteria) this;
        }

        public Criteria andC_InstallDateIsNotNull() {
            addCriterion("C_InstallDate is not null");
            return (Criteria) this;
        }

        public Criteria andC_InstallDateEqualTo(String value) {
            addCriterion("C_InstallDate =", value, "c_InstallDate");
            return (Criteria) this;
        }

        public Criteria andC_InstallDateNotEqualTo(String value) {
            addCriterion("C_InstallDate <>", value, "c_InstallDate");
            return (Criteria) this;
        }

        public Criteria andC_InstallDateGreaterThan(String value) {
            addCriterion("C_InstallDate >", value, "c_InstallDate");
            return (Criteria) this;
        }

        public Criteria andC_InstallDateGreaterThanOrEqualTo(String value) {
            addCriterion("C_InstallDate >=", value, "c_InstallDate");
            return (Criteria) this;
        }

        public Criteria andC_InstallDateLessThan(String value) {
            addCriterion("C_InstallDate <", value, "c_InstallDate");
            return (Criteria) this;
        }

        public Criteria andC_InstallDateLessThanOrEqualTo(String value) {
            addCriterion("C_InstallDate <=", value, "c_InstallDate");
            return (Criteria) this;
        }

        public Criteria andC_InstallDateLike(String value) {
            addCriterion("C_InstallDate like", value, "c_InstallDate");
            return (Criteria) this;
        }

        public Criteria andC_InstallDateNotLike(String value) {
            addCriterion("C_InstallDate not like", value, "c_InstallDate");
            return (Criteria) this;
        }

        public Criteria andC_InstallDateIn(List<String> values) {
            addCriterion("C_InstallDate in", values, "c_InstallDate");
            return (Criteria) this;
        }

        public Criteria andC_InstallDateNotIn(List<String> values) {
            addCriterion("C_InstallDate not in", values, "c_InstallDate");
            return (Criteria) this;
        }

        public Criteria andC_InstallDateBetween(String value1, String value2) {
            addCriterion("C_InstallDate between", value1, value2, "c_InstallDate");
            return (Criteria) this;
        }

        public Criteria andC_InstallDateNotBetween(String value1, String value2) {
            addCriterion("C_InstallDate not between", value1, value2, "c_InstallDate");
            return (Criteria) this;
        }

        public Criteria andC_DespIsNull() {
            addCriterion("C_Desp is null");
            return (Criteria) this;
        }

        public Criteria andC_DespIsNotNull() {
            addCriterion("C_Desp is not null");
            return (Criteria) this;
        }

        public Criteria andC_DespEqualTo(String value) {
            addCriterion("C_Desp =", value, "c_Desp");
            return (Criteria) this;
        }

        public Criteria andC_DespNotEqualTo(String value) {
            addCriterion("C_Desp <>", value, "c_Desp");
            return (Criteria) this;
        }

        public Criteria andC_DespGreaterThan(String value) {
            addCriterion("C_Desp >", value, "c_Desp");
            return (Criteria) this;
        }

        public Criteria andC_DespGreaterThanOrEqualTo(String value) {
            addCriterion("C_Desp >=", value, "c_Desp");
            return (Criteria) this;
        }

        public Criteria andC_DespLessThan(String value) {
            addCriterion("C_Desp <", value, "c_Desp");
            return (Criteria) this;
        }

        public Criteria andC_DespLessThanOrEqualTo(String value) {
            addCriterion("C_Desp <=", value, "c_Desp");
            return (Criteria) this;
        }

        public Criteria andC_DespLike(String value) {
            addCriterion("C_Desp like", value, "c_Desp");
            return (Criteria) this;
        }

        public Criteria andC_DespNotLike(String value) {
            addCriterion("C_Desp not like", value, "c_Desp");
            return (Criteria) this;
        }

        public Criteria andC_DespIn(List<String> values) {
            addCriterion("C_Desp in", values, "c_Desp");
            return (Criteria) this;
        }

        public Criteria andC_DespNotIn(List<String> values) {
            addCriterion("C_Desp not in", values, "c_Desp");
            return (Criteria) this;
        }

        public Criteria andC_DespBetween(String value1, String value2) {
            addCriterion("C_Desp between", value1, value2, "c_Desp");
            return (Criteria) this;
        }

        public Criteria andC_DespNotBetween(String value1, String value2) {
            addCriterion("C_Desp not between", value1, value2, "c_Desp");
            return (Criteria) this;
        }

        public Criteria andNbDeviceIdIsNull() {
            addCriterion("nbDeviceId is null");
            return (Criteria) this;
        }

        public Criteria andNbDeviceIdIsNotNull() {
            addCriterion("nbDeviceId is not null");
            return (Criteria) this;
        }

        public Criteria andNbDeviceIdEqualTo(String value) {
            addCriterion("nbDeviceId =", value, "nbDeviceId");
            return (Criteria) this;
        }

        public Criteria andNbDeviceIdNotEqualTo(String value) {
            addCriterion("nbDeviceId <>", value, "nbDeviceId");
            return (Criteria) this;
        }

        public Criteria andNbDeviceIdGreaterThan(String value) {
            addCriterion("nbDeviceId >", value, "nbDeviceId");
            return (Criteria) this;
        }

        public Criteria andNbDeviceIdGreaterThanOrEqualTo(String value) {
            addCriterion("nbDeviceId >=", value, "nbDeviceId");
            return (Criteria) this;
        }

        public Criteria andNbDeviceIdLessThan(String value) {
            addCriterion("nbDeviceId <", value, "nbDeviceId");
            return (Criteria) this;
        }

        public Criteria andNbDeviceIdLessThanOrEqualTo(String value) {
            addCriterion("nbDeviceId <=", value, "nbDeviceId");
            return (Criteria) this;
        }

        public Criteria andNbDeviceIdLike(String value) {
            addCriterion("nbDeviceId like", value, "nbDeviceId");
            return (Criteria) this;
        }

        public Criteria andNbDeviceIdNotLike(String value) {
            addCriterion("nbDeviceId not like", value, "nbDeviceId");
            return (Criteria) this;
        }

        public Criteria andNbDeviceIdIn(List<String> values) {
            addCriterion("nbDeviceId in", values, "nbDeviceId");
            return (Criteria) this;
        }

        public Criteria andNbDeviceIdNotIn(List<String> values) {
            addCriterion("nbDeviceId not in", values, "nbDeviceId");
            return (Criteria) this;
        }

        public Criteria andNbDeviceIdBetween(String value1, String value2) {
            addCriterion("nbDeviceId between", value1, value2, "nbDeviceId");
            return (Criteria) this;
        }

        public Criteria andNbDeviceIdNotBetween(String value1, String value2) {
            addCriterion("nbDeviceId not between", value1, value2, "nbDeviceId");
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