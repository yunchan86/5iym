package com.iyoumei.util.enumcollection;

/**
 * 评论类型
 * 
 * @author Jeff
 * 
 */
public enum ReplyType {
	like(0, "点赞"), reply(1, "回复");
	private int type;
	private String msg;

	private ReplyType(int type, String msg) {
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
