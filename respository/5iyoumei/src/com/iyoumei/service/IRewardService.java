package com.iyoumei.service;

import com.iyoumei.bean.RewardServiceData;
import com.iyoumei.bean.ServiceResultBean;

public interface IRewardService {

	public ServiceResultBean<?, ?> service(RewardServiceData data) ;
}
