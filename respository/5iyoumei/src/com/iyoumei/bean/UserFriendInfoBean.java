package com.iyoumei.bean;

import com.iyoumei.domain.UserFriendDomain;

public class UserFriendInfoBean extends UserFriendBean {
	private String icon ;
	private String signature ;
	
	public UserFriendInfoBean(){}
	public UserFriendInfoBean(UserFriendDomain userFriend){
		super(userFriend) ;
		this.icon = userFriend.getUserInfo().getUserIcon() ;
		this.signature = userFriend.getUserInfo().getSignature() ;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
	
}
