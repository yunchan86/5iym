package com.iyoumei.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;

import com.iyoumei.util.Constant;
import com.iyoumei.util.UtilMethods;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 验证无需登录操作的sign是否正确
 * 
 * @author Jeff
 * 
 */
public class NoLoginSignInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -2949438144692573693L;
	private static Log logger = LogFactory.getLog(NoLoginSignInterceptor.class);

	@Override
	public String intercept(ActionInvocation invocation) {
		Map<String, Object> parameters = invocation.getInvocationContext().getParameters();
		HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(
				StrutsStatics.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) invocation.getInvocationContext().get(
				StrutsStatics.HTTP_RESPONSE);
		String sign;
		try {
			String callType = ((String[]) parameters.get("callType"))[0];
			String uuid = ((String[]) parameters.get("uuid"))[0];
			String v = ((String[]) parameters.get("v"))[0];
			sign = ((String[]) parameters.get("sign"))[0];

			if (v == null || "".equals(v) || callType == null || "".equals(callType) || sign == null || "".equals(sign)
					|| uuid == null || "".equals(uuid)) {
				UtilMethods.responseMessage(request, response, "参数错误");
				return null;
			}
		} catch (Exception e) {
			logger.error("", e);
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			if (!UtilMethods.isSignRight(request, Constant.noLoginSig, sign)) {
				UtilMethods.responseMessage(request, response, "签名错误");
				return null;
			}
			return invocation.invoke();
		} catch (Exception e) {
			logger.error("", e);
			UtilMethods.responseMessage(request, response, "系统错误");
			return null;
		}
	}
}
