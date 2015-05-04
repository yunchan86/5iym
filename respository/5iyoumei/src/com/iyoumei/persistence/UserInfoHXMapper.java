package com.iyoumei.persistence;

import com.iyoumei.domain.UserInfoHXDomain;

public interface UserInfoHXMapper {
    int deleteByPrimaryKey(Long userId);

    int insert(UserInfoHXDomain record);

    int insertSelective(UserInfoHXDomain record);

    UserInfoHXDomain selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserInfoHXDomain record);

    int updateByPrimaryKey(UserInfoHXDomain record);
}