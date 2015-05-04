package com.iyoumei.domain;

import java.util.List;

public class UserFullInfoDomain {

	private UserInfoDomain userInfo ;
	
	private UserInfoHXDomain userInfoHX ;
	
	private List<UserGroupInfoDomain> userGroupInfoList ;

	public UserInfoDomain getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfoDomain userInfo) {
		this.userInfo = userInfo;
	}

	public UserInfoHXDomain getUserInfoHX() {
		return userInfoHX;
	}

	public void setUserInfoHX(UserInfoHXDomain userInfoHX) {
		this.userInfoHX = userInfoHX;
	}

	public List<UserGroupInfoDomain> getUserGroupInfoList() {
		return userGroupInfoList;
	}

	public void setUserGroupInfoList(List<UserGroupInfoDomain> userGroupInfoList) {
		this.userGroupInfoList = userGroupInfoList;
	}
	
	
	
}
