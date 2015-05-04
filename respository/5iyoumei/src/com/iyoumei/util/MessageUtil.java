package com.iyoumei.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iyoumei.service.bean.ChatMessageParamsBean;
import com.iyoumei.service.bean.MessageAudio;
import com.iyoumei.service.bean.MessagePic;
import com.iyoumei.service.bean.MessageText;
import com.iyoumei.service.bean.MessageUnvarnished;
import com.thoughtworks.xstream.XStream;

public class MessageUtil {
	
	private static JsonNodeFactory factory = new JsonNodeFactory(false);

	public static String getChatData(ChatMessageParamsBean<?> msg) {
		String result = null ;
		XStream xs = XStreamUtil.getXStream("json", "chatdata");
		xs.alias("result", ChatMessageParamsBean.class);
		xs.alias("ext", Map.class);
		xs.aliasSystemAttribute(null, "class");
		result = xs.toXML(msg) ;
		return result ;
	}
	
	public static ArrayNode getTarget(ChatMessageParamsBean<?> msg) {
		ArrayNode arrNode = factory.arrayNode() ;
		List<String> list = msg.getTarget() ;
		for(String str:list) {
			arrNode.add(str) ;
		}
		return arrNode ;
	}
	
	public static ObjectNode getExt(ChatMessageParamsBean<?> msg) {
		ObjectNode objectNode = factory.objectNode() ;
		Map<String,String> map = msg.getExt() ;
		if(map==null||map.size()==0) return objectNode ;
		for(String key : map.keySet()) {
			objectNode.put(key, map.get(key)) ;
		}
		return objectNode ;
	}
	
	public static ObjectNode getMsg(ChatMessageParamsBean<?> msg) {
		ObjectNode objectNode = factory.objectNode() ;
		if(msg.getMsg() instanceof MessageText) {
			MessageText mt = (MessageText) msg.getMsg() ;
			objectNode.put("type",mt.getType()) ;
			objectNode.put("msg",mt.getMsg()) ;
		}else if(msg.getMsg() instanceof MessagePic) {
			MessagePic mp = (MessagePic)msg.getMsg() ;
			objectNode.put("type",mp.getType()) ;
			objectNode.put("url", mp.getUrl()) ;
			objectNode.put("filename", mp.getFilename()) ;
			objectNode.put("secret", mp.getSecret()) ;
			//TODO
		}else if(msg.getMsg() instanceof MessageAudio) {
			MessageAudio ma = (MessageAudio)msg.getMsg() ;
			objectNode.put("type",ma.getType()) ;
			objectNode.put("url", ma.getUrl()) ;
			objectNode.put("filename", ma.getFilename()) ;
			objectNode.put("secret", ma.getSecret()) ;
			objectNode.put("length", ma.getLength()) ;
			//TODO
		}else if(msg.getMsg() instanceof MessageUnvarnished){
			MessageUnvarnished mu = (MessageUnvarnished)msg.getMsg() ;
			objectNode.put("type",mu.getType()) ;
			objectNode.put("action", mu.getAction()) ;
		}
		return objectNode ;
	}
	
	public static void main(String[] args) {
		MessageText mt = new MessageText("您好") ;
		List<String> list = new ArrayList<String>() ;
		list.add("user1") ;
		list.add("user2") ;
		Map<String,String> map = new HashMap<String,String>() ;
		map.put("key", "value") ;
		ChatMessageParamsBean<MessageText> msg  = new ChatMessageParamsBean<MessageText>("1234566","users",list,mt,map);
		System.out.println(MessageUtil.getChatData(msg));
		
	}
}
