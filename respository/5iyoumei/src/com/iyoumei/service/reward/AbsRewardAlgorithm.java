package com.iyoumei.service.reward;

import java.util.Date;

import com.iyoumei.bean.RewardAlgorithmResult;
import com.iyoumei.bean.RewardUserData;
import com.iyoumei.entity.UserRelation;
import com.iyoumei.entity.UserRewardLog;
import com.iyoumei.entity.UserRewardRule;
import com.iyoumei.entity.VipUserRecord;
import com.iyoumei.entity.constant.UserRewardLogConstant;
import com.iyoumei.entity.constant.VipUserRecordConstant;
import com.iyoumei.util.enumcollection.CommonCode;
import com.wuwaikeji.luyou.common.StringUtil;

public abstract class AbsRewardAlgorithm implements IRewardAlgorithm {
	
	public RewardAlgorithmResult calculate(VipUserRecord vipRecord,
			RewardUserData data) {
		RewardAlgorithmResult result = null ;
		if(vipRecord==null||data==null) return result ;
		if(data.getRelation()==null||data.getRule()==null) return result ;
		if(StringUtil.equals(vipRecord.getStatus(), VipUserRecordConstant.STATUS_DO_NOTHING)) {
			UserRewardLog rewardLog = this.getUserRewardLog(data) ;
			result = new RewardAlgorithmResult(CommonCode.SUCCESS.getCode(),CommonCode.SUCCESS.getMsg(),rewardLog) ;
		}
		return result;
	}
	
	protected UserRewardLog getUserRewardLog(RewardUserData data) {
		UserRewardLog rewardLog = null ;
		UserRelation relation = data.getRelation() ;
		UserRewardRule rule = data.getRule() ;
		if(relation==null||rule==null) return rewardLog ;
		rewardLog = new UserRewardLog() ;
		Date date = new Date() ;
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
		rewardLog.setInsertTime(date);
		rewardLog.setRewardAmt(rule.getUnitAmt());
		rewardLog.setRewardStatus(UserRewardLogConstant.STATUS_DO_OK);
		rewardLog.setRuleId(rule.getRuleId());
		rewardLog.setSuperId(relation.getSuperId());
		rewardLog.setSuperLevelNum(relation.getSuperLevelNum());
		rewardLog.setSuperName(relation.getSuperName());
		rewardLog.setSuperPosition(relation.getSuperPosition());
		rewardLog.setUserId(relation.getUserId());
		return rewardLog ;
	}
}
