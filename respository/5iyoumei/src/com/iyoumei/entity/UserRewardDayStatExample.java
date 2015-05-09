package com.iyoumei.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserRewardDayStatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserRewardDayStatExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andStatDateIsNull() {
            addCriterion("stat_date is null");
            return (Criteria) this;
        }

        public Criteria andStatDateIsNotNull() {
            addCriterion("stat_date is not null");
            return (Criteria) this;
        }

        public Criteria andStatDateEqualTo(Date value) {
            addCriterionForJDBCDate("stat_date =", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("stat_date <>", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateGreaterThan(Date value) {
            addCriterionForJDBCDate("stat_date >", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stat_date >=", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateLessThan(Date value) {
            addCriterionForJDBCDate("stat_date <", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("stat_date <=", value, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateIn(List<Date> values) {
            addCriterionForJDBCDate("stat_date in", values, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("stat_date not in", values, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stat_date between", value1, value2, "statDate");
            return (Criteria) this;
        }

        public Criteria andStatDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("stat_date not between", value1, value2, "statDate");
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

        public Criteria andLeftNumIsNull() {
            addCriterion("left_num is null");
            return (Criteria) this;
        }

        public Criteria andLeftNumIsNotNull() {
            addCriterion("left_num is not null");
            return (Criteria) this;
        }

        public Criteria andLeftNumEqualTo(Integer value) {
            addCriterion("left_num =", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumNotEqualTo(Integer value) {
            addCriterion("left_num <>", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumGreaterThan(Integer value) {
            addCriterion("left_num >", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("left_num >=", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumLessThan(Integer value) {
            addCriterion("left_num <", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumLessThanOrEqualTo(Integer value) {
            addCriterion("left_num <=", value, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumIn(List<Integer> values) {
            addCriterion("left_num in", values, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumNotIn(List<Integer> values) {
            addCriterion("left_num not in", values, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumBetween(Integer value1, Integer value2) {
            addCriterion("left_num between", value1, value2, "leftNum");
            return (Criteria) this;
        }

        public Criteria andLeftNumNotBetween(Integer value1, Integer value2) {
            addCriterion("left_num not between", value1, value2, "leftNum");
            return (Criteria) this;
        }

        public Criteria andRightNumIsNull() {
            addCriterion("right_num is null");
            return (Criteria) this;
        }

        public Criteria andRightNumIsNotNull() {
            addCriterion("right_num is not null");
            return (Criteria) this;
        }

        public Criteria andRightNumEqualTo(Integer value) {
            addCriterion("right_num =", value, "rightNum");
            return (Criteria) this;
        }

        public Criteria andRightNumNotEqualTo(Integer value) {
            addCriterion("right_num <>", value, "rightNum");
            return (Criteria) this;
        }

        public Criteria andRightNumGreaterThan(Integer value) {
            addCriterion("right_num >", value, "rightNum");
            return (Criteria) this;
        }

        public Criteria andRightNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("right_num >=", value, "rightNum");
            return (Criteria) this;
        }

        public Criteria andRightNumLessThan(Integer value) {
            addCriterion("right_num <", value, "rightNum");
            return (Criteria) this;
        }

        public Criteria andRightNumLessThanOrEqualTo(Integer value) {
            addCriterion("right_num <=", value, "rightNum");
            return (Criteria) this;
        }

        public Criteria andRightNumIn(List<Integer> values) {
            addCriterion("right_num in", values, "rightNum");
            return (Criteria) this;
        }

        public Criteria andRightNumNotIn(List<Integer> values) {
            addCriterion("right_num not in", values, "rightNum");
            return (Criteria) this;
        }

        public Criteria andRightNumBetween(Integer value1, Integer value2) {
            addCriterion("right_num between", value1, value2, "rightNum");
            return (Criteria) this;
        }

        public Criteria andRightNumNotBetween(Integer value1, Integer value2) {
            addCriterion("right_num not between", value1, value2, "rightNum");
            return (Criteria) this;
        }

        public Criteria andZhituiAmtIsNull() {
            addCriterion("zhitui_amt is null");
            return (Criteria) this;
        }

        public Criteria andZhituiAmtIsNotNull() {
            addCriterion("zhitui_amt is not null");
            return (Criteria) this;
        }

        public Criteria andZhituiAmtEqualTo(Long value) {
            addCriterion("zhitui_amt =", value, "zhituiAmt");
            return (Criteria) this;
        }

        public Criteria andZhituiAmtNotEqualTo(Long value) {
            addCriterion("zhitui_amt <>", value, "zhituiAmt");
            return (Criteria) this;
        }

        public Criteria andZhituiAmtGreaterThan(Long value) {
            addCriterion("zhitui_amt >", value, "zhituiAmt");
            return (Criteria) this;
        }

        public Criteria andZhituiAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("zhitui_amt >=", value, "zhituiAmt");
            return (Criteria) this;
        }

        public Criteria andZhituiAmtLessThan(Long value) {
            addCriterion("zhitui_amt <", value, "zhituiAmt");
            return (Criteria) this;
        }

        public Criteria andZhituiAmtLessThanOrEqualTo(Long value) {
            addCriterion("zhitui_amt <=", value, "zhituiAmt");
            return (Criteria) this;
        }

        public Criteria andZhituiAmtIn(List<Long> values) {
            addCriterion("zhitui_amt in", values, "zhituiAmt");
            return (Criteria) this;
        }

        public Criteria andZhituiAmtNotIn(List<Long> values) {
            addCriterion("zhitui_amt not in", values, "zhituiAmt");
            return (Criteria) this;
        }

        public Criteria andZhituiAmtBetween(Long value1, Long value2) {
            addCriterion("zhitui_amt between", value1, value2, "zhituiAmt");
            return (Criteria) this;
        }

        public Criteria andZhituiAmtNotBetween(Long value1, Long value2) {
            addCriterion("zhitui_amt not between", value1, value2, "zhituiAmt");
            return (Criteria) this;
        }

        public Criteria andJiandianAmtIsNull() {
            addCriterion("jiandian_amt is null");
            return (Criteria) this;
        }

        public Criteria andJiandianAmtIsNotNull() {
            addCriterion("jiandian_amt is not null");
            return (Criteria) this;
        }

        public Criteria andJiandianAmtEqualTo(Long value) {
            addCriterion("jiandian_amt =", value, "jiandianAmt");
            return (Criteria) this;
        }

        public Criteria andJiandianAmtNotEqualTo(Long value) {
            addCriterion("jiandian_amt <>", value, "jiandianAmt");
            return (Criteria) this;
        }

        public Criteria andJiandianAmtGreaterThan(Long value) {
            addCriterion("jiandian_amt >", value, "jiandianAmt");
            return (Criteria) this;
        }

        public Criteria andJiandianAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("jiandian_amt >=", value, "jiandianAmt");
            return (Criteria) this;
        }

        public Criteria andJiandianAmtLessThan(Long value) {
            addCriterion("jiandian_amt <", value, "jiandianAmt");
            return (Criteria) this;
        }

        public Criteria andJiandianAmtLessThanOrEqualTo(Long value) {
            addCriterion("jiandian_amt <=", value, "jiandianAmt");
            return (Criteria) this;
        }

        public Criteria andJiandianAmtIn(List<Long> values) {
            addCriterion("jiandian_amt in", values, "jiandianAmt");
            return (Criteria) this;
        }

        public Criteria andJiandianAmtNotIn(List<Long> values) {
            addCriterion("jiandian_amt not in", values, "jiandianAmt");
            return (Criteria) this;
        }

        public Criteria andJiandianAmtBetween(Long value1, Long value2) {
            addCriterion("jiandian_amt between", value1, value2, "jiandianAmt");
            return (Criteria) this;
        }

        public Criteria andJiandianAmtNotBetween(Long value1, Long value2) {
            addCriterion("jiandian_amt not between", value1, value2, "jiandianAmt");
            return (Criteria) this;
        }

        public Criteria andDuipengAmtIsNull() {
            addCriterion("duipeng_amt is null");
            return (Criteria) this;
        }

        public Criteria andDuipengAmtIsNotNull() {
            addCriterion("duipeng_amt is not null");
            return (Criteria) this;
        }

        public Criteria andDuipengAmtEqualTo(Long value) {
            addCriterion("duipeng_amt =", value, "duipengAmt");
            return (Criteria) this;
        }

        public Criteria andDuipengAmtNotEqualTo(Long value) {
            addCriterion("duipeng_amt <>", value, "duipengAmt");
            return (Criteria) this;
        }

        public Criteria andDuipengAmtGreaterThan(Long value) {
            addCriterion("duipeng_amt >", value, "duipengAmt");
            return (Criteria) this;
        }

        public Criteria andDuipengAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("duipeng_amt >=", value, "duipengAmt");
            return (Criteria) this;
        }

        public Criteria andDuipengAmtLessThan(Long value) {
            addCriterion("duipeng_amt <", value, "duipengAmt");
            return (Criteria) this;
        }

        public Criteria andDuipengAmtLessThanOrEqualTo(Long value) {
            addCriterion("duipeng_amt <=", value, "duipengAmt");
            return (Criteria) this;
        }

        public Criteria andDuipengAmtIn(List<Long> values) {
            addCriterion("duipeng_amt in", values, "duipengAmt");
            return (Criteria) this;
        }

        public Criteria andDuipengAmtNotIn(List<Long> values) {
            addCriterion("duipeng_amt not in", values, "duipengAmt");
            return (Criteria) this;
        }

        public Criteria andDuipengAmtBetween(Long value1, Long value2) {
            addCriterion("duipeng_amt between", value1, value2, "duipengAmt");
            return (Criteria) this;
        }

        public Criteria andDuipengAmtNotBetween(Long value1, Long value2) {
            addCriterion("duipeng_amt not between", value1, value2, "duipengAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtIsNull() {
            addCriterion("tax_amt is null");
            return (Criteria) this;
        }

        public Criteria andTaxAmtIsNotNull() {
            addCriterion("tax_amt is not null");
            return (Criteria) this;
        }

        public Criteria andTaxAmtEqualTo(Long value) {
            addCriterion("tax_amt =", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtNotEqualTo(Long value) {
            addCriterion("tax_amt <>", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtGreaterThan(Long value) {
            addCriterion("tax_amt >", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("tax_amt >=", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtLessThan(Long value) {
            addCriterion("tax_amt <", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtLessThanOrEqualTo(Long value) {
            addCriterion("tax_amt <=", value, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtIn(List<Long> values) {
            addCriterion("tax_amt in", values, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtNotIn(List<Long> values) {
            addCriterion("tax_amt not in", values, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtBetween(Long value1, Long value2) {
            addCriterion("tax_amt between", value1, value2, "taxAmt");
            return (Criteria) this;
        }

        public Criteria andTaxAmtNotBetween(Long value1, Long value2) {
            addCriterion("tax_amt not between", value1, value2, "taxAmt");
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