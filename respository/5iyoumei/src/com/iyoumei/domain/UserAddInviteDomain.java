package com.iyoumei.domain;

import java.io.Serializable;
import java.util.Date;

public class UserAddInviteDomain implements Serializable {
	private static final long serialVersionUID = 2573724279488405585L;
	
	private Long inviteId ;

	private Long invitingUserId;

	private Long invitedUserId;

	private String source;

	private String status;

	private Date linkTime;

	private Date applyTime;

	private String message;

	public Long getInvitingUserId() {
		return invitingUserId;
	}

	public void setInvitingUserId(Long invitingUserId) {
		this.invitingUserId = invitingUserId;
	}

	public Long getInvitedUserId() {
		return invitedUserId;
	}

	public void setInvitedUserId(Long invitedUserId) {
		this.invitedUserId = invitedUserId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source == null ? null : source.trim();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	public Date getLinkTime() {
		return linkTime;
	}

	public void setLinkTime(Date linkTime) {
		this.linkTime = linkTime;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message == null ? null : message.trim();
	}

	public Long getInviteId() {
		return inviteId;
	}

	public void setInviteId(Long inviteId) {
		this.inviteId = inviteId;
	}
	
	
}