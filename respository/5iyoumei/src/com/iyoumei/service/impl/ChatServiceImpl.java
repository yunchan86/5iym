package com.iyoumei.service.impl;

import com.easemob.server.jersey.api.EasemobMessages;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iyoumei.bean.ChatMessageBean;
import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.service.IChatService;
import com.iyoumei.service.bean.ChatMessageParamsBean;
import com.iyoumei.service.bean.MessageAudio;
import com.iyoumei.service.bean.MessagePic;
import com.iyoumei.service.bean.MessageText;
import com.iyoumei.service.bean.MessageUnvarnished;
import com.iyoumei.util.HXResultUtil;
import com.iyoumei.util.MessageUtil;
import com.iyoumei.util.bean.LogBean;
import com.iyoumei.util.enumcollection.RespCode;

public class ChatServiceImpl implements IChatService {
	
	private LogBean logbean = null ;

	@Override
	public ResultDataBean<ChatMessageBean> sendText(ChatMessageParamsBean<MessageText> chatMsg) {
		ResultDataBean<ChatMessageBean> result = new ResultDataBean<ChatMessageBean>() ;
		if(logbean==null) logbean = new LogBean("ChatServiceImpl::sendText",chatMsg.getFrom(),MessageUtil.getChatData(chatMsg),"数据初始化") ;
		ObjectNode sendResult = EasemobMessages.sendMessages(chatMsg.getTargetType(), MessageUtil.getTarget(chatMsg), MessageUtil.getMsg(chatMsg), chatMsg.getFrom(),MessageUtil.getExt(chatMsg)) ;
		System.out.println(sendResult);
		if (HXResultUtil.isChatSuccess(sendResult)) {
			result.setMsgCode(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail());
			setSendMsgResult(result,chatMsg,sendResult) ;
			logbean.setContentException(sendResult.toString(), null);
		}else {
			result.setMsgCode(RespCode.MSG_SEND_ERROR.getCode(), RespCode.MSG_SEND_ERROR.getDetail());
			logbean.setContentException(sendResult.toString(), null);
		}
		return result;
	}
	
	private void setSendMsgResult(ResultDataBean<ChatMessageBean> result,ChatMessageParamsBean<MessageText> chatMsg,ObjectNode sendResult) {
		ChatMessageBean ctbean = new ChatMessageBean() ;
		ctbean.setFromUserId(chatMsg.getFrom());
		ctbean.setMsg(chatMsg.getMsg().getMsg());
	}

	@Override
	public ResultDataBean<ChatMessageBean> sendPic(ChatMessageParamsBean<MessagePic> chatMsg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultDataBean<ChatMessageBean> sendAudio(ChatMessageParamsBean<MessageAudio> chatMsg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultDataBean<ChatMessageBean> sendUnvarnished(ChatMessageParamsBean<MessageUnvarnished> chatMsg) {
		ResultDataBean<ChatMessageBean> result = new ResultDataBean<ChatMessageBean>() ;
		if(logbean==null) logbean = new LogBean("ChatServiceImpl::sendUnvarnished",chatMsg.getFrom(),MessageUtil.getChatData(chatMsg),"数据初始化") ;
		ObjectNode sendResult = EasemobMessages.sendMessages(chatMsg.getTargetType(), MessageUtil.getTarget(chatMsg), MessageUtil.getMsg(chatMsg), chatMsg.getFrom(),MessageUtil.getExt(chatMsg)) ;
		System.out.println(sendResult);
		if (HXResultUtil.isChatSuccess(sendResult)) {
			result.setMsgCode(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail());
			setMessageUnvarnishedResult(result,chatMsg,sendResult) ;
			logbean.setContentException(sendResult.toString(), null);
		}else {
			result.setMsgCode(RespCode.MSG_SEND_ERROR.getCode(), RespCode.MSG_SEND_ERROR.getDetail());
			logbean.setContentException(sendResult.toString(), null);
		}
		return result;
	}
	private void setMessageUnvarnishedResult(ResultDataBean<ChatMessageBean> result,ChatMessageParamsBean<MessageUnvarnished> chatMsg,ObjectNode sendResult) {
		ChatMessageBean ctbean = new ChatMessageBean() ;
		ctbean.setFromUserId(chatMsg.getFrom());
		ctbean.setMsg(chatMsg.getMsg().getAction());
	}

	@Override
	public void setLogbean(LogBean logbean) {
		this.logbean = logbean ;
	}


}
