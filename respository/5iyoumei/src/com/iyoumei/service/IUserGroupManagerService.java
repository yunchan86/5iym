package com.iyoumei.service;

import java.util.List;

import com.iyoumei.bean.GroupInfoBean;
import com.iyoumei.bean.GroupUsersInfoBean;
import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.util.bean.LogBean;

public interface IUserGroupManagerService {
	
	public ResultDataBean<?> create(GroupInfoBean bean) ;

	public ResultDataBean<?> get(long groupID) ;
	
	public ResultDataBean<?> del(long groupId) ;
	
	public ResultDataBean<?> del(long userId,long groupId) ;
	
	public ResultDataBean<?> delMember(long userId,long groupId,long delUserId) ;
	
	public ResultDataBean<?> addMember(long userId,long groupId,long addUserId) ;
	
	public ResultDataBean<GroupUsersInfoBean> getGroupMembers(long selfId,long groupId) ;
	
	public ResultDataBean<List<GroupUsersInfoBean>> getGroupsMembers(long userId) ;
	
	public ResultDataBean<List<GroupInfoBean>> getGroupList(long userId) ;
	
	public ResultDataBean<?> addBatchMember(long userId,long groupId,List<Long> addUserIdList) ;
	
	public void setLogbean(LogBean logbean) ;

	ResultDataBean<?> delBatchMember(long userId, long groupId,List<Long> delUserIds);
	
}
