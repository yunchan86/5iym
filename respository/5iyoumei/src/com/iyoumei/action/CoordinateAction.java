package com.iyoumei.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.CodeMsgBean;
import com.iyoumei.modeldriver.CoordinateMd;
import com.iyoumei.service.ICoordinateService;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;

public class CoordinateAction extends ParentAction implements ModelDriven<CoordinateMd> {
	private static final long serialVersionUID = -8101708732000188201L;
	private static Log logger = LogFactory.getLog(CoordinateAction.class);
	private ICoordinateService coordinateService;

	CoordinateMd md = new CoordinateMd();

	public void setCoordinateService(ICoordinateService coordinateService) {
		this.coordinateService = coordinateService;
	}

	public String coordinate() throws Exception {
		// 验证参数是否合法
		if (md.getUserId() == null || md.getX() == null || md.getY() == null || "".equals(md.getUserId())
				|| "".equals(md.getX()) || "".equals(md.getY())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}

		CodeMsgBean bean = new CodeMsgBean();
		try {
			if (coordinateService.report(md) == true) {
				bean.setCode(RespCode.SUCCESS.getCode());
			}
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
		}
		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "userSettingsAction");
		xs.alias("result", CodeMsgBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	@Override
	public CoordinateMd getModel() {
		return md;
	}

}
