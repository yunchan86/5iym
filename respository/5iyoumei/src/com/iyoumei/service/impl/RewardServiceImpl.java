package com.iyoumei.service.impl;

import javax.annotation.Resource;

import com.iyoumei.bean.RewardServiceData;
import com.iyoumei.bean.ServiceResultBean;
import com.iyoumei.mapper.RewardRuleMapper;
import com.iyoumei.mapper.UserRewardLogMapper;
import com.iyoumei.mapper.UserRewardRuleMapper;
import com.iyoumei.service.IRewardService;

/**
 * 收益分配服务
 * @author chenhuangyun
 *
 */
public class RewardServiceImpl implements IRewardService {

	@Resource(type=RewardRuleMapper.class)
	private RewardRuleMapper ruleMapper ;
	@Resource(type=UserRewardRuleMapper.class)
	private UserRewardRuleMapper userRuleMapper ;
	@Resource(type=UserRewardLogMapper.class)
	private UserRewardLogMapper rewardLogMapper ;
	
	@Override
	public ServiceResultBean<?, ?> service(RewardServiceData data) {
		// TODO Auto-generated method stub
		return null;
	}

}
