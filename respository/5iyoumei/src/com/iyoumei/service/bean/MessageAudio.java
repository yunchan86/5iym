package com.iyoumei.service.bean;

public class MessageAudio extends MessagePic {

	private String type = "audio" ;
	
	private long length ;

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
