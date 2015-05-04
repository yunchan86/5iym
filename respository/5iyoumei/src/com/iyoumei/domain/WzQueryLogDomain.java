package com.iyoumei.domain;

import java.io.Serializable;

/**
 * 违章查询信息日志
 * 
 * @author Jeff
 * 
 */
public class WzQueryLogDomain implements Serializable {

	private static final long serialVersionUID = 281000322326366625L;
	private String uuid;
	private String userId;
	private String hphm;// 车牌号
	private String classno;// 车架号
	private String engineno;// 发动机号
	private String registno;// 证书编号
	private String cityId;// 查询城市（第三方机构城市代码）

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getHphm() {
		return hphm;
	}

	public void setHphm(String hphm) {
		this.hphm = hphm;
	}

	public String getClassno() {
		return classno;
	}

	public void setClassno(String classno) {
		this.classno = classno;
	}

	public String getEngineno() {
		return engineno;
	}

	public void setEngineno(String engineno) {
		this.engineno = engineno;
	}

	public String getRegistno() {
		return registno;
	}

	public void setRegistno(String registno) {
		this.registno = registno;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

}
