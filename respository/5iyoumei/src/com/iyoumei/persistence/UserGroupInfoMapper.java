package com.iyoumei.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.domain.UserGroupInfoDomain;

public interface UserGroupInfoMapper {
    int deleteByPrimaryKey(Long groupId);

    int insert(UserGroupInfoDomain record);

    int insertSelective(UserGroupInfoDomain record);

    UserGroupInfoDomain selectByPrimaryKey(Long groupId);
    
    UserGroupInfoDomain selectByGroupname(@Param("userId")long userId,@Param("groupname")String groupname);

    List<UserGroupInfoDomain> getGroupList(@Param("userId")long userId) ;
    
    int updateByPrimaryKeySelective(UserGroupInfoDomain record);

    int updateByPrimaryKey(UserGroupInfoDomain record);
}