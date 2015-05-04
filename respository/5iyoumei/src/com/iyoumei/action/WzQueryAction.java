package com.iyoumei.action;

import java.util.ArrayList;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.ResultDataCollectionBean;
import com.iyoumei.domain.WzInfoDomain;
import com.iyoumei.modeldriver.WzQueryMd;
import com.iyoumei.service.IWzService;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.enumcollection.RespCode;
import com.iyoumei.util.weizhang.WzQueryUtil;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;

/**
 * 违章查询
 * 
 * @author Jeff
 * 
 */
public class WzQueryAction extends ParentAction implements ModelDriven<WzQueryMd> {
	private static final long serialVersionUID = -63434201075963256L;
	private static Log logger = LogFactory.getLog(WzQueryAction.class);
	private IWzService wzService;
	private WzQueryMd md = new WzQueryMd();

	/**
	 * 违章查询
	 * 
	 * @return
	 */
	public String execute() {
		if (StringUtils.isEmpty(md.getHphm()) || StringUtils.isEmpty(md.getCityId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		ResultDataCollectionBean<WzInfoDomain> queryWzInfo = null;
		try {
			queryWzInfo = WzQueryUtil.queryWzInfo(md.getHphm(), md.getClassno(), md.getEngineno(), md.getRegistno(),
					md.getCityId());
			wzService.synDataToDb(queryWzInfo.getData());// 将查询结果同步到数据库中
			wzService.saveQueryLog(md);// 保存查询记录
		} catch (Exception e) {
			logger.error("", e);
			queryWzInfo = new ResultDataCollectionBean<WzInfoDomain>();
			queryWzInfo.setCode(RespCode.ERROR.getCode());
			queryWzInfo.setMsg("系统繁忙，请稍后再试");
			queryWzInfo.setData(new ArrayList<WzInfoDomain>(1));
		}

		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "WzQueryAction");
		xs.alias("result", ResultDataCollectionBean.class);
		xs.alias("item", WzInfoDomain.class);
		xs.omitField(WzInfoDomain.class, "uuid");
		xs.omitField(WzInfoDomain.class, "carId");
		xs.omitField(WzInfoDomain.class, "cityId");
		xs.omitField(WzInfoDomain.class, "provinceId");
		xs.omitField(WzInfoDomain.class, "code");
		xs.aliasSystemAttribute(null, "class");
		xs.registerConverter(new DateConverter("yyyyMMddHHmm", null, TimeZone.getTimeZone("GMT+8")));
		UtilMethods.responseMessage(request, response, xs.toXML(queryWzInfo), md.getReturnType());
		return null;
	}

	@Override
	public WzQueryMd getModel() {
		return md;
	}

	public void setWzService(IWzService wzService) {
		this.wzService = wzService;
	}

}
