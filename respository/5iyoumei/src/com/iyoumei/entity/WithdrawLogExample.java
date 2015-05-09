package com.iyoumei.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WithdrawLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WithdrawLogExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserIdIsNull() {
            addCriterion("withdraw_user_id is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserIdIsNotNull() {
            addCriterion("withdraw_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserIdEqualTo(Long value) {
            addCriterion("withdraw_user_id =", value, "withdrawUserId");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserIdNotEqualTo(Long value) {
            addCriterion("withdraw_user_id <>", value, "withdrawUserId");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserIdGreaterThan(Long value) {
            addCriterion("withdraw_user_id >", value, "withdrawUserId");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("withdraw_user_id >=", value, "withdrawUserId");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserIdLessThan(Long value) {
            addCriterion("withdraw_user_id <", value, "withdrawUserId");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserIdLessThanOrEqualTo(Long value) {
            addCriterion("withdraw_user_id <=", value, "withdrawUserId");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserIdIn(List<Long> values) {
            addCriterion("withdraw_user_id in", values, "withdrawUserId");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserIdNotIn(List<Long> values) {
            addCriterion("withdraw_user_id not in", values, "withdrawUserId");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserIdBetween(Long value1, Long value2) {
            addCriterion("withdraw_user_id between", value1, value2, "withdrawUserId");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserIdNotBetween(Long value1, Long value2) {
            addCriterion("withdraw_user_id not between", value1, value2, "withdrawUserId");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserNameIsNull() {
            addCriterion("withdraw_user_name is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserNameIsNotNull() {
            addCriterion("withdraw_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserNameEqualTo(String value) {
            addCriterion("withdraw_user_name =", value, "withdrawUserName");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserNameNotEqualTo(String value) {
            addCriterion("withdraw_user_name <>", value, "withdrawUserName");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserNameGreaterThan(String value) {
            addCriterion("withdraw_user_name >", value, "withdrawUserName");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_user_name >=", value, "withdrawUserName");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserNameLessThan(String value) {
            addCriterion("withdraw_user_name <", value, "withdrawUserName");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserNameLessThanOrEqualTo(String value) {
            addCriterion("withdraw_user_name <=", value, "withdrawUserName");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserNameLike(String value) {
            addCriterion("withdraw_user_name like", value, "withdrawUserName");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserNameNotLike(String value) {
            addCriterion("withdraw_user_name not like", value, "withdrawUserName");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserNameIn(List<String> values) {
            addCriterion("withdraw_user_name in", values, "withdrawUserName");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserNameNotIn(List<String> values) {
            addCriterion("withdraw_user_name not in", values, "withdrawUserName");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserNameBetween(String value1, String value2) {
            addCriterion("withdraw_user_name between", value1, value2, "withdrawUserName");
            return (Criteria) this;
        }

        public Criteria andWithdrawUserNameNotBetween(String value1, String value2) {
            addCriterion("withdraw_user_name not between", value1, value2, "withdrawUserName");
            return (Criteria) this;
        }

        public Criteria andWithdrawTrueNameIsNull() {
            addCriterion("withdraw_true_name is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawTrueNameIsNotNull() {
            addCriterion("withdraw_true_name is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawTrueNameEqualTo(String value) {
            addCriterion("withdraw_true_name =", value, "withdrawTrueName");
            return (Criteria) this;
        }

        public Criteria andWithdrawTrueNameNotEqualTo(String value) {
            addCriterion("withdraw_true_name <>", value, "withdrawTrueName");
            return (Criteria) this;
        }

        public Criteria andWithdrawTrueNameGreaterThan(String value) {
            addCriterion("withdraw_true_name >", value, "withdrawTrueName");
            return (Criteria) this;
        }

        public Criteria andWithdrawTrueNameGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_true_name >=", value, "withdrawTrueName");
            return (Criteria) this;
        }

        public Criteria andWithdrawTrueNameLessThan(String value) {
            addCriterion("withdraw_true_name <", value, "withdrawTrueName");
            return (Criteria) this;
        }

        public Criteria andWithdrawTrueNameLessThanOrEqualTo(String value) {
            addCriterion("withdraw_true_name <=", value, "withdrawTrueName");
            return (Criteria) this;
        }

        public Criteria andWithdrawTrueNameLike(String value) {
            addCriterion("withdraw_true_name like", value, "withdrawTrueName");
            return (Criteria) this;
        }

        public Criteria andWithdrawTrueNameNotLike(String value) {
            addCriterion("withdraw_true_name not like", value, "withdrawTrueName");
            return (Criteria) this;
        }

        public Criteria andWithdrawTrueNameIn(List<String> values) {
            addCriterion("withdraw_true_name in", values, "withdrawTrueName");
            return (Criteria) this;
        }

        public Criteria andWithdrawTrueNameNotIn(List<String> values) {
            addCriterion("withdraw_true_name not in", values, "withdrawTrueName");
            return (Criteria) this;
        }

        public Criteria andWithdrawTrueNameBetween(String value1, String value2) {
            addCriterion("withdraw_true_name between", value1, value2, "withdrawTrueName");
            return (Criteria) this;
        }

        public Criteria andWithdrawTrueNameNotBetween(String value1, String value2) {
            addCriterion("withdraw_true_name not between", value1, value2, "withdrawTrueName");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountIdIsNull() {
            addCriterion("withdraw_account_id is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountIdIsNotNull() {
            addCriterion("withdraw_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountIdEqualTo(String value) {
            addCriterion("withdraw_account_id =", value, "withdrawAccountId");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountIdNotEqualTo(String value) {
            addCriterion("withdraw_account_id <>", value, "withdrawAccountId");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountIdGreaterThan(String value) {
            addCriterion("withdraw_account_id >", value, "withdrawAccountId");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_account_id >=", value, "withdrawAccountId");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountIdLessThan(String value) {
            addCriterion("withdraw_account_id <", value, "withdrawAccountId");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountIdLessThanOrEqualTo(String value) {
            addCriterion("withdraw_account_id <=", value, "withdrawAccountId");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountIdLike(String value) {
            addCriterion("withdraw_account_id like", value, "withdrawAccountId");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountIdNotLike(String value) {
            addCriterion("withdraw_account_id not like", value, "withdrawAccountId");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountIdIn(List<String> values) {
            addCriterion("withdraw_account_id in", values, "withdrawAccountId");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountIdNotIn(List<String> values) {
            addCriterion("withdraw_account_id not in", values, "withdrawAccountId");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountIdBetween(String value1, String value2) {
            addCriterion("withdraw_account_id between", value1, value2, "withdrawAccountId");
            return (Criteria) this;
        }

        public Criteria andWithdrawAccountIdNotBetween(String value1, String value2) {
            addCriterion("withdraw_account_id not between", value1, value2, "withdrawAccountId");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeIsNull() {
            addCriterion("withdraw_type is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeIsNotNull() {
            addCriterion("withdraw_type is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeEqualTo(String value) {
            addCriterion("withdraw_type =", value, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeNotEqualTo(String value) {
            addCriterion("withdraw_type <>", value, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeGreaterThan(String value) {
            addCriterion("withdraw_type >", value, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeGreaterThanOrEqualTo(String value) {
            addCriterion("withdraw_type >=", value, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeLessThan(String value) {
            addCriterion("withdraw_type <", value, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeLessThanOrEqualTo(String value) {
            addCriterion("withdraw_type <=", value, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeLike(String value) {
            addCriterion("withdraw_type like", value, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeNotLike(String value) {
            addCriterion("withdraw_type not like", value, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeIn(List<String> values) {
            addCriterion("withdraw_type in", values, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeNotIn(List<String> values) {
            addCriterion("withdraw_type not in", values, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeBetween(String value1, String value2) {
            addCriterion("withdraw_type between", value1, value2, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawTypeNotBetween(String value1, String value2) {
            addCriterion("withdraw_type not between", value1, value2, "withdrawType");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmtIsNull() {
            addCriterion("withdraw_amt is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmtIsNotNull() {
            addCriterion("withdraw_amt is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmtEqualTo(Long value) {
            addCriterion("withdraw_amt =", value, "withdrawAmt");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmtNotEqualTo(Long value) {
            addCriterion("withdraw_amt <>", value, "withdrawAmt");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmtGreaterThan(Long value) {
            addCriterion("withdraw_amt >", value, "withdrawAmt");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("withdraw_amt >=", value, "withdrawAmt");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmtLessThan(Long value) {
            addCriterion("withdraw_amt <", value, "withdrawAmt");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmtLessThanOrEqualTo(Long value) {
            addCriterion("withdraw_amt <=", value, "withdrawAmt");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmtIn(List<Long> values) {
            addCriterion("withdraw_amt in", values, "withdrawAmt");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmtNotIn(List<Long> values) {
            addCriterion("withdraw_amt not in", values, "withdrawAmt");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmtBetween(Long value1, Long value2) {
            addCriterion("withdraw_amt between", value1, value2, "withdrawAmt");
            return (Criteria) this;
        }

        public Criteria andWithdrawAmtNotBetween(Long value1, Long value2) {
            addCriterion("withdraw_amt not between", value1, value2, "withdrawAmt");
            return (Criteria) this;
        }

        public Criteria andPayTrueNameIsNull() {
            addCriterion("pay_true_name is null");
            return (Criteria) this;
        }

        public Criteria andPayTrueNameIsNotNull() {
            addCriterion("pay_true_name is not null");
            return (Criteria) this;
        }

        public Criteria andPayTrueNameEqualTo(String value) {
            addCriterion("pay_true_name =", value, "payTrueName");
            return (Criteria) this;
        }

        public Criteria andPayTrueNameNotEqualTo(String value) {
            addCriterion("pay_true_name <>", value, "payTrueName");
            return (Criteria) this;
        }

        public Criteria andPayTrueNameGreaterThan(String value) {
            addCriterion("pay_true_name >", value, "payTrueName");
            return (Criteria) this;
        }

        public Criteria andPayTrueNameGreaterThanOrEqualTo(String value) {
            addCriterion("pay_true_name >=", value, "payTrueName");
            return (Criteria) this;
        }

        public Criteria andPayTrueNameLessThan(String value) {
            addCriterion("pay_true_name <", value, "payTrueName");
            return (Criteria) this;
        }

        public Criteria andPayTrueNameLessThanOrEqualTo(String value) {
            addCriterion("pay_true_name <=", value, "payTrueName");
            return (Criteria) this;
        }

        public Criteria andPayTrueNameLike(String value) {
            addCriterion("pay_true_name like", value, "payTrueName");
            return (Criteria) this;
        }

        public Criteria andPayTrueNameNotLike(String value) {
            addCriterion("pay_true_name not like", value, "payTrueName");
            return (Criteria) this;
        }

        public Criteria andPayTrueNameIn(List<String> values) {
            addCriterion("pay_true_name in", values, "payTrueName");
            return (Criteria) this;
        }

        public Criteria andPayTrueNameNotIn(List<String> values) {
            addCriterion("pay_true_name not in", values, "payTrueName");
            return (Criteria) this;
        }

        public Criteria andPayTrueNameBetween(String value1, String value2) {
            addCriterion("pay_true_name between", value1, value2, "payTrueName");
            return (Criteria) this;
        }

        public Criteria andPayTrueNameNotBetween(String value1, String value2) {
            addCriterion("pay_true_name not between", value1, value2, "payTrueName");
            return (Criteria) this;
        }

        public Criteria andPayAccountIdIsNull() {
            addCriterion("pay_account_id is null");
            return (Criteria) this;
        }

        public Criteria andPayAccountIdIsNotNull() {
            addCriterion("pay_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayAccountIdEqualTo(String value) {
            addCriterion("pay_account_id =", value, "payAccountId");
            return (Criteria) this;
        }

        public Criteria andPayAccountIdNotEqualTo(String value) {
            addCriterion("pay_account_id <>", value, "payAccountId");
            return (Criteria) this;
        }

        public Criteria andPayAccountIdGreaterThan(String value) {
            addCriterion("pay_account_id >", value, "payAccountId");
            return (Criteria) this;
        }

        public Criteria andPayAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("pay_account_id >=", value, "payAccountId");
            return (Criteria) this;
        }

        public Criteria andPayAccountIdLessThan(String value) {
            addCriterion("pay_account_id <", value, "payAccountId");
            return (Criteria) this;
        }

        public Criteria andPayAccountIdLessThanOrEqualTo(String value) {
            addCriterion("pay_account_id <=", value, "payAccountId");
            return (Criteria) this;
        }

        public Criteria andPayAccountIdLike(String value) {
            addCriterion("pay_account_id like", value, "payAccountId");
            return (Criteria) this;
        }

        public Criteria andPayAccountIdNotLike(String value) {
            addCriterion("pay_account_id not like", value, "payAccountId");
            return (Criteria) this;
        }

        public Criteria andPayAccountIdIn(List<String> values) {
            addCriterion("pay_account_id in", values, "payAccountId");
            return (Criteria) this;
        }

        public Criteria andPayAccountIdNotIn(List<String> values) {
            addCriterion("pay_account_id not in", values, "payAccountId");
            return (Criteria) this;
        }

        public Criteria andPayAccountIdBetween(String value1, String value2) {
            addCriterion("pay_account_id between", value1, value2, "payAccountId");
            return (Criteria) this;
        }

        public Criteria andPayAccountIdNotBetween(String value1, String value2) {
            addCriterion("pay_account_id not between", value1, value2, "payAccountId");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("pay_type is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("pay_type is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("pay_type =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("pay_type <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("pay_type >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pay_type >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("pay_type <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("pay_type <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("pay_type like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("pay_type not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("pay_type in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("pay_type not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("pay_type between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("pay_type not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayAmtIsNull() {
            addCriterion("pay_amt is null");
            return (Criteria) this;
        }

        public Criteria andPayAmtIsNotNull() {
            addCriterion("pay_amt is not null");
            return (Criteria) this;
        }

        public Criteria andPayAmtEqualTo(Long value) {
            addCriterion("pay_amt =", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtNotEqualTo(Long value) {
            addCriterion("pay_amt <>", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtGreaterThan(Long value) {
            addCriterion("pay_amt >", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_amt >=", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtLessThan(Long value) {
            addCriterion("pay_amt <", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtLessThanOrEqualTo(Long value) {
            addCriterion("pay_amt <=", value, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtIn(List<Long> values) {
            addCriterion("pay_amt in", values, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtNotIn(List<Long> values) {
            addCriterion("pay_amt not in", values, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtBetween(Long value1, Long value2) {
            addCriterion("pay_amt between", value1, value2, "payAmt");
            return (Criteria) this;
        }

        public Criteria andPayAmtNotBetween(Long value1, Long value2) {
            addCriterion("pay_amt not between", value1, value2, "payAmt");
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