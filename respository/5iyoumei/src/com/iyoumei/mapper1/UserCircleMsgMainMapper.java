package com.iyoumei.mapper1;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.entity.UserCircleMsgMainDomain;

/**
 * 朋友圈发布消息
 * 
 * @author Jeff
 * 
 */
public interface UserCircleMsgMainMapper {
	/**
	 * 发布消息
	 * 
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	public int add(UserCircleMsgMainDomain domain) throws Exception;

	/**
	 * 赞
	 * 
	 * @param msgId
	 * @return
	 * @throws Exception
	 */
	public int like(String msgId) throws Exception;

	/**
	 * 取消赞
	 * 
	 * @param msgId
	 * @return
	 * @throws Exception
	 */
	public int cancleLike(String msgId) throws Exception;

	/**
	 * 删除消息
	 * 
	 * @param messageId
	 * @return
	 * @throws Exception
	 */
	public int remove(String messageId) throws Exception;

	/**
	 * 消息列表（自己及朋友发布的消息）
	 * 
	 * @param userId
	 * @param baseTime
	 * @param orientation
	 *            (p:previous,n:next)
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public List<UserCircleMsgMainDomain> list(@Param("userId") String userId, @Param("baseTime") Date baseTime,
			@Param("orientation") String orientation, @Param("size") int size) throws Exception;
	/**
	 * 获取某人（包含自己）的朋友圈消息列表
	 * @param userId
	 * @param baseTime
	 * @param orientation
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public List<UserCircleMsgMainDomain> userMsglist(@Param("userId") String userId, @Param("baseTime") Date baseTime,
			@Param("orientation") String orientation, @Param("size") int size) throws Exception;

	/**
	 * 获取单个信息
	 * 
	 * @param msgId
	 * @return
	 * @throws Exception
	 */
	public UserCircleMsgMainDomain get(String msgId) throws Exception;

}
