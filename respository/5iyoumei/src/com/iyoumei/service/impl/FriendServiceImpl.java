package com.iyoumei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.easemob.server.jersey.api.EasemobIMUsers;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.entity.UserInfoDomain;
import com.iyoumei.entity.UserInfoHXDomain;
import com.iyoumei.mapper1.UserInfoHXLogMapper;
import com.iyoumei.mapper1.UserInfoHXMapper;
import com.iyoumei.mapper1.UserInfoMapper;
import com.iyoumei.service.IFriendService;
import com.iyoumei.util.HXResultUtil;
import com.iyoumei.util.HXUserUtil;
import com.iyoumei.util.StringUtil;

public class FriendServiceImpl implements IFriendService {
	@Resource(type = UserInfoHXMapper.class)
	private UserInfoHXMapper userInfoHxMapper;
	@Resource(type = UserInfoMapper.class)
	private UserInfoMapper userInfoMapper;
	@Resource(type = UserInfoHXLogMapper.class)
	private UserInfoHXLogMapper userInfoHXLogMapper;

	@Override
	public ResultDataBean<ObjectNode> singleReg(UserInfoDomain userInfo) {
		ResultDataBean<ObjectNode> result = new ResultDataBean<ObjectNode>();
		try {
			if (userInfo == null) {
				result.setMsgCode("99", "user is null.");
				return result;
			}
			if (StringUtil.isNull(userInfo.getUserId())) {// 通过手机号查询
				userInfo = this.userInfoMapper.selectByMobileNumber(userInfo.getMobileNumber());
			}
			if (userInfo == null) {
				result.setMsgCode("99", "user is null.");
				return result;
			}
			ObjectNode dataNode = JsonNodeFactory.instance.objectNode();
			dataNode.put("username", HXUserUtil.getUserName(userInfo));
			dataNode.put("password", HXUserUtil.getPassword(userInfo));
			System.out.println(dataNode);
			ObjectNode imObject = EasemobIMUsers.createNewIMUserSingle(dataNode);
			if (HXResultUtil.isSuccess(imObject)) {
				result.setMsgCodeData("00", "Create account of huaxin successfully!", imObject);
				imObject.put("password", HXUserUtil.getPassword(userInfo));
				this.userInfoHXLogMapper.deleteByPrimaryKey(Long.parseLong(userInfo.getUserId()));
			} else {
				result.setMsgCodeData("99", "Failed to create account of huaxin", imObject);
			}
			UserInfoHXDomain userInfoHX = userInfoHxMapper.selectByPrimaryKey(Long.parseLong(userInfo.getUserId())) ;
			if(userInfoHX==null) {
				userInfoHX = HXResultUtil.getCreateInfo(imObject);
				if (userInfoHX != null) {
					userInfoHX.setUserId(Long.parseLong(userInfo.getUserId()));
					userInfoHX.setPassword(HXUserUtil.getPassword(userInfo));
					userInfoHxMapper.insert(userInfoHX);
				}
			}
		} catch (Exception e) {
			result.setMsgCode("99", "registing huanxin is exception : " + e.getMessage());
		}
		return result;
	}

