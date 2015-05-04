package com.iyoumei.gearman.client.util;

public class GearmanCode {

	private String code ;
	private String msg ;
	private Exception exception ;
	
	public GearmanCode(String code,String msg,Exception exception) {
		this.code = code ;
		this.msg = msg ;
		this.exception = exception ;
	}
	
	public void setGearmanCode(String code,String msg,Exception exception) {
		this.code = code ;
		this.msg = msg ;
		this.exception = exception ;
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

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	public String toDataString() {
		StringBuffer sb = new StringBuffer() ;
		sb.append(this.code + " ") ;
		sb.append(this.msg + " ") ;
		if(exception!=null) sb.append(exception.getMessage()) ;
		return sb.toString() ;
	}
}
