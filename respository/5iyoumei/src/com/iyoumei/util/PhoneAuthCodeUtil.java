package com.iyoumei.util;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.PhoneAuthCodeReturnBean;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * 短信发送
 * 
 * @author lijf
 */
public class PhoneAuthCodeUtil {

	/**
	 * 发送验证码
	 * 
	 * @param moduleId
	 * @param phoneNum
	 * @param callType
	 * @return
	 */
	public static PhoneAuthCodeReturnBean sendEmsAuthCode(String moduleId, String phoneNum, String callType, String ip)
			throws Exception {
		String urlStr = UtilMethods.getEmsUrl() + "/s.do?m=" + moduleId + "&o=" + phoneNum + "&p=" + phoneNum
				+ "&dt=xml&c=" + callType;
		// + "&user_ip=" + (ip == null ? "" : ip);
		String returnStr = requestPhoneAuthCodeUrl(urlStr);
		PhoneAuthCodeReturnBean returnBean = new PhoneAuthCodeReturnBean();
		XStream xs = new XStream(new DomDriver());
		xs.aliasField("f", PhoneAuthCodeReturnBean.class, "success");
		xs.aliasField("rc", PhoneAuthCodeReturnBean.class, "returnCode");
		xs.aliasField("mg", PhoneAuthCodeReturnBean.class, "msg");
		xs.aliasField("p", PhoneAuthCodeReturnBean.class, "mobile");
		xs.aliasField("o", PhoneAuthCodeReturnBean.class, "objectId");
		xs.alias("results", PhoneAuthCodeReturnBean.class);
		returnBean = (PhoneAuthCodeReturnBean) xs.fromXML(returnStr);
		return returnBean;
	}

	/**
	 * 验证验证码
	 * 
	 * @param moduleId
	 * @param phoneNum
	 * @param authCode
	 * @param callType
	 * @return
	 */
	public static PhoneAuthCodeReturnBean validateEmsAuthCode(String moduleId, String phoneNum, String authCode,
			String callType, String ip) throws Exception {
		PhoneAuthCodeReturnBean returnBean = new PhoneAuthCodeReturnBean();
		String urlStr = UtilMethods.getEmsUrl() + "/v.do?m=" + moduleId + "&o=" + phoneNum + "&p=" + phoneNum
				+ "&dt=xml&ct=" + callType + "&s=" + authCode;
		// + "&user_ip=" + (ip == null ? "" : ip);
		String returnStr = requestPhoneAuthCodeUrl(urlStr);
		XStream xs = new XStream(new DomDriver());
		xs.alias("results", PhoneAuthCodeReturnBean.class);
		xs.aliasField("f", PhoneAuthCodeReturnBean.class, "success");
		xs.aliasField("rc", PhoneAuthCodeReturnBean.class, "returnCode");
		xs.aliasField("mg", PhoneAuthCodeReturnBean.class, "msg");
		xs.aliasField("p", PhoneAuthCodeReturnBean.class, "mobile");
		xs.aliasField("o", PhoneAuthCodeReturnBean.class, "objectId");
		returnBean = (PhoneAuthCodeReturnBean) xs.fromXML(returnStr);
		return returnBean;
	}

	/**
	 * 发送请求
	 * 
	 * @param urlStr
	 * @return
	 * @throws IOException
	 */
	private static String requestPhoneAuthCodeUrl(String urlStr) throws Exception {

		long requestStartTime = System.currentTimeMillis();
		try {
			String respStr = UtilMethods.requestHttpUrl(urlStr,"GBK");
			logger.error("请求地址：" + urlStr + "\n返回值：" + respStr + "\n耗时"
					+ (System.currentTimeMillis() - requestStartTime));
			return respStr;

		} catch (Exception e) {
			logger.error("请求地址" + urlStr + "\n返回值" + e.toString() + "\n耗时"
					+ (System.currentTimeMillis() - requestStartTime), e);
			throw e;
		}
	}

	private static Log logger = LogFactory.getLog(PhoneAuthCodeUtil.class);
	
	public static void main(String[] args) throws Exception {
//		20000001
//		sendEmsAuthCode("20000001", "15811309227", "android", null);
		String authCode="856820";
		validateEmsAuthCode("20000001", "15811309227", authCode, "android", null);
		validateEmsAuthCode("20000001", "15811309227", authCode, "android", null);
		validateEmsAuthCode("20000001", "15811309227", authCode, "iphone", null);
//		sendEmsAuthCode("20000002", "15811309227", "android", null);
		
	}
}
