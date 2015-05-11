package com.iyoumei.util;

public class CurrencyUtil {

	/**
	 * 将数据库中的数据转换为人民币单位
	 * @param dbMoney
	 * @return
	 */
	public static double getCNY(long dbMoney) {
		double amt = 0.0000 ;
		amt = (dbMoney*1.0000)/(10000*1.0000) ;
		return amt ;
	}
}
