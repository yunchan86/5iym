package com.iyoumei.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.iyoumei.bean.BrandBean;
import com.iyoumei.bean.InitDataBean;
import com.iyoumei.bean.ResultDataCollectionBean;
import com.iyoumei.modeldriver.InitMd;
import com.iyoumei.service.IBrandService;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.clientversion.ClientUpdateInfo;
import com.iyoumei.util.clientversion.ClientVersionControler;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;

public class InitParamsAction extends ParentAction implements ModelDriven<InitMd> {

	private static final long serialVersionUID = -5424893111768791388L;
	private static Log logger = LogFactory.getLog(InitParamsAction.class);
	InitMd md = new InitMd();
	private IBrandService brandService;

	@Override
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Map<String, String[]> parameterMap = request.getParameterMap();
		ResultDataCollectionBean<InitDataBean<?>> result = new ResultDataCollectionBean<InitDataBean<?>>();
		List<InitDataBean<?>> list = new ArrayList<InitDataBean<?>>();
		try {
			if (parameterMap.containsKey("versionTag")) {
				InitDataBean<ClientUpdateInfo> bean = new InitDataBean<ClientUpdateInfo>();
				ClientUpdateInfo updateInfo = ClientVersionControler.getClientVersionInfo(md.getCallType(),
						Integer.parseInt(md.getVersionTag(), 10));
				bean.setModuleId("version");
				bean.setData(updateInfo);
				bean.setFresh(updateInfo.isFresh());
				bean.setTag(updateInfo.getVersion() + "");
				list.add(bean);
			}
			if (parameterMap.containsKey("brandTag")) {
				InitDataBean<BrandBean> bean = new InitDataBean<BrandBean>();
				Date lastUpdateTime = brandService.lastUpdateTime();
				List<BrandBean> brandList=null;
				//有数据更新
				if(lastUpdateTime!=null&&lastUpdateTime.getTime()>Long.parseLong(md.getBrandTag(), 10)){
					brandList = brandService.getBrandList();
					bean.setFresh(false);
					bean.setTag(lastUpdateTime.getTime() + "");
				}else{
					brandList=new ArrayList<BrandBean>(1);
					bean.setFresh(true);
					bean.setTag("0");
				}
				bean.setModuleId("brand");
				bean.setCollData(brandList);
				list.add(bean);
			}
			result.setCode(RespCode.SUCCESS.getCode());
			result.setData(list);
		} catch (Exception e) {
			logger.error("", e);
			result.setCode(RespCode.ERROR.getCode());
			result.setMsg("系统错误");
			result.setData(list);
		}
		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "InitParamsAction");
		xs.alias("result", ResultDataCollectionBean.class);
		xs.alias("item", BrandBean.class);
		xs.aliasField("data", InitDataBean.class, "collData");
//		xs.addImplicitArray(InitDataBean.class, "collData");
		xs.omitField(ClientUpdateInfo.class, "isFresh");
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request,response,xs.toXML(result), md.getReturnType());
		return null;
	}

	@Override
	public InitMd getModel() {
		return md;
	}

	public void setBrandService(IBrandService brandService) {
		this.brandService = brandService;
	}

}
