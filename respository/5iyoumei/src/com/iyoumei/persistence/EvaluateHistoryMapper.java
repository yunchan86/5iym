package com.iyoumei.persistence;

import com.iyoumei.domain.UserEvaluateHistoryDomain;


public interface EvaluateHistoryMapper {
	/**
	 * 生成一条用户评价记录
	 * @param userId
	 * @return
	 */
	int insert(UserEvaluateHistoryDomain bean);
}
