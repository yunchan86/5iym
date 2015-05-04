package com.iyoumei.util.enumcollection;

/**
 * 用户状态
 * 
 * @author Jeff
 * 
 */
public enum UserStatus {
	common(0, "正常"), locked(1, "锁定"), frozen(2, "冻结");
	private int code;
	private String msg;

	private UserStatus(int code, String msg) {
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
