package com.iyoumei.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.iyoumei.bean.LoginBean;
import com.iyoumei.entity.UserInfoDomain;
import com.iyoumei.entity.UserInfoHXLogDomain;
import com.iyoumei.mapper1.UserInfoHXLogMapper;
import com.iyoumei.mapper1.UserInfoMapper;
import com.iyoumei.mapper1.UuidMapper;
import com.iyoumei.modeldriver.RegisterMd;
import com.iyoumei.service.IRegisterService;
import com.iyoumei.service.IUserFriendService;
import com.iyoumei.util.HXUserUtil;
import com.iyoumei.util.enumcollection.ApproveType;
import com.iyoumei.util.enumcollection.GenderCode;
import com.iyoumei.util.enumcollection.MobileVerifyStatus;
import com.iyoumei.util.enumcollection.RespCode;
import com.iyoumei.util.enumcollection.UserStatus;
import com.iyoumei.util.enumcollection.UserType;

public class RegisterServiceImpl implements IRegisterService {
	@Resource(type = UserInfoMapper.class)
	private UserInfoMapper userInfoMapper;
	@Resource(type = UuidMapper.class)
	private UuidMapper uuidMapper;
	@Resource(type = UserInfoHXLogMapper.class)
	private UserInfoHXLogMapper userInfoHXLogMapper;
	private IUserFriendService userFriendService;

	@Override
	public boolean isMobileRegister(String mobileNumber) throws Exception {
		return userInfoMapper.isMobileNumberRegsiter(mobileNumber) > 0 ? true : false;
	}

	@Override
	@Transactional
	public synchronized LoginBean register(RegisterMd md) throws Exception {
		LoginBean bean = new LoginBean();
		if (isMobileRegister(md.getMobileNumber())) {
			bean.setCode(RespCode.MOBILE_REGISTED.getCode());
			UserInfoDomain domain = this.userInfoMapper.selectByMobileNumber(md.getMobileNumber()) ;
			bean.setUserId(domain.getUserId());
			bean.setUserIcon(domain.getUserIcon());
		} else {
			UserInfoDomain domain = new UserInfoDomain();
			domain.setUserId(uuidMapper.getUuidShort());
			domain.setMobileNumber(md.getMobileNumber());
			domain.setMobileVerifyStatus(MobileVerifyStatus.unverified.getCode());
			domain.setPassword(md.getPwd());
			domain.setGender(GenderCode.unkonw.getCode());
			domain.setApproveType(ApproveType.validate.getType());
			domain.setShowInMap(1);// 是否开启好友地图，开启后好友在地图中可以查看该人 0-不开启 1-开启
			domain.setPicViewLimit(0);// 陌生人图片查看权限，陌生人查看图片存在张数限制 0-不允许查看 1-允许查看
			domain.setNewMessageSwitch(0);// 新消息推送开关 0:接收新消息推送;1:不接收新推送 默认值为0
			domain.setStrangerMessageSwitch(0);// 陌生人临时会话开关0:开启临时会话;1:关闭临时会话
												// 默认值为0
			domain.setUserType(UserType.common.getType());
			domain.setStatus(UserStatus.common.getCode());
			userInfoMapper.insert(domain);
			userFriendService.addFriend(Long.parseLong(domain.getUserId(), 10), Long.parseLong(domain.getUserId(), 10));// 与自己建立关系
			UserInfoHXLogDomain userInfoHXLog = new UserInfoHXLogDomain();
			userInfoHXLog.setUserId(Long.parseLong(domain.getUserId()));
			userInfoHXLog.setPassword(HXUserUtil.getPassword(domain));
			this.userInfoHXLogMapper.insert(userInfoHXLog);
			bean.setCode(RespCode.SUCCESS.getCode());
			bean.setUserId(domain.getUserId());
			bean.setUserIcon(domain.getUserIcon());

		}
		return bean;
	}

	public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
		this.userInfoMapper = userInfoMapper;
	}

	public void setUuidMapper(UuidMapper uuidMapper) {
		this.uuidMapper = uuidMapper;
	}

	public void setUserInfoHXLogMapper(UserInfoHXLogMapper userInfoHXLogMapper) {
		this.userInfoHXLogMapper = userInfoHXLogMapper;
	}

	public void setUserFriendService(IUserFriendService userFriendService) {
		this.userFriendService = userFriendService;
	}

}
