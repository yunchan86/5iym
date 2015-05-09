package com.iyoumei.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.easemob.server.jersey.api.EasemobChatGroups;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iyoumei.bean.GroupInfoBean;
import com.iyoumei.bean.GroupUsersInfoBean;
import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.entity.UserGroupInfoDomain;
import com.iyoumei.entity.UserGroupMemberDomain;
import com.iyoumei.entity.UserInfoDomain;
import com.iyoumei.mapper1.UserFullInfoMapper;
import com.iyoumei.mapper1.UserGroupInfoMapper;
import com.iyoumei.mapper1.UserGroupMemberMapper;
import com.iyoumei.mapper1.UserInfoHXMapper;
import com.iyoumei.mapper1.UserInfoMapper;
import com.iyoumei.mapper1.UuidMapper;
import com.iyoumei.service.IUserGroupManagerService;
import com.iyoumei.util.HXResultUtil;
import com.iyoumei.util.HXUserUtil;
import com.iyoumei.util.UserGroupMemberUtil;
import com.iyoumei.util.bean.LogBean;
import com.iyoumei.util.enumcollection.RespCode;

public class UserGroupManagerServiceImpl implements IUserGroupManagerService {
	
	private LogBean logbean = null ;

	@Resource(type = UserInfoMapper.class)
	private UserInfoMapper userInfoMapper;
	
	@Resource(type = UserGroupInfoMapper.class)
	private UserGroupInfoMapper userGroupInfoMapper ;
	
	@Resource(type = UserGroupMemberMapper.class)
	private UserGroupMemberMapper userGroupMemberMapper ;
	
	@Resource(type = UserInfoHXMapper.class)
	private UserInfoHXMapper userInfoHXMapper ;
	
	@Resource(type = UuidMapper.class)
	private UuidMapper uuidMapper ;
	
	@Resource(type = UserFullInfoMapper.class)
	private UserFullInfoMapper userFullInfoMapper ;
	@Override
	
	public ResultDataBean<UserGroupInfoDomain> create(GroupInfoBean bean) {
		if(logbean==null) logbean = new LogBean("UserGroupManagerServiceImpl::create","none","none","none") ;
		ResultDataBean<UserGroupInfoDomain> result = new ResultDataBean<UserGroupInfoDomain>();
		try {
			if(bean==null||bean.getCreateUserId()==0) {
				result.setMsgCode(RespCode.USER_NOT_EXISTS.getCode(), RespCode.USER_NOT_EXISTS.getDetail());
				logbean.setContentException( "your user_id is null.", null);
				return result;
			}
			UserInfoDomain userInfoDomain = this.userInfoMapper.selectByUserId(String.valueOf(bean.getCreateUserId())) ;
			if(userInfoDomain==null) {
				result.setMsgCode(RespCode.USER_NOT_EXISTS.getCode(), RespCode.USER_NOT_EXISTS.getDetail());
				logbean.setContentException("your user_id["+bean.getCreateUserId()+"] is not exist.", null);
				return result;
			}
			UserGroupInfoDomain userGroupInfoDomain = this.userGroupInfoMapper.selectByGroupname(bean.getCreateUserId(),bean.getGroupName()) ;
			if(userGroupInfoDomain!=null) {
				result.setMsgCode(RespCode.GROUP_EXISTS.getCode(), RespCode.GROUP_EXISTS.getDetail());
				logbean.setContentException("your user_id["+bean.getCreateUserId()+"] has added.", null);
				return result;
			}
			ObjectNode dataObjectNode = JsonNodeFactory.instance.objectNode();
			dataObjectNode.put("groupname", bean.getGroupName());
			dataObjectNode.put("desc", bean.getGroupDesc());
			dataObjectNode.put("approval", true);
			dataObjectNode.put("public", true);
			dataObjectNode.put("maxusers", 200);
			dataObjectNode.put("owner", HXUserUtil.getUserName(userInfoDomain));
			ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
			arrayNode.add(HXUserUtil.getUserName(userInfoDomain));
			dataObjectNode.put("members", arrayNode);
			ObjectNode creatChatGroupNode = EasemobChatGroups.creatChatGroups(dataObjectNode);
			logbean.setContentException(dataObjectNode.toString(), null);
			if (HXResultUtil.isSuccess(creatChatGroupNode)) {
				userGroupInfoDomain = HXResultUtil.getCreateGroupInfo(creatChatGroupNode, userInfoDomain) ;
				String uuid = uuidMapper.getUuidShort() ;
				//增加userGroupInfo
				userGroupInfoDomain.setUserId(bean.getCreateUserId());
				userGroupInfoDomain.setGroupId(Long.parseLong(uuid));
				userGroupInfoDomain.setGroupName(bean.getGroupName());
				userGroupInfoDomain.setComments(bean.getGroupDesc());
				this.userGroupInfoMapper.insert(userGroupInfoDomain) ;
				//增加会员，为群主
				UserGroupMemberDomain userGroupMemberInfo = new UserGroupMemberDomain() ;
				userGroupMemberInfo.setGroupId(Long.parseLong(uuid));
				userGroupMemberInfo.setJoinTime(new Date());
				userGroupMemberInfo.setStatus((byte)0);
				userGroupMemberInfo.setUserId(bean.getCreateUserId());
				this.userGroupMemberMapper.insert(userGroupMemberInfo) ;
				result.setMsgCodeData(RespCode.SUCCESS.getCode(),RespCode.SUCCESS.getDetail(), userGroupInfoDomain);
				logbean.setContentException("create group of huaxin successfully!", null);
			} else {
				result.setMsgCodeData(RespCode.GROUP_CREATE_ERROR.getCode(), RespCode.GROUP_CREATE_ERROR.getDetail(), null);
				logbean.setContentException("Failed to create group of huaxin", null);
			}
		} catch (Exception e) {
			e.printStackTrace(); 
			logbean.setContentException("create huanxin group  is exception :", e);
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
		}
		return result;
	}

