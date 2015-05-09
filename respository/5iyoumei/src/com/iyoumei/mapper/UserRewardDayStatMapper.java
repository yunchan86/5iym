package com.iyoumei.mapper;

import com.iyoumei.entity.UserRewardDayStat;
import com.iyoumei.entity.UserRewardDayStatExample;
import com.iyoumei.entity.UserRewardDayStatKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRewardDayStatMapper {
    int countByExample(UserRewardDayStatExample example);

    int deleteByExample(UserRewardDayStatExample example);

    int deleteByPrimaryKey(UserRewardDayStatKey key);

    int insert(UserRewardDayStat record);

    int insertSelective(UserRewardDayStat record);

    List<UserRewardDayStat> selectByExample(UserRewardDayStatExample example);

    UserRewardDayStat selectByPrimaryKey(UserRewardDayStatKey key);

    int updateByExampleSelective(@Param("record") UserRewardDayStat record, @Param("example") UserRewardDayStatExample example);

    int updateByExample(@Param("record") UserRewardDayStat record, @Param("example") UserRewardDayStatExample example);

    int updateByPrimaryKeySelective(UserRewardDayStat record);

    int updateByPrimaryKey(UserRewardDayStat record);
}