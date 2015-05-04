package com.iyoumei.domain;

import java.util.List;

public class GroupMemberDomain {
	
	private long userId ;

	private UserGroupInfoDomain userGroupInfo ;
	
	private List<GroupMemberInfoDomain> memberList ;

	public UserGroupInfoDomain getUserGroupInfo() {
		return userGroupInfo;
	}

	public void setUserGroupInfo(UserGroupInfoDomain userGroupInfo) {
		this.userGroupInfo = userGroupInfo;
	}

	public List<GroupMemberInfoDomain> getMemberList() {
		return memberList;
	}

	public void setMemberList(List<GroupMemberInfoDomain> memberList) {
		this.memberList = memberList;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	
	
	
}
