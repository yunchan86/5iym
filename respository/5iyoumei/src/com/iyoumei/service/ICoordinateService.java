package com.iyoumei.service;

import com.iyoumei.modeldriver.CoordinateMd;

public interface ICoordinateService {
	/**
	 * 上报用户坐标
	 * @param md
	 * @return
	 * @throws Exception
	 */
	public Boolean report(CoordinateMd md) throws Exception;
}
