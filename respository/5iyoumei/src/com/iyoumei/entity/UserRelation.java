package com.iyoumei.entity;

import java.util.Date;

public class UserRelation extends UserRelationKey {
    private String userName;

    private String superName;

    private Byte superPosition;

    private Integer superLevelNum;

    private String status;

    private Date insertTime;

    private Date updateTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName == null ? null : superName.trim();
    }

    public Byte getSuperPosition() {
        return superPosition;
    }

    public void setSuperPosition(Byte superPosition) {
        this.superPosition = superPosition;
    }

    public Integer getSuperLevelNum() {
        return superLevelNum;
    }

    public void setSuperLevelNum(Integer superLevelNum) {
        this.superLevelNum = superLevelNum;
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