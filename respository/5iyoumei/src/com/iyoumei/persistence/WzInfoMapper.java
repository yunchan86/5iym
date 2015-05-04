package com.iyoumei.persistence;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.domain.WzInfoDomain;

public interface WzInfoMapper {
	/**
	 * 判断违章信息是否已经在数据库中存在
	 * 
	 * @param id
	 * @param carId
	 * @return
	 * @throws Exception
	 */
	public int isWzInfoExist(@Param("id") int id, @Param("carId") int carId) throws Exception;

	/**
	 * 保存违章记录
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	public int insert(WzInfoDomain domain) throws Exception;

	/**
	 * 更新违章信息（只更新处理标志）
	 * 
	 * @param id
	 * @param carId
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public int update(@Param("id") int id, @Param("carId") int carId, @Param("status") String status) throws Exception;
}
