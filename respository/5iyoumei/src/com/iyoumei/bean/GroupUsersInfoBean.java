package com.iyoumei.bean;

import java.util.List;

public class GroupUsersInfoBean {

	private long ownerId ;
	private long selfId ;
	private long groupId ;
	private int groupStatus ;
	private String groupName ;
	private String groupDesc ;
	
	private List<GroupMemberSimpleInfoBean> members ;

	public long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	public long getSelfId() {
		return selfId;
	}

	public void setSelfId(long selfId) {
		this.selfId = selfId;
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
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

	public List<GroupMemberSimpleInfoBean> getMembers() {
		return members;
	}

	public void setMembers(List<GroupMemberSimpleInfoBean> members) {
		this.members = members;
	}
	
	
}
