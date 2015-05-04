package com.iyoumei.persistence;

import com.iyoumei.domain.WzQueryLogDomain;

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
