package com.iyoumei.util.enumcollection;

/**
 * 请求返回结果
 * 
 * @author huang
 *
 */
public interface IResMsg {
	
	/**
	 * 结果编码
	 * 
	 * @return
	 */
	public String getCode() ;
	
	/**
	 * 结果详细描述
	 * 
	 * @return
	 */
	public String getDetail() ;
}
