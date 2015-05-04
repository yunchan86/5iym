package com.iyoumei.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class UtilMethods {
	private static Log logger = LogFactory.getLog(UtilMethods.class);

	/**
	 * 
	 * 
	 * @param message
	 */
	public static void responseMessage(HttpServletRequest request, HttpServletResponse response, final String message) {
		responseMessagePlain(request, response, message);
	}

	/**
	 * 返回数据
	 * 
	 * @param response
	 * @param message
	 * @param type
	 *            (xml或者json)
	 */
	public static void responseMessage(HttpServletRequest request, HttpServletResponse response, final String message,
			final String type) {
		if ("xml".equalsIgnoreCase(type)) {
			responseMessageXML(request, response, message);
		} else {
			responseMessagePlain(request, response, message);
		}
	}

	/**
	 * 返回json
	 * 
	 * @param response
	 * @param str
	 */
	public static void responseMessageJSON(HttpServletRequest request, HttpServletResponse response, final String str) {

		logger.info(genRequestString(request) + "\r\nreturnValue:" + str);
		response.setContentType("text/x-json;charset=" + Constant.CHARSET);
		response.setHeader("Connection", "close");
		response.setCharacterEncoding(Constant.CHARSET);
		try {
			byte[] byteArr = str.getBytes(Constant.CHARSET);
			response.getOutputStream().write(byteArr);
			response.getOutputStream().flush();
		} catch (IOException e) {
			logger.error("", e);
		} finally {
			try {
				response.getOutputStream().close();
			} catch (IOException e) {
				logger.error("", e);
			}
		}
	}

	/**
	 * 返回xml
	 * 
	 * @param response
	 * @param str
	 */
	public static void responseMessageXML(HttpServletRequest request, HttpServletResponse response, final String str) {
		logger.info(genRequestString(request) + "\r\nreturnValue:" + str);

		response.setContentType("text/xml;charset=" + Constant.CHARSET);
		response.setHeader("Connection", "close");
		response.setCharacterEncoding(Constant.CHARSET);
		try {
			byte[] byteArr = str.getBytes(Constant.CHARSET);
			response.getOutputStream().write(byteArr);
			response.getOutputStream().flush();
		} catch (IOException e) {
			logger.error("", e);
		} finally {
			try {
				response.getOutputStream().close();
			} catch (IOException e) {
				logger.error("", e);
			}
		}
	}

	/**
	 * 以plain格式返回
	 * 
	 * @param response
	 * @param str
	 */
	public static void responseMessagePlain(HttpServletRequest request, HttpServletResponse response, final String str) {
		logger.info(genRequestString(request) + "\r\nreturnValue:" + str);
		response.setContentType("text/plain;charset=" + Constant.CHARSET);
		response.setHeader("Connection", "close");
		response.setCharacterEncoding(Constant.CHARSET);
		try {
			byte[] byteArr = str.getBytes(Constant.CHARSET);
			response.getOutputStream().write(byteArr);
			response.getOutputStream().flush();
		} catch (IOException e) {
			logger.error("", e);
		} finally {
			try {
				response.getOutputStream().close();
			} catch (IOException e) {
				logger.error("", e);
			}
		}
	}

	/**
	 * MD5加密
	 * 
	 * @param str
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String md5(final String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String result = null;
		if (str != null) {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] byteArr = md5.digest(str.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < byteArr.length; i++) {
				int val = ((int) byteArr[i]) & 0xff;
				if (val < 16) {
					sb.append("0");
				}
				sb.append(Integer.toHexString(val));

			}
			result = sb.toString();
		}
		return result;
	}

	/**
	 * MD5加密
	 * 
	 * @param str
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public static String md5(final byte[] barr) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String result = null;
		if (barr != null) {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] byteArr = md5.digest(barr);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < byteArr.length; i++) {
				int val = ((int) byteArr[i]) & 0xff;
				if (val < 16) {
					sb.append("0");
				}
				sb.append(Integer.toHexString(val));

			}
			result = sb.toString();
		}
		return result;
	}

	/**
	 * 获取发送短信url
	 * 
	 * @return
	 * @throws NamingException
	 */
	public static String getEmsUrl() throws NamingException {
		Context c = new InitialContext();
		String pointHead = (String) c.lookup("java:comp/env/sms/endPoint");
		return pointHead;
	}

	/**
	 * 验证手机号是否合法
	 * 
	 * @param phoneNum
	 * @return
	 */
	public static boolean validatePhoneNumFormat(String phoneNum) {
		if (phoneNum != null) {
			Pattern pattern = Pattern
					.compile("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|17[0|2|6|7|8]|18[0|1|2|3|4|5|6|7|8|9])\\d{8}$");
			Matcher matcher = pattern.matcher(phoneNum);
			if (matcher.matches()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 验证邮箱是否合法
	 * 
	 * @param email
	 * @return
	 */
	public static boolean validateEmailFormat(final String email) {
		if (email != null) {
			Pattern pattern = Pattern
					.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * get请求
	 * 
	 * @param urlStr
	 * @return
	 * @throws IOException
	 */
	public static String requestHttpUrl(String urlStr) throws IOException {
		return requestHttpUrl(urlStr, Constant.CHARSET);
	}

	/**
	 * get请求
	 * 
	 * @param urlStr
	 * @return
	 * @throws IOException
	 */
	public static String requestHttpUrl(String urlStr, String charset) throws IOException {
		HttpClient client = new HttpClient();
		GetMethod get = new GetMethod(urlStr);
		get.addRequestHeader("Connection", "close");
		get.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
		get.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0, false));
		get.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);// 过期时间
		client.getHttpConnectionManager().getParams().setSoTimeout(30000);// 过期时间
		client.getParams().setContentCharset("utf-8");
		try {
			int statusCode = client.executeMethod(get);
			if (statusCode != HttpStatus.SC_OK) {
				return null;
			}
			return new String(get.getResponseBody(), charset);

		} catch (SocketTimeoutException e) {
			logger.error("", e);
			return null;
		} catch (Exception e) {
			logger.error("", e);
			return null;
		} finally {
			get.releaseConnection();
		}
	}

	/**
	 * post请求
	 * 
	 * @param urlStr
	 * @return
	 * @throws IOException
	 */
	public static String requestHttpUrlPost(String urlStr, String params) throws IOException {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(urlStr);
		post.addRequestHeader("Connection", "close");
		post.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
		post.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0, false));
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		post.setQueryString(params);
		client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);// 过期时间
		client.getHttpConnectionManager().getParams().setSoTimeout(30000);// 过期时间
		client.getParams().setContentCharset("utf-8");
		try {
			int statusCode = client.executeMethod(post);
			if (statusCode != HttpStatus.SC_OK) {
				return null;
			}
			return new String(post.getResponseBody());

		} catch (SocketTimeoutException e) {
			logger.error("", e);
			return null;
		} catch (Exception e) {
			logger.error("", e);
			return null;
		} finally {
			post.releaseConnection();
		}
	}

	/**
	 * post请求(参数以流的形式传递）
	 * 
	 * @param urlStr
	 * @return
	 * @throws IOException
	 */
	public static String requestHttpUrlPostByStream(String urlStr, String streamContent) throws IOException {
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod(urlStr);
		post.addRequestHeader("Connection", "close");
		post.getParams().setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
		post.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(0, false));
		post.addRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		client.getHttpConnectionManager().getParams().setConnectionTimeout(5000);// 过期时间
		client.getHttpConnectionManager().getParams().setSoTimeout(30000);// 过期时间
		RequestEntity requestEntity = new StringRequestEntity(streamContent);
		post.setRequestEntity(requestEntity);
		try {
			int statusCode = client.executeMethod(post);
			if (statusCode != HttpStatus.SC_OK) {
				return null;
			}
			return new String(post.getResponseBody());

		} catch (SocketTimeoutException e) {
			logger.error("", e);
			return null;
		} catch (Exception e) {
			logger.error("", e);
			return null;
		} finally {
			post.releaseConnection();
		}
	}

	/**
	 * 产生一个长度为24的sig
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	public static String genSigOf24length() {
		String sig = null;
		try {
			sig = md5(System.currentTimeMillis() + "").substring(0, 24); // 生成sig
		} catch (NoSuchAlgorithmException e) {
			sig = "123456789012345678901234";
		} catch (UnsupportedEncodingException e) {
			sig = "123456789012345678901234";
		}
		return sig;
	}

	/**
	 * 得到调用客户端ip的方法<br>
	 * <b>按这种方法不一定100%准</b>
	 * 
	 * @see http://momodog.iteye.com/blog/295946
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 生成请求数据 <br>
	 * <b>用户记录日志</b>
	 * 
	 * @param request
	 * @return
	 */
	public static String genRequestString(HttpServletRequest request) {
		StringBuilder logStr = new StringBuilder();
		logStr.append("\t\r\nRequest url:" + request.getRequestURL());
		logStr.append("\t\r\nremoteAddr:" + request.getRemoteAddr());
		logStr.append("\t\r\nip:" + UtilMethods.getIpAddr(request));
		logStr.append("\t\r\nmethod:" + request.getMethod());
		Map<String, String[]> paramsMap = request.getParameterMap();
		StringBuilder paramsStr = new StringBuilder();
		if (paramsMap != null && !paramsMap.isEmpty()) {
			Iterator<Entry<String, String[]>> iterator = paramsMap.entrySet().iterator();
			while (iterator.hasNext()) {
				Entry<String, String[]> next = iterator.next();
				if (paramsStr.length() > 0) {
					paramsStr.append("&");
				}
				paramsStr.append(next.getKey() + "=");
				String[] valueStrArr = next.getValue();
				StringBuilder tempStr = new StringBuilder();
				for (String s : valueStrArr) {
					if (tempStr.length() == 0) {
						tempStr.append(s);
					} else {
						tempStr.append("," + s);
					}
				}
				paramsStr.append(tempStr);
			}
		}
		if (!request.getRequestURL().toString().contains("saveIcon")) {
			logStr.append("\t\r\nqueryParams:" + paramsStr);
		}
		return logStr.toString();
	}

	/**
	 * 验证签名是否正确
	 * 
	 * @param request
	 * @param key
	 * @param sign
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	public static boolean isSignRight(HttpServletRequest request, final String key, final String sign)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		logger.info(genRequestString(request));
		Map<String, String[]> tempMap = request.getParameterMap();
		StringBuilder signBuilder = new StringBuilder();
		List<String> keys = new ArrayList<String>(tempMap.keySet());
		Collections.sort(keys);

		for (int i = 0; i < keys.size(); i++) {
			if ("sign".equals(keys.get(i))) {
				continue;
			}
			String[] value = tempMap.get(keys.get(i));
			if (value != null && value.length > 0 && !"".equals(value[0])) {
				if (signBuilder.length() == 0) {
					signBuilder.append(keys.get(i) + "=" + value[0]);
				} else {
					signBuilder.append("&" + keys.get(i) + "=" + value[0]);
				}
			}

		}
		signBuilder.append(key);
		String signTemp = md5(signBuilder.toString());
		logger.info("String of sign:" + signBuilder.toString() + "\r\nsign:" + signTemp);
		if (signTemp.equalsIgnoreCase(sign)) {
			return true;
		}
		return false;

	}

	/**
	 * 处理反斜杠
	 * 
	 * @param backSlashStr
	 * @return
	 */
	public static String dealBackSlash(String backSlashStr) {
		return backSlashStr;
		// if (backSlashStr != null)
		// return backSlashStr.replaceAll("\\\\", "\\\\\\\\");
		// return null;
	}

}
