package com.iyoumei.service.impl;

import javax.annotation.Resource;

import com.iyoumei.modeldriver.CoordinateMd;
import com.iyoumei.persistence.CoordinateMapper;
import com.iyoumei.service.ICoordinateService;

public class CoordinateServiceImpl implements ICoordinateService {

	@Resource(type = CoordinateMapper.class)
	private CoordinateMapper coordinateMapper;

	public void setCoordinateMapper(CoordinateMapper coordinateMapper) {
		this.coordinateMapper = coordinateMapper;
	}

	@Override
	public Boolean report(CoordinateMd md) throws Exception {
		Boolean hr=false;
		
		coordinateMapper.insertUserPositionHistory(md.getUserId(), md.getX(), md.getY());
		int count=coordinateMapper.checkUserPosition(md.getUserId());
		if(count>0){
			coordinateMapper.updateUserPosition(md.getUserId(), md.getX(), md.getY());
		}else{
			coordinateMapper.insertUserPosition(md.getUserId(), md.getX(), md.getY());
		}
		hr=true;
		
		return hr;
	}

}
