package com.iyoumei.action;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.ServiceResultBean;
import com.iyoumei.entity.UserInfo;
import com.iyoumei.modeldriver.LoginMd;
import com.iyoumei.service.ILoginService;
import com.iyoumei.util.enumcollection.IResMsg;
import com.opensymphony.xwork2.ModelDriven;

public class LoginAction extends ParentAction  implements ModelDriven<LoginMd> {

	private static final long serialVersionUID = -5424893111768791388L;
	private static Log logger = LogFactory.getLog(LoginAction.class);
	@Resource(type = ILoginService.class)
	private ILoginService loginService ;
	private LoginMd md = new LoginMd(); 

	@Override
	public String execute() {
		ServiceResultBean<UserInfo, IResMsg> _result = loginService.selectUserInfo(md) ;
		
		return _result.getResult() ;
	}

	
	public LoginMd getModel() {
		return md;
	}

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

}
