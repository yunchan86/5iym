package com.iyoumei.mapper1;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.entity.UserEvaluateDomain;

public interface EvaluateMapper {
	/**
	 * 检查是否已经存在用户评价记录
	 * @param userId
	 * @return
	 */
	int checkUserEvaluate(@Param("userId")String userId);
	
	/**
	 * 生成一条用户评价记录
	 * @param userId
	 * @return
	 */
	int insert(@Param("userId")String userId);
	
	/**
	 * 增加赞计数
	 * @param userId
	 * @return
	 */
	int updatePraiseTimes(@Param("userId")String userId);
	
	/**
	 * 增加踩计数
	 * @param userId
	 * @return
	 */
	int updateStampTimes(@Param("userId")String userId);
	
	UserEvaluateDomain get(long userId) ;
}
