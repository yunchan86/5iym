package com.iyoumei.domain;

public class CarBrandDomain {

	private String carId ;
	private String userId;// 用户ID
	private String brandId;// 汽车品牌
	private String motorcydeTypeId;// 汽车型号
	private String colorId;// 颜色ID
	private String licenseNumber;// 车牌号码
	private String carImgId ;// 当前车辆图片
	private int current;// 是否当前座驾（0：非当前座驾，1：当前座驾）
	private String brandName ;
	private String brandIntro ;
	private String brandIcon ;
	private String brandLetter ;
	
	
	public String getCarId() {
		return carId;
	}
	public void setCarId(String carId) {
		this.carId = carId;
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
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getBrandIntro() {
		return brandIntro;
	}
	public void setBrandIntro(String brandIntro) {
		this.brandIntro = brandIntro;
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
