package com.zz.common.model;

import java.util.ArrayList;
import java.util.List;

public class t_cal_zExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public t_cal_zExample() {
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

        public Criteria andZaIsNull() {
            addCriterion("za is null");
            return (Criteria) this;
        }

        public Criteria andZaIsNotNull() {
            addCriterion("za is not null");
            return (Criteria) this;
        }

        public Criteria andZaEqualTo(Float value) {
            addCriterion("za =", value, "za");
            return (Criteria) this;
        }

        public Criteria andZaNotEqualTo(Float value) {
            addCriterion("za <>", value, "za");
            return (Criteria) this;
        }

        public Criteria andZaGreaterThan(Float value) {
            addCriterion("za >", value, "za");
            return (Criteria) this;
        }

        public Criteria andZaGreaterThanOrEqualTo(Float value) {
            addCriterion("za >=", value, "za");
            return (Criteria) this;
        }

        public Criteria andZaLessThan(Float value) {
            addCriterion("za <", value, "za");
            return (Criteria) this;
        }

        public Criteria andZaLessThanOrEqualTo(Float value) {
            addCriterion("za <=", value, "za");
            return (Criteria) this;
        }

        public Criteria andZaIn(List<Float> values) {
            addCriterion("za in", values, "za");
            return (Criteria) this;
        }

        public Criteria andZaNotIn(List<Float> values) {
            addCriterion("za not in", values, "za");
            return (Criteria) this;
        }

        public Criteria andZaBetween(Float value1, Float value2) {
            addCriterion("za between", value1, value2, "za");
            return (Criteria) this;
        }

        public Criteria andZaNotBetween(Float value1, Float value2) {
            addCriterion("za not between", value1, value2, "za");
            return (Criteria) this;
        }

        public Criteria andZbIsNull() {
            addCriterion("zb is null");
            return (Criteria) this;
        }

        public Criteria andZbIsNotNull() {
            addCriterion("zb is not null");
            return (Criteria) this;
        }

        public Criteria andZbEqualTo(Float value) {
            addCriterion("zb =", value, "zb");
            return (Criteria) this;
        }

        public Criteria andZbNotEqualTo(Float value) {
            addCriterion("zb <>", value, "zb");
            return (Criteria) this;
        }

        public Criteria andZbGreaterThan(Float value) {
            addCriterion("zb >", value, "zb");
            return (Criteria) this;
        }

        public Criteria andZbGreaterThanOrEqualTo(Float value) {
            addCriterion("zb >=", value, "zb");
            return (Criteria) this;
        }

        public Criteria andZbLessThan(Float value) {
            addCriterion("zb <", value, "zb");
            return (Criteria) this;
        }

        public Criteria andZbLessThanOrEqualTo(Float value) {
            addCriterion("zb <=", value, "zb");
            return (Criteria) this;
        }

        public Criteria andZbIn(List<Float> values) {
            addCriterion("zb in", values, "zb");
            return (Criteria) this;
        }

        public Criteria andZbNotIn(List<Float> values) {
            addCriterion("zb not in", values, "zb");
            return (Criteria) this;
        }

        public Criteria andZbBetween(Float value1, Float value2) {
            addCriterion("zb between", value1, value2, "zb");
            return (Criteria) this;
        }

        public Criteria andZbNotBetween(Float value1, Float value2) {
            addCriterion("zb not between", value1, value2, "zb");
            return (Criteria) this;
        }

        public Criteria andZcIsNull() {
            addCriterion("zc is null");
            return (Criteria) this;
        }

        public Criteria andZcIsNotNull() {
            addCriterion("zc is not null");
            return (Criteria) this;
        }

