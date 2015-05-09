package com.iyoumei.mapper1;

import com.iyoumei.entity.UserInfoHXLogDomain;

public interface UserInfoHXLogMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserInfoHXLogDomain record);

    int insertSelective(UserInfoHXLogDomain record);

    UserInfoHXLogDomain selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserInfoHXLogDomain record);

    int updateByPrimaryKey(UserInfoHXLogDomain record);
}