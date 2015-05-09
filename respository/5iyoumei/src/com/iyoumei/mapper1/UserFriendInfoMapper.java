package com.iyoumei.mapper1;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.entity.UserFriendDomain;

public interface UserFriendInfoMapper {
	
	public UserFriendDomain getUserFriendInfo(@Param("userId")long userId,@Param("friendUserId")long friendUserId) ;
	
	public List<UserFriendDomain> getUserFriendList(long userId) ;
	
	public List<UserFriendDomain> getDailyUserFriendList(long userId) ;
}
