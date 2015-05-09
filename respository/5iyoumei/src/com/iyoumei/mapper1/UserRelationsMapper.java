package com.iyoumei.mapper1;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.entity.UserRelationsDomain;

public interface UserRelationsMapper {
    int deleteByPrimaryKey(@Param("userId1")long selfUserId,@Param("userId2")long friendUserId);

    int insert(UserRelationsDomain record);

    int insertSelective(UserRelationsDomain record);

    UserRelationsDomain selectByPrimaryKey(@Param("userId1")long selfUserId,@Param("userId2")long friendUserId);

    int updateByPrimaryKeySelective(UserRelationsDomain record);

    int updateByPrimaryKey(UserRelationsDomain record);
    
    int updateLabel(UserRelationsDomain record) ;
    
    int updateBlacklist(@Param("userId1")long selfUserId,@Param("userId2")long friendUserId) ;
    
    int updateAuth(UserRelationsDomain record) ;
}