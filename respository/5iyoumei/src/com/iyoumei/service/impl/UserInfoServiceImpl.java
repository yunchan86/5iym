package com.iyoumei.service.impl;

import javax.annotation.Resource;

import com.iyoumei.bean.CodeMsgBean;
import com.iyoumei.entity.UserInfoDomain;
import com.iyoumei.mapper1.UserInfoMapper;
import com.iyoumei.service.IUserInfoService;
import com.iyoumei.util.FTPUtil;
import com.iyoumei.util.enumcollection.RespCode;

public class UserInfoServiceImpl implements IUserInfoService {
	@Resource(type = UserInfoMapper.class)
	private UserInfoMapper userInfoMapper;

	private String iconUrlPrefix;

	@Override
	public UserInfoDomain getUserInfo(String userId) throws Exception {
		return userInfoMapper.selectByUserId(userId);

	}

	@Override
	public String saveIconAndGetUrl(String userId, byte[] imageDataArr, String ext, String iconType) throws Exception {
		String iconUrl = null;
		UserInfoDomain userInfo = userInfoMapper.selectByUserId(userId);
		String icon = userInfo.getUserIcon();
		String iconName = null;
		int index = 0;
		String subDir = null;
		iconType=iconType==null?"0":iconType;
		if ("1".equals(iconType) || "2".equals(iconType) || "3".equals(iconType))
			subDir = "private";
		else
			subDir = "icon";
		if (icon != null && !"".equals(icon)) {// 头像不为空
			// 先删除头像
			iconName = icon.substring(icon.lastIndexOf("/") + 1);
			String[] split = iconName.split("\\.")[0].split("_");
			if (split.length == 3)
				try {
					index = Integer.parseInt(split[2], 10);
				} catch (Exception e) {
					index = 0;
				}
			FTPUtil.deleteFile("images", subDir, iconName);
		}
		// 上传图片文件(给图像加上序列号，防止客户端缓存时显示旧头像）
		String iconNew = userId.toString() + "_" + iconType + "_" + (index + 1) + "." + ext;
		boolean flag = FTPUtil.uploadFile("images", subDir, iconNew, imageDataArr);
		if (flag) {
			iconUrl = iconUrlPrefix + "images/" + subDir + "/" + iconNew;
			if ("1".equals(iconType))// 身份证正面
				userInfo.setIdentityCardFrontUrl(iconUrl);
			else if ("2".equals(iconType))// 身份证反面
				userInfo.setIdentityCardBackUrl(iconUrl);
			else if ("3".equals(iconType))// 驾驶证
				userInfo.setDrivingLicencsUrl(iconUrl);
			else
				userInfo.setUserIcon(iconUrl);
			userInfoMapper.update(userInfo);
		}
		return iconUrl;
	}

	@Override
	public CodeMsgBean modifyPwd(String userId, String pwd, String newPwd) throws Exception {
		CodeMsgBean bean = new CodeMsgBean();
		UserInfoDomain domain = userInfoMapper.selectByUserId(userId);
		if (!pwd.equalsIgnoreCase(domain.getPassword())) {
			bean.setCode(RespCode.PWD_ERROR.getCode());
			bean.setMsg("密码错误");
		} else {
			domain.setPassword(newPwd.trim().toLowerCase());
			userInfoMapper.update(domain);
			bean.setCode(RespCode.SUCCESS.getCode());
			bean.setMsg("修改成功");
		}
		return bean;
	}

	
	@Override
	public CodeMsgBean modifyPwdByForget(String mobileNumber, String pwd) throws Exception {
		CodeMsgBean bean = new CodeMsgBean();
		UserInfoDomain domain = userInfoMapper.selectByMobileNumber(mobileNumber);
		if (domain!=null) {
			domain.setPassword(pwd.trim().toLowerCase());
			userInfoMapper.update(domain);
			bean.setCode(RespCode.SUCCESS.getCode());
			bean.setMsg("修改成功");
		} else {
			bean.setCode(RespCode.ERROR.getCode());
			bean.setMsg("用户不存在");
		}
		return bean;
	}

	@Override
	public boolean updateUserInfo(UserInfoDomain domain) throws Exception {
		userInfoMapper.update(domain);
		return true;
	}

	public UserInfoMapper getUserInfoMapper() {
		return userInfoMapper;
	}

	public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
		this.userInfoMapper = userInfoMapper;
	}

	public void setIconUrlPrefix(String iconUrlPrefix) {
		this.iconUrlPrefix = iconUrlPrefix;
	}

}
