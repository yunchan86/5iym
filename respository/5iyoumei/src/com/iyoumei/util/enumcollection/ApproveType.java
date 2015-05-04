package com.iyoumei.util.enumcollection;

/**
 * 加好友类型
 * 
 * @author Jeff
 * 
 */
public enum ApproveType {
	validate(0, "需要验证"), open(1, "任何人可加"), forbidden(2, "不允许加");
	private int type;
	private String msg;

	private ApproveType(int type, String msg) {
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
