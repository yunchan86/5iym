package com.iyoumei.bean;

import com.fasterxml.jackson.databind.node.ObjectNode;

public class GroupInfoBean {

	private ObjectNode hxData ;
	private long groupId ;
	private long createUserId ;
	private int groupStatus ;
	private String groupName ;
	private String groupDesc ;
	private int maxNum ;
	public ObjectNode getHxData() {
		return hxData;
	}
	public void setHxData(ObjectNode hxData) {
		this.hxData = hxData;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public long getCreateUserId() {
		return createUserId;
	}
	public void setCreateUserId(long createUserId) {
		this.createUserId = createUserId;
	}
	public int getGroupStatus() {
		return groupStatus;
	}
	public void setGroupStatus(int groupStatus) {
		this.groupStatus = groupStatus;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDesc() {
		return groupDesc;
	}
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
	public int getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	
	
	
}
