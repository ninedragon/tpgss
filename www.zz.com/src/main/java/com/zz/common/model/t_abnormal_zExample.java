package com.zz.common.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class t_abnormal_zExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public t_abnormal_zExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
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

        public Criteria andC_AddressIdEqualTo(Integer value) {
            addCriterion("C_AddressId =", value, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdNotEqualTo(Integer value) {
            addCriterion("C_AddressId <>", value, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdGreaterThan(Integer value) {
            addCriterion("C_AddressId >", value, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("C_AddressId >=", value, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdLessThan(Integer value) {
            addCriterion("C_AddressId <", value, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdLessThanOrEqualTo(Integer value) {
            addCriterion("C_AddressId <=", value, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdIn(List<Integer> values) {
            addCriterion("C_AddressId in", values, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdNotIn(List<Integer> values) {
            addCriterion("C_AddressId not in", values, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdBetween(Integer value1, Integer value2) {
            addCriterion("C_AddressId between", value1, value2, "c_AddressId");
            return (Criteria) this;
        }

        public Criteria andC_AddressIdNotBetween(Integer value1, Integer value2) {
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

        public Criteria andC_FrameCmdIdIsNull() {
            addCriterion("C_FrameCmdId is null");
            return (Criteria) this;
        }

        public Criteria andC_FrameCmdIdIsNotNull() {
            addCriterion("C_FrameCmdId is not null");
            return (Criteria) this;
        }

        public Criteria andC_FrameCmdIdEqualTo(String value) {
            addCriterion("C_FrameCmdId =", value, "c_FrameCmdId");
            return (Criteria) this;
        }

        public Criteria andC_FrameCmdIdNotEqualTo(String value) {
            addCriterion("C_FrameCmdId <>", value, "c_FrameCmdId");
            return (Criteria) this;
        }

        public Criteria andC_FrameCmdIdGreaterThan(String value) {
            addCriterion("C_FrameCmdId >", value, "c_FrameCmdId");
            return (Criteria) this;
        }

        public Criteria andC_FrameCmdIdGreaterThanOrEqualTo(String value) {
            addCriterion("C_FrameCmdId >=", value, "c_FrameCmdId");
            return (Criteria) this;
        }

        public Criteria andC_FrameCmdIdLessThan(String value) {
            addCriterion("C_FrameCmdId <", value, "c_FrameCmdId");
            return (Criteria) this;
        }

        public Criteria andC_FrameCmdIdLessThanOrEqualTo(String value) {
            addCriterion("C_FrameCmdId <=", value, "c_FrameCmdId");
            return (Criteria) this;
        }

        public Criteria andC_FrameCmdIdLike(String value) {
            addCriterion("C_FrameCmdId like", value, "c_FrameCmdId");
            return (Criteria) this;
        }

        public Criteria andC_FrameCmdIdNotLike(String value) {
            addCriterion("C_FrameCmdId not like", value, "c_FrameCmdId");
            return (Criteria) this;
        }

        public Criteria andC_FrameCmdIdIn(List<String> values) {
            addCriterion("C_FrameCmdId in", values, "c_FrameCmdId");
            return (Criteria) this;
        }

        public Criteria andC_FrameCmdIdNotIn(List<String> values) {
            addCriterion("C_FrameCmdId not in", values, "c_FrameCmdId");
            return (Criteria) this;
        }

        public Criteria andC_FrameCmdIdBetween(String value1, String value2) {
            addCriterion("C_FrameCmdId between", value1, value2, "c_FrameCmdId");
            return (Criteria) this;
        }

        public Criteria andC_FrameCmdIdNotBetween(String value1, String value2) {
            addCriterion("C_FrameCmdId not between", value1, value2, "c_FrameCmdId");
            return (Criteria) this;
        }

        public Criteria andC_RecordInsertTimeIsNull() {
            addCriterion("C_RecordInsertTime is null");
            return (Criteria) this;
        }

        public Criteria andC_RecordInsertTimeIsNotNull() {
            addCriterion("C_RecordInsertTime is not null");
            return (Criteria) this;
        }

        public Criteria andC_RecordInsertTimeEqualTo(Date value) {
            addCriterion("C_RecordInsertTime =", value, "c_RecordInsertTime");
            return (Criteria) this;
        }

        public Criteria andC_RecordInsertTimeNotEqualTo(Date value) {
            addCriterion("C_RecordInsertTime <>", value, "c_RecordInsertTime");
            return (Criteria) this;
        }

        public Criteria andC_RecordInsertTimeGreaterThan(Date value) {
            addCriterion("C_RecordInsertTime >", value, "c_RecordInsertTime");
            return (Criteria) this;
        }

        public Criteria andC_RecordInsertTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("C_RecordInsertTime >=", value, "c_RecordInsertTime");
            return (Criteria) this;
        }

        public Criteria andC_RecordInsertTimeLessThan(Date value) {
            addCriterion("C_RecordInsertTime <", value, "c_RecordInsertTime");
            return (Criteria) this;
        }

        public Criteria andC_RecordInsertTimeLessThanOrEqualTo(Date value) {
            addCriterion("C_RecordInsertTime <=", value, "c_RecordInsertTime");
            return (Criteria) this;
        }

        public Criteria andC_RecordInsertTimeIn(List<Date> values) {
            addCriterion("C_RecordInsertTime in", values, "c_RecordInsertTime");
            return (Criteria) this;
        }

        public Criteria andC_RecordInsertTimeNotIn(List<Date> values) {
            addCriterion("C_RecordInsertTime not in", values, "c_RecordInsertTime");
            return (Criteria) this;
        }

        public Criteria andC_RecordInsertTimeBetween(Date value1, Date value2) {
            addCriterion("C_RecordInsertTime between", value1, value2, "c_RecordInsertTime");
            return (Criteria) this;
        }

        public Criteria andC_RecordInsertTimeNotBetween(Date value1, Date value2) {
            addCriterion("C_RecordInsertTime not between", value1, value2, "c_RecordInsertTime");
            return (Criteria) this;
        }

        public Criteria andUaIsNull() {
            addCriterion("ua is null");
            return (Criteria) this;
        }

        public Criteria andUaIsNotNull() {
            addCriterion("ua is not null");
            return (Criteria) this;
        }

        public Criteria andUaEqualTo(Float value) {
            addCriterion("ua =", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaNotEqualTo(Float value) {
            addCriterion("ua <>", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaGreaterThan(Float value) {
            addCriterion("ua >", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaGreaterThanOrEqualTo(Float value) {
            addCriterion("ua >=", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaLessThan(Float value) {
            addCriterion("ua <", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaLessThanOrEqualTo(Float value) {
            addCriterion("ua <=", value, "ua");
            return (Criteria) this;
        }

        public Criteria andUaIn(List<Float> values) {
            addCriterion("ua in", values, "ua");
            return (Criteria) this;
        }

        public Criteria andUaNotIn(List<Float> values) {
            addCriterion("ua not in", values, "ua");
            return (Criteria) this;
        }

        public Criteria andUaBetween(Float value1, Float value2) {
            addCriterion("ua between", value1, value2, "ua");
            return (Criteria) this;
        }

        public Criteria andUaNotBetween(Float value1, Float value2) {
            addCriterion("ua not between", value1, value2, "ua");
            return (Criteria) this;
        }

        public Criteria andUbIsNull() {
            addCriterion("ub is null");
            return (Criteria) this;
        }

        public Criteria andUbIsNotNull() {
            addCriterion("ub is not null");
            return (Criteria) this;
        }

        public Criteria andUbEqualTo(Float value) {
            addCriterion("ub =", value, "ub");
            return (Criteria) this;
        }

        public Criteria andUbNotEqualTo(Float value) {
            addCriterion("ub <>", value, "ub");
            return (Criteria) this;
        }

        public Criteria andUbGreaterThan(Float value) {
            addCriterion("ub >", value, "ub");
            return (Criteria) this;
        }

        public Criteria andUbGreaterThanOrEqualTo(Float value) {
            addCriterion("ub >=", value, "ub");
            return (Criteria) this;
        }

        public Criteria andUbLessThan(Float value) {
            addCriterion("ub <", value, "ub");
            return (Criteria) this;
        }

        public Criteria andUbLessThanOrEqualTo(Float value) {
            addCriterion("ub <=", value, "ub");
            return (Criteria) this;
        }

        public Criteria andUbIn(List<Float> values) {
            addCriterion("ub in", values, "ub");
            return (Criteria) this;
        }

        public Criteria andUbNotIn(List<Float> values) {
            addCriterion("ub not in", values, "ub");
            return (Criteria) this;
        }

        public Criteria andUbBetween(Float value1, Float value2) {
            addCriterion("ub between", value1, value2, "ub");
            return (Criteria) this;
        }

        public Criteria andUbNotBetween(Float value1, Float value2) {
            addCriterion("ub not between", value1, value2, "ub");
            return (Criteria) this;
        }

        public Criteria andUcIsNull() {
            addCriterion("uc is null");
            return (Criteria) this;
        }

        public Criteria andUcIsNotNull() {
            addCriterion("uc is not null");
            return (Criteria) this;
        }

        public Criteria andUcEqualTo(Float value) {
            addCriterion("uc =", value, "uc");
            return (Criteria) this;
        }

        public Criteria andUcNotEqualTo(Float value) {
            addCriterion("uc <>", value, "uc");
            return (Criteria) this;
        }

        public Criteria andUcGreaterThan(Float value) {
            addCriterion("uc >", value, "uc");
            return (Criteria) this;
        }

        public Criteria andUcGreaterThanOrEqualTo(Float value) {
            addCriterion("uc >=", value, "uc");
            return (Criteria) this;
        }

        public Criteria andUcLessThan(Float value) {
            addCriterion("uc <", value, "uc");
            return (Criteria) this;
        }

        public Criteria andUcLessThanOrEqualTo(Float value) {
            addCriterion("uc <=", value, "uc");
            return (Criteria) this;
        }

        public Criteria andUcIn(List<Float> values) {
            addCriterion("uc in", values, "uc");
            return (Criteria) this;
        }

        public Criteria andUcNotIn(List<Float> values) {
            addCriterion("uc not in", values, "uc");
            return (Criteria) this;
        }

        public Criteria andUcBetween(Float value1, Float value2) {
            addCriterion("uc between", value1, value2, "uc");
            return (Criteria) this;
        }

        public Criteria andUcNotBetween(Float value1, Float value2) {
            addCriterion("uc not between", value1, value2, "uc");
            return (Criteria) this;
        }

        public Criteria andPIsNull() {
            addCriterion("p is null");
            return (Criteria) this;
        }

        public Criteria andPIsNotNull() {
            addCriterion("p is not null");
            return (Criteria) this;
        }

        public Criteria andPEqualTo(Float value) {
            addCriterion("p =", value, "p");
            return (Criteria) this;
        }

        public Criteria andPNotEqualTo(Float value) {
            addCriterion("p <>", value, "p");
            return (Criteria) this;
        }

        public Criteria andPGreaterThan(Float value) {
            addCriterion("p >", value, "p");
            return (Criteria) this;
        }

        public Criteria andPGreaterThanOrEqualTo(Float value) {
            addCriterion("p >=", value, "p");
            return (Criteria) this;
        }

        public Criteria andPLessThan(Float value) {
            addCriterion("p <", value, "p");
            return (Criteria) this;
        }

        public Criteria andPLessThanOrEqualTo(Float value) {
            addCriterion("p <=", value, "p");
            return (Criteria) this;
        }

        public Criteria andPIn(List<Float> values) {
            addCriterion("p in", values, "p");
            return (Criteria) this;
        }

        public Criteria andPNotIn(List<Float> values) {
            addCriterion("p not in", values, "p");
            return (Criteria) this;
        }

        public Criteria andPBetween(Float value1, Float value2) {
            addCriterion("p between", value1, value2, "p");
            return (Criteria) this;
        }

        public Criteria andPNotBetween(Float value1, Float value2) {
            addCriterion("p not between", value1, value2, "p");
            return (Criteria) this;
        }

        public Criteria andQIsNull() {
            addCriterion("q is null");
            return (Criteria) this;
        }

        public Criteria andQIsNotNull() {
            addCriterion("q is not null");
            return (Criteria) this;
        }

        public Criteria andQEqualTo(Float value) {
            addCriterion("q =", value, "q");
            return (Criteria) this;
        }

        public Criteria andQNotEqualTo(Float value) {
            addCriterion("q <>", value, "q");
            return (Criteria) this;
        }

        public Criteria andQGreaterThan(Float value) {
            addCriterion("q >", value, "q");
            return (Criteria) this;
        }

        public Criteria andQGreaterThanOrEqualTo(Float value) {
            addCriterion("q >=", value, "q");
            return (Criteria) this;
        }

        public Criteria andQLessThan(Float value) {
            addCriterion("q <", value, "q");
            return (Criteria) this;
        }

        public Criteria andQLessThanOrEqualTo(Float value) {
            addCriterion("q <=", value, "q");
            return (Criteria) this;
        }

        public Criteria andQIn(List<Float> values) {
            addCriterion("q in", values, "q");
            return (Criteria) this;
        }

        public Criteria andQNotIn(List<Float> values) {
            addCriterion("q not in", values, "q");
            return (Criteria) this;
        }

        public Criteria andQBetween(Float value1, Float value2) {
            addCriterion("q between", value1, value2, "q");
            return (Criteria) this;
        }

        public Criteria andQNotBetween(Float value1, Float value2) {
            addCriterion("q not between", value1, value2, "q");
            return (Criteria) this;
        }

        public Criteria andIIsNull() {
            addCriterion("i is null");
            return (Criteria) this;
        }

        public Criteria andIIsNotNull() {
            addCriterion("i is not null");
            return (Criteria) this;
        }

        public Criteria andIEqualTo(Float value) {
            addCriterion("i =", value, "i");
            return (Criteria) this;
        }

        public Criteria andINotEqualTo(Float value) {
            addCriterion("i <>", value, "i");
            return (Criteria) this;
        }

        public Criteria andIGreaterThan(Float value) {
            addCriterion("i >", value, "i");
            return (Criteria) this;
        }

        public Criteria andIGreaterThanOrEqualTo(Float value) {
            addCriterion("i >=", value, "i");
            return (Criteria) this;
        }

        public Criteria andILessThan(Float value) {
            addCriterion("i <", value, "i");
            return (Criteria) this;
        }

        public Criteria andILessThanOrEqualTo(Float value) {
            addCriterion("i <=", value, "i");
            return (Criteria) this;
        }

        public Criteria andIIn(List<Float> values) {
            addCriterion("i in", values, "i");
            return (Criteria) this;
        }

        public Criteria andINotIn(List<Float> values) {
            addCriterion("i not in", values, "i");
            return (Criteria) this;
        }

        public Criteria andIBetween(Float value1, Float value2) {
            addCriterion("i between", value1, value2, "i");
            return (Criteria) this;
        }

        public Criteria andINotBetween(Float value1, Float value2) {
            addCriterion("i not between", value1, value2, "i");
            return (Criteria) this;
        }

        public Criteria andC_FaultIdIsNull() {
            addCriterion("C_FaultId is null");
            return (Criteria) this;
        }

        public Criteria andC_FaultIdIsNotNull() {
            addCriterion("C_FaultId is not null");
            return (Criteria) this;
        }

        public Criteria andC_FaultIdEqualTo(Integer value) {
            addCriterion("C_FaultId =", value, "c_FaultId");
            return (Criteria) this;
        }

        public Criteria andC_FaultIdNotEqualTo(Integer value) {
            addCriterion("C_FaultId <>", value, "c_FaultId");
            return (Criteria) this;
        }

        public Criteria andC_FaultIdGreaterThan(Integer value) {
            addCriterion("C_FaultId >", value, "c_FaultId");
            return (Criteria) this;
        }

        public Criteria andC_FaultIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("C_FaultId >=", value, "c_FaultId");
            return (Criteria) this;
        }

        public Criteria andC_FaultIdLessThan(Integer value) {
            addCriterion("C_FaultId <", value, "c_FaultId");
            return (Criteria) this;
        }

        public Criteria andC_FaultIdLessThanOrEqualTo(Integer value) {
            addCriterion("C_FaultId <=", value, "c_FaultId");
            return (Criteria) this;
        }

        public Criteria andC_FaultIdIn(List<Integer> values) {
            addCriterion("C_FaultId in", values, "c_FaultId");
            return (Criteria) this;
        }

        public Criteria andC_FaultIdNotIn(List<Integer> values) {
            addCriterion("C_FaultId not in", values, "c_FaultId");
            return (Criteria) this;
        }

        public Criteria andC_FaultIdBetween(Integer value1, Integer value2) {
            addCriterion("C_FaultId between", value1, value2, "c_FaultId");
            return (Criteria) this;
        }

        public Criteria andC_FaultIdNotBetween(Integer value1, Integer value2) {
            addCriterion("C_FaultId not between", value1, value2, "c_FaultId");
            return (Criteria) this;
        }

        public Criteria andTSegmentIdIsNull() {
            addCriterion("TSegmentId is null");
            return (Criteria) this;
        }

        public Criteria andTSegmentIdIsNotNull() {
            addCriterion("TSegmentId is not null");
            return (Criteria) this;
        }

        public Criteria andTSegmentIdEqualTo(Integer value) {
            addCriterion("TSegmentId =", value, "TSegmentId");
            return (Criteria) this;
        }

        public Criteria andTSegmentIdNotEqualTo(Integer value) {
            addCriterion("TSegmentId <>", value, "TSegmentId");
            return (Criteria) this;
        }

        public Criteria andTSegmentIdGreaterThan(Integer value) {
            addCriterion("TSegmentId >", value, "TSegmentId");
            return (Criteria) this;
        }

        public Criteria andTSegmentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TSegmentId >=", value, "TSegmentId");
            return (Criteria) this;
        }

        public Criteria andTSegmentIdLessThan(Integer value) {
            addCriterion("TSegmentId <", value, "TSegmentId");
            return (Criteria) this;
        }

        public Criteria andTSegmentIdLessThanOrEqualTo(Integer value) {
            addCriterion("TSegmentId <=", value, "TSegmentId");
            return (Criteria) this;
        }

        public Criteria andTSegmentIdIn(List<Integer> values) {
            addCriterion("TSegmentId in", values, "TSegmentId");
            return (Criteria) this;
        }

        public Criteria andTSegmentIdNotIn(List<Integer> values) {
            addCriterion("TSegmentId not in", values, "TSegmentId");
            return (Criteria) this;
        }

        public Criteria andTSegmentIdBetween(Integer value1, Integer value2) {
            addCriterion("TSegmentId between", value1, value2, "TSegmentId");
            return (Criteria) this;
        }

        public Criteria andTSegmentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TSegmentId not between", value1, value2, "TSegmentId");
            return (Criteria) this;
        }

        public Criteria andRecordDateBCDIsNull() {
            addCriterion("RecordDateBCD is null");
            return (Criteria) this;
        }

        public Criteria andRecordDateBCDIsNotNull() {
            addCriterion("RecordDateBCD is not null");
            return (Criteria) this;
        }

        public Criteria andRecordDateBCDEqualTo(Integer value) {
            addCriterion("RecordDateBCD =", value, "recordDateBCD");
            return (Criteria) this;
        }

        public Criteria andRecordDateBCDNotEqualTo(Integer value) {
            addCriterion("RecordDateBCD <>", value, "recordDateBCD");
            return (Criteria) this;
        }

        public Criteria andRecordDateBCDGreaterThan(Integer value) {
            addCriterion("RecordDateBCD >", value, "recordDateBCD");
            return (Criteria) this;
        }

        public Criteria andRecordDateBCDGreaterThanOrEqualTo(Integer value) {
            addCriterion("RecordDateBCD >=", value, "recordDateBCD");
            return (Criteria) this;
        }

        public Criteria andRecordDateBCDLessThan(Integer value) {
            addCriterion("RecordDateBCD <", value, "recordDateBCD");
            return (Criteria) this;
        }

        public Criteria andRecordDateBCDLessThanOrEqualTo(Integer value) {
            addCriterion("RecordDateBCD <=", value, "recordDateBCD");
            return (Criteria) this;
        }

        public Criteria andRecordDateBCDIn(List<Integer> values) {
            addCriterion("RecordDateBCD in", values, "recordDateBCD");
            return (Criteria) this;
        }

        public Criteria andRecordDateBCDNotIn(List<Integer> values) {
            addCriterion("RecordDateBCD not in", values, "recordDateBCD");
            return (Criteria) this;
        }

        public Criteria andRecordDateBCDBetween(Integer value1, Integer value2) {
            addCriterion("RecordDateBCD between", value1, value2, "recordDateBCD");
            return (Criteria) this;
        }

        public Criteria andRecordDateBCDNotBetween(Integer value1, Integer value2) {
            addCriterion("RecordDateBCD not between", value1, value2, "recordDateBCD");
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