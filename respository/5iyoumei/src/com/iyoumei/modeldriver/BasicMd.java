package com.iyoumei.modeldriver;

public class BasicMd {
	private String callType;
	private String uuid;
	private String v;
	private String sign;
	private String returnType;
	private int appV;

	public int getAppV() {
		return appV;
	}

	public void setAppV(int appV) {
		this.appV = appV;
	}

	public String getCallType() {
		return callType;
	}

	public void setCallType(String callType) {
		this.callType = callType;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String toBasicParamString() {
		StringBuffer sb = new StringBuffer();
		sb.append("v=" + this.v + ",uuid=" + this.uuid + ",appV=" + this.appV + ",call_type=" + this.callType
				+ "return_type=" + this.returnType + ",sign=" + this.sign);
		return sb.toString();
	}
}
