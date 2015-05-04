package com.iyoumei.domain;

import java.util.Date;

public class UserInviteDomain {
	private long inviteId ;
	private String invitingUserId;//邀请用户ID
	private String invitedUserId;//被邀请用户ID
	private String source;//邀请来源：00–通过账号或昵称;01–通过附近的人 
	private String status;//好友状态：00-已经是好友；01-等待加入；02-已经拒绝；
	private String message;//验证消息
	private Date linkTime;

	private Date applyTime;
	public String getInvitingUserId() {
		return invitingUserId;
	}
	public void setInvitingUserId(String invitingUserId) {
		this.invitingUserId = invitingUserId;
	}
	public String getInvitedUserId() {
		return invitedUserId;
	}
	public void setInvitedUserId(String invitedUserId) {
		this.invitedUserId = invitedUserId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public long getInviteId() {
		return inviteId;
	}
	public void setInviteId(long inviteId) {
		this.inviteId = inviteId;
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
	
	
}
