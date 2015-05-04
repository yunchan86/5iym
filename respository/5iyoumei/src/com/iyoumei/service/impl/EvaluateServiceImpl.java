package com.iyoumei.service.impl;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.domain.UserEvaluateDomain;
import com.iyoumei.domain.UserEvaluateHistoryDomain;
import com.iyoumei.gearman.client.CommonWorker;
import com.iyoumei.gearman.client.EvaluateUpClient;
import com.iyoumei.gearman.client.FacJobClient;
import com.iyoumei.modeldriver.EvaluateMd;
import com.iyoumei.persistence.EvaluateHistoryMapper;
import com.iyoumei.persistence.EvaluateMapper;
import com.iyoumei.service.IEvaluateService;
import com.iyoumei.util.bean.LogBean;
import com.iyoumei.util.enumcollection.RespCode;

public class EvaluateServiceImpl implements IEvaluateService {
	
	private static Log logger = LogFactory.getLog(EvaluateServiceImpl.class);
	
	private LogBean logbean = null ;
	
	@Resource(type = EvaluateMapper.class)
	private EvaluateMapper evaluateMapper;
	
	@Resource(type = EvaluateHistoryMapper.class)
	private EvaluateHistoryMapper userEvaluateMapper;
	
	public EvaluateMapper getEvaluateMapper() {
		return evaluateMapper;
	}

	public void setEvaluateMapper(EvaluateMapper evaluateMapper) {
		this.evaluateMapper = evaluateMapper;
	}
	@Override
	public Boolean evaluate(EvaluateMd md) throws Exception {
		Boolean hr=false;
		try{ 
			int count=evaluateMapper.checkUserEvaluate(md.getUserId());
			if(count==0){
					evaluateMapper.insert(md.getUserId());
				}
			UserEvaluateHistoryDomain ueh = new  UserEvaluateHistoryDomain() ;
			ueh.setUserId(Long.parseLong(md.getUserId()));
			ueh.setEvaUserId(Long.parseLong(md.getEvaUserId()));
			if(md.getEvaType().toLowerCase().equals("p")){
				evaluateMapper.updatePraiseTimes(md.getUserId());
				ueh.setEvaType(0);
			}else{
				evaluateMapper.updateStampTimes(md.getUserId());
				ueh.setEvaType(1);
			}
			hr=true;
			userEvaluateMapper.insert(ueh) ;
			if(md.getEvaType().toLowerCase().equals("p"))
				FacJobClient.submitBackground(new EvaluateUpClient(), CommonWorker.WORKER_COMMON_NAME, CommonWorker.FUNCTION_EVALUATE, 
						new String[]{"from="+md.getEvaUserId(),"to="+md.getUserId(),"module_id="+CommonWorker.MODULE_TRANSMISSION});
		}
		catch(Exception e){
			logger.error("用户评价出现异常！", e);
		}
		return hr;
	}
	
	public ResultDataBean<UserEvaluateDomain> evaluteInfo(long userId) {
		ResultDataBean<UserEvaluateDomain> result = new ResultDataBean<UserEvaluateDomain>();
		if(logbean==null) logbean = new LogBean("EvaluateServiceImpl::evaluteInfo","none","none","none") ;
		try {
			UserEvaluateDomain userEvaluate = this.evaluateMapper.get(userId) ;
			result.setMsgCodeData(RespCode.SUCCESS.getCode(), RespCode.SUCCESS.getDetail(), userEvaluate);
			logbean.setContentException("user["+userId+"] get user["+userId+"] evaluate success.", null);
		} catch (Exception e) {
			result.setMsgCodeData(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail(), null);
			logbean.setContentException("99", e);
		}
		return result;
	}

	public void setLogbean(LogBean logbean) {
		this.logbean = logbean;
	}
	
	

}
