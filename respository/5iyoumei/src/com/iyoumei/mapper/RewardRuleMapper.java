package com.iyoumei.mapper;

import com.iyoumei.entity.RewardRule;
import com.iyoumei.entity.RewardRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RewardRuleMapper {
    int countByExample(RewardRuleExample example);

    int deleteByExample(RewardRuleExample example);

    int deleteByPrimaryKey(Integer ruleId);

    int insert(RewardRule record);

    int insertSelective(RewardRule record);

    List<RewardRule> selectByExample(RewardRuleExample example);

    RewardRule selectByPrimaryKey(Integer ruleId);

    int updateByExampleSelective(@Param("record") RewardRule record, @Param("example") RewardRuleExample example);

    int updateByExample(@Param("record") RewardRule record, @Param("example") RewardRuleExample example);

    int updateByPrimaryKeySelective(RewardRule record);

    int updateByPrimaryKey(RewardRule record);
}