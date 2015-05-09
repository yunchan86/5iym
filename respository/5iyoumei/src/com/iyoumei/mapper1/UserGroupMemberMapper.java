package com.iyoumei.mapper1;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.entity.UserGroupMemberDomain;

public interface UserGroupMemberMapper {
    int insert(UserGroupMemberDomain record);

    int insertSelective(UserGroupMemberDomain record);
    
    int deleteGroupAll(long groupId);
    
    int deleteMember(@Param("groupId")long groupId,@Param("userId")long userId);
    
    UserGroupMemberDomain select(@Param("delUserId")long groupId,@Param("userId")long userId) ;
}