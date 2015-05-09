package com.iyoumei.service;

import java.util.List;

import com.iyoumei.bean.CarImageBean;
import com.iyoumei.bean.ColorBean;
import com.iyoumei.bean.MotorcydeTypeBean;
import com.iyoumei.bean.SameCarUserBean;
import com.iyoumei.entity.UserCarBrandDomain;
import com.iyoumei.entity.UserCarsDomain;
import com.iyoumei.modeldriver.UserCarsMd;

public interface IUserCarsService {
	/**
	 * 获取当前用户的驾座列表
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<UserCarsDomain> getUserCars(String userId) throws Exception;

	/**
	 * 设置当前驾座
	 * 
	 * @param carId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public boolean setCurrentCar(String carId, String userId) throws Exception;

	/**
	 * 新增驾座
	 * 
	 * @param md
	 * @return
	 * @throws Exception
	 */
	public boolean addCar(UserCarsMd md) throws Exception;

	/**
	 * 获取座驾信息
	 * 
	 * @param carId
	 * @param userId
	 * @throws Exception
	 */
	public UserCarsDomain getUserCar(String carId, String userId) throws Exception;

	/**
	 * 更新驾座
	 * 
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	public boolean updateCar(UserCarsDomain domain, boolean needUpdateCurrent) throws Exception;

	/**
	 * 删除驾座
	 * 
	 * @param userId
	 * @param carId
	 * @return
	 * @throws Exception
	 */
	public boolean deleteCar(String carId, String userId) throws Exception;

	/**
	 * 用户当前座驾数量
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public int userCarCount(String userId) throws Exception;

	/**
	 * 同车型车主
	 * 
	 * @param carId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<SameCarUserBean> sameCarUserBeanList(String carId, String userId) throws Exception;

	/**
	 * 读取颜色列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<ColorBean> getColorList(String motorcydeTypeId) throws Exception;

	/**
	 * 根据品牌ID读取车型列表
	 * 
	 * @param brandId
	 * @return
	 * @throws Exception
	 */
	public List<MotorcydeTypeBean> getMotorcydeTyeList(String brandId) throws Exception;

	/**
	 * 根据车型ID读取汽车图片
	 * 
	 * @param motorcydeTypeId
	 * @return
	 * @throws Exception
	 */
	public List<CarImageBean> getCarImageList(String motorcydeTypeId) throws Exception;

	/**
	 * 根据车型ID和颜色ID读取汽车图片
	 * 
	 * @param motorcydeTypeId
	 * @param colorId
	 * @return
	 * @throws Exception
	 */
	public List<CarImageBean> getCarImageList(String motorcydeTypeId, String colorId) throws Exception;
	/**
	 * 获取用户及卡信息
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public UserCarBrandDomain getUserCarInfo(String userId) throws Exception;;
}
