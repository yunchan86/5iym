package com.iyoumei.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.modeldriver.RegisterMd;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ParentAction  implements ModelDriven<RegisterMd> {

	private static final long serialVersionUID = -5424893111768791388L;
	private static Log logger = LogFactory.getLog(LoginAction.class);
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
