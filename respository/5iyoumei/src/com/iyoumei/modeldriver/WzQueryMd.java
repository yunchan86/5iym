package com.iyoumei.modeldriver;

/**
 * 违章查询md
 * 
 * @author Jeff
 * 
 */
public class WzQueryMd extends BasicMd {
	private String hphm;// 车牌号码
	private String classno;// 车架号
	private String engineno;// 发动机号
	private String registno;// 证书编号
	private String cityId;// 违章查询城市ID
	private String userId;

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
