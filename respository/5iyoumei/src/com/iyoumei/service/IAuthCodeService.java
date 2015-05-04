package com.iyoumei.service;

import com.iyoumei.bean.CodeMsgBean;

public interface IAuthCodeService {
	/**
	 * 发送验证码
	 * 
	 * @param phoneNumber
	 *            手机号
	 * @param moduleId
	 *            发送短息ID
	 * @param callType
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public CodeMsgBean sendAuthCode(String phoneNumber, String moduleId, String callType, String ip) throws Exception;

	/**
	 * 验证验证码
	 * 
	 * @param phoneNumber
	 *            手机号
	 * @param authCode
	 *            验证码
	 * @param moduleId
	 *            发送短信ID
	 * @param callType
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	public CodeMsgBean validateAuthCode(String phoneNumber, String authCode, String moduleId, String callType, String ip)
			throws Exception;

}
