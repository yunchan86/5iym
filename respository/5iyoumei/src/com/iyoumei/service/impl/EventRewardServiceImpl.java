package com.iyoumei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.iyoumei.bean.CommonServiceResult;
import com.iyoumei.bean.RewardServiceData;
import com.iyoumei.entity.UserInfo;
import com.iyoumei.entity.UserRelation;
import com.iyoumei.entity.UserRelationExample;
import com.iyoumei.entity.VipUserRecord;
import com.iyoumei.entity.VipUserRecordExample;
import com.iyoumei.entity.constant.UserRelationConstant;
import com.iyoumei.entity.constant.VipUserRecordConstant;
import com.iyoumei.mapper.UserInfoMapper;
import com.iyoumei.mapper.UserRelationMapper;
import com.iyoumei.mapper.VipUserRecordMapper;
import com.iyoumei.service.IEventRewardService;
import com.iyoumei.service.IRewardService;

public class EventRewardServiceImpl implements IEventRewardService {
	
	@Resource(type=VipUserRecordMapper.class)
	private VipUserRecordMapper vipUserRecordMapper  ;
	@Resource(type=UserRelationMapper.class)
	private UserRelationMapper relationMapper ;
	@Resource(type=UserInfoMapper.class)
	private UserInfoMapper userInfoMapper ;
	
	
	private IRewardService rewardService = null ;

	@Override
	public CommonServiceResult<?> service() {
		CommonServiceResult<?> result = null;
		VipUserRecordExample vipUserExample = new VipUserRecordExample() ;
		VipUserRecordExample.Criteria vipUserCriteria = vipUserExample.createCriteria() ;
		vipUserCriteria.andStatusEqualTo(VipUserRecordConstant.STATUS_DO_NOTHING) ;
		//TODO 设置分页
		List<VipUserRecord> recordList = this.vipUserRecordMapper.selectByExample(vipUserExample) ;
		for(VipUserRecord record : recordList) {
			this.service(record.getUserId()) ;
		}
		return result;
	}

	@Override
	public CommonServiceResult<?> service(long userId) {
		UserInfo userInfo = this.userInfoMapper.selectByPrimaryKey(userId) ;
		//VipUserRecord的处理
		VipUserRecordExample vipUserExample = new VipUserRecordExample() ;
		VipUserRecordExample.Criteria vipUserCriteria = vipUserExample.createCriteria() ;
		vipUserCriteria.andUserIdEqualTo(userId) ;
		vipUserCriteria.andStatusEqualTo(VipUserRecordConstant.STATUS_DO_NOTHING) ;
		List<VipUserRecord> recodeList = vipUserRecordMapper.selectByExample(vipUserExample);
		//UserRelation的处理
		UserRelationExample relationExample = new UserRelationExample() ;
		UserRelationExample.Criteria relationCriteria = relationExample.createCriteria() ;
		relationCriteria.andUserIdEqualTo(userId) ;
		relationCriteria.andSuperIdEqualTo(userInfo.getSuperId()) ;
		relationCriteria.andStatusEqualTo(UserRelationConstant.STATUS_DO_OK) ;
		List<UserRelation> relationList = this.relationMapper.selectByExample(relationExample) ;
		RewardServiceData data = new RewardServiceData(recodeList.get(0),relationList.get(0)) ;
		CommonServiceResult<?> result = rewardService.service(data) ;
		return result;
	}

	public IRewardService getRewardService() {
		return rewardService;
	}

	public void setRewardService(IRewardService rewardService) {
		this.rewardService = rewardService;
	}
	
}
