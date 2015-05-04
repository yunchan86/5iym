package com.iyoumei.persistence;

import org.apache.ibatis.annotations.Param;

public interface CoordinateMapper {
	
	int checkUserPosition(@Param("userId")String userId);
	
	int insertUserPosition(@Param("userId")String userId,@Param("xPos") String xPos,@Param("yPos") String yPos);
	
	int updateUserPosition(@Param("userId")String userId,@Param("xPos") String xPos,@Param("yPos") String yPos);
	
	int insertUserPositionHistory(@Param("userId")String userId,@Param("xPos") String xPos,@Param("yPos") String yPos);
	
}
