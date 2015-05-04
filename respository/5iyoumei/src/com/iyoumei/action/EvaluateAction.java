package com.iyoumei.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.CodeMsgBean;
import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.bean.UserEvaluateBean;
import com.iyoumei.domain.UserEvaluateDomain;
import com.iyoumei.modeldriver.EvaluateMd;
import com.iyoumei.service.IEvaluateService;
import com.iyoumei.util.LYLogUtil;
import com.iyoumei.util.StringUtil;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.bean.LogBean;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;

public class EvaluateAction extends ParentAction implements ModelDriven<EvaluateMd> {

	private static final long serialVersionUID = -3642004631252873737L;

	private static Log logger = LogFactory.getLog(EvaluateAction.class);

	EvaluateMd md = new EvaluateMd();
	private IEvaluateService evaluateService;

	public void setEvaluateService(IEvaluateService evaluateService) {
		this.evaluateService = evaluateService;
	}

	public String evaluate() throws Exception {
		// 验证参数是否合法
		if (md.getUserId() == null || md.getEvaType() == null || "".equals(md.getUserId())
				|| "".equals(md.getEvaType())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		if (!md.getEvaType().toLowerCase().equals("p") && !md.getEvaType().toLowerCase().equals("s")) {
			UtilMethods.responseMessage(request, response, "指定的评价类型无效");
			return null;
		}
		CodeMsgBean bean = new CodeMsgBean();
		try {
			if (evaluateService.evaluate(md) == true) {
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

	public String evaluateInfo() {
		LogBean logbean = new LogBean("EvaluateAction::evaluateInfo", md.toKeyString(), md.toParamsString(), "参数初始化.");
		ResultDataBean<UserEvaluateBean> result = new ResultDataBean<UserEvaluateBean>();
		if (StringUtil.isNull(md.getUserId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			evaluateService.setLogbean(logbean);
			ResultDataBean<UserEvaluateDomain> data = (ResultDataBean<UserEvaluateDomain>) evaluateService
					.evaluteInfo(Long.parseLong(md.getUserId()));
			UserEvaluateBean bean = new UserEvaluateBean(data.getData());
			if (data.getData() == null)
				bean.setUserId(Long.parseLong(md.getUserId()));
			result.setMsgCode(data.getCode(), data.getMsg());
		} catch (Exception e) {
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("获取朋友信息异常：", e);
		} finally {
			LYLogUtil.info(logger, logbean);
			XStream xs = XStreamUtil.getXStream(md.getReturnType(), "evaluateInfo");
			xs.alias("result", ResultDataBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), md.getReturnType());
		}
		return null;
	}

	@Override
	public EvaluateMd getModel() {
		return md;
	}

}
