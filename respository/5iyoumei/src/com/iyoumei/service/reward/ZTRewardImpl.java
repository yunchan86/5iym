package com.iyoumei.service.reward;

import com.iyoumei.bean.RewardAlgorithmResult;
import com.iyoumei.bean.RewardUserData;
import com.iyoumei.entity.UserRewardLog;
import com.iyoumei.entity.VipUserRecord;
import com.iyoumei.entity.constant.VipUserRecordConstant;
import com.iyoumei.util.enumcollection.CommonCode;
import com.wuwaikeji.luyou.common.StringUtil;

public class ZTRewardImpl extends AbsRewardAlgorithm {

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

}
