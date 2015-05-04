package com.iyoumei.gearman.client;

import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.gearman.Gearman;
import org.gearman.GearmanClient;
import org.gearman.GearmanJobEvent;
import org.gearman.GearmanJobReturn;
import org.gearman.GearmanServer;

public class GearmanJobConnection {
	
	protected static final Log logger = LogFactory.getLog(GearmanJobConnection.class);
	
	private Gearman gearman = null;

	/**
	 * 提交并同步执行
	 * @param host
	 * @param port
	 * @param workerName
	 * @param params
	 */
	@SuppressWarnings("rawtypes")
	public void submit(String host,int port,String workerName,Map params){
		String result = "-1" ;
		GearmanClient client = null ;
		if(params==null||params.size()==0) return ;
		try {
			client = this.init(host, port) ;
			String paramsJson = JSONObject.fromObject(params).toString() ;
			GearmanJobReturn jobReturn = client.submitJob(workerName,paramsJson.getBytes());
			System.out.println("前");
			while (!jobReturn.isEOF()) {
		          GearmanJobEvent event = jobReturn.poll();
		          switch (event.getEventType()) {
		          // success
		          case GEARMAN_JOB_SUCCESS: // Job completed successfully
		        	  result = new String(event.getData()) ;
		              System.out.println(new String(event.getData()));
		              System.out.println("成功");
		              break;
		          // failure
		          case GEARMAN_SUBMIT_FAIL:   System.out.println("subm失败");// The job submit operation failed
		          case GEARMAN_JOB_FAIL:   System.out.println("job失败");// The job's execution failed
		        	  result = event.getEventType() + ": " + new String(event.getData()) ;
		              System.err.println(event.getEventType() + ": " + new String(event.getData()));
		          default : break ;
		          }
		          break ;
		      }
		} catch (Exception e) {
			result = e.toString() ;
			logger.error("执行gearman job发生异常：", e) ;
		}finally {
			closeGearmanClient(client) ;
			closeGearman() ;
			logger.info("[host="+host+",port="+port+",worker="+workerName+",params="+params+"]执行后数据为：[result="+result+"]") ;
		}
		System.out.println("后");
	}
	/**
	 * 后台异步执行
	 * @param host
	 * @param port
	 * @param workerName
	 * @param params
	 */
	@SuppressWarnings("rawtypes")
	public void submitBackground(String host,int port,String workerName,Map params){
		String result = "-1" ;
		GearmanClient client = null ;
		if(params==null||params.size()==0) return ;
		try {
			client = this.init(host, port) ;
			String paramsJson = JSONObject.fromObject(params).toString() ;
			GearmanJobReturn jobReturn = client.submitBackgroundJob(workerName,paramsJson.getBytes());
			while (!jobReturn.isEOF()) {
				 GearmanJobEvent event = jobReturn.poll();
		          switch (event.getEventType()) {
		          // success
		          case GEARMAN_JOB_SUCCESS: // Job completed successfully
		        	  result = new String(event.getData()) ;
		              System.out.println(new String(event.getData()));
		              break;
		          // failure
		          case GEARMAN_SUBMIT_FAIL: // The job submit operation failed
		          case GEARMAN_JOB_FAIL: // The job's execution failed
		        	  result = event.getEventType() + ": " + new String(event.getData()) ;
		              System.err.println(event.getEventType() + ": " + new String(event.getData()));
		          default : break ;
		          }
		          break ;
		      }
		} catch (Exception e) {
			result = e.toString() ;
			logger.error("执行gearman job发生异常：", e) ;
		}finally {
			closeGearmanClient(client) ;
			closeGearman() ;
			logger.info("[host="+host+",port="+port+",worker="+workerName+",params="+params+"]执行后数据为：[result="+result+"]") ;
		}
	      
	}
	
	protected GearmanClient init(String host,int port) {
		GearmanClient client = null ;
		try {
			if(gearman==null) gearman = Gearman.createGearman();
			client = gearman.createGearmanClient();
			GearmanServer server = gearman.createGearmanServer(host, port);
			client.addServer(server);
		}catch (Exception e) {
			logger.error("初始化Gearman客户端发生异常：", e) ;
		}
		return client ;
	}
	
	protected void closeGearman() {
		if(gearman!=null&&!gearman.isShutdown()) {
			gearman.shutdown() ;
			gearman = null ;
		}
	}
	
	protected void closeGearmanClient(GearmanClient client) {
		if(client!=null&&!client.isShutdown()) {
			client.shutdown() ;
			client = null ;
		}
	}
}
