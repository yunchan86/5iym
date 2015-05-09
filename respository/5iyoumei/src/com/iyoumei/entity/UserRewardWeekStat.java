package com.iyoumei.entity;

import java.util.Date;

public class UserRewardWeekStat extends UserRewardWeekStatKey {
    private Integer leftNum;

    private Integer rightNum;

    private Long zhituiAmt;

    private Long jiandianAmt;

    private Long duipengAmt;

    private Long taxAmt;

    private Date insertTime;

    private Date updateTime;

    public Integer getLeftNum() {
        return leftNum;
    }

    public void setLeftNum(Integer leftNum) {
        this.leftNum = leftNum;
    }

    public Integer getRightNum() {
        return rightNum;
    }

    public void setRightNum(Integer rightNum) {
        this.rightNum = rightNum;
    }

    public Long getZhituiAmt() {
        return zhituiAmt;
    }

    public void setZhituiAmt(Long zhituiAmt) {
        this.zhituiAmt = zhituiAmt;
    }

    public Long getJiandianAmt() {
        return jiandianAmt;
    }

    public void setJiandianAmt(Long jiandianAmt) {
        this.jiandianAmt = jiandianAmt;
    }

    public Long getDuipengAmt() {
        return duipengAmt;
    }

    public void setDuipengAmt(Long duipengAmt) {
        this.duipengAmt = duipengAmt;
    }

    public Long getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(Long taxAmt) {
        this.taxAmt = taxAmt;
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