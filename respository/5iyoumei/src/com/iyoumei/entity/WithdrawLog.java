package com.iyoumei.entity;

import java.util.Date;

public class WithdrawLog {
    private String orderId;

    private Long withdrawUserId;

    private String withdrawUserName;

    private String withdrawTrueName;

    private String withdrawAccountId;

    private String withdrawType;

    private Long withdrawAmt;

    private String payTrueName;

    private String payAccountId;

    private String payType;

    private Long payAmt;

    private Date insertTime;

    private Date updateTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Long getWithdrawUserId() {
        return withdrawUserId;
    }

    public void setWithdrawUserId(Long withdrawUserId) {
        this.withdrawUserId = withdrawUserId;
    }

    public String getWithdrawUserName() {
        return withdrawUserName;
    }

    public void setWithdrawUserName(String withdrawUserName) {
        this.withdrawUserName = withdrawUserName == null ? null : withdrawUserName.trim();
    }

    public String getWithdrawTrueName() {
        return withdrawTrueName;
    }

    public void setWithdrawTrueName(String withdrawTrueName) {
        this.withdrawTrueName = withdrawTrueName == null ? null : withdrawTrueName.trim();
    }

    public String getWithdrawAccountId() {
        return withdrawAccountId;
    }

    public void setWithdrawAccountId(String withdrawAccountId) {
        this.withdrawAccountId = withdrawAccountId == null ? null : withdrawAccountId.trim();
    }

    public String getWithdrawType() {
        return withdrawType;
    }

    public void setWithdrawType(String withdrawType) {
        this.withdrawType = withdrawType == null ? null : withdrawType.trim();
    }

    public Long getWithdrawAmt() {
        return withdrawAmt;
    }

    public void setWithdrawAmt(Long withdrawAmt) {
        this.withdrawAmt = withdrawAmt;
    }

    public String getPayTrueName() {
        return payTrueName;
    }

    public void setPayTrueName(String payTrueName) {
        this.payTrueName = payTrueName == null ? null : payTrueName.trim();
    }

    public String getPayAccountId() {
        return payAccountId;
    }

    public void setPayAccountId(String payAccountId) {
        this.payAccountId = payAccountId == null ? null : payAccountId.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public Long getPayAmt() {
        return payAmt;
    }

    public void setPayAmt(Long payAmt) {
        this.payAmt = payAmt;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}