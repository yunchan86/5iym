package com.iyoumei.bean;

import com.iyoumei.domain.UserFriendDomain;

public class UserFriendMapBean extends UserFriendBean{
	private double xpos ;
	private double ypos ;
	
	public UserFriendMapBean(){}
	public UserFriendMapBean(UserFriendDomain userFriend){
		super(userFriend) ;
		if(userFriend.getUserPosition()!=null) {
			this.xpos = userFriend.getUserPosition().getXpos() ;
			this.ypos = userFriend.getUserPosition().getYpos() ;
		}
	}
	
	public double getXpos() {
		return xpos;
	}
	public void setXpos(double xpos) {
		this.xpos = xpos;
	}
	public double getYpos() {
		return ypos;
	}
	public void setYpos(double ypos) {
		this.ypos = ypos;
	}
	
	
}
