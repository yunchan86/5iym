package com.iyoumei.service.bean;

public class MessageText extends MessageType {

	private String type = "txt" ;
	
	private String msg ;
	
	public MessageText(){}
	public MessageText(String msg) {
		this.msg = msg ;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
