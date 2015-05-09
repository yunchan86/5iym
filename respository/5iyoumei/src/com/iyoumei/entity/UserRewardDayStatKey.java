package com.iyoumei.entity;

import java.util.Date;

public class UserRewardDayStatKey {
    private Date statDate;

    private Long userId;

    public Date getStatDate() {
        return statDate;
    }

    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}