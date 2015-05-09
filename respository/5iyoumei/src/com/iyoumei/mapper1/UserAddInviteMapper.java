package com.iyoumei.mapper1;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.entity.UserAddInviteDomain;

public interface UserAddInviteMapper {
	
	UserAddInviteDomain selectByUserId(@Param("invitingUserId")String invitingUserId,@Param("invitedUserId")String invitedUserId) ;
	
	UserAddInviteDomain selectById(long inviteId) ;
	
    int insert(UserAddInviteDomain record);

    int insertSelective(UserAddInviteDomain record);
}