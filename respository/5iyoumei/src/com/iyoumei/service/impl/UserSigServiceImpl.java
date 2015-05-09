package com.iyoumei.service.impl;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.annotation.Resource;

import com.iyoumei.entity.UserSigDomain;
import com.iyoumei.mapper1.UserSigMapper;
import com.iyoumei.mapper1.UuidMapper;
import com.iyoumei.service.IUserSigService;
import com.iyoumei.util.UtilMethods;

public class UserSigServiceImpl implements IUserSigService {
	@Resource(type = UserSigMapper.class)
	private UserSigMapper userSigMapper;
	@Resource(type = UuidMapper.class)
	private UuidMapper uuidMapper;

	private static Lock lock = new ReentrantLock();

	@Override
	public UserSigDomain getUserSig(String userId, String uuid, String callType) throws Exception {
		UserSigDomain domain = null;
		domain = userSigMapper.select(userId, uuid, callType);
		return domain;
	}

	@Override
	public int updateUserSig(UserSigDomain domain) throws Exception {
		int count = userSigMapper.update(domain);
		return count;
	}

	@Override
	public UserSigDomain getUserSigOnLogin(String userId, String uuid, String callType) throws Exception {
		UserSigDomain userSig = this.userSigMapper.select(userId, uuid, callType);
		if (userSig == null) {// 首次登录生成usersig
			lock.lock();
			try {
				userSig = userSigMapper.select(userId, uuid, callType);
				if (userSig == null) {
					userSig = new UserSigDomain();
					userSig.setId(uuidMapper.getUuidShort());
					Date now = new Date();
					userSig.setInsert_time(now);
					userSig.setUser_id(userId);
					userSig.setSig(UtilMethods.genSigOf24length());
					userSig.setStatus("1");// 已经登录
					userSig.setTerminal_type(callType);
					userSig.setUuid(uuid);
					userSigMapper.insert(userSig);
				}
			} finally {
				lock.unlock();
			}
		} else {
			userSig.setUser_id(userId);
			userSig.setStatus("1");// 已经登录
			userSigMapper.update(userSig);
			userSigMapper.forbiddenOtherLoginInfo(userId, uuid);
		}
		return userSig;
	}

	@Override
	public void updateUserSigOnLogout(String userId, String uuid, String callType) throws Exception {
		UserSigDomain userSig = userSigMapper.select(userId, uuid, callType);
		if (userSig != null) {// 首次登录生成usersig
			userSig.setStatus("0");// 已经登出
			userSigMapper.update(userSig);
		}

	}

	public void setUserSigMapper(UserSigMapper userSigMapper) {
		this.userSigMapper = userSigMapper;
	}

	public void setUuidMapper(UuidMapper uuidMapper) {
		this.uuidMapper = uuidMapper;
	}

}
