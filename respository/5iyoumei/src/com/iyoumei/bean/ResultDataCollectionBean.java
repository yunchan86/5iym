package com.iyoumei.bean;

import java.util.Collection;

public class ResultDataCollectionBean<T> {

	private String code;
	private String msg;
	private Collection<T> data;

	public void setMsgCode(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public void setMsgCodeData(String code, String msg, Collection<T> data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
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

	public Collection<T> getData() {
		return data;
	}

	public void setData(Collection<T> data) {
		this.data = data;
	}

}
