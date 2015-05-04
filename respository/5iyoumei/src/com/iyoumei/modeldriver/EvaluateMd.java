package com.iyoumei.modeldriver;

public class EvaluateMd extends BasicMd {
	private String userId;
	private String evaType;
	private String evaUserId ;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEvaType() {
		return evaType;
	}
	public void setEvaType(String evaType) {
		this.evaType = evaType;
	}
	
	public String toKeyString() {
		StringBuffer sb = new StringBuffer() ;
		sb.append("user_id="+this.userId) ;
		return sb.toString() ;
	}
	
	public String toParamsString() {
		StringBuffer sb = new StringBuffer() ;
		sb.append(this.toBasicParamString()+this.toKeyString()+",eva_type="+this.evaType) ;
		return sb.toString() ;
	}
	public String getEvaUserId() {
		return evaUserId;
	}
	public void setEvaUserId(String evaUserId) {
		this.evaUserId = evaUserId;
	}
	
	
}
