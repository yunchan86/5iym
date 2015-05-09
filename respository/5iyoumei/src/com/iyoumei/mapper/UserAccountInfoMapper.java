package com.iyoumei.mapper;

import com.iyoumei.entity.UserAccountInfo;
import com.iyoumei.entity.UserAccountInfoExample;
import com.iyoumei.entity.UserAccountInfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAccountInfoMapper {
    int countByExample(UserAccountInfoExample example);

    int deleteByExample(UserAccountInfoExample example);

    int deleteByPrimaryKey(UserAccountInfoKey key);

    int insert(UserAccountInfo record);

    int insertSelective(UserAccountInfo record);

    List<UserAccountInfo> selectByExample(UserAccountInfoExample example);

    UserAccountInfo selectByPrimaryKey(UserAccountInfoKey key);

    int updateByExampleSelective(@Param("record") UserAccountInfo record, @Param("example") UserAccountInfoExample example);

    int updateByExample(@Param("record") UserAccountInfo record, @Param("example") UserAccountInfoExample example);

    int updateByPrimaryKeySelective(UserAccountInfo record);

    int updateByPrimaryKey(UserAccountInfo record);
}