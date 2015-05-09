package com.iyoumei.mapper1;

import com.iyoumei.entity.WzQueryLogDomain;

public interface WzQueryLogMapper {

	/**
	 * 保存违章查询记录
	 * 
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	public int insert(WzQueryLogDomain domain) throws Exception;
}
