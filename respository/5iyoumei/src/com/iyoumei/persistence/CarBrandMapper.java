package com.iyoumei.persistence;

import java.util.List;

import com.iyoumei.domain.CarBrandDomain;

public interface CarBrandMapper {

	public List<CarBrandDomain> getList(String userId) ;
	
}
