package com.iyoumei.bean;

import com.iyoumei.domain.UserFriendDomain;

public class UserFriendBean {

	private String selfUserId ;
	private String userId ;
	private String nickname ;
	private String hxuserId ;
	private String hxnickname ;
	private String label ;
	private String tag ;
	private String icon ;
	private String signature ;
	
	public UserFriendBean(){}
	public UserFriendBean(UserFriendDomain userFriend){
		this.selfUserId = String.valueOf(userFriend.getUserRelation().getUserId1()) ;
		this.userId = String.valueOf(userFriend.getUserRelation().getUserId2()) ;
		this.nickname = userFriend.getUserInfo().getNickname() ;
		this.hxuserId = userFriend.getUserInfoHX().getHxUUID() ;
		this.hxnickname=userFriend.getUserInfoHX().getHxUsername() ;
		this.label = userFriend.getUserRelation().getLabel() ;
		this.tag = userFriend.getUserRelation().getTag() ;
		this.icon = userFriend.getUserInfo().getUserIcon() ;
		this.signature = userFriend.getUserInfo().getSignature();
	}
	
	public String getSelfUserId() {
		return selfUserId;
	}
	public void setSelfUserId(String selfUserId) {
		this.selfUserId = selfUserId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHxuserId() {
		return hxuserId;
	}
	public void setHxuserId(String hxuserId) {
		this.hxuserId = hxuserId;
	}
	public String getHxnickname() {
		return hxnickname;
	}
	public void setHxnickname(String hxnickname) {
		this.hxnickname = hxnickname;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
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
