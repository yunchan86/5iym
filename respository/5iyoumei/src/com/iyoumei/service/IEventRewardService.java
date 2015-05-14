package com.iyoumei.service;

import com.iyoumei.bean.CommonServiceResult;

public interface IEventRewardService {

	/**
	 * 批处理
	 * @return
	 */
	public CommonServiceResult<?> service() ;
	/**
	 * 单条数据处理
	 * @param userId
	 * @return
	 */
	public CommonServiceResult<?> service(long userId) ;
}
