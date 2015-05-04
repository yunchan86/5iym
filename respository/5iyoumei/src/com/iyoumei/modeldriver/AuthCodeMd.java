package com.iyoumei.modeldriver;

public class AuthCodeMd extends BasicMd {
	private String mobileNumber;// 手机号
	private String pwd;// 密码
	private String authCode;// 手机验证码
	private int type;// 验证码类型(0：注册(默认）；1：忘记登录密码)

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getAuthCode() {
		return authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
