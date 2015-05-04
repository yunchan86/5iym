package com.iyoumei.modeldriver;

public class InviteMd extends BasicMd {
	private String sourceUser;//发起添加好友动作的源用户
	private String targetUser;//添加好友动作的目标用户
	private String message;//好友添加是的验证消息
	private String channel;//添加好友的渠道 00–通过账号或昵称;01–通过附近的人   
	public String getSourceUser() {
		return sourceUser;
	}
	public void setSourceUser(String sourceUser) {
		this.sourceUser = sourceUser;
	}
	public String getTargetUser() {
		return targetUser;
	}
	public void setTargetUser(String targetUser) {
		this.targetUser = targetUser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String toParamsString() {
		StringBuffer sb = new StringBuffer() ;
		sb.append(this.toBasicParamString()+",source_user="+this.sourceUser+",target_user="+this.targetUser+",message="+message) ;
		return sb.toString() ;
	}
}
