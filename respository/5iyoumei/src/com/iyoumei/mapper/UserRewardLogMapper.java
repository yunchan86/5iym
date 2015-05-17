package com.iyoumei.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.entity.UserRewardLog;
import com.iyoumei.entity.UserRewardLogExample;
import com.iyoumei.entity.UserRewardLogKey;

public interface UserRewardLogMapper {
    int countByExample(UserRewardLogExample example);

    int deleteByExample(UserRewardLogExample example);

    int deleteByPrimaryKey(UserRewardLogKey key);

    int insert(UserRewardLog record);

    int insertSelective(UserRewardLog record);

    List<UserRewardLog> selectByExample(UserRewardLogExample example);

    UserRewardLog selectByPrimaryKey(UserRewardLogKey key);
    
    Long sumBySuperId(@Param("superId")Long superId , @Param("rewardStatus")String rewardStatus) ;
    
    UserRewardLog selectSumBySuperId(@Param("superId")Long superId , @Param("rewardStatus")String rewardStatus,@Param("startTime")String startTime,@Param("endTime")String endTime) ;

    int updateByExampleSelective(@Param("record") UserRewardLog record, @Param("example") UserRewardLogExample example);

    int updateByExample(@Param("record") UserRewardLog record, @Param("example") UserRewardLogExample example);

    int updateByPrimaryKeySelective(UserRewardLog record);

    int updateByPrimaryKey(UserRewardLog record);
}