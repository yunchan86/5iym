package com.iyoumei.domain;

import java.io.Serializable;

public class UserPositionDomain    implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long userId ;
	private double xpos ;
	private double ypos ;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
