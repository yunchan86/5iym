package com.iyoumei.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.domain.UserFriendDomain;

public interface UserFriendInfoMapper {
	
	public UserFriendDomain getUserFriendInfo(@Param("userId")long userId,@Param("friendUserId")long friendUserId) ;
	
	public List<UserFriendDomain> getUserFriendList(long userId) ;
	
	public List<UserFriendDomain> getDailyUserFriendList(long userId) ;
}
