package com.iyoumei.action;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iyoumei.bean.CodeMsgBean;
import com.iyoumei.bean.LoginBean;
import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.domain.UserInfoDomain;
import com.iyoumei.domain.UserSigDomain;
import com.iyoumei.modeldriver.RegisterMd;
import com.iyoumei.service.IAuthCodeService;
import com.iyoumei.service.IFriendService;
import com.iyoumei.service.IRegisterService;
import com.iyoumei.service.IUserSigService;
import com.iyoumei.util.Constant;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;

public class RegisterAction extends ParentAction implements ModelDriven<RegisterMd> {
	private static final long serialVersionUID = -4199343522755766525L;
	private static Log logger = LogFactory.getLog(RegisterAction.class);
	private IRegisterService registerService;
	private IFriendService friendService;

	private IUserSigService userSigService;
	private IAuthCodeService authCodeService;
	RegisterMd md = new RegisterMd();

	@Override
	public String execute() {

		// 验证参数是否合法
		if (StringUtils.isEmpty(md.getMobileNumber()) || StringUtils.isEmpty(md.getPwd())
				|| StringUtils.isEmpty(md.getAuthCode())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		LoginBean bean = null;
		// 验证手机号格式是否正确
		if (!UtilMethods.validatePhoneNumFormat(md.getMobileNumber())) {
			bean = new LoginBean();
			bean.setCode(RespCode.MOBILE_FORMAT_ERROR.getCode());
		} else {
			// 验证手机号是否可用
			try {
				CodeMsgBean validateAuthCode = authCodeService.validateAuthCode(md.getMobileNumber(), md.getAuthCode(),
						Constant.PHONE_AUTHCODE_REG_MODULEID, md.getCallType(), UtilMethods.getIpAddr(request));
				if (!RespCode.SUCCESS.getCode().equals(validateAuthCode.getCode())) {// 验证码无效
					bean = new LoginBean();
					bean.setCode(validateAuthCode.getCode());
					bean.setMsg(validateAuthCode.getMsg());
				} else if (registerService.isMobileRegister(md.getMobileNumber())) {
					bean = new LoginBean();
					bean = registerService.register(md);
					bean.setCode(RespCode.MOBILE_REGISTED.getCode());
				} else {// 注册
					bean = registerService.register(md);
					if (RespCode.SUCCESS.getCode().equals(bean.getCode())) {
						UserSigDomain userSigOnLogin = userSigService.getUserSigOnLogin(bean.getUserId(), md.getUuid(),
								md.getCallType());
						bean.setSig(userSigOnLogin.getSig());
						/*
						 * UserInfoDomain userInfoDomain = new UserInfoDomain();
						 * userInfoDomain.setUserId(bean.getUserId());
						 * userInfoDomain.setName(bean.getUserId());
						 * userInfoDomain
						 * .setPassword(md.getPwd().toLowerCase());
						 * ResultDataBean<ObjectNode> resultData =
						 * this.friendService.singleReg(userInfoDomain); if
						 * ("00".equals(resultData.getCode())) { String
						 * hxPassword =
						 * resultData.getData().get("password").textValue();
						 * bean.setHxPwd(hxPassword); }
						 */
					}

				}
				UserInfoDomain userInfoDomain = new UserInfoDomain();
				userInfoDomain.setUserId(bean.getUserId());
				userInfoDomain.setName(bean.getUserId());
				userInfoDomain.setPassword(md.getPwd().toLowerCase());
				ResultDataBean<ObjectNode> resultData = this.friendService.singleReg(userInfoDomain);
				if ("00".equals(resultData.getCode())) {
					String hxPassword = resultData.getData().get("password").textValue();
					bean.setHxPwd(hxPassword);
				}
				if (bean.getCode().equals(RespCode.MOBILE_REGISTED.getCode())) {
					bean.setUserId(null);
					bean.setHxPwd(null);
				}
			} catch (Exception e) {
				logger.error("", e);
				bean = new LoginBean();
				bean.setCode(RespCode.ERROR.getCode());
			}
		}
		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "registerAction");
		xs.alias("result", LoginBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	@Override
	public RegisterMd getModel() {
		return md;
	}

	public void setRegisterService(IRegisterService registerService) {
		this.registerService = registerService;
	}

	public void setUserSigService(IUserSigService userSigService) {
		this.userSigService = userSigService;
	}

	public void setFriendService(IFriendService friendService) {
		this.friendService = friendService;
	}

}
