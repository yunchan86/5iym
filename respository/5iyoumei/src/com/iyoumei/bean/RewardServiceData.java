package com.iyoumei.bean;

import com.iyoumei.entity.UserRelation;
import com.iyoumei.entity.VipUserRecord;

public class RewardServiceData {
	
	public RewardServiceData(){}
	public RewardServiceData(VipUserRecord recode,UserRelation relation){
		this.recode = recode ;
		this.relation = relation ;
	}

	private VipUserRecord recode ;
	private UserRelation relation ;
	public VipUserRecord getRecode() {
		return recode;
	}
	public void setRecode(VipUserRecord recode) {
		this.recode = recode;
	}
	public UserRelation getRelation() {
		return relation;
	}
	public void setRelation(UserRelation relation) {
		this.relation = relation;
	}
	
	
}
