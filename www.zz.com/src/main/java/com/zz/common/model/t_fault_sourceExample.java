package com.zz.common.model;

import java.util.ArrayList;
import java.util.List;

public class t_fault_sourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public t_fault_sourceExample() {
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

        public Criteria andFault_idIsNull() {
            addCriterion("fault_id is null");
            return (Criteria) this;
        }

        public Criteria andFault_idIsNotNull() {
            addCriterion("fault_id is not null");
            return (Criteria) this;
        }

        public Criteria andFault_idEqualTo(String value) {
            addCriterion("fault_id =", value, "fault_id");
            return (Criteria) this;
        }

        public Criteria andFault_idNotEqualTo(String value) {
            addCriterion("fault_id <>", value, "fault_id");
            return (Criteria) this;
        }

        public Criteria andFault_idGreaterThan(String value) {
            addCriterion("fault_id >", value, "fault_id");
            return (Criteria) this;
        }

        public Criteria andFault_idGreaterThanOrEqualTo(String value) {
            addCriterion("fault_id >=", value, "fault_id");
            return (Criteria) this;
        }

        public Criteria andFault_idLessThan(String value) {
            addCriterion("fault_id <", value, "fault_id");
            return (Criteria) this;
        }

        public Criteria andFault_idLessThanOrEqualTo(String value) {
            addCriterion("fault_id <=", value, "fault_id");
            return (Criteria) this;
        }

        public Criteria andFault_idLike(String value) {
            addCriterion("fault_id like", value, "fault_id");
            return (Criteria) this;
        }

        public Criteria andFault_idNotLike(String value) {
            addCriterion("fault_id not like", value, "fault_id");
            return (Criteria) this;
        }

        public Criteria andFault_idIn(List<String> values) {
            addCriterion("fault_id in", values, "fault_id");
            return (Criteria) this;
        }

        public Criteria andFault_idNotIn(List<String> values) {
            addCriterion("fault_id not in", values, "fault_id");
            return (Criteria) this;
        }

        public Criteria andFault_idBetween(String value1, String value2) {
            addCriterion("fault_id between", value1, value2, "fault_id");
            return (Criteria) this;
        }

        public Criteria andFault_idNotBetween(String value1, String value2) {
            addCriterion("fault_id not between", value1, value2, "fault_id");
            return (Criteria) this;
        }

        public Criteria andTable_nameIsNull() {
            addCriterion("table_name is null");
            return (Criteria) this;
        }

        public Criteria andTable_nameIsNotNull() {
            addCriterion("table_name is not null");
            return (Criteria) this;
        }

        public Criteria andTable_nameEqualTo(String value) {
            addCriterion("table_name =", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameNotEqualTo(String value) {
            addCriterion("table_name <>", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameGreaterThan(String value) {
            addCriterion("table_name >", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameGreaterThanOrEqualTo(String value) {
            addCriterion("table_name >=", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameLessThan(String value) {
            addCriterion("table_name <", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameLessThanOrEqualTo(String value) {
            addCriterion("table_name <=", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameLike(String value) {
            addCriterion("table_name like", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameNotLike(String value) {
            addCriterion("table_name not like", value, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameIn(List<String> values) {
            addCriterion("table_name in", values, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameNotIn(List<String> values) {
            addCriterion("table_name not in", values, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameBetween(String value1, String value2) {
            addCriterion("table_name between", value1, value2, "table_name");
            return (Criteria) this;
        }

        public Criteria andTable_nameNotBetween(String value1, String value2) {
            addCriterion("table_name not between", value1, value2, "table_name");
            return (Criteria) this;
        }

        public Criteria andRecord_idIsNull() {
            addCriterion("record_id is null");
            return (Criteria) this;
        }

        public Criteria andRecord_idIsNotNull() {
            addCriterion("record_id is not null");
            return (Criteria) this;
        }

        public Criteria andRecord_idEqualTo(String value) {
            addCriterion("record_id =", value, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idNotEqualTo(String value) {
            addCriterion("record_id <>", value, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idGreaterThan(String value) {
            addCriterion("record_id >", value, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idGreaterThanOrEqualTo(String value) {
            addCriterion("record_id >=", value, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idLessThan(String value) {
            addCriterion("record_id <", value, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idLessThanOrEqualTo(String value) {
            addCriterion("record_id <=", value, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idLike(String value) {
            addCriterion("record_id like", value, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idNotLike(String value) {
            addCriterion("record_id not like", value, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idIn(List<String> values) {
            addCriterion("record_id in", values, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idNotIn(List<String> values) {
            addCriterion("record_id not in", values, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idBetween(String value1, String value2) {
            addCriterion("record_id between", value1, value2, "record_id");
            return (Criteria) this;
        }

        public Criteria andRecord_idNotBetween(String value1, String value2) {
            addCriterion("record_id not between", value1, value2, "record_id");
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