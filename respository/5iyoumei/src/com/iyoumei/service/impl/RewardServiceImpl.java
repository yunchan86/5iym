package com.iyoumei.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import com.iyoumei.bean.RewardAlgorithmResult;
import com.iyoumei.bean.RewardServiceData;
import com.iyoumei.bean.RewardUserData;
import com.iyoumei.bean.ServiceResultBean;
import com.iyoumei.entity.RewardRule;
import com.iyoumei.entity.RewardRuleExample;
import com.iyoumei.entity.UserRelationExample;
import com.iyoumei.entity.UserRewardRule;
import com.iyoumei.entity.UserRewardRuleExample;
import com.iyoumei.entity.constant.PositionValueConstant;
import com.iyoumei.entity.constant.RewardRuleConstant;
import com.iyoumei.entity.constant.UserRewardRuleConstant;
import com.iyoumei.entity.util.EntityTransitionUtil;
import com.iyoumei.entity.view.UserCircleReward;
import com.iyoumei.exception.RewardNoConfigException;
import com.iyoumei.mapper.RewardRuleMapper;
import com.iyoumei.mapper.UserRelationMapper;
import com.iyoumei.mapper.UserRewardLogMapper;
import com.iyoumei.mapper.UserRewardRuleMapper;
import com.iyoumei.service.IRewardService;
import com.iyoumei.service.reward.FacRewardAlgorithm;
import com.iyoumei.service.reward.IRewardAlgorithm;

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
	@Resource(type=UserRelationMapper.class)
	private UserRelationMapper relationMapper ;
	
	public ServiceResultBean<?, ?> service(RewardServiceData data) {
		RewardRuleExample ruleExample = new RewardRuleExample() ;
		RewardRuleExample.Criteria ruleCriteria =  ruleExample.createCriteria() ;
		ruleCriteria.andStatusEqualTo(RewardRuleConstant.STATUS_OK) ;
		List<UserRewardRule>  userRuleList = getRewardRuleList(data) ;
		for(UserRewardRule userRule : userRuleList) {
			//RewardRuleValueConstant
			UserCircleReward circleReward = this.getUserCircleReward(userRule, data) ;
			RewardUserData rewardData = new RewardUserData(userRule,data.getRelation(),circleReward) ;
			IRewardAlgorithm algorithm = FacRewardAlgorithm.getInstance(data.getRecode(), rewardData) ;
			RewardAlgorithmResult algorithmResult = algorithm.calculate(data.getRecode(), rewardData) ;
			//TODO
		}
		//TODO
		return null;
	}
	
	private UserCircleReward getUserCircleReward(UserRewardRule rule,RewardServiceData data) {
		UserCircleReward circleReward = null ;
		UserRelationExample relationExample = new UserRelationExample() ;
		UserRelationExample.Criteria relationCriteria = relationExample.createCriteria() ;
		relationCriteria.andSuperIdEqualTo(rule.getUserId()) ;
		relationCriteria.andSuperPositionEqualTo(PositionValueConstant.LEFT) ;
		int left = relationMapper.countByExample(relationExample) ;
		relationExample.clear();
		relationCriteria.andSuperIdEqualTo(rule.getUserId()) ;
		relationCriteria.andSuperPositionEqualTo(PositionValueConstant.RIGHT) ;
		int right = relationMapper.countByExample(relationExample) ;
		Long currentTotalAmt = 0l ;
		//TODO
		
		circleReward = new UserCircleReward(rule.getRuleId(),data.getRelation().getSuperId()
				,currentTotalAmt,left,right) ;
		return circleReward ;
	}
	
	private List<UserRewardRule> getRewardRuleList(RewardServiceData data) {
		List<UserRewardRule> userRuleList = null ;
		//公共RewardRule的处理
		RewardRuleExample ruleExample = new RewardRuleExample() ;
		RewardRuleExample.Criteria ruleCriteria =  ruleExample.createCriteria() ;
		ruleCriteria.andStatusEqualTo(RewardRuleConstant.STATUS_OK) ;
		List<RewardRule>  ruleList = ruleMapper.selectByExample(ruleExample) ;
		if(ruleList==null||ruleList.size()==0) throw new RewardNoConfigException("reward rule no configuration.");
		//会员特性RewardRule的处理
		UserRewardRuleExample  userRuleExample = new UserRewardRuleExample() ;
		UserRewardRuleExample.Criteria userRuleCriteria = userRuleExample.createCriteria() ;
		userRuleCriteria.andUserIdEqualTo(data.getRelation().getSuperId()) ;
		userRuleCriteria.andStatusEqualTo(UserRewardRuleConstant.STATUS_OK) ;
		userRuleList = this.userRuleMapper.selectByExample(userRuleExample) ;
		//公共RewardRule与UserRewardRule的整合
		if(userRuleList==null||userRuleList.size()==0) {
			if(userRuleList==null) userRuleList = new ArrayList<UserRewardRule>() ;
			for(RewardRule reward : ruleList) {
				UserRewardRule userRule = EntityTransitionUtil.getByRewardRule(data.getRelation(), reward) ;
				userRuleList.add(userRule) ;
			}
		}
		return userRuleList ;
	}

}
