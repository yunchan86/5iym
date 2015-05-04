package com.iyoumei.action;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.CodeMsgBean;
import com.iyoumei.modeldriver.AuthCodeMd;
import com.iyoumei.service.IAuthCodeService;
import com.iyoumei.service.IRegisterService;
import com.iyoumei.util.Constant;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;

/**
 * 验证码发送和验证接口
 * 
 * @author Jeff
 * 
 */
public class PhoneAuthCodeAction extends ParentAction implements ModelDriven<AuthCodeMd> {
	private static final long serialVersionUID = 5620640896007684132L;

	private Log logger = LogFactory.getLog(PhoneAuthCodeAction.class);
	private AuthCodeMd md = new AuthCodeMd();

	private IAuthCodeService authCodeService;
	private IRegisterService registerService;

	/**
	 * 发送验证码
	 * 
	 * @return
	 */
	public String sendAuthCode() {
		// 验证参数是否合法
		if (StringUtils.isEmpty(md.getMobileNumber())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		CodeMsgBean bean = new CodeMsgBean();
		try {
			if (UtilMethods.validatePhoneNumFormat(md.getMobileNumber())) {
				boolean phoneNumExist = registerService.isMobileRegister(md.getMobileNumber());

				if (phoneNumExist && md.getType() == 0) { // 注册：手机号已经注册
					bean.setCode(RespCode.MOBILE_REGISTED.getCode());
					bean.setMsg("手机号已经注册");
				} else if (!phoneNumExist && md.getType() == 1) {// 忘记密码：手机号未注册
					bean.setCode(RespCode.MOBILE_NOREGISTER.getCode());
					bean.setMsg("账户不存在");
				} else {
					String moduleId = md.getType() == 0 ? Constant.PHONE_AUTHCODE_REG_MODULEID
							: Constant.PHONE_AUTHCODE_LOGINPWD_MODULEID;// 20000001:注册;20000002:忘记密码
					bean = authCodeService.sendAuthCode(md.getMobileNumber(), moduleId, md.getCallType(),
							UtilMethods.getIpAddr(request));
				}
			} else {
				bean.setCode(RespCode.MOBILE_FORMAT_ERROR.getCode());
				bean.setMsg("请输入正确的手机号");
			}

		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
			bean.setMsg("系统错误");
		}
		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "PhoneAuthCodeAction", "sendAuthCode");
		xs.alias("result", CodeMsgBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 验证验证码
	 * 
	 * @return
	 */
	public String validateAuthCode() {
		// 验证参数是否合法
		if (StringUtils.isEmpty(md.getMobileNumber()) || StringUtils.isEmpty(md.getAuthCode())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}

		CodeMsgBean bean = null;
		try {
			String moduleId = md.getType() == 0 ? "20000001" : "20000002";// 20000001:注册;20000002:忘记密码
			bean = authCodeService.validateAuthCode(md.getMobileNumber(), md.getAuthCode(), moduleId, md.getCallType(),
					UtilMethods.getIpAddr(request));
		} catch (Exception e) {
			logger.error("", e);
			bean = new CodeMsgBean();
			bean.setCode(RespCode.ERROR.getCode());
			bean.setMsg("系统错误");
		}
		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "PhoneAuthCodeAction", "validateAuthCode");
		xs.alias("result", CodeMsgBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;

	}

	@Override
	public AuthCodeMd getModel() {
		return md;
	}

	public void setAuthCodeService(IAuthCodeService authCodeService) {
		this.authCodeService = authCodeService;
	}

	public void setRegisterService(IRegisterService registerService) {
		this.registerService = registerService;
	}

}
