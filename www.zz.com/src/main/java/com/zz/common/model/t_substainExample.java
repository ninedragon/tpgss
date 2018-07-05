package com.zz.common.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class t_substainExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public t_substainExample() {
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

        public Criteria andSubstainIdIsNull() {
            addCriterion("substainId is null");
            return (Criteria) this;
        }

        public Criteria andSubstainIdIsNotNull() {
            addCriterion("substainId is not null");
            return (Criteria) this;
        }

        public Criteria andSubstainIdEqualTo(String value) {
            addCriterion("substainId =", value, "substainId");
            return (Criteria) this;
        }

        public Criteria andSubstainIdNotEqualTo(String value) {
            addCriterion("substainId <>", value, "substainId");
            return (Criteria) this;
        }

        public Criteria andSubstainIdGreaterThan(String value) {
            addCriterion("substainId >", value, "substainId");
            return (Criteria) this;
        }

        public Criteria andSubstainIdGreaterThanOrEqualTo(String value) {
            addCriterion("substainId >=", value, "substainId");
            return (Criteria) this;
        }

        public Criteria andSubstainIdLessThan(String value) {
            addCriterion("substainId <", value, "substainId");
            return (Criteria) this;
        }

        public Criteria andSubstainIdLessThanOrEqualTo(String value) {
            addCriterion("substainId <=", value, "substainId");
            return (Criteria) this;
        }

        public Criteria andSubstainIdLike(String value) {
            addCriterion("substainId like", value, "substainId");
            return (Criteria) this;
        }

        public Criteria andSubstainIdNotLike(String value) {
            addCriterion("substainId not like", value, "substainId");
            return (Criteria) this;
        }

        public Criteria andSubstainIdIn(List<String> values) {
            addCriterion("substainId in", values, "substainId");
            return (Criteria) this;
        }

        public Criteria andSubstainIdNotIn(List<String> values) {
            addCriterion("substainId not in", values, "substainId");
            return (Criteria) this;
        }

        public Criteria andSubstainIdBetween(String value1, String value2) {
            addCriterion("substainId between", value1, value2, "substainId");
            return (Criteria) this;
        }

        public Criteria andSubstainIdNotBetween(String value1, String value2) {
            addCriterion("substainId not between", value1, value2, "substainId");
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

        public Criteria andEpu_xscaleIsNull() {
            addCriterion("epu_xscale is null");
            return (Criteria) this;
        }

        public Criteria andEpu_xscaleIsNotNull() {
            addCriterion("epu_xscale is not null");
            return (Criteria) this;
        }

        public Criteria andEpu_xscaleEqualTo(Double value) {
            addCriterion("epu_xscale =", value, "epu_xscale");
            return (Criteria) this;
        }

        public Criteria andEpu_xscaleNotEqualTo(Double value) {
            addCriterion("epu_xscale <>", value, "epu_xscale");
            return (Criteria) this;
        }

        public Criteria andEpu_xscaleGreaterThan(Double value) {
            addCriterion("epu_xscale >", value, "epu_xscale");
            return (Criteria) this;
        }

        public Criteria andEpu_xscaleGreaterThanOrEqualTo(Double value) {
            addCriterion("epu_xscale >=", value, "epu_xscale");
            return (Criteria) this;
        }

        public Criteria andEpu_xscaleLessThan(Double value) {
            addCriterion("epu_xscale <", value, "epu_xscale");
            return (Criteria) this;
        }

        public Criteria andEpu_xscaleLessThanOrEqualTo(Double value) {
            addCriterion("epu_xscale <=", value, "epu_xscale");
            return (Criteria) this;
        }

        public Criteria andEpu_xscaleIn(List<Double> values) {
            addCriterion("epu_xscale in", values, "epu_xscale");
            return (Criteria) this;
        }

        public Criteria andEpu_xscaleNotIn(List<Double> values) {
            addCriterion("epu_xscale not in", values, "epu_xscale");
            return (Criteria) this;
        }

        public Criteria andEpu_xscaleBetween(Double value1, Double value2) {
            addCriterion("epu_xscale between", value1, value2, "epu_xscale");
            return (Criteria) this;
        }

        public Criteria andEpu_xscaleNotBetween(Double value1, Double value2) {
            addCriterion("epu_xscale not between", value1, value2, "epu_xscale");
            return (Criteria) this;
        }

        public Criteria andEpu_yscaleIsNull() {
            addCriterion("epu_yscale is null");
            return (Criteria) this;
        }

        public Criteria andEpu_yscaleIsNotNull() {
            addCriterion("epu_yscale is not null");
            return (Criteria) this;
        }

        public Criteria andEpu_yscaleEqualTo(Double value) {
            addCriterion("epu_yscale =", value, "epu_yscale");
            return (Criteria) this;
        }

        public Criteria andEpu_yscaleNotEqualTo(Double value) {
            addCriterion("epu_yscale <>", value, "epu_yscale");
            return (Criteria) this;
        }

        public Criteria andEpu_yscaleGreaterThan(Double value) {
            addCriterion("epu_yscale >", value, "epu_yscale");
            return (Criteria) this;
        }

        public Criteria andEpu_yscaleGreaterThanOrEqualTo(Double value) {
            addCriterion("epu_yscale >=", value, "epu_yscale");
            return (Criteria) this;
        }

        public Criteria andEpu_yscaleLessThan(Double value) {
            addCriterion("epu_yscale <", value, "epu_yscale");
            return (Criteria) this;
        }

        public Criteria andEpu_yscaleLessThanOrEqualTo(Double value) {
            addCriterion("epu_yscale <=", value, "epu_yscale");
            return (Criteria) this;
        }

        public Criteria andEpu_yscaleIn(List<Double> values) {
            addCriterion("epu_yscale in", values, "epu_yscale");
            return (Criteria) this;
        }

        public Criteria andEpu_yscaleNotIn(List<Double> values) {
            addCriterion("epu_yscale not in", values, "epu_yscale");
            return (Criteria) this;
        }

        public Criteria andEpu_yscaleBetween(Double value1, Double value2) {
            addCriterion("epu_yscale between", value1, value2, "epu_yscale");
            return (Criteria) this;
        }

        public Criteria andEpu_yscaleNotBetween(Double value1, Double value2) {
            addCriterion("epu_yscale not between", value1, value2, "epu_yscale");
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