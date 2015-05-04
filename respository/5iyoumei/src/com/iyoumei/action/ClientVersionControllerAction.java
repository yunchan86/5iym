package com.iyoumei.action;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.modeldriver.BasicMd;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.clientversion.ClientUpdateInfo;
import com.iyoumei.util.clientversion.ClientVersionControler;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;

public class ClientVersionControllerAction extends ParentAction implements ModelDriven<BasicMd> {
	private static final long serialVersionUID = -4061044770236935380L;
	private static Log logger = LogFactory.getLog(ClientVersionControllerAction.class);
	private BasicMd md = new BasicMd();

	@Override
	public String execute() {

		ResultDataBean<ClientUpdateInfo> bean = new ResultDataBean<ClientUpdateInfo>();
		try {
			String callType = md.getCallType();
			int appV = md.getAppV();
			String interfaceVersion = md.getV();// 接口版本信息
			String uuid = md.getUuid();
			if (StringUtils.isEmpty(callType) || StringUtils.isEmpty(interfaceVersion) || StringUtils.isEmpty(uuid)) {
				UtilMethods.responseMessage(request,response,"参数错误");
				return null;
			}

			ClientUpdateInfo updateInfo = ClientVersionControler.getClientVersionInfo(callType, appV);
			bean.setCode(RespCode.SUCCESS.getCode());
			bean.setData(updateInfo);
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
		}

		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "AppClientVersionAction");
		xs.alias("result", ClientUpdateInfo.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request,response,xs.toXML(bean), md.getReturnType());
		return null;
	}

	@Override
	public BasicMd getModel() {
		return md;
	}

}
