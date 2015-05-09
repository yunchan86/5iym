package com.iyoumei.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.entity.UserFriendDomain;
import com.iyoumei.modeldriver.UserRelationsMd;
import com.iyoumei.util.bean.LogBean;

public interface IUserFriendService {

	Log log = LogFactory.getLog(IUserFriendService.class);

	public ResultDataBean<?> addFriend(long selfUserId, long addUserId);

	public ResultDataBean<List<UserFriendDomain>> getFriendList(long selfUserId);

	public ResultDataBean<List<UserFriendDomain>> getDailyFriendList(long selfUserId);

	public ResultDataBean<?> delFriend(long selfUserId, long delUserId);

	public void setLogbean(LogBean logbean);// 日志操作的处理

	ResultDataBean<UserFriendDomain> getFriendInfo(long selfUserId, long userId);

	ResultDataBean<?> updateFriendTag(long selfUserId, long userId, String tag);

	public ResultDataBean<?> updateFriendLabel(long selfUserId, long userId, String label);

	public ResultDataBean<?> addBlacklist(long selfUserId, long userId);

	public ResultDataBean<?> auth(UserRelationsMd md);

	/**
	 * 是否好友
	 * 
	 * @param userId
	 *            自己的Id
	 * @param firendUserId
	 *            待查询的Id
	 * @return
	 * @throws Exception
	 */
	public boolean isFriend(String userId, String firendUserId) throws Exception;
}
