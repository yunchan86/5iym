package com.iyoumei.util;

public class Constant {
	/**
	 * 系统编码
	 */
	public final static String CHARSET = "UTF-8";

	/**
	 * 发送验证码（注册）
	 */
	public static final String PHONE_AUTHCODE_REG_MODULEID = "20000001";
	/**
	 * 发送验证码（忘记登录密码）
	 */
	public static final String PHONE_AUTHCODE_LOGINPWD_MODULEID = "20000002";
	/**
	 * 无需登录的接口验证签名使用的密钥
	 */
	public static final String noLoginSig = "luyou";
	/**
	 * 锁定账户前，密码连续错误次数
	 */
	public static final int pwdErrorTimes = 5;
	/**
	 * 账户被锁定时长
	 */
	public static final int accountLockMinutes = 30;
	/**
	 * 找回支付密码前，密保问题可连续输入次数
	 */
	public static final int protectPwdError = 3;
	/**
	 * 密保问题错误被锁定时长
	 */
	public static final int protectQuestionLockMinutes = 30;
}
