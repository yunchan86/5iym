package com.iyoumei.modeldriver;

public class UserCarsMd extends BasicMd {
	private String id;
	private String userId;
	private String brandId;// 汽车品牌
	private String motorcydeTypeId;// 汽车型号
	private String colorId;// 颜色ID
	private String licenseNumber;// 车牌号码
	private String carImgId;// 当前车辆图片
	private int current;// 0:非当前座驾；1：当前座驾

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBrandId() {
		return brandId;
	}

	public void setBrandId(String brandId) {
		this.brandId = brandId;
	}

	public String getMotorcydeTypeId() {
		return motorcydeTypeId;
	}

	public void setMotorcydeTypeId(String motorcydeTypeId) {
		this.motorcydeTypeId = motorcydeTypeId;
	}

	public String getColorId() {
		return colorId;
	}

	public void setColorId(String colorId) {
		this.colorId = colorId;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getCarImgId() {
		return carImgId;
	}

	public void setCarImgId(String carImgId) {
		this.carImgId = carImgId;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

}
