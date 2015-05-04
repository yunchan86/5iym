package com.iyoumei.domain;

public class UserEvaluateDomain {

	private long userId ;
	private int praiseTimes ;
	private int stampTimes ;
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
