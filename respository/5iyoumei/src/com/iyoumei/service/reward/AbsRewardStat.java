package com.iyoumei.service.reward;

import com.iyoumei.bean.CommonServiceResult;
import com.iyoumei.bean.RewardStatServiceData;

public abstract class AbsRewardStat {

	public abstract CommonServiceResult<?> stat(RewardStatServiceData data) ;
	
}
