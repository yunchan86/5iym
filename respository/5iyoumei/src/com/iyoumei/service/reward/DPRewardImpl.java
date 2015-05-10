package com.iyoumei.service.reward;

import com.iyoumei.bean.RewardUserData;
import com.iyoumei.entity.UserRewardLog;
import com.iyoumei.entity.constant.UserRewardLogConstant;
/**
 * 对碰奖一个用户按一半奖金插入，同时状态先设置为不可用，等满足条件时，重新置为可用
 * @author chenhuangyun
 *
 */
public class DPRewardImpl extends AbsRewardAlgorithm {

	protected Long getRealRewardAmt(RewardUserData data) {
		Long amt = super.getRealRewardAmt(data)/2 ;
		return amt ;
	}
	
	protected UserRewardLog getUserRewardLog(RewardUserData data) {
		UserRewardLog reward = super.getUserRewardLog(data) ;
		if(reward!=null) {
			reward.setRewardStatus(UserRewardLogConstant.STATUS_DO_NOTHING);//设置为未处理
		}
		return reward ;
	}
}
