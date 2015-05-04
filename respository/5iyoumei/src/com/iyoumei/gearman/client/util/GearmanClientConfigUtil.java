package com.iyoumei.gearman.client.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Element;

import com.iyoumei.util.StringUtil;
import com.wuwaikeji.luyou.common.Dom4j;


public class GearmanClientConfigUtil {

	private static Log log = LogFactory.getLog(GearmanClientConfigUtil.class);
	private final static String configPath = "resources/gearman-client-config.xml" ;
	private static Element root ;
	static {
		if(root==null) {
			root = Dom4j.getRootElement(configPath) ;
		}
	}
	/**
	 * 获取Gearman服务的配置信息
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String,String>> getServerConfig() {
		List<Map<String,String>> list = null ;
		try {
			Element element = Dom4j.getChildElement(root,"servers") ;
			List<Element> listEl = Dom4j.getChildElements(element) ;//获取server配置
			Iterator<Element> it = listEl.iterator() ;
			while(it.hasNext()) {
				Element ele = it.next() ;
				String host = Dom4j.getTextValue(ele.element("host")) ;
				String portStr = Dom4j.getTextValue(ele.element("port")) ;
				Map<String,String> map = new HashMap<String,String>() ;
				map.put("host", host) ;
				map.put("port", portStr) ;
				if(list==null) list = new ArrayList<Map<String,String>>();
				list.add(map) ;
			}
		} catch (Exception e) {
			log.error("获取gearman的服务器配置异常：",e) ;
		}
		return list ;
	}
	
	/**
	 * 获取指定的资源配置
	 * @param resourceId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getResourceConfig(String resourceId) {
		String resource = null ;
		try {
			Element element = Dom4j.getChildElement(root,"resources") ;
			List<Element> listEl = Dom4j.getChildElements(element) ;//获取server配置
			Iterator<Element> it = listEl.iterator() ;
			while(it.hasNext()) {
				Element ele = it.next() ;
				String id = ele.attributeValue("id") ;
				if(StringUtil.equals(resourceId, id)) {
					resource = Dom4j.getTextValue(ele) ;
					break ;
				}
			}
		} catch (Exception e) {
			log.error("获取gearman的服务器配置异常：",e) ;
		}
		return resource ;
	}
}
