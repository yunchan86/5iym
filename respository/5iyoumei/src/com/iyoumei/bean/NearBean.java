package com.iyoumei.bean;

import java.util.Date;
import java.util.List;

import com.iyoumei.domain.UserCarsDomain;

public class NearBean {
	private String userId;// 用户唯一标识，uuid_short形式，在内部系统中全局标识一个唯一用户；
	private String nickname;// 用户昵称
	private String gender;// 用户性别，0-未指定 1-女 2-男
	private Date birthday;// 生日
	private String cityCode;// 所在城市代码
	private String districtCode;// 所在城区代码
	private String signature;// 个性签名
	private String userIcon;// 用户头像，存放在public目录下
	private Date getDrivingLicenceTime;// 初次领证时间，计算驾龄使用
	private int praiseTimes;// 赞数
	private int stampTimes;// 踩数
	private String xpos;// 用户的经度
	private String ypos;// 维度
	private int distance;// 距离（单位：米）
	private List<UserCarsDomain> carList;
	private List<String> imageList;// 最近图片

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(String userIcon) {
		this.userIcon = userIcon;
	}

	public Date getGetDrivingLicenceTime() {
		return getDrivingLicenceTime;
	}

	public void setGetDrivingLicenceTime(Date getDrivingLicenceTime) {
		this.getDrivingLicenceTime = getDrivingLicenceTime;
	}

	public int getPraiseTimes() {
		return praiseTimes;
	}

	public void setPraiseTimes(int praiseTimes) {
		this.praiseTimes = praiseTimes;
	}

	public int getStampTimes() {
		return stampTimes;
	}

	public void setStampTimes(int stampTimes) {
		this.stampTimes = stampTimes;
	}

	public List<UserCarsDomain> getCarList() {
		return carList;
	}

	public void setCarList(List<UserCarsDomain> carList) {
		this.carList = carList;
	}

	public List<String> getImageList() {
		return imageList;
	}

	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}

	public String getXpos() {
		return xpos;
	}

	public void setXpos(String xpos) {
		this.xpos = xpos;
	}

	public String getYpos() {
		return ypos;
	}

	public void setYpos(String ypos) {
		this.ypos = ypos;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

}
