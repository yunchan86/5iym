package com.iyoumei.service;

import com.iyoumei.modeldriver.UserSettingsMd;

public interface IUserSettingsService {
	/**
	 * 用户隐私及个人设置
	 * @param md
	 * @return
	 * @throws Exception
	 */
	public Boolean settings(UserSettingsMd md) throws Exception;
}
