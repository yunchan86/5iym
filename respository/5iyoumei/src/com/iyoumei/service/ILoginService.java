package com.iyoumei.service;

import com.iyoumei.bean.ServiceResultBean;
import com.iyoumei.entity.UserInfo;
import com.iyoumei.modeldriver.LoginMd;
import com.iyoumei.util.enumcollection.IResMsg;

public interface ILoginService {

	public ServiceResultBean<UserInfo, IResMsg> selectUserInfo(LoginMd loginMd);
	
}
