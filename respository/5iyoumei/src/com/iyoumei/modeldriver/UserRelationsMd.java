package com.iyoumei.modeldriver;

public class UserRelationsMd extends BasicMd{
	private String userId ;
	private String friendUserId ;
	private String tag ;
	private String label ;
	private String regular ;
	private String viewCircle ;
	private String viewMap ;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFriendUserId() {
		return friendUserId;
	}
	public void setFriendUserId(String friendUserId) {
		this.friendUserId = friendUserId;
	}
	
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String toKeyString() {
		StringBuffer sb = new StringBuffer() ;
		sb.append("user_id="+this.userId+",friend_user_id="+this.friendUserId) ;
		return sb.toString() ;
	}
	
	public String toParamsString() {
		StringBuffer sb = new StringBuffer() ;
		sb.append(this.toBasicParamString()+",user_id="+this.userId+",friend_user_id="+this.friendUserId) ;
		return sb.toString() ;
	}
	public String getRegular() {
		return regular;
	}
	public void setRegular(String regular) {
		this.regular = regular;
	}
	public String getViewCircle() {
		return viewCircle;
	}
	public void setViewCircle(String viewCircle) {
		this.viewCircle = viewCircle;
	}
	public String getViewMap() {
		return viewMap;
	}
	public void setViewMap(String viewMap) {
		this.viewMap = viewMap;
	}
	
}
