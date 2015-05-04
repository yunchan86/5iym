package com.iyoumei.util.enumcollection;

public enum BusinessCode {

	/**
	 * 群成员的处理
	 */
	GROUP_MEMBER_NORMAL("0","普通会员"),GROUP_MEMBER_OWNER("1","群主"),GROUP_MEMBER_MANAGER("2","管理员");
	
	private String code;
	private String msg;
	private BusinessCode(String code, String msg) {
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
