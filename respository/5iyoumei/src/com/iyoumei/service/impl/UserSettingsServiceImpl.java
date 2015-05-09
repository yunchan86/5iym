package com.iyoumei.service.impl;

import javax.annotation.Resource;

import com.iyoumei.mapper1.UserSettingsMapper;
import com.iyoumei.modeldriver.UserSettingsMd;
import com.iyoumei.service.IUserSettingsService;

public class UserSettingsServiceImpl implements IUserSettingsService {
	@Resource(type = UserSettingsMapper.class)
	private UserSettingsMapper userSettingsMapper;
	
	public UserSettingsMapper getUserSettingsMapper() {
		return userSettingsMapper;
	}

	public void setUserSettingsMapper(UserSettingsMapper userSettingsMapper) {
		this.userSettingsMapper = userSettingsMapper;
	}

	@Override
	public Boolean settings(UserSettingsMd md) throws Exception {
		Boolean hr=false;
		
		switch(md.getSwitchType()){
			case "01"://常用联系人开关
				userSettingsMapper.updateRegularfriend(md.getUserId(), md.getUserId2(), md.getIsOpen());
				break;
			case "02"://主用户朋友圈信息从用户是否可见
				userSettingsMapper.updateFriendCircle1(md.getUserId(), md.getUserId2(), md.getIsOpen());
				break;
			case "03"://从用户朋友圈信息主用户是否可见
				userSettingsMapper.updateFriendCircle2(md.getUserId(), md.getUserId2(), md.getIsOpen());
				break;
			case "04"://主用户好友地图对从用户可见
				userSettingsMapper.updateFriendMap(md.getUserId(), md.getUserId2(), md.getIsOpen());
				break;
			case "05"://是否开启好友验证
				userSettingsMapper.updateApproveTypeSwitch(md.getUserId(), md.getIsOpen());
				break;
			case "06"://路友账号找到我
				userSettingsMapper.updateMobileNumberSwitch(md.getUserId(), md.getIsOpen());
				break;
			case "07"://是否开启好友地图
				userSettingsMapper.updateShowInMap(md.getUserId(), md.getIsOpen());
				break;
			case "08"://通过车牌找到我
				userSettingsMapper.updateLicencePlateSwitch(md.getUserId(), md.getIsOpen());
				break;
			case "09"://是否允许陌生人查看照片
				userSettingsMapper.updatePicViewLimit(md.getUserId(), md.getIsOpen());
				break;
			case "10"://是否接收临时会话
				userSettingsMapper.updateStrangerMessageSwitch(md.getUserId(), md.getIsOpen());
				break;
		}
		
		hr=true;
		
		return hr;
		
	}

}
