package com.iyoumei.service.impl;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.iyoumei.bean.CarImageBean;
import com.iyoumei.bean.ColorBean;
import com.iyoumei.bean.MotorcydeTypeBean;
import com.iyoumei.bean.SameCarUserBean;
import com.iyoumei.entity.CarBrandDomain;
import com.iyoumei.entity.UserCarBrandDomain;
import com.iyoumei.entity.UserCarsDomain;
import com.iyoumei.entity.UserInfoDomain;
import com.iyoumei.exception.UserNotExistsException;
import com.iyoumei.mapper1.CarBrandMapper;
import com.iyoumei.mapper1.UserCarsMapper;
import com.iyoumei.mapper1.UserInfoMapper;
import com.iyoumei.mapper1.UuidMapper;
import com.iyoumei.modeldriver.UserCarsMd;
import com.iyoumei.service.IUserCarsService;

public class UserCarsServiceImpl implements IUserCarsService {

	@Resource(type = UserCarsMapper.class)
	private UserCarsMapper userCarsMapper;
	@Resource(type = UuidMapper.class)
	private UuidMapper uuidMapper;
	@Resource(type = CarBrandMapper.class)
	private CarBrandMapper carBrandMapper ;
	@Resource(type = UserInfoMapper.class)
	private UserInfoMapper uiMapper ;

	@Override
	public List<UserCarsDomain> getUserCars(String userId) throws Exception {
		return userCarsMapper.getUserCarsList(userId);
	}

	@Override
	public boolean setCurrentCar(String carId, String userId) throws Exception {
		userCarsMapper.setCurrentCar(carId, userId);
		return true;
	}

	@Override
	public synchronized boolean addCar(UserCarsMd md) throws Exception {
		int carsCount = userCarsMapper.getCarsCount(md.getUserId());
		int current = 0;
		if (carsCount == 0)
			current = 1;
		UserCarsDomain domain = new UserCarsDomain();
		domain.setBrandId(md.getBrandId());
		domain.setCarImgId(md.getCarImgId());
		domain.setColorId(md.getColorId());
		domain.setCurrent(current);
		domain.setId(uuidMapper.getUuidShort());
		domain.setLicenseNumber(md.getLicenseNumber());
		domain.setMotorcydeTypeId(md.getMotorcydeTypeId());
		domain.setUserId(md.getUserId());
		userCarsMapper.insert(domain);
		return true;
	}

	@Override
	public UserCarsDomain getUserCar(String carId, String userId) throws Exception {
		return userCarsMapper.getUserCar(carId, userId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean updateCar(UserCarsDomain domain, boolean needUpdateCurrent) throws Exception {

		userCarsMapper.update(domain);
		if (needUpdateCurrent)
			userCarsMapper.setNotCurrentCar(domain.getId(), domain.getUserId());
		return true;
	}

	@Override
	public List<ColorBean> getColorList(String motorcydeTypeId) throws Exception {
		return userCarsMapper.getColorList(motorcydeTypeId);
	}

	@Override
	public List<MotorcydeTypeBean> getMotorcydeTyeList(String brandId) throws Exception {
		return userCarsMapper.getMotorcydeTypeList(brandId);
	}

	@Override
	public List<CarImageBean> getCarImageList(String motorcydeTypeId) throws Exception {
		return userCarsMapper.getCarImageListByMotorcydeTypeId(motorcydeTypeId);
	}

	@Override
	public List<CarImageBean> getCarImageList(String motorcydeTypeId, String colorId) throws Exception {
		return userCarsMapper.getCarImageListByMotorcydeTypeIdAndColorId(motorcydeTypeId, colorId);
	}

	@Override
	public boolean deleteCar(String carId, String userId) throws Exception {
		userCarsMapper.delete(carId, userId);
		return true;
	}

	@Override
	public int userCarCount(String userId) throws Exception {
		return userCarsMapper.getCarsCount(userId);
	}

	@Override
	public List<SameCarUserBean> sameCarUserBeanList(String carId, String userId) throws Exception {
		UserCarsDomain userCar = userCarsMapper.getUserCar(carId, userId);
		if (userCar == null)
			return null;

		// 同车型用户数量
		int samecarCount = userCarsMapper.getSameCarUserCount(userCar.getMotorcydeTypeId(), userId);
		if (samecarCount == 0)
			return null;
		// 获取随机查询位置
		int pageSize = 5;// 每页查询5个数据
		Random r = new Random();
		int sqlFrom = Math.max(r.nextInt(samecarCount) - pageSize, 0);
		// 获取相同车型用户的数据
		return userCarsMapper.getSameCarUserList(userCar.getMotorcydeTypeId(), userId, sqlFrom, pageSize);
	}

	@Override
	public UserCarBrandDomain getUserCarInfo(String userId) throws Exception {
		UserCarBrandDomain userCarBrand = null ;
		UserInfoDomain userInfo = this.uiMapper.selectByUserId(userId) ;
		if(userInfo==null) throw new UserNotExistsException("用户不存在。") ;
		List<CarBrandDomain> carBranList = this.carBrandMapper.getList(userId) ;
		userCarBrand = new UserCarBrandDomain() ;
		userCarBrand.setUserInfo(userInfo);
		userCarBrand.setCarBrand(carBranList);
		return userCarBrand;
	}

}
