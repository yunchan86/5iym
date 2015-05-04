package com.iyoumei.util;

import java.util.Date;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.iyoumei.domain.UserGroupInfoDomain;
import com.iyoumei.domain.UserInfoDomain;
import com.iyoumei.domain.UserInfoHXDomain;

public class HXResultUtil {

	public static boolean isSuccess(ObjectNode data) {
		boolean b = true;
		if(data.has("error")) {
			b = false ;
		}
		return b ;
	}
	
	public static boolean isChatSuccess(ObjectNode data) {
		boolean b = true;
		if(data.toString().indexOf("success")==-1) {
			b = false ;
		}
		return b ;
	}
	
	public static UserInfoHXDomain getCreateInfo(ObjectNode data) {
		if(!isSuccess(data)) return null;
		UserInfoHXDomain userInfoHXDomain = new UserInfoHXDomain() ;
		JsonNode jsonNode = data.path("entities") ;
		if(!jsonNode.isArray()) return null ;
		JsonNode userData = jsonNode.get(0) ;
		userInfoHXDomain.setActivated(userData.get("activated").booleanValue());
		userInfoHXDomain.setHxUsername(userData.get("username").textValue());
		userInfoHXDomain.setHxUUID(userData.get("uuid").textValue());
		return userInfoHXDomain ;
	}
	
	public static UserGroupInfoDomain getCreateGroupInfo(ObjectNode data,UserInfoDomain userInfo) {
		if(!isSuccess(data)) return null;
		Date now = new Date() ;
		UserGroupInfoDomain userGroupInfoDomain = new UserGroupInfoDomain() ;
		if(data.has("desc"))userGroupInfoDomain.setComments(data.get("desc").asText());
		userGroupInfoDomain.setCreateTime(now);
		//userGroupInfoDomain.setGroupId(Long.parseLong(data.get("").asText()));
		if(data.has("groupname"))userGroupInfoDomain.setGroupName(data.get("groupname").asText());
		//userGroupInfoDomain.setUserId(HXUserUtil.getUserName(userInfoDomain));
		return userGroupInfoDomain ;
	}
}
