package com.iyoumei.gearman.client;

public class ClientJobReturn {

	private String code = "-1" ;//返回的代码，0-成功，非0-失败
	private String info = "未知错误" ;//调用gearman的说明：如成功或失败明细
	private String data ;//调用gearman后返回的值
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String toString() {
		return "[code="+this.code+"][info="+this.info+"][data="+this.data+"]" ;
	}
}
