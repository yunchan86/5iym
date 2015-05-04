package com.iyoumei.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.BrandBean;
import com.iyoumei.bean.ResultDataCollectionBean;
import com.iyoumei.modeldriver.BasicMd;
import com.iyoumei.service.IBrandService;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;

public class BrandAction extends ParentAction implements ModelDriven<BasicMd> {
	private static final long serialVersionUID = -63434201075963256L;
	private static Log logger = LogFactory.getLog(BrandAction.class);
	private IBrandService brandService;
	private BasicMd md = new BasicMd();

	/**
	 * 品牌列表
	 * 
	 * @return
	 */
	public String getBrandList() {
		ResultDataCollectionBean<BrandBean> bean = new ResultDataCollectionBean<BrandBean>();
		try {
			List<BrandBean> brandList = brandService.getBrandList();
			if (brandList == null)
				brandList = new ArrayList<BrandBean>(1);
			bean.setCode(RespCode.SUCCESS.getCode());
			bean.setData(brandList);
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
			bean.setMsg("系统错误");
		}

		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "BrandAction", "getBrandList");
		xs.alias("result", ResultDataCollectionBean.class);
		xs.alias("item", BrandBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	@Override
	public BasicMd getModel() {
		return md;
	}

	public void setBrandService(IBrandService brandService) {
		this.brandService = brandService;
	}

}
