package com.iyoumei.bean;

import java.util.Collection;

/**
 * 系统初始化数据
 * 
 * @author Jeff
 * 
 * @param <T>
 */
public class InitDataBean<T> {
	private String tag;// 缓存标志
	private String moduleId;// 类型Id
	private boolean isFresh;// 客户端本地数据是否需要更新
	private T data;//单个object时使用
	private Collection<T> collData;//列表时使用

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public boolean isFresh() {
		return isFresh;
	}

	public void setFresh(boolean isFresh) {
		this.isFresh = isFresh;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Collection<T> getCollData() {
		return collData;
	}

	public void setCollData(Collection<T> collData) {
		this.collData = collData;
	}

}
