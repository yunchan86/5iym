package com.iyoumei.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息回复
 * 
 * @author Jeff
 * 
 */
public class UserCircleMsgChainDomain implements Serializable {
	private static final long serialVersionUID = 8381183242129287186L;
	private String replyId;// 回复ID
	private String messageId;// 消息ID
	private String sourceUserId;// 消息源用户ID
	private String sourceUserName;// 消息源用户Id
	private String sourceUserIdIconUrl;// 消息源用户头像地址
	private String sourceUserCarBrandIcon;// 消息源用户的车标
	private String replyUserId;// 消息回复人ID
	private String replyUserName;// 消息回复用户Id
	private String replyUserIdIconUrl;// 消息回复用户头像地址
	private String replyUserCarBrandIcon;// 消息回复用户的车标
	private Date replyTime;// 回复时间
	private String replyContent;// 回复内容
	private int replyType;// 回复类型 0-赞 1-评论回复

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getSourceUserId() {
		return sourceUserId;
	}

	public void setSourceUserId(String sourceUserId) {
		this.sourceUserId = sourceUserId;
	}

	public String getSourceUserName() {
		return sourceUserName;
	}

	public void setSourceUserName(String sourceUserName) {
		this.sourceUserName = sourceUserName;
	}

	public String getSourceUserIdIconUrl() {
		return sourceUserIdIconUrl;
	}

	public void setSourceUserIdIconUrl(String sourceUserIdIconUrl) {
		this.sourceUserIdIconUrl = sourceUserIdIconUrl;
	}

	public String getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(String replyUserId) {
		this.replyUserId = replyUserId;
	}

	public String getReplyUserName() {
		return replyUserName;
	}

	public void setReplyUserName(String replyUserName) {
		this.replyUserName = replyUserName;
	}

	public String getReplyUserIdIconUrl() {
		return replyUserIdIconUrl;
	}

	public void setReplyUserIdIconUrl(String replyUserIdIconUrl) {
		this.replyUserIdIconUrl = replyUserIdIconUrl;
	}

	public Date getReplyTime() {
		return replyTime;
	}

	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public int getReplyType() {
		return replyType;
	}

	public void setReplyType(int replyType) {
		this.replyType = replyType;
	}

	public String getSourceUserCarBrandIcon() {
		return sourceUserCarBrandIcon;
	}

	public void setSourceUserCarBrandIcon(String sourceUserCarBrandIcon) {
		this.sourceUserCarBrandIcon = sourceUserCarBrandIcon;
	}

	public String getReplyUserCarBrandIcon() {
		return replyUserCarBrandIcon;
	}

	public void setReplyUserCarBrandIcon(String replyUserCarBrandIcon) {
		this.replyUserCarBrandIcon = replyUserCarBrandIcon;
	}

}
