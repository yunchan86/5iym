package com.iyoumei.service;

import java.util.Collection;

import com.iyoumei.entity.WzInfoDomain;
import com.iyoumei.modeldriver.WzQueryMd;

/**
 * 违章操作
 * 
 * @author Jeff
 * 
 */
public interface IWzService {
	/**
	 * 将违章数据同步到数据库
	 * 
	 * @param wzInfoColl
	 * @throws Exception
	 */
	public void synDataToDb(Collection<WzInfoDomain> wzInfoColl) throws Exception;

	/**
	 * 保存查询日志
	 * 
	 * @param md
	 * @throws Exception
	 */
	public void saveQueryLog(WzQueryMd md) throws Exception;
}
