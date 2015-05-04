package com.iyoumei.domain;

import java.io.Serializable;

/**
 * 朋友圈发布图片
 * 
 * @author Jeff
 * 
 */
public class UserCircleMsgPicturesDomain implements Serializable {
	private static final long serialVersionUID = -7045700346995259020L;
	private String messageId;// 消息ID
	private String picUrl;// 发布图片的URL

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

}
