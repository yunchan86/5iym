package com.iyoumei.bean;

import com.iyoumei.domain.UserEvaluateDomain;

public class UserEvaluateBean {
	private long userId ;
	private int praiseTimes ;
	private int stampTimes ;
	
	public UserEvaluateBean() {}
	public UserEvaluateBean(UserEvaluateDomain domain) {
		if(domain==null) return ;
		this.userId = domain.getUserId() ;
		this.praiseTimes = domain.getPraiseTimes() ;
		this.stampTimes = domain.getStampTimes() ;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public int getPraiseTimes() {
		return praiseTimes;
	}
	public void setPraiseTimes(int praiseTimes) {
		this.praiseTimes = praiseTimes;
	}
	public int getStampTimes() {
		return stampTimes;
	}
	public void setStampTimes(int stampTimes) {
		this.stampTimes = stampTimes;
	}
	
	
}
