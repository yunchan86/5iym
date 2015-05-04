package com.iyoumei.domain;

import java.util.List;

public class UserCarBrandDomain {

	private UserInfoDomain userInfo ;
	private List<CarBrandDomain> carBrand ;
	public UserInfoDomain getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfoDomain userInfo) {
		this.userInfo = userInfo;
	}
	public List<CarBrandDomain> getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(List<CarBrandDomain> carBrand) {
		this.carBrand = carBrand;
	} 
	
	
}
