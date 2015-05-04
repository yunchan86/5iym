package com.iyoumei.modeldriver;

public class UserInfoMd extends BasicMd {
	private String userId;// 用户唯一标识，uuid_short形式，在内部系统中全局标识一个唯一用户；
	private String nickname;// 用户昵称
	private String mobileNumber;// 用户手机号
	private String pwd;// 用户密码。需要salt加密的形式
	private String newPwd;// 新密码
	private String name;// 用户姓名
	private String gender;// 用户性别，0-未指定 1-女 2-男
	private String birthday;// 生日
	private String cityCode;// 所在城市代码
	private String districtCode;// 所在城区代码
	private String signature;// 个性签名
	private String userIcon;// 用户头像
	private int approveType;// 是否可加好友：0－需要验证；1-任何人可加；2－不允许加
	private int showInMap;// 是否开启好友地图，开启后好友在地图中可以查看该人 0-不开启 1-开启
	private int picViewLimit;// 陌生人图片查看权限，陌生人查看图片存在张数限制 0-不允许查看 1-允许查看
	private int newMessageSwitch;// 新消息推送开关 0:接收新消息推送;1:不接收新推送 默认值为0
	private int strangerMessageSwitch;// 陌生人临时会话开关0:开启临时会话;1:关闭临时会话 默认值为0
	private String getDrivingLicenceTime;// 初次领证时间，计算驾龄使用
	private String drivingLicencsUrl;// 驾驶证图片URL地址。个人隐私数据，放到private目录
	private String identityCardFrontUrl;// 身份证正面图片URL地址。个人隐私数据，放到private目录
	private String identityCardBackUrl;// 身份证背面图片URL地址，个人隐私数据，放到private目录
	private String iconData;// 个人头像数据（base64）
	private String iconType;//头像类型(0:个人头像，1;身份证正面，2：身份证反面，3：驾驶证）

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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
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

	public String getGetDrivingLicenceTime() {
		return getDrivingLicenceTime;
	}

	public void setGetDrivingLicenceTime(String getDrivingLicenceTime) {
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

	public String getIconData() {
		return iconData;
	}

	public void setIconData(String iconData) {
		this.iconData = iconData;
	}

	public String getIconType() {
		return iconType;
	}

	public void setIconType(String iconType) {
		this.iconType = iconType;
	}
	
}
