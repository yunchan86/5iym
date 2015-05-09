package com.iyoumei.entity;

import java.util.Date;

public class UserRewardRule extends UserRewardRuleKey {
    private String ruleName;

    private Integer maxLevel;

    private Short timeCycle;

    private Long limitMaxAmt;

    private Long unitAmt;

    private String status;

    private Date insertTime;

    private Date updateTime;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    public Integer getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(Integer maxLevel) {
        this.maxLevel = maxLevel;
    }

    public Short getTimeCycle() {
        return timeCycle;
    }

    public void setTimeCycle(Short timeCycle) {
        this.timeCycle = timeCycle;
    }

    public Long getLimitMaxAmt() {
        return limitMaxAmt;
    }

    public void setLimitMaxAmt(Long limitMaxAmt) {
        this.limitMaxAmt = limitMaxAmt;
    }

    public Long getUnitAmt() {
        return unitAmt;
    }

    public void setUnitAmt(Long unitAmt) {
        this.unitAmt = unitAmt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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