package com.iyoumei.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.iyoumei.domain.WzInfoDomain;
import com.iyoumei.domain.WzQueryLogDomain;
import com.iyoumei.modeldriver.WzQueryMd;
import com.iyoumei.persistence.UuidMapper;
import com.iyoumei.persistence.WzInfoMapper;
import com.iyoumei.persistence.WzQueryLogMapper;
import com.iyoumei.service.IWzService;

public class WzServiceImpl implements IWzService {
	@Resource(type = WzInfoMapper.class)
	private WzInfoMapper wzInfoMapper;
	@Resource(type = UuidMapper.class)
	private UuidMapper uuidMapper;
	@Resource(type = WzQueryLogMapper.class)
	private WzQueryLogMapper wzQueryLogMapper;
	private static String mutex = "lock";

	@Override
	@Transactional
	public void synDataToDb(Collection<WzInfoDomain> wzInfoColl) throws Exception {
		for (WzInfoDomain domain : wzInfoColl) {
			if (wzInfoMapper.isWzInfoExist(domain.getId(), domain.getCarId()) == 0) {
				synchronized (mutex) {
					if (wzInfoMapper.isWzInfoExist(domain.getId(), domain.getCarId()) == 0) {
						domain.setUuid(uuidMapper.getUuidShort());
						wzInfoMapper.insert(domain);
					}
				}
			} else
				wzInfoMapper.update(domain.getId(), domain.getCarId(), domain.getStatus());
		}
	}

	@Override
	public void saveQueryLog(WzQueryMd md) throws Exception {
		WzQueryLogDomain domain = new WzQueryLogDomain();
		domain.setUuid(uuidMapper.getUuidShort());
		domain.setCityId(md.getCityId());
		domain.setClassno(md.getClassno());
		domain.setEngineno(md.getEngineno());
		domain.setHphm(md.getHphm());
		domain.setRegistno(md.getRegistno());
		domain.setUserId(md.getUserId());
		wzQueryLogMapper.insert(domain);
	}

}
