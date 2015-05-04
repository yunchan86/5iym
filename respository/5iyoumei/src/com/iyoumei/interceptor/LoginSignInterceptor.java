package com.iyoumei.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;

import com.iyoumei.bean.CodeMsgBean;
import com.iyoumei.domain.UserInfoDomain;
import com.iyoumei.domain.UserSigDomain;
import com.iyoumei.service.IUserInfoService;
import com.iyoumei.service.IUserSigService;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.enumcollection.RespCode;
import com.iyoumei.util.enumcollection.UserStatus;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.thoughtworks.xstream.XStream;

/**
 * 验证登录用户的sign是否正确
 * 
 * @author Jeff
 * 
 */
public class LoginSignInterceptor extends AbstractInterceptor {
	private static Log logger = LogFactory.getLog(LoginSignInterceptor.class);
	private static final long serialVersionUID = -2949438144692573693L;

	private IUserSigService userSigService;
	private IUserInfoService userInfoService;

	@Override
	public String intercept(ActionInvocation invocation) {
		Map<String, Object> parameters = invocation.getInvocationContext().getParameters();
		HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(
				StrutsStatics.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) invocation.getInvocationContext().get(
				StrutsStatics.HTTP_RESPONSE);
		String userId;
		String callType;
		String uuid;
		String sign;
		String returnType;
		try {
			userId = ((String[]) parameters.get("userId"))[0];
			callType = ((String[]) parameters.get("callType"))[0];
			uuid = ((String[]) parameters.get("uuid"))[0];
			sign = ((String[]) parameters.get("sign"))[0];
			Object returnTypeObj = parameters.get("returnType");
			if (returnTypeObj != null)
				returnType = ((String[]) returnTypeObj)[0];
			else
				returnType = "json";

			if (userId == null || "".equals(userId) || callType == null || "".equals(callType) || sign == null
					|| "".equals(sign) || uuid == null || "".equals(uuid)) {
				UtilMethods.responseMessage(request, response, "参数错误");
				return null;
			}
		} catch (Exception e) {
			logger.error("", e);
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			UserSigDomain userSig = userSigService.getUserSig(userId, uuid, callType);
			if (userSig != null) {
				if (userSig.getStatus().equals("0")) {// 登出
					CodeMsgBean bean = new CodeMsgBean();
					bean.setCode(RespCode.SESSION_EXPIRED.getCode());
					XStream xs = XStreamUtil.getXStream(returnType, "LoginSignInterceptor");
					xs.alias("result", CodeMsgBean.class);
					UtilMethods.responseMessage(request, response, xs.toXML(bean), returnType);
					return null;
				}
				if (!UtilMethods.isSignRight(request, userSig.getSig(), sign)) {
					// 签名错误
					UtilMethods.responseMessage(request, response, "签名错误");
					return null;
				}
				UserInfoDomain userInfoDomain = userInfoService.getUserInfo(userId);
				CodeMsgBean bean = new CodeMsgBean();
				if (UserStatus.frozen.getCode() == userInfoDomain.getStatus())
					bean.setCode(RespCode.ACCOUNT_FROZEN.getCode());
				else if (UserStatus.locked.getCode() == userInfoDomain.getStatus())
					bean.setCode(RespCode.ACCOUNT_LOCKED.getCode());
				if (bean.getCode() != null) {
					XStream xs = XStreamUtil.getXStream(returnType, "LoginSignInterceptor");
					xs.alias("result", CodeMsgBean.class);
					UtilMethods.responseMessage(request, response, xs.toXML(bean), returnType);
					return null;
				}
			} else {
				CodeMsgBean bean = new CodeMsgBean();
				bean.setCode(RespCode.SESSION_EXPIRED.getCode());
				XStream xs = XStreamUtil.getXStream(returnType, "LoginSignInterceptor");
				xs.alias("result", CodeMsgBean.class);
				UtilMethods.responseMessage(request, response, xs.toXML(bean), returnType);
				return null;
			}
			return invocation.invoke();
		} catch (Exception e) {
			logger.error("", e);
			UtilMethods.responseMessage(request, response, "系统错误");
			return null;
		}
	}

	public void setUserSigService(IUserSigService userSigService) {
		this.userSigService = userSigService;
	}

	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

}
