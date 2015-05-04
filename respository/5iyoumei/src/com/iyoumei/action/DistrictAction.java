package com.iyoumei.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.CityBean;
import com.iyoumei.bean.DistrictBean;
import com.iyoumei.bean.ProvinceBean;
import com.iyoumei.bean.ResultDataCollectionBean;
import com.iyoumei.modeldriver.DistrictMd;
import com.iyoumei.service.IDistrictService;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;

public class DistrictAction extends ParentAction implements ModelDriven<DistrictMd> {

	private static final long serialVersionUID = 4935991944231376282L;

	private static Log logger = LogFactory.getLog(DistrictAction.class);

	DistrictMd md = new DistrictMd();
	private IDistrictService districtService;

	public void setDistrictService(IDistrictService districtService) {
		this.districtService = districtService;
	}

	/**
	 * 获取省份列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getProvinceList() {
		ResultDataCollectionBean<ProvinceBean> bean = new ResultDataCollectionBean<ProvinceBean>();
		try {
			List<ProvinceBean> provinceList = null;
			provinceList = districtService.getProvinceList();
			if (provinceList == null)
				provinceList = new ArrayList<ProvinceBean>(1);
			bean.setCode(RespCode.SUCCESS.getCode());
			bean.setData(provinceList);
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
			bean.setMsg("系统错误");
		}

		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "DistrictAction", "getProvinceList");
		xs.alias("result", ResultDataCollectionBean.class);
		xs.alias("item", ProvinceBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 获取城市信息
	 * 
	 * @return
	 */
	public String getCityList() {
		// 验证参数是否合法
		if (md.getProvinceCode() == null || "".equals(md.getProvinceCode())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		ResultDataCollectionBean<CityBean> bean = new ResultDataCollectionBean<CityBean>();
		try {
			List<CityBean> cityList = null;
			cityList = districtService.getCityList(md.getProvinceCode());
			if (cityList == null)
				cityList = new ArrayList<CityBean>(1);
			bean.setCode(RespCode.SUCCESS.getCode());
			bean.setData(cityList);
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
			bean.setMsg("系统错误");
		}

		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "DistrictAction", "getCityList");
		xs.alias("result", ResultDataCollectionBean.class);
		xs.alias("item", CityBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 获取区县信息
	 * 
	 * @return
	 */
	public String getDistrictList() {
		// 验证参数是否合法
		if (md.getCityCode() == null || "".equals(md.getCityCode())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		ResultDataCollectionBean<DistrictBean> bean = new ResultDataCollectionBean<DistrictBean>();
		try {
			List<DistrictBean> districtList = null;
			districtList = districtService.getDistrictList(md.getCityCode());
			if (districtList == null)
				districtList = new ArrayList<DistrictBean>(1);
			bean.setCode(RespCode.SUCCESS.getCode());
			bean.setData(districtList);
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
			bean.setMsg("系统错误");
		}

		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "DistrictAction", "getDistrictList");
		xs.alias("result", ResultDataCollectionBean.class);
		xs.alias("item", DistrictBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	@Override
	public DistrictMd getModel() {
		return md;
	}

}
