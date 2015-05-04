package com.iyoumei.persistence;

import java.util.List;

import com.iyoumei.domain.UserCircleMsgPicturesDomain;

/**
 * 朋友圈发布图片
 * 
 * @author Jeff
 * 
 */
public interface UserCircleMsgPictureMapper {
	/**
	 * 发布消息图片
	 * 
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	public int add(UserCircleMsgPicturesDomain domain) throws Exception;
	/**
	 * 删除消息的所有图片
	 * @param msgId
	 * @return
	 * @throws Exception
	 */
	public int deleteMsgId(String msgId) throws Exception;

	/**
	 * 获取消息的图片列表
	 * 
	 * @param msgIdList
	 * @return
	 * @throws Exception
	 */
	public List<UserCircleMsgPicturesDomain> list(String msgId) throws Exception;
}
