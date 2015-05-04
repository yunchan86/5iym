package com.iyoumei.persistence;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.domain.UserGroupMemberDomain;

public interface UserGroupMemberMapper {
    int insert(UserGroupMemberDomain record);

    int insertSelective(UserGroupMemberDomain record);
    
    int deleteGroupAll(long groupId);
    
    int deleteMember(@Param("groupId")long groupId,@Param("userId")long userId);
    
    UserGroupMemberDomain select(@Param("delUserId")long groupId,@Param("userId")long userId) ;
}