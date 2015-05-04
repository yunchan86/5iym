package com.iyoumei.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 朋友圈发布消息
 * 
 * @author Jeff
 * 
 */
public class UserCircleMsgMainDomain implements Serializable {

	private static final long serialVersionUID = -6717298721199842198L;
	private String messageId;// 消息ID
	private String userId;// 发布用户ID
	private String userName;//发布人名称
	private String userIcon;// 发布人头像
	private Date pubTime;// 发布时间
	private String content;// 发布内容
	private int priseTiems;// 赞数

	private List<UserCircleMsgChainDomain> likeList;
	private List<UserCircleMsgChainDomain> replyList;
	private List<UserCircleMsgPicturesDomain> picList;// 图片列表
	private boolean isLiked;// 是否已经点赞（当前登录用户）

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getPubTime() {
		return pubTime;
	}

	public void setPubTime(Date pubTime) {
		this.pubTime = pubTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPriseTiems() {
		return priseTiems;
	}

	public void setPriseTiems(int priseTiems) {
		this.priseTiems = priseTiems;
	}

	public List<UserCircleMsgChainDomain> getLikeList() {
		return likeList;
	}

	public void setLikeList(List<UserCircleMsgChainDomain> likeList) {
		this.likeList = likeList;
	}

	public List<UserCircleMsgChainDomain> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<UserCircleMsgChainDomain> replyList) {
		this.replyList = replyList;
	}

	public List<UserCircleMsgPicturesDomain> getPicList() {
		return picList;
	}

	public void setPicList(List<UserCircleMsgPicturesDomain> picList) {
		this.picList = picList;
	}

	public boolean isLiked() {
		return isLiked;
	}

	public void setLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

}
