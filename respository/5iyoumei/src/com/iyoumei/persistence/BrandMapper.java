package com.iyoumei.persistence;

import java.util.Date;
import java.util.List;

import com.iyoumei.bean.BrandBean;

public interface BrandMapper {
	/**
	 * 获取品牌最后一次更新时间
	 * @return
	 * @throws Exception
	 */
	public Date lastUpdateTime() throws Exception;
	/**
	 * 读取品牌列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<BrandBean> getBrandList() throws Exception;

}
