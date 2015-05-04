package com.iyoumei.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.domain.GroupMemberDomain;
import com.iyoumei.domain.GroupMemberInfoDomain;

public interface GroupMemberMapper {

	public List<GroupMemberDomain> selectGroupsMembers(long userId);
	
	public List<GroupMemberInfoDomain> selectMember(@Param("userId")long userId,@Param("groupId")long groupId) ;
	
}
