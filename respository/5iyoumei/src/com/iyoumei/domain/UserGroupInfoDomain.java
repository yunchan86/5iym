package com.iyoumei.domain;

import java.io.Serializable;
import java.util.Date;

public class UserGroupInfoDomain  implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long groupId;

    private Long userId;

    private Date createTime;

    private String comments;

    private Integer userNum;

    private Byte groupStatus;
    
    private String groupName ;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public Byte getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(Byte groupStatus) {
        this.groupStatus = groupStatus;
    }

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
    
    
}