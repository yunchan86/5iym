package com.iyoumei.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.domain.UserCircleMsgChainDomain;

/**
 * 朋友圈评论回复
 * 
 * @author Jeff
 * 
 */
public interface UserCircleMsgChainMapper {
	/**
	 * 评论/回复/赞
	 * 
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	public int add(UserCircleMsgChainDomain domain) throws Exception;

	/**
	 * 获取消息的评论
	 * 
	 * @param msgIdList
	 * @return
	 * @throws Exception
	 */
	public List<UserCircleMsgChainDomain> list(@Param("msgId") String msgId, @Param("size") int size,
			@Param("replyType") int replyType) throws Exception;

	/**
	 * 取消赞
	 * 
	 * @param msgId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public int cancalLike(@Param("msgId") String msgId, @Param("userId") String userId) throws Exception;

	/**
	 * 删除评论
	 * 
	 * @param replyId
	 * @return
	 * @throws Exception
	 */
	public int delete(@Param("replyId") String replyId) throws Exception;

	/**
	 * 删除消息的所有评论数据
	 * @param msgId
	 * @return
	 * @throws Exception
	 */
	public int deleteMsg(String msgId) throws Exception;

	/**
	 * 获取单条回复数据
	 * 
	 * @param replyId
	 * @return
	 * @throws Exception
	 */
	public UserCircleMsgChainDomain get(@Param("replyId") String replyId, @Param("replyType") int replyType)
			throws Exception;

	/**
	 * 判断用户是否已经对消息点赞
	 * 
	 * @param msgId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public int isLiked(@Param("msgId") String msgId, @Param("userId") String userId) throws Exception;
}
