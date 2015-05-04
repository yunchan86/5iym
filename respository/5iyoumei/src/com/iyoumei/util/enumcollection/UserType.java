package com.iyoumei.util.enumcollection;

/**
 * 用户类型
 * 
 * @author Jeff
 * 
 */
public enum UserType {
	common(0, "普通用户"), employee(1, "商户员工"), provider(2, "商户");
	private int type;
	private String msg;

	private UserType(int type, String msg) {
		this.type = type;
		this.msg = msg;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
