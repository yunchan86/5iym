package com.iyoumei.bean;

import java.io.Serializable;

public class ProvinceBean implements Serializable {
	private static final long serialVersionUID = 7972541976040991815L;
	private String provinceCode;
	private String provinceName;
	private String shortName;// 简称
	private short wzQueryEnable;// 是否支持违章查询(0：不支持；1:支持)

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public short getWzQueryEnable() {
		return wzQueryEnable;
	}

	public void setWzQueryEnable(short wzQueryEnable) {
		this.wzQueryEnable = wzQueryEnable;
	}

}
