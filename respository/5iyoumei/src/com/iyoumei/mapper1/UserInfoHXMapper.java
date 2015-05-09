package com.iyoumei.mapper1;

import com.iyoumei.entity.UserInfoHXDomain;

public interface UserInfoHXMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserInfoHXDomain record);

    int insertSelective(UserInfoHXDomain record);

    UserInfoHXDomain selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserInfoHXDomain record);

    int updateByPrimaryKey(UserInfoHXDomain record);
}