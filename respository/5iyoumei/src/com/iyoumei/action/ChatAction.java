package com.iyoumei.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.domain.UserRelationsDomain;
import com.iyoumei.modeldriver.ChatMd;
import com.iyoumei.service.IChatService;
import com.iyoumei.service.bean.ChatMessageParamsBean;
import com.iyoumei.service.bean.MessageText;
import com.iyoumei.service.bean.MessageUnvarnished;
import com.iyoumei.util.ChatUtil;
import com.iyoumei.util.LYLogUtil;
import com.iyoumei.util.StringUtil;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.bean.LogBean;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;

public class ChatAction extends ParentAction implements ModelDriven<ChatMd> {

	private static Log log = LogFactory.getLog(ChatAction.class);

	private ChatMd md = new ChatMd();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IChatService chatService;

	public String execute() {
		LogBean logbean = new LogBean("ChatAction::execute", md.toKeyString(), md.toParamsString(), "参数初始化.");
		ResultDataBean<?> result = new ResultDataBean<UserRelationsDomain>();
		if (StringUtil.isNull(md.getFrom()) || StringUtil.isNull(md.getTo())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			chatService.setLogbean(logbean);
			MessageText mt = new MessageText(md.getMsg());
			List<String> list = new ArrayList<String>();
			list.add(md.getTo());
			ChatMessageParamsBean<MessageText> chatMsg = new ChatMessageParamsBean<MessageText>(md.getFrom(), "users",
					list, mt, null);
			result = chatService.sendText(chatMsg);
		} catch (Exception e) {
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("发送消息异常：", e);
		} finally {
			LYLogUtil.info(log, logbean);
			XStream xs = XStreamUtil.getXStream(md.getReturnType(), "ChatAction");
			xs.alias("result", ResultDataBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), md.getReturnType());
		}
		return null;
	}
	/**
	 * 消息透传的处理
	 * @return
	 */
	public String message() {
		LogBean logbean = new LogBean("ChatAction::message", md.toKeyString(), md.toParamsString(), "参数初始化.");
		ResultDataBean<?> result = new ResultDataBean<UserRelationsDomain>();
		if (StringUtil.isNull(md.getFrom()) || StringUtil.isNull(md.getTo())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			chatService.setLogbean(logbean);
			MessageUnvarnished mu = new MessageUnvarnished();
			mu.setAction(md.getAction());
			List<String> list = new ArrayList<String>();
			list.add(md.getTo());
			Map<String,String> extMap = ChatUtil.getChatExt(md.getExt()) ;
			ChatMessageParamsBean<MessageUnvarnished> chatMsg = new ChatMessageParamsBean<MessageUnvarnished>(md.getFrom(), "users",
					list, mu, extMap);
			result = chatService.sendUnvarnished(chatMsg);
		} catch (Exception e) {
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("发送消息异常：", e);
		} finally {
			LYLogUtil.info(log, logbean);
			XStream xs = XStreamUtil.getXStream(md.getReturnType(), "ChatAction");
			xs.alias("result", ResultDataBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), md.getReturnType());
		}
		return null;
	}

	public String chatGroup() {
		LogBean logbean = new LogBean("ChatAction::execute", md.toKeyString(), md.toParamsString(), "参数初始化.");
		ResultDataBean<?> result = new ResultDataBean<UserRelationsDomain>();
		if (StringUtil.isNull(md.getFrom()) || StringUtil.isNull(md.getTo())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			chatService.setLogbean(logbean);
			MessageText mt = new MessageText(md.getMsg());
			List<String> list = new ArrayList<String>();
			list.add(md.getTo());
			ChatMessageParamsBean<MessageText> chatMsg = new ChatMessageParamsBean<MessageText>(md.getFrom(),
					"chatgroups", list, mt, null);
			result = chatService.sendText(chatMsg);
		} catch (Exception e) {
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("发送消息异常：", e);
		} finally {
			LYLogUtil.info(log, logbean);
			XStream xs = XStreamUtil.getXStream(md.getReturnType(), "ChatAction");
			xs.alias("result", ResultDataBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), md.getReturnType());
		}
		return null;
	}

	@Override
	public ChatMd getModel() {
		return md;
	}

	public IChatService getChatService() {
		return chatService;
	}

	public void setChatService(IChatService chatService) {
		this.chatService = chatService;
	}

}
