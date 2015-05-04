package com.iyoumei.service;

import java.util.List;

import com.iyoumei.bean.CityBean;
import com.iyoumei.bean.DistrictBean;
import com.iyoumei.bean.ProvinceBean;

public interface IDistrictService {
	/**
	 * 获取省份列表
	 * 
	 * @return
	 */
	public List<ProvinceBean> getProvinceList();

	/**
	 * 根据省份代码获取城市信息
	 * 
	 * @param provinceCode
	 * @return
	 */
	public List<CityBean> getCityList(String provinceCode);

	/**
	 * 根据城市代码获取城区/区县信息
	 * 
	 * @param cityCode
	 * @return
	 */
	public List<DistrictBean> getDistrictList(String cityCode);
}
