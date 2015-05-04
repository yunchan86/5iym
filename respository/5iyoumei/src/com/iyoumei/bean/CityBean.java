package com.iyoumei.bean;

import java.io.Serializable;

public class CityBean implements Serializable {
	private static final long serialVersionUID = 8091888401197124189L;
	private String cityCode;
	private String cityName;
	private String wzQueryCode;// 违章查询的城市代码
	private String carHead;// 该城市车牌号的开头
	private short engineno;// 违章查询时需要输入发动机号位数（"-1"：全部输入，"0"：不需要输入，其他的显示几位输入发动机号后面几位）
	private short classno;// 违章查询时需要输入车架号位数（"-1"：全部输入，"0"：不需要输入，其他的显示几位输入车架号后面几位）
	private short registno;// 违章查询时需要输入证书编号位数（"-1"：全部输入，"0"：不需要输入，其他的显示几位输入证书编号后面几位）
	private short wzQueryEnable;// 是否支持违章查询(0：不支持；1:支持)

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getWzQueryCode() {
		return wzQueryCode;
	}

	public void setWzQueryCode(String wzQueryCode) {
		this.wzQueryCode = wzQueryCode;
	}

	public String getCarHead() {
		return carHead;
	}

	public void setCarHead(String carHead) {
		this.carHead = carHead;
	}

	public short getEngineno() {
		return engineno;
	}

	public void setEngineno(short engineno) {
		this.engineno = engineno;
	}

	public short getClassno() {
		return classno;
	}

	public void setClassno(short classno) {
		this.classno = classno;
	}

	public short getRegistno() {
		return registno;
	}

	public void setRegistno(short registno) {
		this.registno = registno;
	}

	public short getWzQueryEnable() {
		return wzQueryEnable;
	}

	public void setWzQueryEnable(short wzQueryEnable) {
		this.wzQueryEnable = wzQueryEnable;
	}

}
