package com.iyoumei.service.reward;

import javax.annotation.Resource;

import com.iyoumei.bean.CommonServiceResult;
import com.iyoumei.bean.RewardStatServiceData;
import com.iyoumei.entity.UserRewardDayStat;
import com.iyoumei.entity.UserRewardDayStatKey;
import com.iyoumei.entity.UserRewardLog;
import com.iyoumei.entity.constant.UserRewardLogConstant;
import com.iyoumei.mapper.UserRewardDayStatMapper;
import com.iyoumei.mapper.UserRewardLogMapper;

public class DayStatRewardImpl extends AbsRewardStat {

	@Resource(type=UserRewardLogMapper.class)
	private UserRewardLogMapper rewardLogMapper ;
	@Resource(type=UserRewardDayStatMapper.class)
	private UserRewardDayStatMapper dayStatMapper ;
	@Override
	
	public CommonServiceResult<?> stat(RewardStatServiceData data) {
		/*UserRewardDayStatExample dayStatExample = new UserRewardDayStatExample() ;
		UserRewardDayStatExample.Criteria dayStatCriteria = dayStatExample.createCriteria() ;*/
		UserRewardDayStatKey key = new UserRewardDayStatKey() ;
		key.setUserId(data.getUserId());
		key.setStatDate(data.getStartTime());//TODO 可能需要修改
		UserRewardDayStat dayStat = dayStatMapper.selectByPrimaryKey(key) ;
		String startTime = null ;//TODO
		String endTime = null ;//TODO
		UserRewardLog rewardLog = this.rewardLogMapper.selectSumBySuperId(data.getUserId(), UserRewardLogConstant.STATUS_DO_OK,startTime, endTime) ;
		
		return null;
	}

}
