package com.iyoumei.bean;

public class CommonServiceResult<T> extends BasicCodeMsgBean {

	public CommonServiceResult(){}
	public CommonServiceResult(String code,String msg,T data) {
		this.setCode(code) ;
		this.setMsg(msg);
		this.data = data ;
	}
	
	public void setResult(String code,String msg,T data) {
		this.setCode(code) ;
		this.setMsg(msg);
		this.data = data ;
	}
	
	private T data ;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
	
}
