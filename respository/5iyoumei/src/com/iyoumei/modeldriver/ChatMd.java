package com.iyoumei.modeldriver;

public class ChatMd extends BasicMd {

	private String from ;
	private String to ;
	private String msg ;
	private String action ;
	private String ext ;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String toKeyString() {
		StringBuffer sb = new StringBuffer() ;
		sb.append("from_id="+this.from+",to_id="+this.to) ;
		return sb.toString() ;
	}
	
	public String toParamsString() {
		StringBuffer sb = new StringBuffer() ;
		sb.append(this.toBasicParamString()+this.toKeyString()+",msg="+this.msg+",action="+this.action) ;
		return sb.toString() ;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	
}
