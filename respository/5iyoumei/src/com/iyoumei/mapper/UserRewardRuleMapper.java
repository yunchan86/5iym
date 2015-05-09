package com.iyoumei.mapper;

import com.iyoumei.entity.UserRewardRule;
import com.iyoumei.entity.UserRewardRuleExample;
import com.iyoumei.entity.UserRewardRuleKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRewardRuleMapper {
    int countByExample(UserRewardRuleExample example);

    int deleteByExample(UserRewardRuleExample example);

    int deleteByPrimaryKey(UserRewardRuleKey key);

    int insert(UserRewardRule record);

    int insertSelective(UserRewardRule record);

    List<UserRewardRule> selectByExample(UserRewardRuleExample example);

    UserRewardRule selectByPrimaryKey(UserRewardRuleKey key);

    int updateByExampleSelective(@Param("record") UserRewardRule record, @Param("example") UserRewardRuleExample example);

    int updateByExample(@Param("record") UserRewardRule record, @Param("example") UserRewardRuleExample example);

    int updateByPrimaryKeySelective(UserRewardRule record);

    int updateByPrimaryKey(UserRewardRule record);
}