package com.iyoumei.service.impl;

import com.iyoumei.bean.CodeMsgBean;
import com.iyoumei.bean.PhoneAuthCodeReturnBean;
import com.iyoumei.service.IAuthCodeService;
import com.iyoumei.util.PhoneAuthCodeUtil;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.enumcollection.RespCode;

public class AuthCodeServiceImpl implements IAuthCodeService {

	@Override
	public CodeMsgBean sendAuthCode(String phoneNumber, String moduleId, String callType, String ip) throws Exception {
		CodeMsgBean bean = new CodeMsgBean();

		PhoneAuthCodeUtil.sendEmsAuthCode(moduleId, phoneNumber, callType, ip);
		bean.setCode(RespCode.SUCCESS.getCode());
		bean.setMsg("发送成功");

		return bean;
	}

	@Override
	public CodeMsgBean validateAuthCode(String phoneNumber, String authCode, String moduleId, String callType, String ip)
			throws Exception {
		CodeMsgBean bean = new CodeMsgBean();

		if (phoneNumber != null) {
			if (UtilMethods.validatePhoneNumFormat(phoneNumber)) {
				PhoneAuthCodeReturnBean pacBean = PhoneAuthCodeUtil.validateEmsAuthCode(moduleId, phoneNumber, authCode, callType, ip);
				if ("00".equals(pacBean.getReturnCode())||"02".equals(pacBean.getReturnCode())) {
					bean.setCode(RespCode.SUCCESS.getCode());
					bean.setMsg("验证成功");
				} else {
					bean.setCode(RespCode.AUTH_CODE_ERROR.getCode());
					bean.setMsg("验证码错误");
				}
			} else {
				bean.setCode(RespCode.MOBILE_FORMAT_ERROR.getCode());
				bean.setMsg("手机号错误");
			}
		}
		return bean;
	}

}
