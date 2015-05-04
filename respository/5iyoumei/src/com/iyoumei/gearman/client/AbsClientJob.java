package com.iyoumei.gearman.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.gearman.Gearman;
import org.gearman.GearmanClient;
import org.gearman.GearmanJobEvent;
import org.gearman.GearmanJobReturn;
import org.gearman.GearmanServer;

import com.iyoumei.gearman.client.util.CommonCode;
import com.iyoumei.gearman.client.util.GearmanClientConfigUtil;
import com.iyoumei.gearman.client.util.GearmanCode;
import com.iyoumei.util.StringUtil;

public abstract class AbsClientJob {
	
	protected static final Log logger = LogFactory.getLog(AbsClientJob.class);
	
	private Gearman gearman = null;

	protected GearmanClient init() {
		GearmanClient client = null ;
		try {
			List<Map<String,String>> list = GearmanClientConfigUtil.getServerConfig() ;
			if(list==null||list.size()==0) return client ;
			gearman = Gearman.createGearman();
			client = gearman.createGearmanClient();
			Map<String,String> map = null ;
			for(int i=0;i<list.size();i++) {
				map = list.get(i) ;
				String host = null ;
				int port = 0 ;
				try {
					host = map.get("host") ;
					port = Integer.parseInt(map.get("port")) ;
					GearmanServer server = gearman.createGearmanServer(host, port);
					client.addServer(server);
				} catch (Exception e) {
					logger.error("初始化[host="+host+",port="+port+"]服务发生异常：", e) ;
				}
			}
		}catch (Exception e) {
			closeGearman() ;
			logger.error("初始化Gearman服务发生异常：", e) ;
		}
		return client ;
	}
	/**
	 * 此服务是同步运行的，即提交任务后需要等待返回才能进行后续操作
	 * @param workerName	worker服务名称，即在JobName中查找
	 * @param params		相对应的worker的Map参数数据
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected ClientJobReturn submit(String workerName,Map params) {
		ClientJobReturn  jobResult = new ClientJobReturn() ;
		GearmanClient client = null ;
		if(params==null||params.size()==0) return jobResult;
		if(!StringUtil.equals(this.verifyParams(workerName,params).getCode(), CommonCode.SUCCESS)) {
			jobResult.setInfo("参数错误，请确认Map中的参数数据") ;
			return jobResult  ;
		}
		client = this.init() ;//初始化服务
		try {
			String paramsJson = JSONObject.fromObject(params).toString() ;
			GearmanJobReturn jobReturn = client.submitJob(workerName,paramsJson.getBytes());
			while (!jobReturn.isEOF()) {
				 GearmanJobEvent event = jobReturn.poll();
		          switch (event.getEventType()) {
		          // success
		          case GEARMAN_JOB_SUCCESS: // Job completed successfully
		        	  jobResult.setData(new String(event.getData())) ;
		              break;
		          // failure
		          case GEARMAN_SUBMIT_FAIL: // The job submit operation failed
		          case GEARMAN_JOB_FAIL: // The job's execution failed
		              jobResult.setData(event.getEventType() + ": " + new String(event.getData())) ;
		          default : break ;
		          }
		          break ;
		      }
			jobResult.setCode("0") ;
			jobResult.setInfo("成功") ;
		} catch (Exception e) {
			logger.error("执行gearman job发生异常：", e) ;
			jobResult.setInfo("失败："+e.toString()) ;
		}finally {
			closeGearmanClient(client) ;
			closeGearman() ;
			logger.info("[worker="+workerName+",params="+params+"]执行后数据为：[result="+jobResult.toString()+"]") ;
		}
		return jobResult ;
	}
	/**
	 * 此服务是异步，提交后后台自动处理
	 * @param workerName	worker服务名称，即在JobName中查找
	 * @param params		相对应的worker的Map参数数据
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected ClientJobReturn submitBackground(String workerName,Map params) {
		ClientJobReturn  jobResult = new ClientJobReturn() ;
		GearmanClient client = null ;
		if(params==null||params.size()==0) return jobResult;
		if(!StringUtil.equals(this.verifyParams(workerName,params).getCode(), CommonCode.SUCCESS)) {
			jobResult.setInfo("参数错误，请确认Map中的参数数据") ;
			return jobResult  ;
		}
		client = this.init() ;//初始化服务
		try {
			String paramsJson = JSONObject.fromObject(params).toString() ;
			GearmanJobReturn jobReturn = client.submitBackgroundJob(workerName,paramsJson.getBytes());
			while (!jobReturn.isEOF()) {
				 GearmanJobEvent event = jobReturn.poll();
		          switch (event.getEventType()) {
		          // success
		          case GEARMAN_JOB_SUCCESS: // Job completed successfully
		        	  jobResult.setData(new String(event.getData())) ;
		              break;
		          // failure
		          case GEARMAN_SUBMIT_FAIL: // The job submit operation failed
		          case GEARMAN_JOB_FAIL: // The job's execution failed
		              jobResult.setData(event.getEventType() + ": " + new String(event.getData())) ;
		          default : break ;
		          }
		          break ;
		      }
			jobResult.setCode("0") ;
			jobResult.setInfo("成功") ;
		} catch (Exception e) {
			logger.error("执行gearman job发生异常：", e) ;
			jobResult.setInfo("失败："+e.toString()) ;
		}finally {
			closeGearmanClient(client) ;
			closeGearman() ;
			logger.info("[worker="+workerName+",params="+params+"]执行后数据为：[result="+jobResult.toString()+"]") ;
		}
		return jobResult ;
	}
	/**
	 * 参数校验
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected abstract GearmanCode verifyParams(String workerName,Map map) ;
	
	public void submitJob(int submitType,String workerName,String[] params) {
		Map<String,String> map = getParamsMap(params) ;
		if(submitType==1) this.submitBackground(workerName,map) ;
		else this.submit(workerName, map) ;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void submitJob(int submitType,String workerName,String function,String[] params) {
		Map map = new HashMap() ;
		map.put("function", function) ;
		Map subMap = getParamsMap(params) ;
		map.put("data", subMap) ;
		if(submitType==1) this.submitBackground(workerName,map) ;
		else this.submit(workerName, map) ;
	}
	
	@SuppressWarnings("rawtypes")
	public void submitJob(int submitType,String workerName,Map map) {
		if(submitType==1) this.submitBackground(workerName,map) ;
		else this.submit(workerName, map) ;
	}
	
	/**
	 * 
	 * @param params  [@string,@string,@string...]
	 * 其中@string的格式数据为两种：key=value
	 * 						key=key1#value1&key2#value2...
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Map<String,String> getParamsMap(String[] params) {
		Map map = new HashMap() ;
		for(String param : params) {
			String arr[] = param.split("=") ;//一级
			String key = arr[0] ;
			String value = arr[1] ;
			String values[] = value.split("&") ;//二级
			Map subMap = null;
			for(String valuekey : values) {
				String vkValues[] = valuekey.split("#") ;//三级
				int vklength = vkValues.length ;
				if(vklength==1) map.put(key, value) ;
				else {
					if(subMap==null)subMap = new HashMap() ;
					subMap.put(vkValues[0], vkValues[1]) ;
					if(!map.containsKey(key)) map.put(key, subMap) ;
				}
			}
		}
		System.out.println(map);
		return map ;
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
