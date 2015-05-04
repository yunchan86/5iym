package com.iyoumei.util;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RequestUtil {
	private static Log log = LogFactory.getLog(RequestUtil.class);

	public static String getIp(HttpServletRequest request) {
		String ip = null;
		ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	private static String simulateIp() {
		String ip = null;
		String str[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			sb.append(str[(int) (Math.random() * 10)] + ""
					+ str[(int) (Math.random() * 10)]);
		}
		return sb.toString();
	}

	/**
	 * 将request中的值存入到Map中
	 * 
	 * @param request
	 * @return
	 */
	public static Map resquest2Map(HttpServletRequest request) {
		Map reqMap = request.getParameterMap();
		Map params = new HashMap();
		String method = request.getMethod();
		String signType = (String) reqMap.get("encode_type");
		for (Iterator iter = reqMap.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) reqMap.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			if (StringUtil.equals(method.toUpperCase(), "POST")) {
				try {
					if (StringUtil.isNull(signType))
						signType = "GBK";
					valueStr = new String(valueStr.getBytes("iso8859_1"),
							signType);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			params.put(name, valueStr);
		}
		return params;
	}

	/**
	 * request传过来的值进行编码,并存入到Map中
	 * 
	 * @param request
	 * @param fromCharset
	 * @param toCharset
	 * @return
	 */
	public static Map resquest2Map(HttpServletRequest request,
			String fromCharset, String toCharset) {
		Map reqMap = request.getParameterMap();
		log.info("request的编码为：" + request.getCharacterEncoding());
		Map params = new HashMap();
		for (Iterator iter = reqMap.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) reqMap.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			try {
				log.info("原始数据：[" + name + ":" + valueStr + "]");
				params.put(name, new String(valueStr.getBytes(fromCharset),
						toCharset));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		log.info("处理数据：" + params);
		return params;
	}
}
