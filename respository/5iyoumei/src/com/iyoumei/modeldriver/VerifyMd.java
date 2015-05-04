package com.iyoumei.modeldriver;

public class VerifyMd extends BasicMd {
	private String sourceUser;//发起添加好友动作的源用户
	private String targetUser;//添加好友动作的目标用户
	private String authStatus;//添加好友时的验证状态 
	
	public VerifyMd() {}
	public VerifyMd(InviteMd im) {
		this.sourceUser = im.getSourceUser() ;
		this.targetUser = im.getTargetUser() ;
		this.setAppV(im.getAppV());
		this.setCallType(im.getCallType());
		this.setReturnType(im.getReturnType());
		this.setSign(im.getSign());
		this.setUuid(im.getUuid());
		this.setV(im.getV());
	}
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
	public String getAuthStatus() {
		return authStatus;
	}
	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}
}
