package com.iyoumei.persistence;

import com.iyoumei.domain.UserInfoHXLogDomain;

public interface UserInfoHXLogMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserInfoHXLogDomain record);

    int insertSelective(UserInfoHXLogDomain record);

    UserInfoHXLogDomain selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserInfoHXLogDomain record);

    int updateByPrimaryKey(UserInfoHXLogDomain record);
}