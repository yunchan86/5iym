package com.iyoumei.persistence;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.domain.UserAddInviteDomain;

public interface UserAddInviteMapper {
	
	UserAddInviteDomain selectByUserId(@Param("invitingUserId")String invitingUserId,@Param("invitedUserId")String invitedUserId) ;
	
	UserAddInviteDomain selectById(long inviteId) ;
	
    int insert(UserAddInviteDomain record);

    int insertSelective(UserAddInviteDomain record);
}