package com.iyoumei.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.iyoumei.domain.UserCircleMsgChainDomain;
import com.iyoumei.domain.UserCircleMsgMainDomain;
import com.iyoumei.domain.UserCircleMsgPicturesDomain;
import com.iyoumei.gearman.client.EvaluateUpClient;
import com.iyoumei.gearman.client.FacJobClient;
import com.iyoumei.persistence.UserCircleMsgChainMapper;
import com.iyoumei.persistence.UserCircleMsgMainMapper;
import com.iyoumei.persistence.UserCircleMsgPictureMapper;
import com.iyoumei.persistence.UuidMapper;
import com.iyoumei.service.IFriendTribeService;
import com.iyoumei.util.FTPUtil;
import com.iyoumei.util.enumcollection.ReplyType;

public class FriendTribeServiceImpl implements IFriendTribeService {
	private static Log logger = LogFactory.getLog(FriendTribeServiceImpl.class);
	@Resource(type = UserCircleMsgMainMapper.class)
	private UserCircleMsgMainMapper mainMapper;
	@Resource(type = UserCircleMsgPictureMapper.class)
	private UserCircleMsgPictureMapper pictureMapper;
	@Resource(type = UserCircleMsgChainMapper.class)
	private UserCircleMsgChainMapper chainMapper;
	@Resource(type = UuidMapper.class)
	private UuidMapper uuidMapper;

	private String iconUrlPrefix;

	@Override
	public String publishAndGetMsgId(String userId, String content) throws Exception {
		String uuidShort = uuidMapper.getUuidShort();
		UserCircleMsgMainDomain domain = new UserCircleMsgMainDomain();
		domain.setMessageId(userId);
		domain.setMessageId(uuidShort);
		domain.setPriseTiems(0);
		domain.setUserId(userId);
		domain.setContent(content);
		mainMapper.add(domain);
		return uuidShort;
	}

	@Override
	public String savePicture(String msgId, byte[] imageDataArr, String ext) throws Exception {
		String iconUrl = null;
		// 上传图片文件(给图像加上序列号，防止客户端缓存时显示旧头像）
		String icon = msgId + "_" + uuidMapper.getUuidShort() + "." + ext;
		boolean flag = FTPUtil.uploadFile("images", "publish", icon, imageDataArr);
		if (flag) {
			iconUrl = iconUrlPrefix + "images/publish/" + icon;
			UserCircleMsgPicturesDomain domain = new UserCircleMsgPicturesDomain();
			domain.setMessageId(msgId);
			domain.setPicUrl(iconUrl);
			pictureMapper.add(domain);
		}
		return iconUrl;
	}

	@Override
	public String replyAndGetReplyId(String userId, String msgId, String replyId, String content) throws Exception {
		String replyIdReturn = uuidMapper.getUuidShort();
		UserCircleMsgChainDomain domain = new UserCircleMsgChainDomain();
		domain.setMessageId(msgId);
		domain.setReplyId(replyIdReturn);
		domain.setReplyUserId(userId);
		if (!StringUtils.isEmpty(replyId)) {
			UserCircleMsgChainDomain replyDomain = chainMapper.get(replyId, 1);
			domain.setSourceUserId(replyDomain.getReplyUserId());
		}
		domain.setReplyContent(content);
		domain.setReplyType(ReplyType.reply.getType());
		chainMapper.add(domain);
		return replyIdReturn;
	}

