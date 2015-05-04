package com.iyoumei.bean;

public class ChatMessageBean {

	private String fromUserId ;
	private String toUserId ;
	private String fromHxUserId ;
	private String toHxUserId ;
	private String msg ;
	private byte[] pic ;
	private byte[] voice ;
	public String getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(String fromUserId) {
		this.fromUserId = fromUserId;
	}
	public String getToUserId() {
		return toUserId;
	}
	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	public String getFromHxUserId() {
		return fromHxUserId;
	}
	public void setFromHxUserId(String fromHxUserId) {
		this.fromHxUserId = fromHxUserId;
	}
	public String getToHxUserId() {
		return toHxUserId;
	}
	public void setToHxUserId(String toHxUserId) {
		this.toHxUserId = toHxUserId;
	}
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public byte[] getPic() {
		return pic;
	}
	public void setPic(byte[] pic) {
		this.pic = pic;
	}
	public byte[] getVoice() {
		return voice;
	}
	public void setVoice(byte[] voice) {
		this.voice = voice;
	}
	
	
}
