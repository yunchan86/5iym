package com.iyoumei.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RewardRuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RewardRuleExample() {
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

        public Criteria andRuleIdIsNull() {
            addCriterion("rule_id is null");
            return (Criteria) this;
        }

        public Criteria andRuleIdIsNotNull() {
            addCriterion("rule_id is not null");
            return (Criteria) this;
        }

        public Criteria andRuleIdEqualTo(Integer value) {
            addCriterion("rule_id =", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotEqualTo(Integer value) {
            addCriterion("rule_id <>", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThan(Integer value) {
            addCriterion("rule_id >", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("rule_id >=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThan(Integer value) {
            addCriterion("rule_id <", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdLessThanOrEqualTo(Integer value) {
            addCriterion("rule_id <=", value, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdIn(List<Integer> values) {
            addCriterion("rule_id in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotIn(List<Integer> values) {
            addCriterion("rule_id not in", values, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdBetween(Integer value1, Integer value2) {
            addCriterion("rule_id between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("rule_id not between", value1, value2, "ruleId");
            return (Criteria) this;
        }

        public Criteria andRuleNameIsNull() {
            addCriterion("rule_name is null");
            return (Criteria) this;
        }

        public Criteria andRuleNameIsNotNull() {
            addCriterion("rule_name is not null");
            return (Criteria) this;
        }

        public Criteria andRuleNameEqualTo(String value) {
            addCriterion("rule_name =", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotEqualTo(String value) {
            addCriterion("rule_name <>", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameGreaterThan(String value) {
            addCriterion("rule_name >", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameGreaterThanOrEqualTo(String value) {
            addCriterion("rule_name >=", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameLessThan(String value) {
            addCriterion("rule_name <", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameLessThanOrEqualTo(String value) {
            addCriterion("rule_name <=", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameLike(String value) {
            addCriterion("rule_name like", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotLike(String value) {
            addCriterion("rule_name not like", value, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameIn(List<String> values) {
            addCriterion("rule_name in", values, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotIn(List<String> values) {
            addCriterion("rule_name not in", values, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameBetween(String value1, String value2) {
            addCriterion("rule_name between", value1, value2, "ruleName");
            return (Criteria) this;
        }

        public Criteria andRuleNameNotBetween(String value1, String value2) {
            addCriterion("rule_name not between", value1, value2, "ruleName");
            return (Criteria) this;
        }

        public Criteria andMaxLevelIsNull() {
            addCriterion("max_level is null");
            return (Criteria) this;
        }

        public Criteria andMaxLevelIsNotNull() {
            addCriterion("max_level is not null");
            return (Criteria) this;
        }

        public Criteria andMaxLevelEqualTo(Integer value) {
            addCriterion("max_level =", value, "maxLevel");
            return (Criteria) this;
        }

        public Criteria andMaxLevelNotEqualTo(Integer value) {
            addCriterion("max_level <>", value, "maxLevel");
            return (Criteria) this;
        }

        public Criteria andMaxLevelGreaterThan(Integer value) {
            addCriterion("max_level >", value, "maxLevel");
            return (Criteria) this;
        }

        public Criteria andMaxLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_level >=", value, "maxLevel");
            return (Criteria) this;
        }

        public Criteria andMaxLevelLessThan(Integer value) {
            addCriterion("max_level <", value, "maxLevel");
            return (Criteria) this;
        }

        public Criteria andMaxLevelLessThanOrEqualTo(Integer value) {
            addCriterion("max_level <=", value, "maxLevel");
            return (Criteria) this;
        }

        public Criteria andMaxLevelIn(List<Integer> values) {
            addCriterion("max_level in", values, "maxLevel");
            return (Criteria) this;
        }

        public Criteria andMaxLevelNotIn(List<Integer> values) {
            addCriterion("max_level not in", values, "maxLevel");
            return (Criteria) this;
        }

        public Criteria andMaxLevelBetween(Integer value1, Integer value2) {
            addCriterion("max_level between", value1, value2, "maxLevel");
            return (Criteria) this;
        }

        public Criteria andMaxLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("max_level not between", value1, value2, "maxLevel");
            return (Criteria) this;
        }

        public Criteria andTimeCycleIsNull() {
            addCriterion("time_cycle is null");
            return (Criteria) this;
        }

        public Criteria andTimeCycleIsNotNull() {
            addCriterion("time_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andTimeCycleEqualTo(Short value) {
            addCriterion("time_cycle =", value, "timeCycle");
            return (Criteria) this;
        }

        public Criteria andTimeCycleNotEqualTo(Short value) {
            addCriterion("time_cycle <>", value, "timeCycle");
            return (Criteria) this;
        }

        public Criteria andTimeCycleGreaterThan(Short value) {
            addCriterion("time_cycle >", value, "timeCycle");
            return (Criteria) this;
        }

        public Criteria andTimeCycleGreaterThanOrEqualTo(Short value) {
            addCriterion("time_cycle >=", value, "timeCycle");
            return (Criteria) this;
        }

        public Criteria andTimeCycleLessThan(Short value) {
            addCriterion("time_cycle <", value, "timeCycle");
            return (Criteria) this;
        }

        public Criteria andTimeCycleLessThanOrEqualTo(Short value) {
            addCriterion("time_cycle <=", value, "timeCycle");
            return (Criteria) this;
        }

        public Criteria andTimeCycleIn(List<Short> values) {
            addCriterion("time_cycle in", values, "timeCycle");
            return (Criteria) this;
        }

        public Criteria andTimeCycleNotIn(List<Short> values) {
            addCriterion("time_cycle not in", values, "timeCycle");
            return (Criteria) this;
        }

        public Criteria andTimeCycleBetween(Short value1, Short value2) {
            addCriterion("time_cycle between", value1, value2, "timeCycle");
            return (Criteria) this;
        }

        public Criteria andTimeCycleNotBetween(Short value1, Short value2) {
            addCriterion("time_cycle not between", value1, value2, "timeCycle");
            return (Criteria) this;
        }

        public Criteria andLimitMaxAmtIsNull() {
            addCriterion("limit_max_amt is null");
            return (Criteria) this;
        }

        public Criteria andLimitMaxAmtIsNotNull() {
            addCriterion("limit_max_amt is not null");
            return (Criteria) this;
        }

        public Criteria andLimitMaxAmtEqualTo(Long value) {
            addCriterion("limit_max_amt =", value, "limitMaxAmt");
            return (Criteria) this;
        }

        public Criteria andLimitMaxAmtNotEqualTo(Long value) {
            addCriterion("limit_max_amt <>", value, "limitMaxAmt");
            return (Criteria) this;
        }

        public Criteria andLimitMaxAmtGreaterThan(Long value) {
            addCriterion("limit_max_amt >", value, "limitMaxAmt");
            return (Criteria) this;
        }

        public Criteria andLimitMaxAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("limit_max_amt >=", value, "limitMaxAmt");
            return (Criteria) this;
        }

        public Criteria andLimitMaxAmtLessThan(Long value) {
            addCriterion("limit_max_amt <", value, "limitMaxAmt");
            return (Criteria) this;
        }

        public Criteria andLimitMaxAmtLessThanOrEqualTo(Long value) {
            addCriterion("limit_max_amt <=", value, "limitMaxAmt");
            return (Criteria) this;
        }

        public Criteria andLimitMaxAmtIn(List<Long> values) {
            addCriterion("limit_max_amt in", values, "limitMaxAmt");
            return (Criteria) this;
        }

        public Criteria andLimitMaxAmtNotIn(List<Long> values) {
            addCriterion("limit_max_amt not in", values, "limitMaxAmt");
            return (Criteria) this;
        }

        public Criteria andLimitMaxAmtBetween(Long value1, Long value2) {
            addCriterion("limit_max_amt between", value1, value2, "limitMaxAmt");
            return (Criteria) this;
        }

        public Criteria andLimitMaxAmtNotBetween(Long value1, Long value2) {
            addCriterion("limit_max_amt not between", value1, value2, "limitMaxAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtIsNull() {
            addCriterion("unit_amt is null");
            return (Criteria) this;
        }

        public Criteria andUnitAmtIsNotNull() {
            addCriterion("unit_amt is not null");
            return (Criteria) this;
        }

        public Criteria andUnitAmtEqualTo(Long value) {
            addCriterion("unit_amt =", value, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtNotEqualTo(Long value) {
            addCriterion("unit_amt <>", value, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtGreaterThan(Long value) {
            addCriterion("unit_amt >", value, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("unit_amt >=", value, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtLessThan(Long value) {
            addCriterion("unit_amt <", value, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtLessThanOrEqualTo(Long value) {
            addCriterion("unit_amt <=", value, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtIn(List<Long> values) {
            addCriterion("unit_amt in", values, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtNotIn(List<Long> values) {
            addCriterion("unit_amt not in", values, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtBetween(Long value1, Long value2) {
            addCriterion("unit_amt between", value1, value2, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andUnitAmtNotBetween(Long value1, Long value2) {
            addCriterion("unit_amt not between", value1, value2, "unitAmt");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNull() {
            addCriterion("insert_time is null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNotNull() {
            addCriterion("insert_time is not null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeEqualTo(Date value) {
            addCriterion("insert_time =", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotEqualTo(Date value) {
            addCriterion("insert_time <>", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThan(Date value) {
            addCriterion("insert_time >", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("insert_time >=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThan(Date value) {
            addCriterion("insert_time <", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThanOrEqualTo(Date value) {
            addCriterion("insert_time <=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIn(List<Date> values) {
            addCriterion("insert_time in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotIn(List<Date> values) {
            addCriterion("insert_time not in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeBetween(Date value1, Date value2) {
            addCriterion("insert_time between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotBetween(Date value1, Date value2) {
            addCriterion("insert_time not between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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