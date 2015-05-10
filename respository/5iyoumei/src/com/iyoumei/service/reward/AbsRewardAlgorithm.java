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
import com.iyoumei.entity.view.UserCircleReward;
import com.iyoumei.util.enumcollection.CommonCode;
import com.wuwaikeji.luyou.common.StringUtil;

/**
 * 奖金处理的抽象类
 * @author chenhuangyun
 *
 */
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
		Long amt = getRealRewardAmt(data) ;
		if(amt.longValue()==0l) return rewardLog ;
		rewardLog = new UserRewardLog() ;
		Date date = new Date() ;
		//DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
		rewardLog.setInsertTime(date);
		rewardLog.setRewardAmt(amt);
		rewardLog.setRewardStatus(UserRewardLogConstant.STATUS_DO_OK);
		rewardLog.setRuleId(rule.getRuleId());
		rewardLog.setSuperId(relation.getSuperId());
		rewardLog.setSuperLevelNum(relation.getSuperLevelNum());
		rewardLog.setSuperName(relation.getSuperName());
		rewardLog.setSuperPosition(relation.getSuperPosition());
		rewardLog.setUserId(relation.getUserId());
		return rewardLog ;
	}
	
	protected boolean isLevelEnable(RewardUserData data) {
		boolean b = false ;
		UserRelation relation = data.getRelation() ;
		UserRewardRule rule = data.getRule() ;
		if(relation.getSuperLevelNum().intValue()>rule.getMaxLevel().intValue()
				&&rule.getMaxLevel().intValue()>0) b = false ;
		else b = true ;
		return b ;
	}
	
	protected Long getRealRewardAmt(RewardUserData data) {
		Long amt = 0l ;
		UserCircleReward ucr = data.getCircleReward() ;
		UserRewardRule rule = data.getRule() ;
		if(!isLevelEnable(data)) return amt ;
		if(rule.getLimitMaxAmt()>ucr.getCurrentTotalAmt()+rule.getUnitAmt()) amt = rule.getUnitAmt() ;
		else if(rule.getLimitMaxAmt()<ucr.getCurrentTotalAmt()+rule.getUnitAmt()
				&&rule.getLimitMaxAmt()>ucr.getCurrentTotalAmt()) amt = rule.getLimitMaxAmt()-ucr.getCurrentTotalAmt() ;
		else amt = 0l ;
		return amt ;
	}
}
