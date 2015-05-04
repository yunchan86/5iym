package com.iyoumei.util;

import com.iyoumei.domain.UserInfoDomain;

public class HXUserUtil {

	public static String getUserName(UserInfoDomain userInfo) {
		return userInfo.getUserId() ;
	}
	
	public static String getPassword(UserInfoDomain userInfo) {
		if(StringUtil.isNull(userInfo.getPassword())) return null ;
		return Md5Encrypt.md5(userInfo.getPassword()+"luyou"+userInfo.getUserId()) ;
	}
}
