package com.iyoumei.mapper;

import com.iyoumei.entity.UserRewardLog;
import com.iyoumei.entity.UserRewardLogExample;
import com.iyoumei.entity.UserRewardLogKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRewardLogMapper {
    int countByExample(UserRewardLogExample example);

    int deleteByExample(UserRewardLogExample example);

    int deleteByPrimaryKey(UserRewardLogKey key);

    int insert(UserRewardLog record);

    int insertSelective(UserRewardLog record);

    List<UserRewardLog> selectByExample(UserRewardLogExample example);

    UserRewardLog selectByPrimaryKey(UserRewardLogKey key);

    int updateByExampleSelective(@Param("record") UserRewardLog record, @Param("example") UserRewardLogExample example);

    int updateByExample(@Param("record") UserRewardLog record, @Param("example") UserRewardLogExample example);

    int updateByPrimaryKeySelective(UserRewardLog record);

    int updateByPrimaryKey(UserRewardLog record);
}