        public Criteria andZcEqualTo(Float value) {
            addCriterion("zc =", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcNotEqualTo(Float value) {
            addCriterion("zc <>", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcGreaterThan(Float value) {
            addCriterion("zc >", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcGreaterThanOrEqualTo(Float value) {
            addCriterion("zc >=", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcLessThan(Float value) {
            addCriterion("zc <", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcLessThanOrEqualTo(Float value) {
            addCriterion("zc <=", value, "zc");
            return (Criteria) this;
        }

        public Criteria andZcIn(List<Float> values) {
            addCriterion("zc in", values, "zc");
            return (Criteria) this;
        }

        public Criteria andZcNotIn(List<Float> values) {
            addCriterion("zc not in", values, "zc");
            return (Criteria) this;
        }

        public Criteria andZcBetween(Float value1, Float value2) {
            addCriterion("zc between", value1, value2, "zc");
            return (Criteria) this;
        }

        public Criteria andZcNotBetween(Float value1, Float value2) {
            addCriterion("zc not between", value1, value2, "zc");
            return (Criteria) this;
        }

        public Criteria andRecord_dateIsNull() {
            addCriterion("record_date is null");
            return (Criteria) this;
        }

        public Criteria andRecord_dateIsNotNull() {
            addCriterion("record_date is not null");
            return (Criteria) this;
        }

        public Criteria andRecord_dateEqualTo(Integer value) {
            addCriterion("record_date =", value, "record_date");
            return (Criteria) this;
        }

        public Criteria andRecord_dateNotEqualTo(Integer value) {
            addCriterion("record_date <>", value, "record_date");
            return (Criteria) this;
        }

        public Criteria andRecord_dateGreaterThan(Integer value) {
            addCriterion("record_date >", value, "record_date");
            return (Criteria) this;
        }

        public Criteria andRecord_dateGreaterThanOrEqualTo(Integer value) {
            addCriterion("record_date >=", value, "record_date");
            return (Criteria) this;
        }

        public Criteria andRecord_dateLessThan(Integer value) {
            addCriterion("record_date <", value, "record_date");
            return (Criteria) this;
        }

        public Criteria andRecord_dateLessThanOrEqualTo(Integer value) {
            addCriterion("record_date <=", value, "record_date");
            return (Criteria) this;
        }

        public Criteria andRecord_dateIn(List<Integer> values) {
            addCriterion("record_date in", values, "record_date");
            return (Criteria) this;
        }

        public Criteria andRecord_dateNotIn(List<Integer> values) {
            addCriterion("record_date not in", values, "record_date");
            return (Criteria) this;
        }

        public Criteria andRecord_dateBetween(Integer value1, Integer value2) {
            addCriterion("record_date between", value1, value2, "record_date");
            return (Criteria) this;
        }

        public Criteria andRecord_dateNotBetween(Integer value1, Integer value2) {
            addCriterion("record_date not between", value1, value2, "record_date");
            return (Criteria) this;
        }

        public Criteria andIs_validIsNull() {
            addCriterion("is_valid is null");
            return (Criteria) this;
        }

        public Criteria andIs_validIsNotNull() {
            addCriterion("is_valid is not null");
            return (Criteria) this;
        }

        public Criteria andIs_validEqualTo(Boolean value) {
            addCriterion("is_valid =", value, "is_valid");
            return (Criteria) this;
        }

        public Criteria andIs_validNotEqualTo(Boolean value) {
            addCriterion("is_valid <>", value, "is_valid");
            return (Criteria) this;
        }

        public Criteria andIs_validGreaterThan(Boolean value) {
            addCriterion("is_valid >", value, "is_valid");
            return (Criteria) this;
        }

        public Criteria andIs_validGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_valid >=", value, "is_valid");
            return (Criteria) this;
        }

        public Criteria andIs_validLessThan(Boolean value) {
            addCriterion("is_valid <", value, "is_valid");
            return (Criteria) this;
        }

        public Criteria andIs_validLessThanOrEqualTo(Boolean value) {
            addCriterion("is_valid <=", value, "is_valid");
            return (Criteria) this;
        }

        public Criteria andIs_validIn(List<Boolean> values) {
            addCriterion("is_valid in", values, "is_valid");
            return (Criteria) this;
        }

        public Criteria andIs_validNotIn(List<Boolean> values) {
            addCriterion("is_valid not in", values, "is_valid");
            return (Criteria) this;
        }

        public Criteria andIs_validBetween(Boolean value1, Boolean value2) {
            addCriterion("is_valid between", value1, value2, "is_valid");
            return (Criteria) this;
        }

        public Criteria andIs_validNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_valid not between", value1, value2, "is_valid");
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