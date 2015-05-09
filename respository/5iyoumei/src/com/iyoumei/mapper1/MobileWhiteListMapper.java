package com.iyoumei.mapper1;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MobileWhiteListMapper {
	/**
	 * 判断是否是白名单 <br>
	 * 返回值大于0为白名单
	 * 
	 * @return
	 * @throws Exception
	 */
	@Select("select count(*) from mobile_white_list where mobile_number=#{mobileNumber}")
	public int isWhite(String mobileNumber) throws Exception;

	/**
	 * 增加白名单
	 * 
	 * @return
	 * @throws Exception
	 */
	@Insert("insert into mobile_white_list values(#{mobileNumber}) ")
	public int addWhite(String mobileNumber) throws Exception;

}
