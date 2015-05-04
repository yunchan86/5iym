package com.iyoumei.modeldriver;

public class UserSettingsMd extends BasicMd {
	private String userId;
	private String userId2;
	public String getUserId2() {
		return userId2;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserId2(String userId2) {
		this.userId2 = userId2;
	}
	private String switchType;
	private String isOpen;
	
	public String getSwitchType() {
		return switchType;
	}
	public void setSwitchType(String switchType) {
		this.switchType = switchType;
	}
	public String getIsOpen() {
		return isOpen;
	}
	public void setIsOpen(String isOpen) {
		this.isOpen = isOpen;
	}
}
