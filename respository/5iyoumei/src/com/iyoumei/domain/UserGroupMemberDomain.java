package com.iyoumei.domain;

import java.io.Serializable;
import java.util.Date;

public class UserGroupMemberDomain  implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long groupId;

    private Long userId;

    private Long inviteUser;

    private Date joinTime;

    private Byte status;
    
    private int level = 0 ;

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

    public Long getInviteUser() {
        return inviteUser;
    }

    public void setInviteUser(Long inviteUser) {
        this.inviteUser = inviteUser;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
    
}