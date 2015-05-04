package com.iyoumei.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.CodeMsgBean;
import com.iyoumei.modeldriver.UserSettingsMd;
import com.iyoumei.service.IUserSettingsService;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;

public class UserSettingsAction extends ParentAction implements ModelDriven<UserSettingsMd> {

	private static Log logger = LogFactory.getLog(LoginAction.class);
	private static final long serialVersionUID = -8752864176795280884L;
	UserSettingsMd md = new UserSettingsMd();
	private IUserSettingsService userSettingsService;

	public void setUserSettingsService(IUserSettingsService userSettingsService) {
		this.userSettingsService = userSettingsService;
	}

	public String settings() throws Exception {
		// 验证参数是否合法
		if (md.getUserId() == null || md.getSwitchType() == null || md.getIsOpen() == null || "".equals(md.getUserId())
				|| "".equals(md.getSwitchType()) || "".equals(md.getIsOpen())) {
			UtilMethods.responseMessage(request, response, "进入此方法，参数错误");
			return null;
		}
		if (!md.getSwitchType().equals("01") && !md.getSwitchType().equals("02") && !md.getSwitchType().equals("03")
				&& !md.getSwitchType().equals("04") && !md.getSwitchType().equals("05")
				&& !md.getSwitchType().equals("06") && !md.getSwitchType().equals("07")
				&& !md.getSwitchType().equals("08") && !md.getSwitchType().equals("09")
				&& !md.getSwitchType().equals("10")) {
			UtilMethods.responseMessage(request, response, "指定的开关类型无效");
			return null;
		}
		if (md.getSwitchType().equals("01") || md.getSwitchType().equals("02") || md.getSwitchType().equals("03")
				|| md.getSwitchType().equals("04")) {
			if (md.getUserId2() == null || md.getUserId2().equals("")) {
				UtilMethods.responseMessage(request, response, "当前操作类型必须指定参数userId2");
				return null;
			}
		}
		if (!md.getIsOpen().equals("0") && !md.getIsOpen().equals("1")) {
			UtilMethods.responseMessage(request, response, "无效的开关状态值，请检查isOpen参数");
			return null;
		}

		CodeMsgBean bean = new CodeMsgBean();
		try {
			if (userSettingsService.settings(md) == true) {
				bean.setCode(RespCode.SUCCESS.getCode());
				bean.setCode(RespCode.SUCCESS.getDetail());
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
	public UserSettingsMd getModel() {
		return md;
	}

}
