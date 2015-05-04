package com.iyoumei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.iyoumei.bean.CityBean;
import com.iyoumei.bean.DistrictBean;
import com.iyoumei.bean.ProvinceBean;
import com.iyoumei.persistence.DistrictMapper;
import com.iyoumei.service.IDistrictService;

public class DistrictServiceImpl implements IDistrictService {
	@Resource(type = DistrictMapper.class)
	private DistrictMapper districtMapper;
	@Override
	public List<ProvinceBean> getProvinceList() {
		return districtMapper.getProvinceList();
	}

	@Override
	public List<CityBean> getCityList(String provinceCode) {
		return districtMapper.getCityList(provinceCode);
	}

	@Override
	public List<DistrictBean> getDistrictList(String cityCode) {
		return districtMapper.getDistrictList(cityCode);
	}

}
