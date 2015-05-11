package com.iyoumei.service.reward;

import com.iyoumei.bean.RewardUserData;
import com.iyoumei.entity.UserRewardRule;
import com.iyoumei.entity.VipUserRecord;
import com.iyoumei.entity.constant.RewardRuleValueConstant;
/**
 * 获取奖励类型
 * @author chenhuangyun
 *
 */
public class FacRewardAlgorithm {

	public static IRewardAlgorithm getInstance(VipUserRecord vipRecord,RewardUserData data) {
		IRewardAlgorithm reward = null ;
		UserRewardRule rule = data.getRule() ;
		if(rule==null) return reward ;
		if(rule.getRuleId().intValue()==RewardRuleValueConstant.REWARD_ZHITUI)
			reward = new ZTRewardImpl() ;
		else if(rule.getRuleId().intValue()==RewardRuleValueConstant.REWARD_JAINDIAN)
			reward = new JDRewardImpl() ;
		else if(rule.getRuleId().intValue()==RewardRuleValueConstant.REWARD_DUIPENG)
			reward = new DPRewardImpl() ;
		return reward ;
	}
}
