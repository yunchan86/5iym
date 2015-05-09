package com.iyoumei.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginSignInterceptor extends AbstractInterceptor {
	private static Log logger = LogFactory.getLog(LoginSignInterceptor.class);
	private static final long serialVersionUID = -2949438144692573693L;

	@Override
	public String intercept(ActionInvocation invocation) {
		Map<String, Object> parameters = invocation.getInvocationContext().getParameters();
		HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(
				StrutsStatics.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) invocation.getInvocationContext().get(
				StrutsStatics.HTTP_RESPONSE);
		try {
			return invocation.invoke();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}

}
