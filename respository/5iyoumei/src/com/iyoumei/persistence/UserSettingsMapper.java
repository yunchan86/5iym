package com.iyoumei.persistence;

import org.apache.ibatis.annotations.Param;

public interface UserSettingsMapper {
	/**
	 * 更新常用联系人
	 * @param user1
	 * @param user2
	 * @param regularFriend
	 * @return
	 */
	int updateRegularfriend(@Param("user1")String user1,@Param("user2")String user2,@Param("regularFriend")String regularFriend);
	
	/**
	 * 主用户朋友圈信息从用户可见
	 * @param user1
	 * @param user2
	 * @param friendCircle1
	 * @return
	 */
	int updateFriendCircle1(@Param("user1")String user1,@Param("user2")String user2,@Param("friendCircle1")String friendCircle1);
	
	/**
	 * 从用户的朋友圈信息是否对主用户可见
	 * @param user1
	 * @param user2
	 * @param friendCircle2
	 * @return
	 */
	int updateFriendCircle2(@Param("user1")String user1,@Param("user2")String user2,@Param("friendCircle2")String friendCircle2);
	
	/**
	 * 主用户好友地图对从用户是否可见
	 * @param user1
	 * @param user2
	 * @param friendMap
	 * @return
	 */
	int updateFriendMap(@Param("user1")String user1,@Param("user2")String user2,@Param("friendMap")String friendMap);
	
	/**
	 * 好友验证开关
	 * @param userId
	 * @param approveType
	 * @return
	 */
	int updateApproveTypeSwitch(@Param("userId")String userId,@Param("approveTypeSwitch")String approveTypeSwitch);
	
	/**
	 * 通过账号找到我
	 * @param userId
	 * @param mobileNumberSwitch
	 * @return
	 */
	int updateMobileNumberSwitch(@Param("userId")String userId,@Param("mobileNumberSwitch")String mobileNumberSwitch);
	
	/**
	 * 通过车牌找到我
	 * @param userId
	 * @param licencePlateSwitch
	 * @return
	 */
	int updateLicencePlateSwitch(@Param("userId")String userId,@Param("licencePlateSwitch")String licencePlateSwitch);
	
	/**
	 * 是否开启好友地图
	 * @param userId
	 * @param showInMap
	 * @return
	 */
	int updateShowInMap(@Param("userId")String userId,@Param("showInMap")String showInMap);
	
	/**
	 * 陌生人临时会话开关
	 * @param userId
	 * @param strangerMessageSwitch
	 * @return
	 */
	int updateStrangerMessageSwitch(@Param("userId")String userId,@Param("strangerMessageSwitch")String strangerMessageSwitch);
	
	/**
	 * 是否允许陌生人查看图片
	 * @param userId
	 * @param picViewLimit
	 * @return
	 */
	int updatePicViewLimit(@Param("userId")String userId,@Param("picViewLimit")String picViewLimit);
}
