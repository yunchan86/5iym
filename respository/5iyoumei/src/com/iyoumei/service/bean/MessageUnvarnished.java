package com.iyoumei.service.bean;

public class MessageUnvarnished extends MessageType {

	private String type = "cmd" ;
	
	private String action ;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
