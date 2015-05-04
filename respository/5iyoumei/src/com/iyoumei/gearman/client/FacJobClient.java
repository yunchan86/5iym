package com.iyoumei.gearman.client;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FacJobClient {

	protected static final Log logger = LogFactory.getLog(FacJobClient.class);
	
	@SuppressWarnings("rawtypes")
	public static void submit(AbsClientJob job,String workername,Map params)  {
		try {
			job.submit(workername, params) ;
		} catch (Exception e) {
			logger.error("workername="+workername+",params="+params, e);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void submitBackground(final AbsClientJob job,final String workername,final Map params)  {
		try {
			new Thread(){
				public void run(){
					job.submitBackground(workername, params) ;
				}
			}.start();
		} catch (Exception e) {
			logger.error("workername="+workername+",params="+params, e);
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static void submitBackground(final AbsClientJob job,final String workername,final String function,final String[] params)  {
		try {
			new Thread(){
				public void run(){
					job.submitJob(1, workername, function, params);
				}
			}.start();
		} catch (Exception e) {
			logger.error("workername="+workername+",params="+params, e);
		}
	}
}
