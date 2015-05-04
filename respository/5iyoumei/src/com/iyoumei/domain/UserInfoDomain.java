package com.iyoumei.domain;

import java.util.Date;

public class UserInfoDomain {
	private String userId;// 用户唯一标识，uuid_short形式，在内部系统中全局标识一个唯一用户；
	private String nickname;// 用户昵称
	private String mobileNumber;// 用户手机号
	private int mobileVerifyStatus;// 手机号验证状态 0-未验证 1-已验证 默认0
	private String password;// 用户密码。需要salt加密的形式
	private String name;// 用户姓名
	private String gender;// 用户性别，0-未指定 1-女 2-男
	private Date birthday;// 生日
	private String cityCode;// 所在城市代码
	private String cityName;//所在城市名称
	private String districtCode;// 所在城区代码
	private String districtName;//所在城区名称
	private String signature;// 个性签名
	private String userIcon;// 用户头像，存放在public目录下
	private int approveType;// 是否可加好友：0－需要验证；1-任何人可加；2－不允许加
	private int showInMap;// 是否开启好友地图，开启后好友在地图中可以查看该人 0-不开启 1-开启
	private int picViewLimit;// 陌生人图片查看权限，陌生人查看图片存在张数限制 0-不允许查看 1-允许查看
	private String recommendId;// 推荐人ID
	private Date regTime;// 注册时间
	private int newMessageSwitch;// 新消息推送开关 0:接收新消息推送;1:不接收新推送 默认值为0
	private int strangerMessageSwitch;// 陌生人临时会话开关0:开启临时会话;1:关闭临时会话 默认值为0
	private Date getDrivingLicenceTime;// 初次领证时间，计算驾龄使用
	private String drivingLicencsUrl;// 驾驶证图片URL地址。个人隐私数据，放到private目录
	private String identityCardFrontUrl;// 身份证正面图片URL地址。个人隐私数据，放到private目录
	private String identityCardBackUrl;// 身份证背面图片URL地址，个人隐私数据，放到private目录。
	private int userType;// 用户类型：0-普通用户；1-商户员工； 2-商户
	private String providerId;// 商户ID
	private int status;// 账户状态 0-正常 1-锁定 2-冻结
	private int praiseTimes;//赞数
	private int stampTimes;//踩数

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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getMobileVerifyStatus() {
		return mobileVerifyStatus;
	}

	public void setMobileVerifyStatus(int mobileVerifyStatus) {
		this.mobileVerifyStatus = mobileVerifyStatus;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
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

	public int getApproveType() {
		return approveType;
	}

	public void setApproveType(int approveType) {
		this.approveType = approveType;
	}

	public int getShowInMap() {
		return showInMap;
	}

	public void setShowInMap(int showInMap) {
		this.showInMap = showInMap;
	}

	public int getPicViewLimit() {
		return picViewLimit;
	}

	public void setPicViewLimit(int picViewLimit) {
		this.picViewLimit = picViewLimit;
	}

	public String getRecommendId() {
		return recommendId;
	}

	public void setRecommendId(String recommendId) {
		this.recommendId = recommendId;
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	public int getNewMessageSwitch() {
		return newMessageSwitch;
	}

	public void setNewMessageSwitch(int newMessageSwitch) {
		this.newMessageSwitch = newMessageSwitch;
	}

	public int getStrangerMessageSwitch() {
		return strangerMessageSwitch;
	}

	public void setStrangerMessageSwitch(int strangerMessageSwitch) {
		this.strangerMessageSwitch = strangerMessageSwitch;
	}

	public Date getGetDrivingLicenceTime() {
		return getDrivingLicenceTime;
	}

	public void setGetDrivingLicenceTime(Date getDrivingLicenceTime) {
		this.getDrivingLicenceTime = getDrivingLicenceTime;
	}

	public String getDrivingLicencsUrl() {
		return drivingLicencsUrl;
	}

	public void setDrivingLicencsUrl(String drivingLicencsUrl) {
		this.drivingLicencsUrl = drivingLicencsUrl;
	}

	public String getIdentityCardFrontUrl() {
		return identityCardFrontUrl;
	}

	public void setIdentityCardFrontUrl(String identityCardFrontUrl) {
		this.identityCardFrontUrl = identityCardFrontUrl;
	}

	public String getIdentityCardBackUrl() {
		return identityCardBackUrl;
	}

	public void setIdentityCardBackUrl(String identityCardBackUrl) {
		this.identityCardBackUrl = identityCardBackUrl;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

}
