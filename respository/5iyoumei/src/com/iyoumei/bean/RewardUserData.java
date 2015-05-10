package com.iyoumei.bean;

import com.iyoumei.entity.UserRelation;
import com.iyoumei.entity.UserRewardRule;
import com.iyoumei.entity.view.UserCircleReward;

public class RewardUserData {

	private UserRewardRule rule ;
	private UserRelation relation ;
	private UserCircleReward circleReward ;
	public RewardUserData(){}
	public RewardUserData(UserRewardRule rule,UserRelation relation
			,UserCircleReward circleReward) {
		this.relation = relation ;
		this.rule = rule ;
		this.circleReward = circleReward ;
	}
	
	public UserRewardRule getRule() {
		return rule;
	}
	public void setRule(UserRewardRule rule) {
		this.rule = rule;
	}
	public UserRelation getRelation() {
		return relation;
	}
	public void setRelation(UserRelation relation) {
		this.relation = relation;
	}
	public UserCircleReward getCircleReward() {
		return circleReward;
	}
	public void setCircleReward(UserCircleReward circleReward) {
		this.circleReward = circleReward;
	}
	
	
}
