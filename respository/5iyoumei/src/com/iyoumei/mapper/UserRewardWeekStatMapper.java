package com.iyoumei.mapper;

import com.iyoumei.entity.UserRewardWeekStat;
import com.iyoumei.entity.UserRewardWeekStatExample;
import com.iyoumei.entity.UserRewardWeekStatKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRewardWeekStatMapper {
    int countByExample(UserRewardWeekStatExample example);

    int deleteByExample(UserRewardWeekStatExample example);

    int deleteByPrimaryKey(UserRewardWeekStatKey key);

    int insert(UserRewardWeekStat record);

    int insertSelective(UserRewardWeekStat record);

    List<UserRewardWeekStat> selectByExample(UserRewardWeekStatExample example);

    UserRewardWeekStat selectByPrimaryKey(UserRewardWeekStatKey key);

    int updateByExampleSelective(@Param("record") UserRewardWeekStat record, @Param("example") UserRewardWeekStatExample example);

    int updateByExample(@Param("record") UserRewardWeekStat record, @Param("example") UserRewardWeekStatExample example);

    int updateByPrimaryKeySelective(UserRewardWeekStat record);

    int updateByPrimaryKey(UserRewardWeekStat record);
}