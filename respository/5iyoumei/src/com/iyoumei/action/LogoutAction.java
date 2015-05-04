package com.iyoumei.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.CodeMsgBean;
import com.iyoumei.modeldriver.LogoutMd;
import com.iyoumei.service.IUserSigService;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;

public class LogoutAction extends ParentAction implements ModelDriven<LogoutMd> {
	private static final long serialVersionUID = -4199343522755766525L;
	private static Log logger = LogFactory.getLog(RegisterAction.class);

	private IUserSigService userSigService;
	private LogoutMd md = new LogoutMd();

	@Override
	public String execute() {

		try {
			userSigService.updateUserSigOnLogout(md.getUserId(), md.getUuid(), md.getCallType());
		} catch (Exception e) {
			logger.error("系统错误", e);
		}
		CodeMsgBean bean = new CodeMsgBean();
		bean.setCode(RespCode.SUCCESS.getCode());
		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "LogoutAction");
		xs.alias("result", CodeMsgBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request,response,xs.toXML(bean), md.getReturnType());
		return null;
	}

	@Override
	public LogoutMd getModel() {
		return md;
	}

	public void setUserSigService(IUserSigService userSigService) {
		this.userSigService = userSigService;
	}

}
