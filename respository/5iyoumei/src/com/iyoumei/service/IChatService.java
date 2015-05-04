package com.iyoumei.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.ChatMessageBean;
import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.service.bean.ChatMessageParamsBean;
import com.iyoumei.service.bean.MessageAudio;
import com.iyoumei.service.bean.MessagePic;
import com.iyoumei.service.bean.MessageText;
import com.iyoumei.service.bean.MessageUnvarnished;
import com.iyoumei.util.bean.LogBean;

public interface IChatService {
	
	Log log = LogFactory.getLog(IChatService.class);

	public ResultDataBean<ChatMessageBean> sendText(ChatMessageParamsBean<MessageText> chatMsg) ;
	
	public ResultDataBean<ChatMessageBean> sendPic(ChatMessageParamsBean<MessagePic> chatMsg) ;
	
	public ResultDataBean<ChatMessageBean> sendAudio(ChatMessageParamsBean<MessageAudio> chatMsg) ;
	
	public ResultDataBean<ChatMessageBean> sendUnvarnished(ChatMessageParamsBean<MessageUnvarnished> chatMsg) ;
	
	public void setLogbean(LogBean logbean) ;//日志操作的处理
	
	
}
