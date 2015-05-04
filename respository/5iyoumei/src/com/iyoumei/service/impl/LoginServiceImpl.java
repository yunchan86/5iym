package com.iyoumei.service.impl;

import javax.annotation.Resource;

import com.iyoumei.bean.LoginBean;
import com.iyoumei.domain.UserInfoDomain;
import com.iyoumei.persistence.UserInfoMapper;
import com.iyoumei.service.ILoginService;
import com.iyoumei.util.enumcollection.RespCode;
import com.iyoumei.util.enumcollection.UserStatus;

public class LoginServiceImpl implements ILoginService {
	@Resource(type = UserInfoMapper.class)
	private UserInfoMapper userInfoMapper ; 

	@Override
	public LoginBean login(String mobileNumber, String pwd) throws Exception {
		LoginBean bean = new LoginBean();
		try {
			UserInfoDomain userInfoDomain = userInfoMapper.selectByMobileNumber(mobileNumber);
			if (userInfoDomain == null || !pwd.equalsIgnoreCase(userInfoDomain.getPassword())) {// 账户不存在或密码错误
				bean.setCode(RespCode.USERNAME_OR_PWD_ERROR.getCode());
			} else {
				if (UserStatus.frozen.getCode() == userInfoDomain.getStatus())
					bean.setCode(RespCode.ACCOUNT_FROZEN.getCode());
				else if (UserStatus.locked.getCode() == userInfoDomain.getStatus())
					bean.setCode(RespCode.ACCOUNT_LOCKED.getCode());
				else
					bean.setCode(RespCode.SUCCESS.getCode());
				bean.setUserId(userInfoDomain.getUserId());
				bean.setUserIcon(userInfoDomain.getUserIcon());
				bean.setNickname(userInfoDomain.getNickname());
			}
		} catch(Exception e) {
			bean.setCode(RespCode.ERROR.getCode());
		}

		return bean;
	}

	public UserInfoMapper getUserInfoMapper() {
		return userInfoMapper;
	}

	public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
		this.userInfoMapper = userInfoMapper;
	}
	
	

}
