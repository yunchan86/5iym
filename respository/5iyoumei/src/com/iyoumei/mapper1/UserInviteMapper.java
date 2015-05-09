package com.iyoumei.mapper1;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.entity.UserAddInviteDomain;
import com.iyoumei.entity.UserInviteDomain;

public interface UserInviteMapper {


	UserInviteDomain selectByUserId(@Param("invitingUserId")String invitingUserId,@Param("invitedUserId")String invitedUserId) ;
	
	UserInviteDomain selectById(long inviteId) ;
	/**
	 * 新建好友添加请求
	 * 
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	public int insert(UserInviteDomain domain) throws Exception;

	

	/**
	 * 更新认证状态
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	
	public int update(UserInviteDomain domain) throws Exception;
	
	/**
	 * 检查两个人是否已经建立了好友关系
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	public int checkInvited00Relation(UserInviteDomain domain) throws Exception;
	
	/**
	 * 检查5分钟内是否已经存在好友申请记录，5分钟内不允许重复发送好友添加申请
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	public int checkInvited01Relation(UserInviteDomain domain) throws Exception;
}
