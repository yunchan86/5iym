package com.iyoumei.entity;

public class UserRewardWeekStatKey {
    private String statWeek;

    private Long userId;

    private Integer weekNum;

    public String getStatWeek() {
        return statWeek;
    }

    public void setStatWeek(String statWeek) {
        this.statWeek = statWeek == null ? null : statWeek.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(Integer weekNum) {
        this.weekNum = weekNum;
    }
}