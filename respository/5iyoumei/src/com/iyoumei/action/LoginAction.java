package com.iyoumei.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.LoginBean;
import com.iyoumei.entity.UserSigDomain;
import com.iyoumei.modeldriver.RegisterMd;
import com.iyoumei.service.ILoginService;
import com.iyoumei.service.IUserSigService;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;

public class LoginAction extends ParentAction implements ModelDriven<RegisterMd> {

	private static final long serialVersionUID = -5424893111768791388L;
	private static Log logger = LogFactory.getLog(LoginAction.class);
	private ILoginService loginService;

	private IUserSigService userSigService;
	RegisterMd md = new RegisterMd();

	@Override
	public String execute() {
		// 验证参数是否合法
		if (md.getMobileNumber() == null || md.getPwd() == null || "".equals(md.getMobileNumber())
				|| "".equals(md.getPwd())) {
			UtilMethods.responseMessage(request,response,"参数错误");
			return null;
		}
		LoginBean bean = null;
		try {
			bean = loginService.login(md.getMobileNumber(), md.getPwd());
			if (RespCode.SUCCESS.getCode().equals(bean.getCode())) {
				UserSigDomain userSigOnLogin = userSigService.getUserSigOnLogin(bean.getUserId(), md.getUuid(),
						md.getCallType());
				bean.setSig(userSigOnLogin.getSig());
				bean.setHxPwd(userSigOnLogin.getHxPwd());
			}
		} catch (Exception e) {
			logger.error("", e);
			bean = new LoginBean();
			bean.setCode(RespCode.ERROR.getCode());
		}
		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "LoginAction");
		xs.alias("result", LoginBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request,response,xs.toXML(bean), md.getReturnType());
		return null;
	}

	@Override
	public RegisterMd getModel() {
		return md;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

	public void setUserSigService(IUserSigService userSigService) {
		this.userSigService = userSigService;
	}

}
