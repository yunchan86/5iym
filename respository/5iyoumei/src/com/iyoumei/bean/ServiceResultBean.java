package com.iyoumei.bean;

import com.iyoumei.util.enumcollection.IResMsg;

public class ServiceResultBean<T, M extends IResMsg> {

	private M resMsg ;
	private T data ;
	private String result;
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public M getResMsg() {
		return resMsg;
	}
	
	public void setResMsg(M resMsg) {
		this.resMsg = resMsg;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
