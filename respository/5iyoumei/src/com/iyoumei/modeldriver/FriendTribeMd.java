package com.iyoumei.modeldriver;

/**
 * 朋友圈
 * 
 * @author Jeff
 * 
 */
public class FriendTribeMd extends BasicMd {
	private String userId;// 用户唯一标识，uuid_short形式，在内部系统中全局标识一个唯一用户；
	private String viewUserId;// 要查看的朋友圈主人的id，为空时表示查看自己的朋友圈
	private String content;// 发布消息内容
	private String picData;// 消息图片（前端逐个上传图片）
	private String msgId;// 消息ID
	private String replyId;// 评论ID
	private String orientation;// 查询数据的方向(p:previous,n:next)

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicData() {
		return picData;
	}

	public void setPicData(String picData) {
		this.picData = picData;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getViewUserId() {
		return viewUserId;
	}

	public void setViewUserId(String viewUserId) {
		this.viewUserId = viewUserId;
	}

}
