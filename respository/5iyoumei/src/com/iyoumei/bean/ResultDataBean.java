package com.iyoumei.bean;

public class ResultDataBean<T> {

	private String code ;
	private String msg ;
	private T data ;
	
	public void setMsgCode(String code,String msg) {
		this.code = code ;
		this.msg = msg ;
	}
	
	public void setMsgCodeData(String code,String msg,T data) {
		this.code = code ;
		this.msg = msg ;
		this.data = data ;
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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
