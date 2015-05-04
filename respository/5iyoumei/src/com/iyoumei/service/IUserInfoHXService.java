package com.iyoumei.service;

import com.iyoumei.bean.ResultDataBean;

public interface IUserInfoHXService {

	/**
	 * 增加环信的昵称
	 * @param userId
	 * @param nickname
	 * @return
	 */
	public ResultDataBean<?> addNickname(long userId,String nickname) ;
	/**
	 * 修改用户包括环信的用户名密码
	 * @param userId
	 * @param oldPwd
	 * @param pwd
	 * @return
	 */
	public ResultDataBean<?> modifyPwd(long userId,String oldPwd,String pwd) ;
	/**
	 * 已经存在的用户增加到换信数据中
	 * @param userId
	 * @param pwd
	 * @return
	 */
	public ResultDataBean<?> addUserInfo(long userId,String pwd) ;
}
