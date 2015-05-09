package com.iyoumei.mapper1;

import com.iyoumei.entity.UserEvaluateHistoryDomain;


public interface EvaluateHistoryMapper {
	/**
	 * 生成一条用户评价记录
	 * @param userId
	 * @return
	 */
	int insert(UserEvaluateHistoryDomain bean);
}
