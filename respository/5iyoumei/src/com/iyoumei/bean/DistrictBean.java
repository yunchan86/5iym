package com.iyoumei.bean;

import java.io.Serializable;

public class DistrictBean implements Serializable {
	private static final long serialVersionUID = 8364343564893491840L;
	private String districtCode;
	private String districtName;

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
}
