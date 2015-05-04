package com.iyoumei.service;

import com.iyoumei.domain.UserSigDomain;

public interface IUserSigService {
	/**
	 * 登录时获取sig（如果第一次登录则生成sig信息）
	 * 
	 * @param userId
	 * @param uuid
	 * @param callType
	 * @return
	 * @throws Exception
	 */
	public UserSigDomain getUserSigOnLogin(String userId, String uuid, String callType) throws Exception;

	/**
	 * 更新sig
	 * 
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	public int updateUserSig(UserSigDomain domain) throws Exception;

	/**
	 * 登出时更新usersig
	 * 
	 * @param userId
	 * @param uuid
	 * @param callType
	 * @throws Exception
	 */
	public void updateUserSigOnLogout(String userId, String uuid, String callType) throws Exception;

	/**
	 * 获取sig
	 * 
	 * @param userId
	 * @param uuid
	 * @param callType
	 * @return
	 * @throws Exception
	 */
	public UserSigDomain getUserSig(String userId, String appType, String terminalType) throws Exception;

}
