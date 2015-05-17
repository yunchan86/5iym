package com.iyoumei.bean;

import com.iyoumei.util.enumcollection.CommonCode;

public class BasicCodeMsgBean {

	private String code = CommonCode.DEFAULT.getCode() ;
	private String msg = CommonCode.DEFAULT.getMsg() ;
	
	public BasicCodeMsgBean(){}
	public BasicCodeMsgBean(String code,String msg) {
		this.code = code ;
		this.msg = msg ;
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
	
	
}
