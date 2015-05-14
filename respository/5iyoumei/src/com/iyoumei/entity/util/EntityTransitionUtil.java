package com.iyoumei.entity.util;

import com.iyoumei.entity.RewardRule;
import com.iyoumei.entity.UserRelation;
import com.iyoumei.entity.UserRewardRule;

public class EntityTransitionUtil {

	public static UserRewardRule getByRewardRule(UserRelation relation,RewardRule rule) {
		UserRewardRule userRule = null ;
		if(rule==null) return userRule ;
		userRule = new UserRewardRule() ;
		userRule.setInsertTime(rule.getInsertTime());
		userRule.setLimitMaxAmt(rule.getLimitMaxAmt());
		userRule.setRuleId(rule.getRuleId());
		userRule.setRuleName(rule.getRuleName());
		userRule.setStatus(rule.getStatus());
		userRule.setTimeCycle(rule.getTimeCycle());
		userRule.setUnitAmt(rule.getUnitAmt());
		userRule.setUpdateTime(rule.getUpdateTime());
		userRule.setUserId(relation.getSuperId());
		return userRule ;
	}
}
