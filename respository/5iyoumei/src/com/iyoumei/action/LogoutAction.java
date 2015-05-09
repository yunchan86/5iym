package com.iyoumei.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.modeldriver.LogoutMd;
import com.opensymphony.xwork2.ModelDriven;

public class LogoutAction extends ParentAction implements ModelDriven<LogoutMd> {
	private static final long serialVersionUID = -4199343522755766525L;
	private static Log logger = LogFactory.getLog(RegisterAction.class);

	private LogoutMd md = new LogoutMd();

	@Override
	public String execute() {
		return null;
	}

	@Override
	public LogoutMd getModel() {
		return md;
	}
}
