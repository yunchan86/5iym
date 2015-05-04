package com.iyoumei.util.clientversion;

/**
 * @author lijf
 * 
 */
public class ClientUpdateInfo {
	private boolean isFresh;// 用户的版本是否时最新版本
	private int version;// 版本号
	private String versionCode;// 版本代码
	private String updateTime;// 发布时间
	private String filePath;// 更新路径
	private String content;// 更新内容
	private boolean isMustUpdate;// 是否必须更新

	public boolean isFresh() {
		return isFresh;
	}

	public void setFresh(boolean isFresh) {
		this.isFresh = isFresh;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public boolean isMustUpdate() {
		return isMustUpdate;
	}

	public void setMustUpdate(boolean isMustUpdate) {
		this.isMustUpdate = isMustUpdate;
	}

	public String getVersionCode() {
		return versionCode;
	}

	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
