package com.iyoumei.domain;

public class UserEvaluateHistoryDomain {

	private long userId ;
	private long evaUserId ;
	private int evaType ;
	private String insertTime ;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getEvaUserId() {
		return evaUserId;
	}
	public void setEvaUserId(long evaUserId) {
		this.evaUserId = evaUserId;
	}
	public int getEvaType() {
		return evaType;
	}
	public void setEvaType(int evaType) {
		this.evaType = evaType;
	}
	public String getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}
	
	
}
