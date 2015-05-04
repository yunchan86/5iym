package com.iyoumei.service;

import com.iyoumei.bean.LoginBean;
import com.iyoumei.modeldriver.RegisterMd;

public interface IRegisterService {
	/**
	 * 验证手机号是否已经注册
	 * @param mobileNumber
	 * @return
	 * @throws Exception
	 */
	public boolean isMobileRegister(String mobileNumber) throws Exception;
	/**
	 * 注册
	 * @param md
	 * @return
	 * @throws Exception
	 */
	public LoginBean register(RegisterMd md) throws Exception;
}
