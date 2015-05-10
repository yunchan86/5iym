package com.iyoumei.service.reward;

import com.iyoumei.bean.RewardAlgorithmResult;
import com.iyoumei.bean.RewardUserData;
import com.iyoumei.entity.VipUserRecord;
import com.iyoumei.exception.RewardCalculateException;

public interface IRewardAlgorithm {

	public RewardAlgorithmResult calculate(VipUserRecord vipRecord,RewardUserData data) throws RewardCalculateException ;
}
