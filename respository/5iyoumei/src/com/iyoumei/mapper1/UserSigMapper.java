package com.iyoumei.mapper1;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.entity.UserSigDomain;

public interface UserSigMapper {
	/**
	 * 插入
	 * 
	 * @param domain
	 * @return
	 */
	int insert(UserSigDomain domain);

	/**
	 * 更新
	 * 
	 * @param domain
	 * @return
	 */
	int update(UserSigDomain domain);

	/**
	 * 查询
	 * 
	 * @param userId
	 * @param uuid
	 * @param teminalType
	 * @return
	 */
	UserSigDomain select(@Param("userId") String userId, @Param("uuid") String uuid,
			@Param("teminalType") String teminalType);

	/**
	 * 关闭掉同一个用户的其它登录信息。 <br>
	 * 用户登录后，将该用户的历史登录记录置为“登录过期”，用于防治用户多个设备同时登录
	 * 
	 * @param userId
	 *            用户编号
	 * @param appType
	 *            应用类型
	 * @param currentLoginUuid
	 *            //本次登录的唯一标识
	 * @return
	 * @throws Exception
	 */
	int forbiddenOtherLoginInfo(@Param("userId") String userId, @Param("currentLoginUuid") String currentLoginUuid)
			throws Exception;
}
