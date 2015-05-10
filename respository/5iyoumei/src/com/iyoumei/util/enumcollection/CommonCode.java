package com.iyoumei.util.enumcollection;

public enum CommonCode {

	/**
	 * 群成员的处理
	 */
	SUCCESS("0","成功"),
	ERROR("1","系统错误"),
	Exception("2","系统异常");
	
	private String code;
	private String msg;
	private CommonCode(String code, String msg) {
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
