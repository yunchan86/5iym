package com.iyoumei.service;

import java.util.List;

import com.iyoumei.entity.UserCircleMsgMainDomain;

public interface IFriendTribeService {
	/**
	 * 发布消息
	 * 
	 * @param userId
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public String publishAndGetMsgId(String userId, String content) throws Exception;

	/**
	 * 保存消息图片
	 * 
	 * @param msgId
	 * @param imageDataArr
	 * @param ext
	 * @return
	 * @throws Exception
	 */
	public String savePicture(String msgId, byte[] imageDataArr, String ext) throws Exception;

	/**
	 * 评论/回复
	 * 
	 * @param userId
	 * @param msgId
	 * @param replyId
	 * @param content
	 * @return
	 * @throws Exception
	 */
	public String replyAndGetReplyId(String userId, String msgId, String replyId, String content) throws Exception;

	/**
	 * 点赞
	 * 
	 * @param userId
	 * @param msgId
	 * @return
	 * @throws Exception
	 */
	public boolean like(String userId, String msgId) throws Exception;

	/**
	 * 取消赞
	 * 
	 * @param userId
	 * @param msgId
	 * @return
	 * @throws Exception
	 */
	public boolean cancleLike(String userId, String msgId) throws Exception;

	/**
	 * 删除消息
	 * 
	 * @param userId
	 * @param msgId
	 * @return
	 * @throws Exception
	 */
	public boolean delMsg(String userId, String msgId) throws Exception;
	/**
	 * 删除回复
	 * 
	 * @param userId
	 * @param replyId
	 * @return
	 * @throws Exception
	 */
	public boolean delReply(String userId, String replyId) throws Exception;

	/**
	 * 消息列表（自己和朋友发布的动态）
	 * 
	 * @param userId
	 * @param baseMsgId
	 * @param orientation
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public List<UserCircleMsgMainDomain> list(String userId, String baseMsgId, String orientation, int size)
			throws Exception;
	/**
	 * 查看某人（包含）的发布消息列表
	 * @param userId
	 * @param baseMsgId
	 * @param orientation
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public List<UserCircleMsgMainDomain> userMsglist(String userId, String baseMsgId, String orientation, int size)
			throws Exception;
	
	

	/**
	 * 获取单条消息
	 * 
	 * @param userId
	 * @param msgId
	 * @return
	 * @throws Exception
	 */
	public UserCircleMsgMainDomain getMsg(String userId, String msgId) throws Exception;

}
