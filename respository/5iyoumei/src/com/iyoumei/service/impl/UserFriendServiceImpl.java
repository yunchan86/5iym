package com.iyoumei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.easemob.server.jersey.api.EasemobIMUsers;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.domain.UserFriendDomain;
import com.iyoumei.domain.UserInfoDomain;
import com.iyoumei.domain.UserRelationsDomain;
import com.iyoumei.modeldriver.UserRelationsMd;
import com.iyoumei.persistence.UserFriendInfoMapper;
import com.iyoumei.persistence.UserInfoMapper;
import com.iyoumei.persistence.UserRelationsMapper;
import com.iyoumei.service.IUserFriendService;
import com.iyoumei.util.HXResultUtil;
import com.iyoumei.util.StringUtil;
import com.iyoumei.util.bean.LogBean;
import com.iyoumei.util.enumcollection.RespCode;

public class UserFriendServiceImpl implements IUserFriendService {

	private LogBean logbean = null;

	@Resource(type = UserInfoMapper.class)
	private UserInfoMapper userInfoMapper;

	@Resource(type = UserRelationsMapper.class)
	private UserRelationsMapper userRelationsMapper;

	@Resource(type = UserFriendInfoMapper.class)
	private UserFriendInfoMapper userFriendMapper;

	@Override
	@Transactional
	public ResultDataBean<UserRelationsDomain> addFriend(long selfUserId, long addUserId) {
		ResultDataBean<UserRelationsDomain> result = new ResultDataBean<UserRelationsDomain>();
		if (logbean == null)
			logbean = new LogBean("UserFriendServiceImpl::addFriend", "none", "none", "none");
		try {
			if (selfUserId == 0 || addUserId == 0) {
				result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
				logbean.setContentException("your user_id or friend user_id is null.", null);
				return result;
			}
			UserInfoDomain userInfoDomain = this.userInfoMapper.selectByUserId(String.valueOf(selfUserId));
			if (userInfoDomain == null) {
				result.setMsgCode(RespCode.USER_NOT_EXISTS.getCode(), RespCode.USER_NOT_EXISTS.getDetail());
				logbean.setContentException("user_id[" + selfUserId + "] is not exists.", null);
				return result;
			}
			UserInfoDomain userInfoAddDomain = this.userInfoMapper.selectByUserId(String.valueOf(addUserId));
			if (userInfoAddDomain == null) {
				result.setMsgCode(RespCode.FRIEND_NOT_EXISTS.getCode(), RespCode.FRIEND_NOT_EXISTS.getDetail());
				logbean.setContentException("friend user_id[" + selfUserId + "] is not exists.", null);
				return result;
			}
			UserRelationsDomain userRelations = this.userRelationsMapper.selectByPrimaryKey(selfUserId, addUserId);
			if (userRelations != null) {
				result.setMsgCode(RespCode.FRIEND_ALREADY.getCode(), RespCode.FRIEND_ALREADY.getDetail());
				logbean.setContentException("user_id[" + selfUserId + "]friend user_id[" + selfUserId + "] has added",
						null);
				return result;
			}
			ObjectNode imObject = EasemobIMUsers.addFriendSingle(String.valueOf(selfUserId), String.valueOf(addUserId));
			logbean.setContentException("添加环信好友列表返回值为" + imObject, null);
			boolean hxLinked = true;
			if (selfUserId != addUserId) {
				if (HXResultUtil.isSuccess(imObject)) {
					logbean.setContentException("add friend[" + selfUserId + "," + addUserId
							+ "] of huaxin successfully!", null);
				} else {
					hxLinked = false;
					result.setMsgCodeData(RespCode.FRIEND_HX_ERROR.getCode(), RespCode.FRIEND_HX_ERROR.getDetail(),
							userRelations);
					logbean.setContentException("Failed to query account of huaxin", null);
				}
			}
			if (hxLinked) {
				UserRelationsDomain userRelationsDomain = this.initUserRelationDomain(selfUserId, addUserId);
				this.userRelationsMapper.insertSelective(userRelationsDomain);
				if (selfUserId != addUserId) {// 不是关联自己时，需要为申请人建立关联
					UserRelationsDomain userRelationsDomainRef = this.initUserRelationDomain(addUserId, selfUserId);
					this.userRelationsMapper.insertSelective(userRelationsDomainRef);
				}
				result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), userRelations);
			}
		} catch (Exception e) {
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("添加好友处理产生异常：", e);
		}
		return result;
	}

	private UserRelationsDomain initUserRelationDomain(long userId, long friendUserId) {
		UserRelationsDomain userRelationsDomain = new UserRelationsDomain();
		userRelationsDomain.setUserId1(userId);
		userRelationsDomain.setUserId2(friendUserId);
		userRelationsDomain.setSource("00");
		return userRelationsDomain;
	}

	@Override
	public ResultDataBean<List<UserFriendDomain>> getFriendList(long selfUserId) {
		ResultDataBean<List<UserFriendDomain>> result = new ResultDataBean<List<UserFriendDomain>>();
		if (logbean == null)
			logbean = new LogBean("UserFriendServiceImpl::getFriendList", "none", "none", "none");
		List<UserFriendDomain> list = null;
		try {
			list = userFriendMapper.getUserFriendList(selfUserId);
			result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), list);
			logbean.setContentException("user[" + selfUserId + "] query friend's list success.", null);
		} catch (Exception e) {
			result.setMsgCodeData(RespCode.FRIEDN_LIST_ERROR.getCode(), RespCode.FRIEDN_LIST_ERROR.getDetail(), null);
			logbean.setContentException("99", e);
		}
		return result;
	}

	@Override
	public ResultDataBean<UserFriendDomain> getFriendInfo(long selfUserId, long userId) {
		ResultDataBean<UserFriendDomain> result = new ResultDataBean<UserFriendDomain>();
		if (logbean == null)
			logbean = new LogBean("UserFriendServiceImpl::getFriendList", "none", "none", "none");
		try {
			UserFriendDomain userFriend = userFriendMapper.getUserFriendInfo(selfUserId, userId);
			if (userFriend == null) {
				result.setMsgCodeData(RespCode.FRIEND_NOT_EXISTS.getCode(), RespCode.FRIEND_NOT_EXISTS.getDetail(),
						null);
				logbean.setContentException("user[" + selfUserId + "] query friend[" + userId + "] is not exists.",
						null);
			} else {
				result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), userFriend);
				logbean.setContentException("user[" + selfUserId + "] query friend[" + userId + "] info success.", null);
			}
		} catch (Exception e) {
			result.setMsgCodeData(RespCode.FRIEND_INFO_ERROR.getCode(), RespCode.FRIEND_INFO_ERROR.getDetail(), null);
			logbean.setContentException("99", e);
		}
		return result;
	}

	@Override
	public ResultDataBean<?> delFriend(long selfUserId, long delUserId) {
		ResultDataBean<String> result = new ResultDataBean<String>();
		if (logbean == null)
			logbean = new LogBean("UserFriendServiceImpl::delFriend", "none", "none", "none");
		try {
			ObjectNode imObject = EasemobIMUsers.deleteFriendSingle(String.valueOf(selfUserId),
					String.valueOf(delUserId));
			if (HXResultUtil.isSuccess(imObject)) {
				this.userRelationsMapper.deleteByPrimaryKey(selfUserId, delUserId);
				this.userRelationsMapper.deleteByPrimaryKey(delUserId, selfUserId);
				result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), null);
				logbean.setContentException("user[" + selfUserId + "] delete friend[" + delUserId + "] success.", null);
			} else {
				result.setMsgCodeData(RespCode.FRIEND_DELETE_ERROR.getCode(), RespCode.FRIEND_DELETE_ERROR.getDetail(),
						null);
				logbean.setContentException("user[" + selfUserId + "] delete friend[" + delUserId + "] success.", null);
			}
		} catch (Exception e) {
			result.setMsgCodeData(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail(), null);
			logbean.setContentException("99", e);
		}
		return result;
	}

	public void setLogbean(LogBean logbean) {
		this.logbean = logbean;
	}

	@Override
	public ResultDataBean<?> updateFriendTag(long selfUserId, long userId, String tag) {
		ResultDataBean<String> result = new ResultDataBean<String>();
		if (logbean == null)
			logbean = new LogBean("UserFriendServiceImpl::updateFriendTag", "none", "none", "none");
		try {
			UserRelationsDomain userRelations = new UserRelationsDomain();
			userRelations.setUserId1(selfUserId);
			userRelations.setUserId2(userId);
			userRelations.setTag(tag);
			int num = this.userRelationsMapper.updateByPrimaryKeySelective(userRelations);
			if (num > 0) {
				result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), null);
				logbean.setContentException("user[" + selfUserId + "] modify friend[" + userId + "] tag success.", null);
			} else {
				result.setMsgCodeData(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail(), null);
				logbean.setContentException("user[" + selfUserId + "] modify friend[" + userId + "] tag error.", null);
			}
		} catch (Exception e) {
			result.setMsgCodeData(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail(), null);
			logbean.setContentException("99", e);
		}
		return result;
	}

	@Override
	public ResultDataBean<?> updateFriendLabel(long selfUserId, long userId, String label) {
		ResultDataBean<String> result = new ResultDataBean<String>();
		if (logbean == null)
			logbean = new LogBean("UserFriendServiceImpl::updateFriendTag", "none", "none", "none");
		try {
			UserRelationsDomain userRelations = new UserRelationsDomain();
			userRelations.setUserId1(selfUserId);
			userRelations.setUserId2(userId);
			userRelations.setLabel(label);
			int num = this.userRelationsMapper.updateLabel(userRelations);
			if (num > 0) {
				result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), null);
				logbean.setContentException("user[" + selfUserId + "] modify friend[" + userId + "] tag success.", null);
			} else {
				result.setMsgCodeData(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail(), null);
				logbean.setContentException("user[" + selfUserId + "] modify friend[" + userId + "] tag error.", null);
			}
		} catch (Exception e) {
			result.setMsgCodeData(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail(), null);
			logbean.setContentException("99", e);
		}
		return result;
	}

	@Override
	public ResultDataBean<?> addBlacklist(long selfUserId, long userId) {
		ResultDataBean<String> result = new ResultDataBean<String>();
		if (logbean == null)
			logbean = new LogBean("UserFriendServiceImpl::updateFriendTag", "none", "none", "none");
		try {
			UserFriendDomain userFriend = userFriendMapper.getUserFriendInfo(selfUserId, userId);
			if (userFriend == null) {
				result.setMsgCodeData(RespCode.FRIEND_NOT_EXISTS.getCode(), RespCode.FRIEND_NOT_EXISTS.getDetail(),
						null);
				logbean.setContentException("user[" + selfUserId + "] query friend[" + userId + "] is not exists.",
						null);
			}
			int num = this.userRelationsMapper.updateBlacklist(selfUserId, userId);
			if (num > 0) {
				result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), null);
				logbean.setContentException("user[" + selfUserId + "] add friend[" + userId + "] blacklist success.",
						null);
			} else {
				result.setMsgCodeData(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail(), null);
				logbean.setContentException("user[" + selfUserId + "] add friend[" + userId + "] blacklist error.",
						null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsgCodeData(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail(), null);
			logbean.setContentException("99", e);
		}
		return result;
	}

	public ResultDataBean<?> auth(UserRelationsMd md) {
		ResultDataBean<String> result = new ResultDataBean<String>();
		if (logbean == null)
			logbean = new LogBean("UserFriendServiceImpl::updateFriendTag", "none", "none", "none");
		try {
			UserRelationsDomain userRelateions = Md2UserRelationsDomain(md);
			UserFriendDomain userFriend = userFriendMapper.getUserFriendInfo(userRelateions.getUserId1(),
					userRelateions.getUserId2());
			if (userFriend == null) {
				result.setMsgCodeData(RespCode.FRIEND_NOT_EXISTS.getCode(), RespCode.FRIEND_NOT_EXISTS.getDetail(),
						null);
				logbean.setContentException(
						"user[" + userRelateions.getUserId1() + "] query friend[" + userRelateions.getUserId2()
								+ "] is not exists.", null);
			}
			int num = this.userRelationsMapper.updateAuth(userRelateions);
			if (num > 0) {
				result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), null);
				logbean.setContentException(
						"user[" + userRelateions.getUserId1() + "] add friend[" + userRelateions.getUserId2()
								+ "] authorization success.", null);
			} else {
				result.setMsgCodeData(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail(), null);
				logbean.setContentException(
						"user[" + userRelateions.getUserId1() + "] add friend[" + userRelateions.getUserId2()
								+ "] authorization error.", null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsgCodeData(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail(), null);
			logbean.setContentException("99", e);
		}
		return result;
	}

	private UserRelationsDomain Md2UserRelationsDomain(UserRelationsMd md) {
		UserRelationsDomain userRelateions = new UserRelationsDomain();
		if (!StringUtil.isNull(md.getUserId()))
			userRelateions.setUserId1(Long.parseLong(md.getUserId()));
		if (!StringUtil.isNull(md.getFriendUserId()))
			userRelateions.setUserId2(Long.parseLong(md.getFriendUserId()));
		if (!StringUtil.isNull(md.getRegular()))
			userRelateions.setRegularFriend(Integer.parseInt(md.getRegular()));
		;
		if (!StringUtil.isNull(md.getViewCircle()))
			userRelateions.setFriendCircle1(Integer.parseInt(md.getUserId()));
		if (!StringUtil.isNull(md.getViewMap()))
			userRelateions.setFriendMap(Integer.parseInt(md.getViewMap()));
		return userRelateions;
	}

	@Override
	public ResultDataBean<List<UserFriendDomain>> getDailyFriendList(long selfUserId) {
		ResultDataBean<List<UserFriendDomain>> result = new ResultDataBean<List<UserFriendDomain>>();
		if (logbean == null)
			logbean = new LogBean("UserFriendServiceImpl::getFriendList", "none", "none", "none");
		List<UserFriendDomain> list = null;
		try {
			list = userFriendMapper.getDailyUserFriendList(selfUserId);
			result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), list);
			logbean.setContentException("user[" + selfUserId + "] query daily friend's list success.", null);
		} catch (Exception e) {
			result.setMsgCodeData(RespCode.FRIEDN_LIST_ERROR.getCode(), RespCode.FRIEDN_LIST_ERROR.getDetail(), null);
			logbean.setContentException("99", e);
		}
		return result;
	}

	@Override
	public boolean isFriend(String userId, String firendUserId) throws Exception {
		UserRelationsDomain domain = userRelationsMapper.selectByPrimaryKey(Long.parseLong(userId, 10),
				Long.parseLong(firendUserId, 10));
		if (domain != null)
			return true;
		return false;
	}

}
