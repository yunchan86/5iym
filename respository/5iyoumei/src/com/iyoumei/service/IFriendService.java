package com.iyoumei.service;

import java.util.List;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.domain.*;

public interface  IFriendService {

	public ResultDataBean<ObjectNode> singleReg(UserInfoDomain userInfo) ;
	
	public ResultDataBean<ObjectNode> batchReg(List<UserInfoDomain> userInfoList)  ;
	
	public ResultDataBean<ObjectNode> get(UserInfoHXDomain userHx) ;
	
	public ResultDataBean<ObjectNode> del(UserInfoHXDomain userHx) ;
	
	public ResultDataBean<ObjectNode> remove(String selfKey,String friendKey) ;
	
	public ResultDataBean<ObjectNode> addBlacklist(String selfKey,String friendKey) ;
	
	public ResultDataBean<ObjectNode> removeBlacklist(String selfKey,String friendKey) ;
	
	//public ResultDataBean<ObjectNode> batchDel(UserInfoHXDomain userHx) ;
	
	public ResultDataBean<ObjectNode> modifyPwd(UserInfoHXDomain userHx,String newPassword) ;
	
	public ResultDataBean<ObjectNode> singleFriendAdd(String selfKey,String friendKey) ;
	
	public ResultDataBean<ObjectNode> getFriendList(String selfKey) ;
}
