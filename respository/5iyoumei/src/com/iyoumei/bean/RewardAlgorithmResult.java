package com.iyoumei.bean;

import com.iyoumei.entity.UserRewardLog;

public class RewardAlgorithmResult extends BasicCodeMsgBean{

	public RewardAlgorithmResult(){}
	
	public RewardAlgorithmResult(String code,String msg,UserRewardLog rewardLog){
		super(code,msg) ;
		this.rewardLog = rewardLog ;
	}
	
	private UserRewardLog rewardLog ;
	
	public void setData(String code,String msg,UserRewardLog rewardLog) {
		this.setCode(code);
		this.setMsg(msg);
		this.rewardLog = rewardLog ;
	}

	public UserRewardLog getRewardLog() {
		return rewardLog;
	}

	public void setRewardLog(UserRewardLog rewardLog) {
		this.rewardLog = rewardLog;
	}
	
}
