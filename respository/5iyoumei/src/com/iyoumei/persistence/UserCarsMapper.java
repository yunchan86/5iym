package com.iyoumei.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.iyoumei.bean.CarImageBean;
import com.iyoumei.bean.ColorBean;
import com.iyoumei.bean.MotorcydeTypeBean;
import com.iyoumei.bean.SameCarUserBean;
import com.iyoumei.domain.UserCarsDomain;

public interface UserCarsMapper {

	/**
	 * 新增驾座
	 * 
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	public int insert(UserCarsDomain domain) throws Exception;

	/**
	 * 获取用户的驾座信息
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<UserCarsDomain> getUserCarsList(String userId) throws Exception;

	/**
	 * 获取用户的驾座信息
	 * 
	 * @param id
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public UserCarsDomain getUserCar(@Param("id") String id, @Param("userId") String userId) throws Exception;

	/**
	 * 更新
	 * 
	 * @param domain
	 * @return
	 * @throws Exception
	 */
	public int update(UserCarsDomain domain) throws Exception;

	/**
	 * 删除座驾
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public int delete(@Param("id") String id, @Param("userId") String userId) throws Exception;

	/**
	 * 获取座驾数量
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public int getCarsCount(String userId) throws Exception;

	/**
	 * 设置当前座驾
	 * 
	 * @param id
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public int setCurrentCar(@Param("id") String id, @Param("userId") String userId) throws Exception;

	/**
	 * 设置非当前座驾
	 * 
	 * @param id
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public int setNotCurrentCar(@Param("id") String id, @Param("userId") String userId) throws Exception;

	/**
	 * 获取相同车型的用户数量
	 * 
	 * @param motorcydeTypeId
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public int getSameCarUserCount(@Param("motorcydeTypeId") String motorcydeTypeId, @Param("userId") String userId)
			throws Exception;

	/**
	 * 获取相同车型用户数据
	 * 
	 * @param motorcydeTypeId
	 * @param userId
	 * @param sqlFrom
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public List<SameCarUserBean> getSameCarUserList(@Param("motorcydeTypeId") String motorcydeTypeId,
			@Param("userId") String userId, @Param("sqlFrom") int sqlFrom, @Param("size") int size) throws Exception;
	
	/**
	 * 根据车型读取颜色列表
	 * @param motorcydeTyeId
	 * @return
	 * @throws Exception
	 */
	public List<ColorBean> getColorList(@Param("motorcydeTypeId")String motorcydeTypeId) throws Exception;
	/**
	 * 根据品牌读取车型
	 * @param brandId
	 * @return
	 * @throws Exception
	 */
	public List<MotorcydeTypeBean> getMotorcydeTypeList(@Param("brandId")String brandId) throws Exception;
	
	/**
	 * 根据车型ID读取汽车图片
	 * @param motorcydeTypeId
	 * @return
	 * @throws Exception
	 */
	public List<CarImageBean> getCarImageListByMotorcydeTypeId(@Param("motorcydeTypeId")String motorcydeTypeId) throws Exception;
	
	/**
	 * 根据车型ID和颜色ID读取汽车图片
	 * @param motorcydeTypeId
	 * @param colorId
	 * @return
	 * @throws Exception
	 */
	public List<CarImageBean> getCarImageListByMotorcydeTypeIdAndColorId(@Param("motorcydeTypeId")String motorcydeTypeId,@Param("colorId")String colorId) throws Exception;

}
