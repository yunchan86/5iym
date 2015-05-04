package com.iyoumei.service.bean;

import java.util.List;
import java.util.Map;

public class ChatMessageParamsBean<T> {

	private String targetType ;
	private List<String> target ;
	private T msg ;
	private Map<String,String>  ext ;
	private String from ;
	
	public ChatMessageParamsBean(){}
	public ChatMessageParamsBean(String from,String targetType,List<String> target,T msg,Map<String, String> map) {
		this.from = from ;
		this.target = target ;
		this.targetType = targetType ;
		this.msg = msg ;
		this.ext = map ;
	}
	
	public String getTargetType() {
		return targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	public List<String> getTarget() {
		return target;
	}
	public void setTarget(List<String> target) {
		this.target = target;
	}
	public T getMsg() {
		return msg;
	}
	public void setMsg(T msg) {
		this.msg = msg;
	}
	public Map<String, String> getExt() {
		return ext;
	}
	public void setExt(Map<String, String> ext) {
		this.ext = ext;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
	
}
