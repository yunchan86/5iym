package com.iyoumei.mapper1;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.entity.GroupMemberDomain;
import com.iyoumei.entity.GroupMemberInfoDomain;

public interface GroupMemberMapper {

	public List<GroupMemberDomain> selectGroupsMembers(long userId);
	
	public List<GroupMemberInfoDomain> selectMember(@Param("userId")long userId,@Param("groupId")long groupId) ;
	
}
