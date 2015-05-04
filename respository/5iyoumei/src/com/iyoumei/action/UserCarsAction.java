package com.iyoumei.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.iyoumei.bean.CarImageBean;
import com.iyoumei.bean.CodeMsgBean;
import com.iyoumei.bean.ColorBean;
import com.iyoumei.bean.MotorcydeTypeBean;
import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.bean.ResultDataCollectionBean;
import com.iyoumei.bean.SameCarUserBean;
import com.iyoumei.domain.UserCarsDomain;
import com.iyoumei.modeldriver.UserCarsMd;
import com.iyoumei.service.IUserCarsService;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;

public class UserCarsAction extends ParentAction implements ModelDriven<UserCarsMd> {
	private static final long serialVersionUID = -63434201075963256L;
	private static Log logger = LogFactory.getLog(UserCarsAction.class);
	private IUserCarsService userCarsService;
	private UserCarsMd md = new UserCarsMd();

	private int maxCars;

	/**
	 * 获取用户驾座列表
	 * 
	 * @return
	 */
	public String getUserCars() {
		ResultDataCollectionBean<UserCarsDomain> bean = new ResultDataCollectionBean<UserCarsDomain>();
		try {
			List<UserCarsDomain> userCars = userCarsService.getUserCars(md.getUserId());
			if (userCars == null)
				userCars = new ArrayList<UserCarsDomain>(1);
			bean.setCode(RespCode.SUCCESS.getCode());
			bean.setMsg(maxCars + "");
			bean.setData(userCars);
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
			bean.setMsg("系统错误");
		}

		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "UserCarsAction", "getUserCars", bean.getCode());
		xs.alias("result", ResultDataCollectionBean.class);
		if (RespCode.SUCCESS.getCode().equals(bean.getCode()))
			xs.aliasField("maxCars", ResultDataCollectionBean.class, "msg");
		xs.omitField(UserCarsDomain.class, "userId");
		xs.alias("item", UserCarsDomain.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 增加座驾
	 * 
	 * @return
	 */
	public String addCar() {

		if (md.getBrandId() == null || md.getMotorcydeTypeId() == null || md.getColorId() == null
				|| md.getCarImgId() == null || "".equals(md.getBrandId()) || "".equals(md.getMotorcydeTypeId())
				|| "".equals(md.getColorId()) || "".equals(md.getCarImgId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		CodeMsgBean bean = new CodeMsgBean();
		try {
			int userCarCount = userCarsService.userCarCount(md.getUserId());
			if (userCarCount < maxCars) {
				userCarsService.addCar(md);
				bean.setCode(RespCode.SUCCESS.getCode());
			} else {
				bean.setCode(RespCode.DATA_OUTOF_LIMIT.getCode());
				bean.setMsg("亲，你的车够多了，要财不外漏呀");
			}
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
			bean.setMsg("系统错误");
		}

		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "UserCarsAction", "addCar");
		xs.alias("result", ResultDataBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;

	}

	/**
	 * 更新驾座信息
	 * 
	 * @return
	 */
	public String updateCar() {

		if (md.getId() == null || "".equals(md.getId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> parameterMap = request.getParameterMap();

		CodeMsgBean bean = new CodeMsgBean();
		try {
			UserCarsDomain domain = userCarsService.getUserCar(md.getId(), md.getUserId());
			boolean needCurrentUpdate = false;
			if (domain != null) {
				if (parameterMap.containsKey("brandId"))
					domain.setBrandId(md.getBrandId());
				if (parameterMap.containsKey("motorcydeTypeId"))
					domain.setMotorcydeTypeId(md.getMotorcydeTypeId());
				if (parameterMap.containsKey("colorId"))
					domain.setColorId(md.getColorId());
				if (parameterMap.containsKey("licenseNumber")) {
					domain.setLicenseNumber(md.getLicenseNumber());
				}
				if (parameterMap.containsKey("carImgId")) {
					domain.setCarImgId(md.getCarImgId());
				}
				if (parameterMap.containsKey("current")) {
					if (domain.getCurrent() != md.getCurrent() && md.getCurrent() == 1)
						needCurrentUpdate = true;
					domain.setCurrent(md.getCurrent());
				}
				userCarsService.updateCar(domain, needCurrentUpdate);
				bean.setCode(RespCode.SUCCESS.getCode());
			}
		} catch (Exception e) {
			logger.error("系统错误", e);
			bean.setCode(RespCode.ERROR.getCode());
			bean.setMsg("系统错误");
		}

		XStream xStream = XStreamUtil.getXStream(md.getReturnType(), "UserInfoAction", "updateUserInfo", md.getV());
		xStream.alias("result", CodeMsgBean.class);
		xStream.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xStream.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 同车型车主
	 * 
	 * @return
	 */
	public String sameCarUserList() {

		if (md.getId() == null || "".equals(md.getId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}

		ResultDataCollectionBean<SameCarUserBean> bean = new ResultDataCollectionBean<SameCarUserBean>();
		try {
			List<SameCarUserBean> sameCarUserList = userCarsService.sameCarUserBeanList(md.getId(), md.getUserId());
			if (sameCarUserList == null)
				sameCarUserList = new ArrayList<SameCarUserBean>(1);
			bean.setCode(RespCode.SUCCESS.getCode());
			bean.setData(sameCarUserList);
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
			bean.setMsg("系统错误");
		}

		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "UserCarsAction", "sameCarUserList");
		xs.alias("result", ResultDataCollectionBean.class);
		xs.alias("item", SameCarUserBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 根据品牌读取车型列表
	 * 
	 * @return
	 */
	public String getMotorcydeTypeList() {
		if (md.getBrandId() == null || "".equals(md.getBrandId())) {
			UtilMethods.responseMessage(request, response, "参数错误,请指定品牌ID");
			return null;
		}

		ResultDataCollectionBean<MotorcydeTypeBean> bean = new ResultDataCollectionBean<MotorcydeTypeBean>();
		try {
			List<MotorcydeTypeBean> motorcydeTypeList = userCarsService.getMotorcydeTyeList(md.getBrandId());
			if (motorcydeTypeList == null)
				motorcydeTypeList = new ArrayList<MotorcydeTypeBean>(1);
			bean.setCode(RespCode.SUCCESS.getCode());
			bean.setData(motorcydeTypeList);
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
			bean.setMsg("系统错误");
		}

		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "UserCarsAction", "getMotorcydeTypeList");
		xs.alias("result", ResultDataCollectionBean.class);
		xs.alias("item", MotorcydeTypeBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 根据品牌读取车型列表
	 * 
	 * @return
	 */
	public String getColorList() {
		if (md.getMotorcydeTypeId() == null || "".equals(md.getMotorcydeTypeId())) {
			UtilMethods.responseMessage(request, response, "参数错误,请指定车型ID");
			return null;
		}

		ResultDataCollectionBean<ColorBean> bean = new ResultDataCollectionBean<ColorBean>();
		try {
			List<ColorBean> colorList = userCarsService.getColorList(md.getMotorcydeTypeId());
			if (colorList == null)
				colorList = new ArrayList<ColorBean>(1);
			bean.setCode(RespCode.SUCCESS.getCode());
			bean.setData(colorList);
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
			bean.setMsg("系统错误");
		}

		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "UserCarsAction", "getColorList");
		xs.alias("result", ResultDataCollectionBean.class);
		xs.alias("item", ColorBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 根据品牌、颜色读取车型列表
	 * 
	 * @return
	 */
	public String getCarImageList() {
		if (md.getMotorcydeTypeId() == null || "".equals(md.getMotorcydeTypeId())) {
			UtilMethods.responseMessage(request, response, "参数错误,请指定车型ID");
			return null;
		}
		ResultDataCollectionBean<CarImageBean> bean = new ResultDataCollectionBean<CarImageBean>();
		try {
			List<CarImageBean> carImageList = null;
			if (md.getColorId() != null && !md.getColorId().equals("")) {
				carImageList = userCarsService.getCarImageList(md.getMotorcydeTypeId(), md.getColorId());
			} else {
				carImageList = userCarsService.getCarImageList(md.getMotorcydeTypeId());
			}
			if (carImageList == null)
				carImageList = new ArrayList<CarImageBean>(1);
			bean.setCode(RespCode.SUCCESS.getCode());
			bean.setData(carImageList);
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
			bean.setMsg("系统错误");
		}

		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "UserCarsAction", "getCarImageList");
		xs.alias("result", ResultDataCollectionBean.class);
		xs.alias("item", CarImageBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	@Override
	public UserCarsMd getModel() {
		return md;
	}

	public void setUserCarsService(IUserCarsService userCarsService) {
		this.userCarsService = userCarsService;
	}

	public void setMaxCars(int maxCars) {
		this.maxCars = maxCars;
	}

}
