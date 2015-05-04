package com.iyoumei.action;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.CodeMsgBean;
import com.iyoumei.modeldriver.RegisterMd;
import com.iyoumei.service.IAuthCodeService;
import com.iyoumei.service.IUserInfoService;
import com.iyoumei.util.Constant;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;

/**
 * 忘记密码
 * 
 * @author Jeff
 * 
 */
public class ForgetPwdAction extends ParentAction implements ModelDriven<RegisterMd> {
	private static final long serialVersionUID = -1971240413131206930L;
	private Log logger = LogFactory.getLog(ForgetPwdAction.class);
	private IAuthCodeService authCodeService;
	private IUserInfoService userInfoService;
	private RegisterMd md = new RegisterMd();

	/**
	 * 修改密码
	 */
	public String modifyPwd() {

		CodeMsgBean bean = null;

		try {
			// 验证参数是否合法
			if (StringUtils.isEmpty(md.getMobileNumber()) || StringUtils.isEmpty(md.getPwd())
					|| StringUtils.isEmpty(md.getAuthCode())) {
				UtilMethods.responseMessage(request, response, "参数错误");
				return null;
			}
			CodeMsgBean vBean = authCodeService.validateAuthCode(md.getMobileNumber(), md.getAuthCode(),
					Constant.PHONE_AUTHCODE_LOGINPWD_MODULEID, md.getCallType(), UtilMethods.getIpAddr(request));
			if( RespCode.SUCCESS.getCode().equals(vBean.getCode())){//验证码正确
				bean=userInfoService.modifyPwdByForget(md.getMobileNumber(), md.getPwd());
			}else
				bean=vBean;
		} catch (Exception e) {
			logger.error("", e);
			bean = new CodeMsgBean();
			bean.setCode(RespCode.ERROR.getCode());
			bean.setMsg("系统繁忙，请稍后再试");
		}

		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "ForgetPwdAction");
		xs.alias("result", CodeMsgBean.class);
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	@Override
	public RegisterMd getModel() {
		return md;
	}

	public void setAuthCodeService(IAuthCodeService authCodeService) {
		this.authCodeService = authCodeService;
	}

	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

}