	@Override
	public ResultDataBean<GroupInfoBean> get(long groupID) {
		if(logbean==null) logbean = new LogBean("UserGroupManagerServiceImpl::create","none","none","none") ;
		ResultDataBean<GroupInfoBean> result = new ResultDataBean<GroupInfoBean>();
		try {
			UserGroupInfoDomain userGroupInfo = this.userGroupInfoMapper.selectByPrimaryKey(groupID) ;
			if(userGroupInfo==null) {
				logbean.setContentException("group_id["+groupID+"] is not exists.", null);
				result.setMsgCode(RespCode.GROUP_NOT_EXISTS.getCode(), RespCode.GROUP_NOT_EXISTS.getDetail());
			}else {
				result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), getGroupInfoBean(userGroupInfo));
			}
		} catch (Exception e) {
			logbean.setContentException("group_id["+groupID+"] information exception:", e);
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
		} 
		return result;
	}
	
	private GroupInfoBean getGroupInfoBean(UserGroupInfoDomain userGroupInfo) {
		GroupInfoBean groupInfo = new GroupInfoBean() ;
		groupInfo.setCreateUserId(userGroupInfo.getUserId());
		groupInfo.setGroupDesc(userGroupInfo.getComments());
		groupInfo.setGroupId(userGroupInfo.getGroupId());
		groupInfo.setGroupName(userGroupInfo.getGroupName());
		if(userGroupInfo.getGroupStatus()!=null)groupInfo.setGroupStatus(userGroupInfo.getGroupStatus());
		if(userGroupInfo.getUserNum()!=null)groupInfo.setMaxNum(userGroupInfo.getUserNum());
		return groupInfo ;
	}

	@Override
	public ResultDataBean<?> del(long groupId) {
		if(logbean==null) logbean = new LogBean("UserGroupManagerServiceImpl::del","none","none","none") ;
		ResultDataBean<String> result = new ResultDataBean<String>();
		try {
			UserGroupInfoDomain userGroupInfo = this.userGroupInfoMapper.selectByPrimaryKey(groupId) ;
			if(userGroupInfo==null) {
				logbean.setContentException("group_id["+groupId+"] is not exists.", null);
				result.setMsgCode(RespCode.GROUP_NOT_EXISTS.getCode(), RespCode.GROUP_NOT_EXISTS.getDetail());
				return result ;
			}
			ObjectNode delNode = EasemobChatGroups.deleteChatGroups(String.valueOf(groupId)) ;
			if (HXResultUtil.isSuccess(delNode)) {
				result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), null);
				userGroupInfoMapper.deleteByPrimaryKey(groupId) ;
				this.userGroupMemberMapper.deleteGroupAll(groupId) ;
			}else {
				logbean.setContentException("group_id["+groupId+"] delete error.", null);
				result.setMsgCodeData(RespCode.GROUP_ERROR.getCode(), RespCode.GROUP_ERROR.getDetail(), null);
			}
		} catch (Exception e) {
			logbean.setContentException("group_id["+groupId+"] delete exception.", e);
			result.setMsgCodeData(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail(), null);
		}
		return result;
	}

	@Override
	public ResultDataBean<?> del(long userId, long groupId) {
		if(logbean==null) logbean = new LogBean("UserGroupManagerServiceImpl::del","none","none","none") ;
		ResultDataBean<String> result = new ResultDataBean<String>();
		try {
			UserGroupInfoDomain userGroupInfo = this.userGroupInfoMapper.selectByPrimaryKey(groupId) ;
			if(userGroupInfo==null) {
				logbean.setContentException("group_id["+groupId+"] is not exists.", null);
				result.setMsgCode(RespCode.GROUP_NOT_EXISTS.getCode(), RespCode.GROUP_NOT_EXISTS.getDetail());
				return result ;
			}
			if(userId!=userGroupInfo.getUserId()) {
				logbean.setContentException("group_id["+groupId+"] can not access.", null);
				result.setMsgCode(RespCode.NO_PRIVILEGE.getCode(), RespCode.NO_PRIVILEGE.getDetail());
				return result ;
			}
			ObjectNode delNode = EasemobChatGroups.deleteChatGroups(String.valueOf(groupId)) ;
			if (HXResultUtil.isSuccess(delNode)) {
				result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), null);
				userGroupInfoMapper.deleteByPrimaryKey(groupId) ;
				this.userGroupMemberMapper.deleteGroupAll(groupId) ;
			}else {
				logbean.setContentException("group_id["+groupId+"] delete error.", null);
				result.setMsgCodeData(RespCode.GROUP_ERROR.getCode(), RespCode.GROUP_ERROR.getDetail(), null);
			}
		} catch (Exception e) {
			logbean.setContentException("group_id["+groupId+"] delete exception.", e);
			result.setMsgCodeData(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail(), null);
		}
		return result;
	}

	@Override
	public ResultDataBean<?> delMember(long userId, long groupId, long delUserId) {
		if(logbean==null) logbean = new LogBean("UserGroupManagerServiceImpl::del","none","none","none") ;
		ResultDataBean<String> result = new ResultDataBean<String>();
		try {
			UserGroupInfoDomain userGroupInfo = this.userGroupInfoMapper.selectByPrimaryKey(groupId) ;
			if(userGroupInfo==null) {
				logbean.setContentException("group_id["+groupId+"] is not exists.", null);
				result.setMsgCode(RespCode.GROUP_NOT_EXISTS.getCode(), RespCode.GROUP_NOT_EXISTS.getDetail());
				return result ;
			}
			UserGroupMemberDomain userMember = this.userGroupMemberMapper.select(groupId, userId) ;
			if((!UserGroupMemberUtil.isManager(userMember))||(!UserGroupMemberUtil.isOwner(userMember))) {
				logbean.setContentException("user_id["+userId+"] is not access.", null);
				result.setMsgCode(RespCode.AUTH_CODE_ERROR.getCode(), RespCode.AUTH_CODE_ERROR.getDetail());
				return result ;
			}
			ObjectNode delNode = EasemobChatGroups.deleteUserFromGroup(String.valueOf(groupId),String.valueOf(delUserId)) ;
			if (HXResultUtil.isSuccess(delNode)) {
				result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), null);
				userGroupInfoMapper.deleteByPrimaryKey(groupId) ;
				this.userGroupMemberMapper.deleteGroupAll(groupId) ;
			}else {
				logbean.setContentException("group_id["+groupId+"] delete error.", null);
				result.setMsgCodeData(RespCode.GROUP_ERROR.getCode(), RespCode.GROUP_ERROR.getDetail(), null);
			}
		} catch (Exception e) {
			logbean.setContentException("group_id["+groupId+"] delete exception.", e);
			result.setMsgCodeData(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail(), null);
		}
		return result;
	}

	@Override
	public ResultDataBean<?> delBatchMember(long userId, long groupId,List<Long> delUserIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultDataBean<?> addMember(long userId, long groupId,
			long addUserId) {
		if(logbean==null) logbean = new LogBean("UserGroupManagerServiceImpl::addMember","none","none","none") ;
		ResultDataBean<String> result = new ResultDataBean<String>();
		try {
			if(userId==0||addUserId==0) {
				result.setMsgCode(RespCode.USER_NOT_EXISTS.getCode(), RespCode.USER_NOT_EXISTS.getDetail());
				logbean.setContentException("your user_id["+userId+"]or add user_id is null.", null);
				return result;
			}
			UserInfoDomain userInfoDomain = this.userInfoMapper.selectByUserId(String.valueOf(userId)) ;
			if(userInfoDomain==null) {
				result.setMsgCode(RespCode.USER_NOT_EXISTS.getCode(), RespCode.USER_NOT_EXISTS.getDetail());
				logbean.setContentException("your user_id["+userId+"] is not exist.", null);
				return result;
			}
			UserGroupMemberDomain userMember = this.userGroupMemberMapper.select(groupId, userId) ;
			if((!UserGroupMemberUtil.isManager(userMember))||(!UserGroupMemberUtil.isOwner(userMember))) {
				logbean.setContentException("user_id["+userId+"] is not access.", null);
				result.setMsgCode(RespCode.AUTH_CODE_ERROR.getCode(), RespCode.AUTH_CODE_ERROR.getDetail());
				return result ;
			}
			UserInfoDomain addUserInfoDomain = this.userInfoMapper.selectByUserId(String.valueOf(userId)) ;
			if(addUserInfoDomain==null) {
				result.setMsgCode(RespCode.USER_NOT_EXISTS.getCode(), RespCode.USER_NOT_EXISTS.getDetail());
				logbean.setContentException("your user_id["+userId+"] is not exist.", null);
				return result;
			}
			UserGroupInfoDomain userGroupInfoDomain = this.userGroupInfoMapper.selectByPrimaryKey(groupId) ;
			if(userGroupInfoDomain!=null) {
				result.setMsgCode(RespCode.GROUP_NOT_EXISTS.getCode(), RespCode.GROUP_NOT_EXISTS.getDetail());
				logbean.setContentException("group["+groupId+"] is not exists.user_id["+userId+"] add friend user_id["+addUserId+"] error.", null);
				return result;
			}
			ObjectNode creatChatGroupNode = EasemobChatGroups.addUserToGroup(String.valueOf(groupId),HXUserUtil.getUserName(addUserInfoDomain));
			if (HXResultUtil.isSuccess(creatChatGroupNode)) {
				userGroupInfoDomain = HXResultUtil.getCreateGroupInfo(creatChatGroupNode, userInfoDomain) ;
				logbean.setContentException("add member["+addUserId+"] to group["+groupId+"] of huaxin successfully!", null);
				result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), null);
			} else {
				logbean.setContentException("Failed to create group of huaxin"+creatChatGroupNode.toString(), null);
				result.setMsgCodeData(RespCode.GROUP_USER_CREATE_ERROR.getCode(), RespCode.GROUP_USER_CREATE_ERROR.getDetail(), null);
			}
		} catch (Exception e) {
			result.setMsgCode("99", "create huanxin group  is exception : " + e.getMessage());
		}
		return result;
	}

	

	@Override
	public ResultDataBean<?> addBatchMember(long userId, long groupId,
			List<Long> addUserIdList) {
		if(logbean==null) logbean = new LogBean("UserGroupManagerServiceImpl::addMember","none","none","none") ;
		ResultDataBean<UserGroupInfoDomain> result = new ResultDataBean<UserGroupInfoDomain>();
		try {
			if(userId==0||addUserIdList==null||addUserIdList.size()==0) {
				result.setMsgCode(RespCode.USER_NOT_EXISTS.getCode(), RespCode.USER_NOT_EXISTS.getDetail());
				logbean.setContentException("your user_id["+userId+"]or add user_id is null.", null);
				return result;
			}
			UserInfoDomain userInfoDomain = this.userInfoMapper.selectByUserId(String.valueOf(userId)) ;
			if(userInfoDomain==null) {
				result.setMsgCode(RespCode.USER_NOT_EXISTS.getCode(), RespCode.USER_NOT_EXISTS.getDetail());
				logbean.setContentException("your user_id["+userId+"] is not exist.", null);
				return result;
			}
			UserGroupMemberDomain userMember = this.userGroupMemberMapper.select(groupId, userId) ;
			if((!UserGroupMemberUtil.isManager(userMember))||(!UserGroupMemberUtil.isOwner(userMember))) {
				logbean.setContentException("user_id["+userId+"] is not access.", null);
				result.setMsgCode(RespCode.AUTH_CODE_ERROR.getCode(), RespCode.AUTH_CODE_ERROR.getDetail());
				return result ;
			}
			UserGroupInfoDomain userGroupInfoDomain = this.userGroupInfoMapper.selectByPrimaryKey(groupId) ;
			if(userGroupInfoDomain!=null) {
				result.setMsgCode(RespCode.GROUP_NOT_EXISTS.getCode(), RespCode.GROUP_NOT_EXISTS.getDetail());
				logbean.setContentException("group["+groupId+"] is not exists.user_id["+userId+"] add batch friend user_id error.", null);
				return result;
			}
			ArrayNode usernames = JsonNodeFactory.instance.arrayNode();
			for(Long addUserId : addUserIdList) {
				UserInfoDomain addUserInfoDomain = this.userInfoMapper.selectByUserId(String.valueOf(addUserId)) ;
				if(addUserInfoDomain==null) {
					result.setMsgCode(RespCode.USER_NOT_EXISTS.getCode(), RespCode.USER_NOT_EXISTS.getDetail());
					logbean.setContentException("your user_id["+userId+"] is not exist.", null);
					return result;
				}
				usernames.add(HXUserUtil.getUserName(addUserInfoDomain)) ;
			}
			ObjectNode usernamesNode = JsonNodeFactory.instance.objectNode();
			usernamesNode.put("usernames", usernames);
			ObjectNode creatChatGroupNode = EasemobChatGroups.addUsersToGroupBatch(String.valueOf(groupId),usernamesNode);
			if (HXResultUtil.isSuccess(creatChatGroupNode)) {
				userGroupInfoDomain = HXResultUtil.getCreateGroupInfo(creatChatGroupNode, userInfoDomain) ;
				logbean.setContentException("add members to group["+groupId+"] of huaxin successfully!", null);
				result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), userGroupInfoDomain);
			} else {
				logbean.setContentException("Failed to create group of huaxin"+creatChatGroupNode.toString(), null);
				result.setMsgCodeData(RespCode.GROUP_USER_CREATE_ERROR.getCode(), RespCode.GROUP_USER_CREATE_ERROR.getDetail(), null);
			}
		} catch (Exception e) {
			result.setMsgCode("99", "create huanxin group  is exception : " + e.getMessage());
		}
		return result;
	}

	@Override
	public void setLogbean(LogBean logbean) {
		this.logbean = logbean ;
	}

	@Override
	public ResultDataBean<GroupUsersInfoBean> getGroupMembers(long selfId,long groupId) {
		if(logbean==null) logbean = new LogBean("UserGroupManagerServiceImpl::create","none","none","none") ;
		ResultDataBean<GroupUsersInfoBean> result = new ResultDataBean<GroupUsersInfoBean>();
		try {
			UserInfoDomain userInfo = this.userInfoMapper.selectByUserId(String.valueOf(selfId)) ;
			if(userInfo==null) {
				logbean.setContentException("user_id["+selfId+"] is not exists.", null);
				result.setMsgCode(RespCode.USER_NOT_EXISTS.getCode(), RespCode.USER_NOT_EXISTS.getDetail());
				return result ;
			}
			UserGroupInfoDomain userGroupInfo = this.userGroupInfoMapper.selectByPrimaryKey(groupId) ;
			if(userGroupInfo==null) {
				logbean.setContentException("group_id["+groupId+"] is not exists.", null);
				result.setMsgCode(RespCode.GROUP_NOT_EXISTS.getCode(), RespCode.GROUP_NOT_EXISTS.getDetail());
			}else {
				//result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), getGroupInfoBean(userGroupInfo));
			}
		} catch (Exception e) {
			logbean.setContentException("group_id["+groupId+"] information exception:", e);
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
		} 
		return result;
	}
	
	@Override
	public ResultDataBean<List<GroupUsersInfoBean>> getGroupsMembers(long userId) {
		return null ;
	}

	@Override
	public ResultDataBean<List<GroupInfoBean>> getGroupList(long userId) {
		if(logbean==null) logbean = new LogBean("UserGroupManagerServiceImpl::getGroupList","none","none","none") ;
		ResultDataBean<List<GroupInfoBean>> result = new ResultDataBean<List<GroupInfoBean>>();
		try {
			UserInfoDomain userInfo = this.userInfoMapper.selectByUserId(String.valueOf(userId)) ;
			if(userInfo==null) {
				logbean.setContentException("user_id["+userId+"] is not exists.", null);
				result.setMsgCode(RespCode.USER_NOT_EXISTS.getCode(), RespCode.USER_NOT_EXISTS.getDetail());
			}else {
				List<UserGroupInfoDomain> list = this.userGroupInfoMapper.getGroupList(userId) ;
				List<GroupInfoBean> listGroup = new ArrayList<GroupInfoBean>() ;
				if(list!=null)
					for(UserGroupInfoDomain userGroupInfo : list) {
						listGroup.add(this.getGroupInfoBean(userGroupInfo)) ;
					}
				result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), listGroup);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logbean.setContentException("user_id["+userId+"] group information exception:", e);
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
		} 
		return result;
	}

}
