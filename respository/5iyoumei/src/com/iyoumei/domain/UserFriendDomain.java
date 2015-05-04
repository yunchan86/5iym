package com.iyoumei.domain;

import java.io.Serializable;

public class UserFriendDomain  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8011482694714275385L;
	
	private UserRelationsDomain userRelation ;
	
	private UserInfoDomain userInfo ;
	
	private UserInfoHXDomain userInfoHX ;
	
	private UserPositionDomain userPosition ;

	public UserRelationsDomain getUserRelation() {
		return userRelation;
	}

	public void setUserRelation(UserRelationsDomain userRelation) {
		this.userRelation = userRelation;
	}

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

	public UserPositionDomain getUserPosition() {
		return userPosition;
	}

	public void setUserPosition(UserPositionDomain userPosition) {
		this.userPosition = userPosition;
	}
	
	
	

}
