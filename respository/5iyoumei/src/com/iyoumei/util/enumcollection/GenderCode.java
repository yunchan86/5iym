package com.iyoumei.util.enumcollection;

/**
 * 性别
 * 
 * @author Jeff
 * 
 */
public enum GenderCode {

	unkonw("0", "未知"), female("1", "女"), male("2", "男");
	private String code;
	private String msg;

	private GenderCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
