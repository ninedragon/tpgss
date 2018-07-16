package com.zz.common.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class t_fault_baseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public t_fault_baseExample() {
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andKey_idIsNull() {
            addCriterion("key_id is null");
            return (Criteria) this;
        }

        public Criteria andKey_idIsNotNull() {
            addCriterion("key_id is not null");
            return (Criteria) this;
        }

        public Criteria andKey_idEqualTo(String value) {
            addCriterion("key_id =", value, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idNotEqualTo(String value) {
            addCriterion("key_id <>", value, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idGreaterThan(String value) {
            addCriterion("key_id >", value, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idGreaterThanOrEqualTo(String value) {
            addCriterion("key_id >=", value, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idLessThan(String value) {
            addCriterion("key_id <", value, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idLessThanOrEqualTo(String value) {
            addCriterion("key_id <=", value, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idLike(String value) {
            addCriterion("key_id like", value, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idNotLike(String value) {
            addCriterion("key_id not like", value, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idIn(List<String> values) {
            addCriterion("key_id in", values, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idNotIn(List<String> values) {
            addCriterion("key_id not in", values, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idBetween(String value1, String value2) {
            addCriterion("key_id between", value1, value2, "key_id");
            return (Criteria) this;
        }

        public Criteria andKey_idNotBetween(String value1, String value2) {
            addCriterion("key_id not between", value1, value2, "key_id");
            return (Criteria) this;
        }

        public Criteria andFault_typeIsNull() {
            addCriterion("fault_type is null");
            return (Criteria) this;
        }

        public Criteria andFault_typeIsNotNull() {
            addCriterion("fault_type is not null");
            return (Criteria) this;
        }

        public Criteria andFault_typeEqualTo(Integer value) {
            addCriterion("fault_type =", value, "fault_type");
            return (Criteria) this;
        }

        public Criteria andFault_typeNotEqualTo(Integer value) {
            addCriterion("fault_type <>", value, "fault_type");
            return (Criteria) this;
        }

        public Criteria andFault_typeGreaterThan(Integer value) {
            addCriterion("fault_type >", value, "fault_type");
            return (Criteria) this;
        }

        public Criteria andFault_typeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fault_type >=", value, "fault_type");
            return (Criteria) this;
        }

        public Criteria andFault_typeLessThan(Integer value) {
            addCriterion("fault_type <", value, "fault_type");
            return (Criteria) this;
        }

        public Criteria andFault_typeLessThanOrEqualTo(Integer value) {
            addCriterion("fault_type <=", value, "fault_type");
            return (Criteria) this;
        }

        public Criteria andFault_typeIn(List<Integer> values) {
            addCriterion("fault_type in", values, "fault_type");
            return (Criteria) this;
        }

        public Criteria andFault_typeNotIn(List<Integer> values) {
            addCriterion("fault_type not in", values, "fault_type");
            return (Criteria) this;
        }

        public Criteria andFault_typeBetween(Integer value1, Integer value2) {
            addCriterion("fault_type between", value1, value2, "fault_type");
            return (Criteria) this;
        }

        public Criteria andFault_typeNotBetween(Integer value1, Integer value2) {
            addCriterion("fault_type not between", value1, value2, "fault_type");
            return (Criteria) this;
        }

        public Criteria andOccur_timeIsNull() {
            addCriterion("occur_time is null");
            return (Criteria) this;
        }

        public Criteria andOccur_timeIsNotNull() {
            addCriterion("occur_time is not null");
            return (Criteria) this;
        }

        public Criteria andOccur_timeEqualTo(Date value) {
            addCriterion("occur_time =", value, "occur_time");
            return (Criteria) this;
        }

        public Criteria andOccur_timeNotEqualTo(Date value) {
            addCriterion("occur_time <>", value, "occur_time");
            return (Criteria) this;
        }

        public Criteria andOccur_timeGreaterThan(Date value) {
            addCriterion("occur_time >", value, "occur_time");
            return (Criteria) this;
        }

        public Criteria andOccur_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("occur_time >=", value, "occur_time");
            return (Criteria) this;
        }

        public Criteria andOccur_timeLessThan(Date value) {
            addCriterion("occur_time <", value, "occur_time");
            return (Criteria) this;
        }

        public Criteria andOccur_timeLessThanOrEqualTo(Date value) {
            addCriterion("occur_time <=", value, "occur_time");
            return (Criteria) this;
        }

        public Criteria andOccur_timeIn(List<Date> values) {
            addCriterion("occur_time in", values, "occur_time");
            return (Criteria) this;
        }

        public Criteria andOccur_timeNotIn(List<Date> values) {
            addCriterion("occur_time not in", values, "occur_time");
            return (Criteria) this;
        }

        public Criteria andOccur_timeBetween(Date value1, Date value2) {
            addCriterion("occur_time between", value1, value2, "occur_time");
            return (Criteria) this;
        }

        public Criteria andOccur_timeNotBetween(Date value1, Date value2) {
            addCriterion("occur_time not between", value1, value2, "occur_time");
            return (Criteria) this;
        }

        public Criteria andIs_cancelledIsNull() {
            addCriterion("is_cancelled is null");
            return (Criteria) this;
        }

        public Criteria andIs_cancelledIsNotNull() {
            addCriterion("is_cancelled is not null");
            return (Criteria) this;
        }

        public Criteria andIs_cancelledEqualTo(Integer value) {
            addCriterion("is_cancelled =", value, "is_cancelled");
            return (Criteria) this;
        }

        public Criteria andIs_cancelledNotEqualTo(Integer value) {
            addCriterion("is_cancelled <>", value, "is_cancelled");
            return (Criteria) this;
        }

        public Criteria andIs_cancelledGreaterThan(Integer value) {
            addCriterion("is_cancelled >", value, "is_cancelled");
            return (Criteria) this;
        }

        public Criteria andIs_cancelledGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_cancelled >=", value, "is_cancelled");
            return (Criteria) this;
        }

        public Criteria andIs_cancelledLessThan(Integer value) {
            addCriterion("is_cancelled <", value, "is_cancelled");
            return (Criteria) this;
        }

        public Criteria andIs_cancelledLessThanOrEqualTo(Integer value) {
            addCriterion("is_cancelled <=", value, "is_cancelled");
            return (Criteria) this;
        }

        public Criteria andIs_cancelledIn(List<Integer> values) {
            addCriterion("is_cancelled in", values, "is_cancelled");
            return (Criteria) this;
        }

        public Criteria andIs_cancelledNotIn(List<Integer> values) {
            addCriterion("is_cancelled not in", values, "is_cancelled");
            return (Criteria) this;
        }

        public Criteria andIs_cancelledBetween(Integer value1, Integer value2) {
            addCriterion("is_cancelled between", value1, value2, "is_cancelled");
            return (Criteria) this;
        }

        public Criteria andIs_cancelledNotBetween(Integer value1, Integer value2) {
            addCriterion("is_cancelled not between", value1, value2, "is_cancelled");
            return (Criteria) this;
        }

        public Criteria andRepair_timeIsNull() {
            addCriterion("repair_time is null");
            return (Criteria) this;
        }

        public Criteria andRepair_timeIsNotNull() {
            addCriterion("repair_time is not null");
            return (Criteria) this;
        }

        public Criteria andRepair_timeEqualTo(Date value) {
            addCriterion("repair_time =", value, "repair_time");
            return (Criteria) this;
        }

        public Criteria andRepair_timeNotEqualTo(Date value) {
            addCriterion("repair_time <>", value, "repair_time");
            return (Criteria) this;
        }

        public Criteria andRepair_timeGreaterThan(Date value) {
            addCriterion("repair_time >", value, "repair_time");
            return (Criteria) this;
        }

        public Criteria andRepair_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("repair_time >=", value, "repair_time");
            return (Criteria) this;
        }

        public Criteria andRepair_timeLessThan(Date value) {
            addCriterion("repair_time <", value, "repair_time");
            return (Criteria) this;
        }

        public Criteria andRepair_timeLessThanOrEqualTo(Date value) {
            addCriterion("repair_time <=", value, "repair_time");
            return (Criteria) this;
        }

        public Criteria andRepair_timeIn(List<Date> values) {
            addCriterion("repair_time in", values, "repair_time");
            return (Criteria) this;
        }

        public Criteria andRepair_timeNotIn(List<Date> values) {
            addCriterion("repair_time not in", values, "repair_time");
            return (Criteria) this;
        }

        public Criteria andRepair_timeBetween(Date value1, Date value2) {
            addCriterion("repair_time between", value1, value2, "repair_time");
            return (Criteria) this;
        }

        public Criteria andRepair_timeNotBetween(Date value1, Date value2) {
            addCriterion("repair_time not between", value1, value2, "repair_time");
            return (Criteria) this;
        }

        public Criteria andIs_repairedIsNull() {
            addCriterion("is_repaired is null");
            return (Criteria) this;
        }

        public Criteria andIs_repairedIsNotNull() {
            addCriterion("is_repaired is not null");
            return (Criteria) this;
        }

        public Criteria andIs_repairedEqualTo(Integer value) {
            addCriterion("is_repaired =", value, "is_repaired");
            return (Criteria) this;
        }

        public Criteria andIs_repairedNotEqualTo(Integer value) {
            addCriterion("is_repaired <>", value, "is_repaired");
            return (Criteria) this;
        }

        public Criteria andIs_repairedGreaterThan(Integer value) {
            addCriterion("is_repaired >", value, "is_repaired");
            return (Criteria) this;
        }

        public Criteria andIs_repairedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_repaired >=", value, "is_repaired");
            return (Criteria) this;
        }

        public Criteria andIs_repairedLessThan(Integer value) {
            addCriterion("is_repaired <", value, "is_repaired");
            return (Criteria) this;
        }

        public Criteria andIs_repairedLessThanOrEqualTo(Integer value) {
            addCriterion("is_repaired <=", value, "is_repaired");
            return (Criteria) this;
        }

        public Criteria andIs_repairedIn(List<Integer> values) {
            addCriterion("is_repaired in", values, "is_repaired");
            return (Criteria) this;
        }

        public Criteria andIs_repairedNotIn(List<Integer> values) {
            addCriterion("is_repaired not in", values, "is_repaired");
            return (Criteria) this;
        }

        public Criteria andIs_repairedBetween(Integer value1, Integer value2) {
            addCriterion("is_repaired between", value1, value2, "is_repaired");
            return (Criteria) this;
        }

        public Criteria andIs_repairedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_repaired not between", value1, value2, "is_repaired");
            return (Criteria) this;
        }

        public Criteria andSubstain_idIsNull() {
            addCriterion("substain_id is null");
            return (Criteria) this;
        }

        public Criteria andSubstain_idIsNotNull() {
            addCriterion("substain_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubstain_idEqualTo(String value) {
            addCriterion("substain_id =", value, "substain_id");
            return (Criteria) this;
        }

        public Criteria andSubstain_idNotEqualTo(String value) {
            addCriterion("substain_id <>", value, "substain_id");
            return (Criteria) this;
        }

        public Criteria andSubstain_idGreaterThan(String value) {
            addCriterion("substain_id >", value, "substain_id");
            return (Criteria) this;
        }

        public Criteria andSubstain_idGreaterThanOrEqualTo(String value) {
            addCriterion("substain_id >=", value, "substain_id");
            return (Criteria) this;
        }

        public Criteria andSubstain_idLessThan(String value) {
            addCriterion("substain_id <", value, "substain_id");
            return (Criteria) this;
        }

        public Criteria andSubstain_idLessThanOrEqualTo(String value) {
            addCriterion("substain_id <=", value, "substain_id");
            return (Criteria) this;
        }

        public Criteria andSubstain_idLike(String value) {
            addCriterion("substain_id like", value, "substain_id");
            return (Criteria) this;
        }

        public Criteria andSubstain_idNotLike(String value) {
            addCriterion("substain_id not like", value, "substain_id");
            return (Criteria) this;
        }

        public Criteria andSubstain_idIn(List<String> values) {
            addCriterion("substain_id in", values, "substain_id");
            return (Criteria) this;
        }

        public Criteria andSubstain_idNotIn(List<String> values) {
            addCriterion("substain_id not in", values, "substain_id");
            return (Criteria) this;
        }

        public Criteria andSubstain_idBetween(String value1, String value2) {
            addCriterion("substain_id between", value1, value2, "substain_id");
            return (Criteria) this;
        }

        public Criteria andSubstain_idNotBetween(String value1, String value2) {
            addCriterion("substain_id not between", value1, value2, "substain_id");
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