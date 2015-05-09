package com.iyoumei.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserRewardLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserRewardLogExample() {
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

        public Criteria andSuperIdIsNull() {
            addCriterion("super_id is null");
            return (Criteria) this;
        }

        public Criteria andSuperIdIsNotNull() {
            addCriterion("super_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuperIdEqualTo(Long value) {
            addCriterion("super_id =", value, "superId");
            return (Criteria) this;
        }

        public Criteria andSuperIdNotEqualTo(Long value) {
            addCriterion("super_id <>", value, "superId");
            return (Criteria) this;
        }

        public Criteria andSuperIdGreaterThan(Long value) {
            addCriterion("super_id >", value, "superId");
            return (Criteria) this;
        }

        public Criteria andSuperIdGreaterThanOrEqualTo(Long value) {
            addCriterion("super_id >=", value, "superId");
            return (Criteria) this;
        }

        public Criteria andSuperIdLessThan(Long value) {
            addCriterion("super_id <", value, "superId");
            return (Criteria) this;
        }

        public Criteria andSuperIdLessThanOrEqualTo(Long value) {
            addCriterion("super_id <=", value, "superId");
            return (Criteria) this;
        }

        public Criteria andSuperIdIn(List<Long> values) {
            addCriterion("super_id in", values, "superId");
            return (Criteria) this;
        }

        public Criteria andSuperIdNotIn(List<Long> values) {
            addCriterion("super_id not in", values, "superId");
            return (Criteria) this;
        }

        public Criteria andSuperIdBetween(Long value1, Long value2) {
            addCriterion("super_id between", value1, value2, "superId");
            return (Criteria) this;
        }

        public Criteria andSuperIdNotBetween(Long value1, Long value2) {
            addCriterion("super_id not between", value1, value2, "superId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andSuperNameIsNull() {
            addCriterion("super_name is null");
            return (Criteria) this;
        }

        public Criteria andSuperNameIsNotNull() {
            addCriterion("super_name is not null");
            return (Criteria) this;
        }

        public Criteria andSuperNameEqualTo(String value) {
            addCriterion("super_name =", value, "superName");
            return (Criteria) this;
        }

        public Criteria andSuperNameNotEqualTo(String value) {
            addCriterion("super_name <>", value, "superName");
            return (Criteria) this;
        }

        public Criteria andSuperNameGreaterThan(String value) {
            addCriterion("super_name >", value, "superName");
            return (Criteria) this;
        }

        public Criteria andSuperNameGreaterThanOrEqualTo(String value) {
            addCriterion("super_name >=", value, "superName");
            return (Criteria) this;
        }

        public Criteria andSuperNameLessThan(String value) {
            addCriterion("super_name <", value, "superName");
            return (Criteria) this;
        }

        public Criteria andSuperNameLessThanOrEqualTo(String value) {
            addCriterion("super_name <=", value, "superName");
            return (Criteria) this;
        }

        public Criteria andSuperNameLike(String value) {
            addCriterion("super_name like", value, "superName");
            return (Criteria) this;
        }

        public Criteria andSuperNameNotLike(String value) {
            addCriterion("super_name not like", value, "superName");
            return (Criteria) this;
        }

        public Criteria andSuperNameIn(List<String> values) {
            addCriterion("super_name in", values, "superName");
            return (Criteria) this;
        }

        public Criteria andSuperNameNotIn(List<String> values) {
            addCriterion("super_name not in", values, "superName");
            return (Criteria) this;
        }

        public Criteria andSuperNameBetween(String value1, String value2) {
            addCriterion("super_name between", value1, value2, "superName");
            return (Criteria) this;
        }

        public Criteria andSuperNameNotBetween(String value1, String value2) {
            addCriterion("super_name not between", value1, value2, "superName");
            return (Criteria) this;
        }

        public Criteria andRewardAmtIsNull() {
            addCriterion("reward_amt is null");
            return (Criteria) this;
        }

        public Criteria andRewardAmtIsNotNull() {
            addCriterion("reward_amt is not null");
            return (Criteria) this;
        }

        public Criteria andRewardAmtEqualTo(Long value) {
            addCriterion("reward_amt =", value, "rewardAmt");
            return (Criteria) this;
        }

        public Criteria andRewardAmtNotEqualTo(Long value) {
            addCriterion("reward_amt <>", value, "rewardAmt");
            return (Criteria) this;
        }

        public Criteria andRewardAmtGreaterThan(Long value) {
            addCriterion("reward_amt >", value, "rewardAmt");
            return (Criteria) this;
        }

        public Criteria andRewardAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("reward_amt >=", value, "rewardAmt");
            return (Criteria) this;
        }

        public Criteria andRewardAmtLessThan(Long value) {
            addCriterion("reward_amt <", value, "rewardAmt");
            return (Criteria) this;
        }

        public Criteria andRewardAmtLessThanOrEqualTo(Long value) {
            addCriterion("reward_amt <=", value, "rewardAmt");
            return (Criteria) this;
        }

        public Criteria andRewardAmtIn(List<Long> values) {
            addCriterion("reward_amt in", values, "rewardAmt");
            return (Criteria) this;
        }

        public Criteria andRewardAmtNotIn(List<Long> values) {
            addCriterion("reward_amt not in", values, "rewardAmt");
            return (Criteria) this;
        }

        public Criteria andRewardAmtBetween(Long value1, Long value2) {
            addCriterion("reward_amt between", value1, value2, "rewardAmt");
            return (Criteria) this;
        }

        public Criteria andRewardAmtNotBetween(Long value1, Long value2) {
            addCriterion("reward_amt not between", value1, value2, "rewardAmt");
            return (Criteria) this;
        }

        public Criteria andSuperPositionIsNull() {
            addCriterion("super_position is null");
            return (Criteria) this;
        }

        public Criteria andSuperPositionIsNotNull() {
            addCriterion("super_position is not null");
            return (Criteria) this;
        }

        public Criteria andSuperPositionEqualTo(Byte value) {
            addCriterion("super_position =", value, "superPosition");
            return (Criteria) this;
        }

        public Criteria andSuperPositionNotEqualTo(Byte value) {
            addCriterion("super_position <>", value, "superPosition");
            return (Criteria) this;
        }

        public Criteria andSuperPositionGreaterThan(Byte value) {
            addCriterion("super_position >", value, "superPosition");
            return (Criteria) this;
        }

        public Criteria andSuperPositionGreaterThanOrEqualTo(Byte value) {
            addCriterion("super_position >=", value, "superPosition");
            return (Criteria) this;
        }

        public Criteria andSuperPositionLessThan(Byte value) {
            addCriterion("super_position <", value, "superPosition");
            return (Criteria) this;
        }

        public Criteria andSuperPositionLessThanOrEqualTo(Byte value) {
            addCriterion("super_position <=", value, "superPosition");
            return (Criteria) this;
        }

        public Criteria andSuperPositionIn(List<Byte> values) {
            addCriterion("super_position in", values, "superPosition");
            return (Criteria) this;
        }

        public Criteria andSuperPositionNotIn(List<Byte> values) {
            addCriterion("super_position not in", values, "superPosition");
            return (Criteria) this;
        }

        public Criteria andSuperPositionBetween(Byte value1, Byte value2) {
            addCriterion("super_position between", value1, value2, "superPosition");
            return (Criteria) this;
        }

        public Criteria andSuperPositionNotBetween(Byte value1, Byte value2) {
            addCriterion("super_position not between", value1, value2, "superPosition");
            return (Criteria) this;
        }

        public Criteria andSuperLevelNumIsNull() {
            addCriterion("super_level_num is null");
            return (Criteria) this;
        }

        public Criteria andSuperLevelNumIsNotNull() {
            addCriterion("super_level_num is not null");
            return (Criteria) this;
        }

        public Criteria andSuperLevelNumEqualTo(Integer value) {
            addCriterion("super_level_num =", value, "superLevelNum");
            return (Criteria) this;
        }

        public Criteria andSuperLevelNumNotEqualTo(Integer value) {
            addCriterion("super_level_num <>", value, "superLevelNum");
            return (Criteria) this;
        }

        public Criteria andSuperLevelNumGreaterThan(Integer value) {
            addCriterion("super_level_num >", value, "superLevelNum");
            return (Criteria) this;
        }

        public Criteria andSuperLevelNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("super_level_num >=", value, "superLevelNum");
            return (Criteria) this;
        }

        public Criteria andSuperLevelNumLessThan(Integer value) {
            addCriterion("super_level_num <", value, "superLevelNum");
            return (Criteria) this;
        }

        public Criteria andSuperLevelNumLessThanOrEqualTo(Integer value) {
            addCriterion("super_level_num <=", value, "superLevelNum");
            return (Criteria) this;
        }

        public Criteria andSuperLevelNumIn(List<Integer> values) {
            addCriterion("super_level_num in", values, "superLevelNum");
            return (Criteria) this;
        }

        public Criteria andSuperLevelNumNotIn(List<Integer> values) {
            addCriterion("super_level_num not in", values, "superLevelNum");
            return (Criteria) this;
        }

        public Criteria andSuperLevelNumBetween(Integer value1, Integer value2) {
            addCriterion("super_level_num between", value1, value2, "superLevelNum");
            return (Criteria) this;
        }

        public Criteria andSuperLevelNumNotBetween(Integer value1, Integer value2) {
            addCriterion("super_level_num not between", value1, value2, "superLevelNum");
            return (Criteria) this;
        }

        public Criteria andRewardStatusIsNull() {
            addCriterion("reward_status is null");
            return (Criteria) this;
        }

        public Criteria andRewardStatusIsNotNull() {
            addCriterion("reward_status is not null");
            return (Criteria) this;
        }

        public Criteria andRewardStatusEqualTo(String value) {
            addCriterion("reward_status =", value, "rewardStatus");
            return (Criteria) this;
        }

        public Criteria andRewardStatusNotEqualTo(String value) {
            addCriterion("reward_status <>", value, "rewardStatus");
            return (Criteria) this;
        }

        public Criteria andRewardStatusGreaterThan(String value) {
            addCriterion("reward_status >", value, "rewardStatus");
            return (Criteria) this;
        }

        public Criteria andRewardStatusGreaterThanOrEqualTo(String value) {
            addCriterion("reward_status >=", value, "rewardStatus");
            return (Criteria) this;
        }

        public Criteria andRewardStatusLessThan(String value) {
            addCriterion("reward_status <", value, "rewardStatus");
            return (Criteria) this;
        }

        public Criteria andRewardStatusLessThanOrEqualTo(String value) {
            addCriterion("reward_status <=", value, "rewardStatus");
            return (Criteria) this;
        }

        public Criteria andRewardStatusLike(String value) {
            addCriterion("reward_status like", value, "rewardStatus");
            return (Criteria) this;
        }

        public Criteria andRewardStatusNotLike(String value) {
            addCriterion("reward_status not like", value, "rewardStatus");
            return (Criteria) this;
        }

        public Criteria andRewardStatusIn(List<String> values) {
            addCriterion("reward_status in", values, "rewardStatus");
            return (Criteria) this;
        }

        public Criteria andRewardStatusNotIn(List<String> values) {
            addCriterion("reward_status not in", values, "rewardStatus");
            return (Criteria) this;
        }

        public Criteria andRewardStatusBetween(String value1, String value2) {
            addCriterion("reward_status between", value1, value2, "rewardStatus");
            return (Criteria) this;
        }

        public Criteria andRewardStatusNotBetween(String value1, String value2) {
            addCriterion("reward_status not between", value1, value2, "rewardStatus");
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