package com.iyoumei.bean;


public class SameCarUserBean {
	private String userId;// 用户唯一标识，uuid_short形式，在内部系统中全局标识一个唯一用户；
	private String nickname;// 用户昵称
	private String gender;// 用户性别，0-未指定 1-女 2-男
	private String userIcon;// 用户头像，存放在public目录下

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

}
