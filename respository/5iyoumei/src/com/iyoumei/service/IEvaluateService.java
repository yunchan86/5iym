package com.iyoumei.service;

import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.domain.UserEvaluateDomain;
import com.iyoumei.modeldriver.EvaluateMd;
import com.iyoumei.util.bean.LogBean;

public interface IEvaluateService {
	/**
	 * 用户评价 赞 踩
	 * @param md
	 * @return
	 * @throws Exception
	 */
	public Boolean evaluate(EvaluateMd md) throws Exception;
	
	public ResultDataBean<UserEvaluateDomain> evaluteInfo(long userId) ;
	
	public void setLogbean(LogBean logbean);
}
