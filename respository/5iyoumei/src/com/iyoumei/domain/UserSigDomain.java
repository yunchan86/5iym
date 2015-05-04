package com.iyoumei.domain;

import java.io.Serializable;
import java.util.Date;

public class UserSigDomain implements Serializable {

	private static final long serialVersionUID = 8689058942919322496L;
	private String id;
	private String user_id;// 用户唯一ID
	private String sig;// 密钥
	private Date insert_time;// 密钥创建时间
	private String uuid;// 客户端唯一标识
	private String terminal_type;// 终端类型
	private String status;// 登录状态，0-未登录，1-已登录
	private String device_token;
	private String baidu_uuid;
	private String hxPwd;

	public String getHxPwd() {
		return hxPwd;
	}

	public void setHxPwd(String hxPwd) {
		this.hxPwd = hxPwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getSig() {
		return sig;
	}

	public void setSig(String sig) {
		this.sig = sig;
	}

	public Date getInsert_time() {
		return insert_time;
	}

	public void setInsert_time(Date insert_time) {
		this.insert_time = insert_time;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getTerminal_type() {
		return terminal_type;
	}

	public void setTerminal_type(String terminal_type) {
		this.terminal_type = terminal_type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDevice_token() {
		return device_token;
	}

	public void setDevice_token(String device_token) {
		this.device_token = device_token;
	}

	public String getBaidu_uuid() {
		return baidu_uuid;
	}

	public void setBaidu_uuid(String baidu_uuid) {
		this.baidu_uuid = baidu_uuid;
	}

}