	@Override
	public ResultDataBean<ObjectNode> batchReg(List<UserInfoDomain> userInfoList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultDataBean<ObjectNode> get(UserInfoHXDomain userHx) {
		ResultDataBean<ObjectNode> result = new ResultDataBean<ObjectNode>();
		try {
			if (userHx == null) {
				result.setMsgCode("99", "user is null.");
				return result;
			}
			ObjectNode imObject = EasemobIMUsers.getIMUsersByPrimaryKey(userHx.getHxUsername());
			if (HXResultUtil.isSuccess(imObject)) {
				result.setMsgCodeData("00", "query account of huaxin successfully!", imObject);
			} else {
				result.setMsgCodeData("99", "Failed to query account of huaxin", imObject);
			}
		} catch (Exception e) {
			result.setMsgCode("99", "registing huanxin is exception : " + e.getMessage());
		}
		return result;
	}

	@Override
	public ResultDataBean<ObjectNode> del(UserInfoHXDomain userHx) {
		ResultDataBean<ObjectNode> result = new ResultDataBean<ObjectNode>();
		try {
			if (userHx == null) {
				result.setMsgCode("99", "user is null.");
				return result;
			}
			ObjectNode imObject = EasemobIMUsers.deleteIMUserByUserPrimaryKey(userHx.getHxUsername());
			if (HXResultUtil.isSuccess(imObject)) {
				result.setMsgCodeData("00", "query account of huaxin successfully!", imObject);
			} else {
				result.setMsgCodeData("99", "Failed to query account of huaxin", imObject);
			}
		} catch (Exception e) {
			result.setMsgCode("99", "registing huanxin is exception : " + e.getMessage());
		}
		return result;
	}

	@Override
	public ResultDataBean<ObjectNode> modifyPwd(UserInfoHXDomain userHx, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultDataBean<ObjectNode> singleFriendAdd(String selfKey, String friendKey) {
		ResultDataBean<ObjectNode> result = new ResultDataBean<ObjectNode>();
		try {
			if (StringUtil.isNull(selfKey) || StringUtil.isNull(friendKey)) {
				result.setMsgCode("99", "your key[" + selfKey + "] is null or your friend key[" + friendKey
						+ "] is null.");
				return result;
			}
			ObjectNode imObject = EasemobIMUsers.addFriendSingle(selfKey, friendKey);
			if (HXResultUtil.isSuccess(imObject)) {
				result.setMsgCodeData("00", "query account of huaxin successfully!", imObject);
			} else {
				result.setMsgCodeData("99", "Failed to query account of huaxin", imObject);
			}
		} catch (Exception e) {
			result.setMsgCode("99", "registing huanxin is exception : " + e.getMessage());
		}
		return result;
	}

	@Override
	public ResultDataBean<ObjectNode> getFriendList(String selfKey) {
		ResultDataBean<ObjectNode> result = new ResultDataBean<ObjectNode>();
		try {
			if (StringUtil.isNull(selfKey)) {
				result.setMsgCode("99", "your key[" + selfKey + "] is null .");
				return result;
			}
			ObjectNode imObject = EasemobIMUsers.getFriends(selfKey);
			if (HXResultUtil.isSuccess(imObject)) {
				result.setMsgCodeData("00", "query account of huaxin successfully!", imObject);
			} else {
				result.setMsgCodeData("99", "Failed to query account of huaxin", imObject);
			}
		} catch (Exception e) {
			result.setMsgCode("99", "registing huanxin is exception : " + e.getMessage());
		}
		return result;
	}

	public void setUserInfoHxMapper(UserInfoHXMapper userInfoHxMapper) {
		this.userInfoHxMapper = userInfoHxMapper;
	}

	public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
		this.userInfoMapper = userInfoMapper;
	}

	public void setUserInfoHXLogMapper(UserInfoHXLogMapper userInfoHXLogMapper) {
		this.userInfoHXLogMapper = userInfoHXLogMapper;
	}

	@Override
	public ResultDataBean<ObjectNode> remove(String selfKey, String friendKey) {
		ResultDataBean<ObjectNode> result = new ResultDataBean<ObjectNode>();
		try {
			if (StringUtil.isNull(selfKey) || StringUtil.isNull(friendKey)) {
				result.setMsgCode("99", "your key[" + selfKey + "] is null or your friend key[" + friendKey
						+ "] is null.");
				return result;
			}
			ObjectNode imObject = EasemobIMUsers.deleteFriendSingle(selfKey, friendKey);
			if (HXResultUtil.isSuccess(imObject)) {
				result.setMsgCodeData("00", "query account of huaxin successfully!", imObject);
			} else {
				result.setMsgCodeData("99", "Failed to query account of huaxin", imObject);
			}
		} catch (Exception e) {
			result.setMsgCode("99", "registing huanxin is exception : " + e.getMessage());
		}
		return result;
	}

	@Override
	public ResultDataBean<ObjectNode> addBlacklist(String selfKey,
			String friendKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultDataBean<ObjectNode> removeBlacklist(String selfKey,
			String friendKey) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
