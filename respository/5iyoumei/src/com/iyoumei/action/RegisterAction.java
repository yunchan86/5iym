package com.iyoumei.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.modeldriver.RegisterMd;
import com.opensymphony.xwork2.ModelDriven;

public class RegisterAction extends ParentAction implements ModelDriven<RegisterMd> {
	private static final long serialVersionUID = -4199343522755766525L;
	private static Log logger = LogFactory.getLog(RegisterAction.class);
	RegisterMd md = new RegisterMd();

	@Override
	public String execute() {
		return null;
	}

	@Override
	public RegisterMd getModel() {
		return md;
	}

}
