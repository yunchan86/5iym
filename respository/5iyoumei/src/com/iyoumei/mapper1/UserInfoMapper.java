package com.iyoumei.mapper1;

import com.iyoumei.entity.UserInfoDomain;

public interface UserInfoMapper {

	/**
	 * 手机号是否注册
	 * 
	 * @param domain
	 * @return
	 */
	public int isMobileNumberRegsiter(String mobileNumber) throws Exception;

	/**
	 * 新增用户
	 * 
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	public int insert(UserInfoDomain domain) throws Exception;

	/**
	 * 根据手机号查询用户信息
	 * 
	 * @param mobileNumber
	 * @return
	 * @throws Exception
	 */
	public UserInfoDomain selectByMobileNumber(String mobileNumber) throws Exception;

	/**
	 * 根据id查询用户
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public UserInfoDomain selectByUserId(String userId) throws Exception;

	/**
	 * 更新
	 * 
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	public int update(UserInfoDomain domain) throws Exception;
}
