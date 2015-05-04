package com.iyoumei.util.weizhang;

import java.util.List;

public class WzProvinceBean {
	private String provinceId;
	private String provinceName;
	private String provinceShortName;
	private List<WzCityBean> cites;

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getProvinceShortName() {
		return provinceShortName;
	}

	public void setProvinceShortName(String provinceShortName) {
		this.provinceShortName = provinceShortName;
	}

	public List<WzCityBean> getCites() {
		return cites;
	}

	public void setCites(List<WzCityBean> cites) {
		this.cites = cites;
	}

}
