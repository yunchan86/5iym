package com.iyoumei.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.iyoumei.bean.BrandBean;
import com.iyoumei.persistence.BrandMapper;
import com.iyoumei.service.IBrandService;

public class BrandServiceImpl implements IBrandService {
	@Resource(type = BrandMapper.class)
	private BrandMapper brandMapper;

	@Override
	public Date lastUpdateTime() throws Exception {
		return brandMapper.lastUpdateTime();
	}

	@Override
	public List<BrandBean> getBrandList() throws Exception {
		return brandMapper.getBrandList();
	}

}
