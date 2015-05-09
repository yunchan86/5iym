package com.iyoumei.service;

import com.iyoumei.bean.CodeMsgBean;
import com.iyoumei.entity.UserInfoDomain;

public interface IUserInfoService {
	/**
	 * 获取用户信息
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public UserInfoDomain getUserInfo(String userId) throws Exception;

	/**
	 * 更新用户信息
	 * 
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	public boolean updateUserInfo(UserInfoDomain domain) throws Exception;

	/**
	 * 保存用户头像并返回头像地址
	 * 
	 * @param userId
	 * @param imageDataArr
	 * @return
	 * @throws Exception
	 */
	public String saveIconAndGetUrl(String userId, byte[] imageDataArr, String ext, String iconType) throws Exception;

	/**
	 * 修改登录密码
	 * 
	 * @param userId
	 * @param pwd
	 * @param newPwd
	 * @return
	 * @throws Exception
	 */
	public CodeMsgBean modifyPwd(String userId, String pwd, String newPwd) throws Exception;

	/**
	 * 通过忘记密码修改密码
	 * 
	 * @param mobileNumber
	 * @param pwd
	 * @return
	 * @throws Exception
	 */
	public CodeMsgBean modifyPwdByForget(String mobileNumber, String pwd) throws Exception;

}
