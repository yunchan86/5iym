package com.iyoumei.action;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.modeldriver.SearchMd;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;
import com.wuwaikeji.luyou.search.bean.SearchResultData;
import com.wuwaikeji.luyou.search.bean.UserCarInfo;
import com.wuwaikeji.luyou.search.bean.UserInfo;
import com.wuwaikeji.luyou.search.bean.UserSearchBean;
import com.wuwaikeji.luyou.search.searcher.SearchIndex;

public class SearchAction extends ParentAction implements ModelDriven<SearchMd> {
	private static final long serialVersionUID = -63434201075963256L;
	private static Log logger = LogFactory.getLog(SearchAction.class);
	private SearchMd md = new SearchMd();

	/**
	 * 普通查询
	 * 
	 * @return
	 */
	public String search() {
		if (md.getPageSize() == 0)
			md.setPageSize(10);

		ResultDataBean<SearchResultData<UserInfo>> result = new ResultDataBean<SearchResultData<UserInfo>>();
		try {
			SearchResultData<UserInfo> query = searchIndex(md);
			result.setCode(RespCode.SUCCESS.getCode());
			result.setData(query);
		} catch (Exception e) {
			result = new ResultDataBean<SearchResultData<UserInfo>>();
			result.setCode(RespCode.ERROR.getCode());
			result.setMsg("系统错误");
			logger.error("", e);
		}

		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "search");
		xs.alias("result", ResultDataBean.class);
		xs.alias("item", UserInfo.class);
		xs.alias("carItem", UserCarInfo.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(result), md.getReturnType());
		return null;
	}

	/**
	 * 附近用户
	 * 
	 * @return
	 */
	public String near() {
		if (StringUtils.isEmpty(md.getXpos()) || StringUtils.isEmpty(md.getYpos()) || md.getPageNo() == 0) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		if (md.getPageSize() == 0)
			md.setPageSize(10);
		if (null == md.getDistance())
			md.setDistance("-1");// TODO 暂时不限定距离
		md.setOrder("1");// 按距离排序
		ResultDataBean<SearchResultData<UserInfo>> result = new ResultDataBean<SearchResultData<UserInfo>>();
		try {
			SearchResultData<UserInfo> query = searchIndex(md);
			result.setCode(RespCode.SUCCESS.getCode());
			result.setData(query);
		} catch (Exception e) {
			result = new ResultDataBean<SearchResultData<UserInfo>>();
			result.setCode(RespCode.ERROR.getCode());
			result.setMsg("系统错误");
			logger.error("", e);
		}

		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "NearAction");
		xs.alias("result", ResultDataBean.class);
		xs.alias("item", UserInfo.class);
		xs.alias("carItem", UserCarInfo.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(result), md.getReturnType());
		return null;
	}

	/**
	 * 从索引文件中查询
	 * 
	 * @param smd
	 * @return
	 * @throws Exception
	 */
	private SearchResultData<UserInfo> searchIndex(SearchMd smd) throws Exception {
		UserSearchBean userSearchBean = new UserSearchBean();
		userSearchBean.setXpos(smd.getXpos());
		userSearchBean.setYpos(smd.getYpos());
		userSearchBean.setDistance(smd.getDistance());
		userSearchBean.setBrandId(smd.getBrandId());
		userSearchBean.setCityCode(smd.getCityCode());
		userSearchBean.setContent(smd.getContent());
		userSearchBean.setGender(smd.getGender());
		userSearchBean.setLicenseNum(smd.getLicenseNum());
		userSearchBean.setOrderBy(smd.getOrder());
		userSearchBean.setUserId(smd.getUserId());
		userSearchBean.setPageNo(smd.getPageNo());
		userSearchBean.setMobileNumber(smd.getMobileNumber());
		userSearchBean.setDistrictCode(smd.getDistrictCode());
		
		userSearchBean.setPageSize(10);// 每页10条数据
		return SearchIndex.query(userSearchBean);

	}

	@Override
	public SearchMd getModel() {
		return md;
	}

}
