package com.iyoumei.domain;

public class GroupMemberInfoDomain {

	private long groupId ;
	private long userId ;
	private String hxUUID ;
    private String hxUsername ;
    private String tag ;
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getHxUUID() {
		return hxUUID;
	}
	public void setHxUUID(String hxUUID) {
		this.hxUUID = hxUUID;
	}
	public String getHxUsername() {
		return hxUsername;
	}
	public void setHxUsername(String hxUsername) {
		this.hxUsername = hxUsername;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
    
}
