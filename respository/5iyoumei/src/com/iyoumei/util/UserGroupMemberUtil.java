package com.iyoumei.util;

import com.iyoumei.domain.UserGroupMemberDomain;
import com.iyoumei.util.enumcollection.BusinessCode;

public class UserGroupMemberUtil {

	public static boolean isManager(UserGroupMemberDomain userGroupMember) {
		boolean b = false ;
		if(userGroupMember==null) return b ;
		if(userGroupMember.getLevel()==Integer.parseInt(BusinessCode.GROUP_MEMBER_MANAGER.getCode())) b = true ;
		return b ;
	}
	
	public static boolean isOwner(UserGroupMemberDomain userGroupMember) {
		boolean b = false ;
		if(userGroupMember==null) return b ;
		if(userGroupMember.getLevel()==Integer.parseInt(BusinessCode.GROUP_MEMBER_OWNER.getCode())) b = true ;
		return b ;
	}
}
