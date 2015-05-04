package com.iyoumei.bean;

public class CarImageBean {
	private String carImgId;//图片ID
	private String imgUrl;//图片URL
	private String colorId;// 颜色ID
	private String colorValue;//颜色值
	private String colorName;//颜色名
	
	public String getColorValue() {
		return colorValue;
	}
	public void setColorValue(String colorValue) {
		this.colorValue = colorValue;
	}
	public String getColorName() {
		return colorName;
	}
	public void setColorName(String colorName) {
		this.colorName = colorName;
	}
	public String getCarImgId() {
		return carImgId;
	}
	public void setCarImgId(String carImgId) {
		this.carImgId = carImgId;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getColorId() {
		return colorId;
	}
	public void setColorId(String colorId) {
		this.colorId = colorId;
	}
}
