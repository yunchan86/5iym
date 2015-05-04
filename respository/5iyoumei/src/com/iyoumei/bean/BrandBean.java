package com.iyoumei.bean;

import java.io.Serializable;

public class BrandBean implements Serializable {
	private static final long serialVersionUID = -3136224991078159192L;
	private String brandId;// 汽车品牌ID
	private String brandName;// 汽车品牌名称
	private String brandIcon;// 品牌图标
	private String brandLetter;// 品牌首字母

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getBrandIcon() {
		return brandIcon;
	}

	public void setBrandIcon(String brandIcon) {
		this.brandIcon = brandIcon;
	}

	public String getBrandLetter() {
		return brandLetter;
	}

	public void setBrandLetter(String brandLetter) {
		this.brandLetter = brandLetter;
	}

}
