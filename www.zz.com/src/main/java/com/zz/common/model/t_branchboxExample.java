package com.zz.common.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class t_branchboxExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public t_branchboxExample() {
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

        public Criteria andBranchBoxIdIsNull() {
            addCriterion("branchBoxId is null");
            return (Criteria) this;
        }

        public Criteria andBranchBoxIdIsNotNull() {
            addCriterion("branchBoxId is not null");
            return (Criteria) this;
        }

        public Criteria andBranchBoxIdEqualTo(String value) {
            addCriterion("branchBoxId =", value, "branchBoxId");
            return (Criteria) this;
        }

        public Criteria andBranchBoxIdNotEqualTo(String value) {
            addCriterion("branchBoxId <>", value, "branchBoxId");
            return (Criteria) this;
        }

        public Criteria andBranchBoxIdGreaterThan(String value) {
            addCriterion("branchBoxId >", value, "branchBoxId");
            return (Criteria) this;
        }

        public Criteria andBranchBoxIdGreaterThanOrEqualTo(String value) {
            addCriterion("branchBoxId >=", value, "branchBoxId");
            return (Criteria) this;
        }

        public Criteria andBranchBoxIdLessThan(String value) {
            addCriterion("branchBoxId <", value, "branchBoxId");
            return (Criteria) this;
        }

        public Criteria andBranchBoxIdLessThanOrEqualTo(String value) {
            addCriterion("branchBoxId <=", value, "branchBoxId");
            return (Criteria) this;
        }

        public Criteria andBranchBoxIdLike(String value) {
            addCriterion("branchBoxId like", value, "branchBoxId");
            return (Criteria) this;
        }

        public Criteria andBranchBoxIdNotLike(String value) {
            addCriterion("branchBoxId not like", value, "branchBoxId");
            return (Criteria) this;
        }

        public Criteria andBranchBoxIdIn(List<String> values) {
            addCriterion("branchBoxId in", values, "branchBoxId");
            return (Criteria) this;
        }

        public Criteria andBranchBoxIdNotIn(List<String> values) {
            addCriterion("branchBoxId not in", values, "branchBoxId");
            return (Criteria) this;
        }

        public Criteria andBranchBoxIdBetween(String value1, String value2) {
            addCriterion("branchBoxId between", value1, value2, "branchBoxId");
            return (Criteria) this;
        }

        public Criteria andBranchBoxIdNotBetween(String value1, String value2) {
            addCriterion("branchBoxId not between", value1, value2, "branchBoxId");
            return (Criteria) this;
        }

        public Criteria andOutgoingCabinetIdIsNull() {
            addCriterion("outgoingCabinetId is null");
            return (Criteria) this;
        }

        public Criteria andOutgoingCabinetIdIsNotNull() {
            addCriterion("outgoingCabinetId is not null");
            return (Criteria) this;
        }

        public Criteria andOutgoingCabinetIdEqualTo(String value) {
            addCriterion("outgoingCabinetId =", value, "outgoingCabinetId");
            return (Criteria) this;
        }

        public Criteria andOutgoingCabinetIdNotEqualTo(String value) {
            addCriterion("outgoingCabinetId <>", value, "outgoingCabinetId");
            return (Criteria) this;
        }

        public Criteria andOutgoingCabinetIdGreaterThan(String value) {
            addCriterion("outgoingCabinetId >", value, "outgoingCabinetId");
            return (Criteria) this;
        }

        public Criteria andOutgoingCabinetIdGreaterThanOrEqualTo(String value) {
            addCriterion("outgoingCabinetId >=", value, "outgoingCabinetId");
            return (Criteria) this;
        }

        public Criteria andOutgoingCabinetIdLessThan(String value) {
            addCriterion("outgoingCabinetId <", value, "outgoingCabinetId");
            return (Criteria) this;
        }

        public Criteria andOutgoingCabinetIdLessThanOrEqualTo(String value) {
            addCriterion("outgoingCabinetId <=", value, "outgoingCabinetId");
            return (Criteria) this;
        }

        public Criteria andOutgoingCabinetIdLike(String value) {
            addCriterion("outgoingCabinetId like", value, "outgoingCabinetId");
            return (Criteria) this;
        }

        public Criteria andOutgoingCabinetIdNotLike(String value) {
            addCriterion("outgoingCabinetId not like", value, "outgoingCabinetId");
            return (Criteria) this;
        }

        public Criteria andOutgoingCabinetIdIn(List<String> values) {
            addCriterion("outgoingCabinetId in", values, "outgoingCabinetId");
            return (Criteria) this;
        }

        public Criteria andOutgoingCabinetIdNotIn(List<String> values) {
            addCriterion("outgoingCabinetId not in", values, "outgoingCabinetId");
            return (Criteria) this;
        }

        public Criteria andOutgoingCabinetIdBetween(String value1, String value2) {
            addCriterion("outgoingCabinetId between", value1, value2, "outgoingCabinetId");
            return (Criteria) this;
        }

        public Criteria andOutgoingCabinetIdNotBetween(String value1, String value2) {
            addCriterion("outgoingCabinetId not between", value1, value2, "outgoingCabinetId");
            return (Criteria) this;
        }

        public Criteria andEpu_nameIsNull() {
            addCriterion("epu_name is null");
            return (Criteria) this;
        }

        public Criteria andEpu_nameIsNotNull() {
            addCriterion("epu_name is not null");
            return (Criteria) this;
        }

        public Criteria andEpu_nameEqualTo(String value) {
            addCriterion("epu_name =", value, "epu_name");
            return (Criteria) this;
        }

        public Criteria andEpu_nameNotEqualTo(String value) {
            addCriterion("epu_name <>", value, "epu_name");
            return (Criteria) this;
        }

        public Criteria andEpu_nameGreaterThan(String value) {
            addCriterion("epu_name >", value, "epu_name");
            return (Criteria) this;
        }

        public Criteria andEpu_nameGreaterThanOrEqualTo(String value) {
            addCriterion("epu_name >=", value, "epu_name");
            return (Criteria) this;
        }

        public Criteria andEpu_nameLessThan(String value) {
            addCriterion("epu_name <", value, "epu_name");
            return (Criteria) this;
        }

        public Criteria andEpu_nameLessThanOrEqualTo(String value) {
            addCriterion("epu_name <=", value, "epu_name");
            return (Criteria) this;
        }

        public Criteria andEpu_nameLike(String value) {
            addCriterion("epu_name like", value, "epu_name");
            return (Criteria) this;
        }

        public Criteria andEpu_nameNotLike(String value) {
            addCriterion("epu_name not like", value, "epu_name");
            return (Criteria) this;
        }

        public Criteria andEpu_nameIn(List<String> values) {
            addCriterion("epu_name in", values, "epu_name");
            return (Criteria) this;
        }

        public Criteria andEpu_nameNotIn(List<String> values) {
            addCriterion("epu_name not in", values, "epu_name");
            return (Criteria) this;
        }

        public Criteria andEpu_nameBetween(String value1, String value2) {
            addCriterion("epu_name between", value1, value2, "epu_name");
            return (Criteria) this;
        }

        public Criteria andEpu_nameNotBetween(String value1, String value2) {
            addCriterion("epu_name not between", value1, value2, "epu_name");
            return (Criteria) this;
        }

        public Criteria andEpu_localIsNull() {
            addCriterion("epu_local is null");
            return (Criteria) this;
        }

        public Criteria andEpu_localIsNotNull() {
            addCriterion("epu_local is not null");
            return (Criteria) this;
        }

        public Criteria andEpu_localEqualTo(String value) {
            addCriterion("epu_local =", value, "epu_local");
            return (Criteria) this;
        }

        public Criteria andEpu_localNotEqualTo(String value) {
            addCriterion("epu_local <>", value, "epu_local");
            return (Criteria) this;
        }

        public Criteria andEpu_localGreaterThan(String value) {
            addCriterion("epu_local >", value, "epu_local");
            return (Criteria) this;
        }

        public Criteria andEpu_localGreaterThanOrEqualTo(String value) {
            addCriterion("epu_local >=", value, "epu_local");
            return (Criteria) this;
        }

        public Criteria andEpu_localLessThan(String value) {
            addCriterion("epu_local <", value, "epu_local");
            return (Criteria) this;
        }

        public Criteria andEpu_localLessThanOrEqualTo(String value) {
            addCriterion("epu_local <=", value, "epu_local");
            return (Criteria) this;
        }

        public Criteria andEpu_localLike(String value) {
            addCriterion("epu_local like", value, "epu_local");
            return (Criteria) this;
        }

        public Criteria andEpu_localNotLike(String value) {
            addCriterion("epu_local not like", value, "epu_local");
            return (Criteria) this;
        }

        public Criteria andEpu_localIn(List<String> values) {
            addCriterion("epu_local in", values, "epu_local");
            return (Criteria) this;
        }

        public Criteria andEpu_localNotIn(List<String> values) {
            addCriterion("epu_local not in", values, "epu_local");
            return (Criteria) this;
        }

        public Criteria andEpu_localBetween(String value1, String value2) {
            addCriterion("epu_local between", value1, value2, "epu_local");
            return (Criteria) this;
        }

        public Criteria andEpu_localNotBetween(String value1, String value2) {
            addCriterion("epu_local not between", value1, value2, "epu_local");
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

        public Criteria andC_ChannelId_bIsNull() {
            addCriterion("C_ChannelId_b is null");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_bIsNotNull() {
            addCriterion("C_ChannelId_b is not null");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_bEqualTo(Integer value) {
            addCriterion("C_ChannelId_b =", value, "c_ChannelId_b");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_bNotEqualTo(Integer value) {
            addCriterion("C_ChannelId_b <>", value, "c_ChannelId_b");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_bGreaterThan(Integer value) {
            addCriterion("C_ChannelId_b >", value, "c_ChannelId_b");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_bGreaterThanOrEqualTo(Integer value) {
            addCriterion("C_ChannelId_b >=", value, "c_ChannelId_b");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_bLessThan(Integer value) {
            addCriterion("C_ChannelId_b <", value, "c_ChannelId_b");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_bLessThanOrEqualTo(Integer value) {
            addCriterion("C_ChannelId_b <=", value, "c_ChannelId_b");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_bIn(List<Integer> values) {
            addCriterion("C_ChannelId_b in", values, "c_ChannelId_b");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_bNotIn(List<Integer> values) {
            addCriterion("C_ChannelId_b not in", values, "c_ChannelId_b");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_bBetween(Integer value1, Integer value2) {
            addCriterion("C_ChannelId_b between", value1, value2, "c_ChannelId_b");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_bNotBetween(Integer value1, Integer value2) {
            addCriterion("C_ChannelId_b not between", value1, value2, "c_ChannelId_b");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_cIsNull() {
            addCriterion("C_ChannelId_c is null");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_cIsNotNull() {
            addCriterion("C_ChannelId_c is not null");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_cEqualTo(Integer value) {
            addCriterion("C_ChannelId_c =", value, "c_ChannelId_c");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_cNotEqualTo(Integer value) {
            addCriterion("C_ChannelId_c <>", value, "c_ChannelId_c");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_cGreaterThan(Integer value) {
            addCriterion("C_ChannelId_c >", value, "c_ChannelId_c");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_cGreaterThanOrEqualTo(Integer value) {
            addCriterion("C_ChannelId_c >=", value, "c_ChannelId_c");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_cLessThan(Integer value) {
            addCriterion("C_ChannelId_c <", value, "c_ChannelId_c");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_cLessThanOrEqualTo(Integer value) {
            addCriterion("C_ChannelId_c <=", value, "c_ChannelId_c");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_cIn(List<Integer> values) {
            addCriterion("C_ChannelId_c in", values, "c_ChannelId_c");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_cNotIn(List<Integer> values) {
            addCriterion("C_ChannelId_c not in", values, "c_ChannelId_c");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_cBetween(Integer value1, Integer value2) {
            addCriterion("C_ChannelId_c between", value1, value2, "c_ChannelId_c");
            return (Criteria) this;
        }

        public Criteria andC_ChannelId_cNotBetween(Integer value1, Integer value2) {
            addCriterion("C_ChannelId_c not between", value1, value2, "c_ChannelId_c");
            return (Criteria) this;
        }

        public Criteria andLine_idIsNull() {
            addCriterion("line_id is null");
            return (Criteria) this;
        }

        public Criteria andLine_idIsNotNull() {
            addCriterion("line_id is not null");
            return (Criteria) this;
        }

        public Criteria andLine_idEqualTo(String value) {
            addCriterion("line_id =", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idNotEqualTo(String value) {
            addCriterion("line_id <>", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idGreaterThan(String value) {
            addCriterion("line_id >", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idGreaterThanOrEqualTo(String value) {
            addCriterion("line_id >=", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idLessThan(String value) {
            addCriterion("line_id <", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idLessThanOrEqualTo(String value) {
            addCriterion("line_id <=", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idLike(String value) {
            addCriterion("line_id like", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idNotLike(String value) {
            addCriterion("line_id not like", value, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idIn(List<String> values) {
            addCriterion("line_id in", values, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idNotIn(List<String> values) {
            addCriterion("line_id not in", values, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idBetween(String value1, String value2) {
            addCriterion("line_id between", value1, value2, "line_id");
            return (Criteria) this;
        }

        public Criteria andLine_idNotBetween(String value1, String value2) {
            addCriterion("line_id not between", value1, value2, "line_id");
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

        public Criteria andEpu_provinceIsNull() {
            addCriterion("epu_province is null");
            return (Criteria) this;
        }

        public Criteria andEpu_provinceIsNotNull() {
            addCriterion("epu_province is not null");
            return (Criteria) this;
        }

        public Criteria andEpu_provinceEqualTo(String value) {
            addCriterion("epu_province =", value, "epu_province");
            return (Criteria) this;
        }

        public Criteria andEpu_provinceNotEqualTo(String value) {
            addCriterion("epu_province <>", value, "epu_province");
            return (Criteria) this;
        }

        public Criteria andEpu_provinceGreaterThan(String value) {
            addCriterion("epu_province >", value, "epu_province");
            return (Criteria) this;
        }

        public Criteria andEpu_provinceGreaterThanOrEqualTo(String value) {
            addCriterion("epu_province >=", value, "epu_province");
            return (Criteria) this;
        }

        public Criteria andEpu_provinceLessThan(String value) {
            addCriterion("epu_province <", value, "epu_province");
            return (Criteria) this;
        }

        public Criteria andEpu_provinceLessThanOrEqualTo(String value) {
            addCriterion("epu_province <=", value, "epu_province");
            return (Criteria) this;
        }

        public Criteria andEpu_provinceLike(String value) {
            addCriterion("epu_province like", value, "epu_province");
            return (Criteria) this;
        }

        public Criteria andEpu_provinceNotLike(String value) {
            addCriterion("epu_province not like", value, "epu_province");
            return (Criteria) this;
        }

        public Criteria andEpu_provinceIn(List<String> values) {
            addCriterion("epu_province in", values, "epu_province");
            return (Criteria) this;
        }

        public Criteria andEpu_provinceNotIn(List<String> values) {
            addCriterion("epu_province not in", values, "epu_province");
            return (Criteria) this;
        }

        public Criteria andEpu_provinceBetween(String value1, String value2) {
            addCriterion("epu_province between", value1, value2, "epu_province");
            return (Criteria) this;
        }

        public Criteria andEpu_provinceNotBetween(String value1, String value2) {
            addCriterion("epu_province not between", value1, value2, "epu_province");
            return (Criteria) this;
        }

        public Criteria andEpu_cityIsNull() {
            addCriterion("epu_city is null");
            return (Criteria) this;
        }

        public Criteria andEpu_cityIsNotNull() {
            addCriterion("epu_city is not null");
            return (Criteria) this;
        }

        public Criteria andEpu_cityEqualTo(String value) {
            addCriterion("epu_city =", value, "epu_city");
            return (Criteria) this;
        }

        public Criteria andEpu_cityNotEqualTo(String value) {
            addCriterion("epu_city <>", value, "epu_city");
            return (Criteria) this;
        }

        public Criteria andEpu_cityGreaterThan(String value) {
            addCriterion("epu_city >", value, "epu_city");
            return (Criteria) this;
        }

        public Criteria andEpu_cityGreaterThanOrEqualTo(String value) {
            addCriterion("epu_city >=", value, "epu_city");
            return (Criteria) this;
        }

        public Criteria andEpu_cityLessThan(String value) {
            addCriterion("epu_city <", value, "epu_city");
            return (Criteria) this;
        }

        public Criteria andEpu_cityLessThanOrEqualTo(String value) {
            addCriterion("epu_city <=", value, "epu_city");
            return (Criteria) this;
        }

        public Criteria andEpu_cityLike(String value) {
            addCriterion("epu_city like", value, "epu_city");
            return (Criteria) this;
        }

        public Criteria andEpu_cityNotLike(String value) {
            addCriterion("epu_city not like", value, "epu_city");
            return (Criteria) this;
        }

        public Criteria andEpu_cityIn(List<String> values) {
            addCriterion("epu_city in", values, "epu_city");
            return (Criteria) this;
        }

        public Criteria andEpu_cityNotIn(List<String> values) {
            addCriterion("epu_city not in", values, "epu_city");
            return (Criteria) this;
        }

        public Criteria andEpu_cityBetween(String value1, String value2) {
            addCriterion("epu_city between", value1, value2, "epu_city");
            return (Criteria) this;
        }

        public Criteria andEpu_cityNotBetween(String value1, String value2) {
            addCriterion("epu_city not between", value1, value2, "epu_city");
            return (Criteria) this;
        }

        public Criteria andEpu_districtIsNull() {
            addCriterion("epu_district is null");
            return (Criteria) this;
        }

        public Criteria andEpu_districtIsNotNull() {
            addCriterion("epu_district is not null");
            return (Criteria) this;
        }

        public Criteria andEpu_districtEqualTo(String value) {
            addCriterion("epu_district =", value, "epu_district");
            return (Criteria) this;
        }

        public Criteria andEpu_districtNotEqualTo(String value) {
            addCriterion("epu_district <>", value, "epu_district");
            return (Criteria) this;
        }

        public Criteria andEpu_districtGreaterThan(String value) {
            addCriterion("epu_district >", value, "epu_district");
            return (Criteria) this;
        }

        public Criteria andEpu_districtGreaterThanOrEqualTo(String value) {
            addCriterion("epu_district >=", value, "epu_district");
            return (Criteria) this;
        }

        public Criteria andEpu_districtLessThan(String value) {
            addCriterion("epu_district <", value, "epu_district");
            return (Criteria) this;
        }

        public Criteria andEpu_districtLessThanOrEqualTo(String value) {
            addCriterion("epu_district <=", value, "epu_district");
            return (Criteria) this;
        }

        public Criteria andEpu_districtLike(String value) {
            addCriterion("epu_district like", value, "epu_district");
            return (Criteria) this;
        }

        public Criteria andEpu_districtNotLike(String value) {
            addCriterion("epu_district not like", value, "epu_district");
            return (Criteria) this;
        }

        public Criteria andEpu_districtIn(List<String> values) {
            addCriterion("epu_district in", values, "epu_district");
            return (Criteria) this;
        }

        public Criteria andEpu_districtNotIn(List<String> values) {
            addCriterion("epu_district not in", values, "epu_district");
            return (Criteria) this;
        }

        public Criteria andEpu_districtBetween(String value1, String value2) {
            addCriterion("epu_district between", value1, value2, "epu_district");
            return (Criteria) this;
        }

        public Criteria andEpu_districtNotBetween(String value1, String value2) {
            addCriterion("epu_district not between", value1, value2, "epu_district");
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