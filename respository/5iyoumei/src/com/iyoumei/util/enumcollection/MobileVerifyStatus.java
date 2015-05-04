package com.iyoumei.util.enumcollection;

/**
 * 手机号验证状态
 * 
 * @author Jeff
 * 
 */
public enum MobileVerifyStatus {

	unverified(0, "未验证"), verify(1, "验证");
	private int code;
	private String msg;

	private MobileVerifyStatus(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
