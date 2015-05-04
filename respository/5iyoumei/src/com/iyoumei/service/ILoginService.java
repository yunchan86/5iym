package com.iyoumei.service;

import com.iyoumei.bean.LoginBean;

public interface ILoginService {
	/**
	 * 登录
	 * @param mobileNumber
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public LoginBean login(String mobileNumber,String pwd) throws Exception;
}