	@Override
	@Transactional
	public boolean like(String userId, String msgId) throws Exception {
		if (chainMapper.isLiked(msgId, userId) == 0) {
			mainMapper.like(msgId);
			String replyIdReturn = uuidMapper.getUuidShort();
			UserCircleMsgChainDomain domain = new UserCircleMsgChainDomain();
			domain.setMessageId(msgId);
			domain.setReplyId(replyIdReturn);
			domain.setReplyUserId(userId);
			domain.setReplyType(ReplyType.like.getType());
			chainMapper.add(domain);
			//FacJobClient.submitBackground(new EvaluateUpClient(), "common-worker","transmission", new String[]{"user_id="+userId,"msg_id="+msgId});
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean cancleLike(String userId, String msgId) throws Exception {
		if (chainMapper.isLiked(msgId, userId) > 0) {
			mainMapper.cancleLike(msgId);
			chainMapper.cancalLike(msgId, userId);
		}
		return true;
	}

	@Override
	@Transactional
	public boolean delMsg(String userId, String msgId) throws Exception {
		UserCircleMsgMainDomain mainDomain = mainMapper.get(msgId);
		if (mainDomain == null)
			return true;
		if (StringUtils.equals(userId, mainDomain.getUserId())) {// 是消息发布人
			mainMapper.remove(msgId);
			chainMapper.deleteMsg(msgId);
			final List<UserCircleMsgPicturesDomain> picList = pictureMapper.list(msgId);
			pictureMapper.deleteMsgId(msgId);
			new Thread() {
				public void run() {
					if (picList != null && !picList.isEmpty()) {
						for (UserCircleMsgPicturesDomain domain : picList) {
							String url = domain.getPicUrl();
							String filename = url.substring(url.lastIndexOf("/"));
							try {
								FTPUtil.deleteFile("images", "publish", filename);
							} catch (Exception e) {
								logger.error("", e);
							}
						}
					}
				};
			}.start();
			return true;
		}
		return false;
	}

	@Override
	public boolean delReply(String userId, String replyId) throws Exception {
		UserCircleMsgChainDomain chainDomain = chainMapper.get(replyId, 1);
		if (StringUtils.equals(userId, chainDomain.getReplyUserId())) {// 是消息回复人
			chainMapper.delete(replyId);
			return true;
		} else {
			UserCircleMsgMainDomain mainDomain = mainMapper.get(chainDomain.getMessageId());
			if (StringUtils.equals(userId, mainDomain.getUserId())) {// 是消息发布人
				chainMapper.delete(replyId);
				return true;
			}
		}
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserCircleMsgMainDomain> list(String userId, String baseMsgId, String orientation, int size)
			throws Exception {
		Date baseTime = null;// 查询基准时间
		if (!StringUtils.isEmpty(baseMsgId)) {
			UserCircleMsgMainDomain mainDomain = mainMapper.get(baseMsgId);
			if (mainDomain != null)
				baseTime = mainDomain.getPubTime();
		}
		List<UserCircleMsgMainDomain> list = mainMapper.list(userId, baseTime, orientation, size);
		if (list != null && list.size() > 0) {
			for (UserCircleMsgMainDomain domain : list) {
				domain.setLikeList(getChainList(domain.getMessageId(), ReplyType.like.getType(), 10));// 喜欢列表
				domain.setReplyList(getChainList(domain.getMessageId(), ReplyType.reply.getType(), 10));// 回复列表
				domain.setLiked(chainMapper.isLiked(domain.getMessageId(), userId) > 0 ? true : false);
				domain.setPicList(pictureMapper.list(domain.getMessageId()));// 设置图片
			}
		}
		return list;
	}

	@Override
	public List<UserCircleMsgMainDomain> userMsglist(String userId, String baseMsgId, String orientation, int size)
			throws Exception {
		Date baseTime = null;// 查询基准时间
		if (!StringUtils.isEmpty(baseMsgId)) {
			UserCircleMsgMainDomain mainDomain = mainMapper.get(baseMsgId);
			if (mainDomain != null)
				baseTime = mainDomain.getPubTime();
		}
		List<UserCircleMsgMainDomain> list = mainMapper.userMsglist(userId, baseTime, orientation, size);
		if (list != null && list.size() > 0) {
			for (UserCircleMsgMainDomain domain : list) {
				domain.setLikeList(getChainList(domain.getMessageId(), ReplyType.like.getType(), 10));// 喜欢列表
				domain.setReplyList(getChainList(domain.getMessageId(), ReplyType.reply.getType(), 10));// 回复列表
				domain.setLiked(chainMapper.isLiked(domain.getMessageId(), userId) > 0 ? true : false);
				domain.setPicList(pictureMapper.list(domain.getMessageId()));// 设置图片
			}
		}
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public UserCircleMsgMainDomain getMsg(String userId, String msgId) throws Exception {
		UserCircleMsgMainDomain domain = mainMapper.get(msgId);
		domain.setLikeList(getChainList(domain.getMessageId(), ReplyType.like.getType(), -1));// 喜欢列表
		domain.setReplyList(getChainList(domain.getMessageId(), ReplyType.reply.getType(), -1));// 回复列表
		domain.setLiked(chainMapper.isLiked(domain.getMessageId(), userId) > 0 ? true : false);
		domain.setPicList(pictureMapper.list(domain.getMessageId()));// 设置图片
		return domain;
	}

	private List<UserCircleMsgChainDomain> getChainList(String msgId, int replyType, int size) throws Exception {
		return chainMapper.list(msgId, size, replyType);
	}

	public void setIconUrlPrefix(String iconUrlPrefix) {
		this.iconUrlPrefix = iconUrlPrefix;
	}

}
