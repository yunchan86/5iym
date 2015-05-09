package com.iyoumei.mapper1;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.bean.CityBean;
import com.iyoumei.bean.DistrictBean;
import com.iyoumei.bean.ProvinceBean;

public interface DistrictMapper {
	public List<ProvinceBean> getProvinceList();

	public List<CityBean> getCityList(@Param("provinceCode") String provinceCode);

	public List<DistrictBean> getDistrictList(@Param("cityCode") String cityCode);

}
