package com.iyoumei.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.bean.ResultDataCollectionBean;
import com.iyoumei.bean.UserFriendBean;
import com.iyoumei.bean.UserFriendInfoBean;
import com.iyoumei.bean.UserFriendMapBean;
import com.iyoumei.domain.UserCarBrandDomain;
import com.iyoumei.domain.UserFriendDomain;
import com.iyoumei.domain.UserRelationsDomain;
import com.iyoumei.modeldriver.UserRelationsMd;
import com.iyoumei.service.IUserCarsService;
import com.iyoumei.service.IUserFriendService;
import com.iyoumei.util.LYLogUtil;
import com.iyoumei.util.StringUtil;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.bean.LogBean;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;

public class UserRelationsAction extends ParentAction implements ModelDriven<UserRelationsMd> {

	private static Log log = LogFactory.getLog(UserRelationsAction.class);

	private UserRelationsMd userRelationMd = new UserRelationsMd();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IUserFriendService userFriendService;
	private IUserCarsService userCarService ;

	public String execute() {
		LogBean logbean = new LogBean("UserRelationsAction::execute", userRelationMd.toKeyString(),
				userRelationMd.toParamsString(), "参数初始化.");
		ResultDataBean<?> result = new ResultDataBean<UserRelationsDomain>();
		if (StringUtil.isNull(userRelationMd.getUserId()) || StringUtil.isNull(userRelationMd.getFriendUserId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			userFriendService.setLogbean(logbean);
			result = userFriendService.addFriend(Long.parseLong(userRelationMd.getUserId()),
					Long.parseLong(userRelationMd.getFriendUserId()));
		} catch (Exception e) {
			logbean.setContentException("添加好友异常：", e);
		} finally {
			LYLogUtil.info(log, logbean);
			XStream xs = XStreamUtil.getXStream(userRelationMd.getReturnType(), "UserRelationsAction");
			xs.alias("result", ResultDataBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userRelationMd.getReturnType());
		}
		return null;
	}

	public String getInfoList() {
		LogBean logbean = new LogBean("UserRelationsAction::getInfoList", userRelationMd.toKeyString(),
				userRelationMd.toParamsString(), "参数初始化.");
		ResultDataCollectionBean<UserFriendBean> result = new ResultDataCollectionBean<UserFriendBean>();
		if (StringUtil.isNull(userRelationMd.getUserId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			userFriendService.setLogbean(logbean);
			ResultDataBean<List<UserFriendDomain>> data = userFriendService.getFriendList(Long.parseLong(userRelationMd
					.getUserId()));
			if (StringUtil.equals(data.getCode(), "000")) {
				List<UserFriendBean> userFriendList = new ArrayList<UserFriendBean>();
				for (UserFriendDomain userFriendDomain : data.getData()) {
					UserFriendBean userFriend = new UserFriendBean(userFriendDomain);
					userFriendList.add(userFriend);
				}
				result.setData(userFriendList);
			}
			result.setMsgCode(data.getCode(), data.getMsg());
		} catch (Exception e) {
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("获取朋友列表异常：", e);
		} finally {
			LYLogUtil.info(log, logbean);
			XStream xs = XStreamUtil.getXStream(userRelationMd.getReturnType(), "getInfoList");
			xs.alias("result", ResultDataBean.class);
			xs.alias("row", UserFriendBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userRelationMd.getReturnType());
		}
		return null;
	}

	public String getInfo() {
		LogBean logbean = new LogBean("UserRelationsAction::getInfo", userRelationMd.toKeyString(),
				userRelationMd.toParamsString(), "参数初始化.");
		ResultDataBean<UserFriendInfoBean> result = new ResultDataBean<UserFriendInfoBean>();
		if (StringUtil.isNull(userRelationMd.getUserId()) || StringUtil.isNull(userRelationMd.getFriendUserId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			userFriendService.setLogbean(logbean);
			ResultDataBean<UserFriendDomain> data = userFriendService.getFriendInfo(
					Long.parseLong(userRelationMd.getUserId()), Long.parseLong(userRelationMd.getFriendUserId()));
			if (StringUtil.equals(data.getCode(), "000")) {
				UserFriendInfoBean userFriend = new UserFriendInfoBean(data.getData());
				result.setData(userFriend);
			}
			result.setMsgCode(data.getCode(), data.getMsg());
		} catch (Exception e) {
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("获取朋友信息异常：", e);
		} finally {
			LYLogUtil.info(log, logbean);
			XStream xs = XStreamUtil.getXStream(userRelationMd.getReturnType(), "getInfo");
			xs.alias("result", ResultDataBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userRelationMd.getReturnType());
		}
		return null;
	}

	public String getStrangerInfo() {
		LogBean logbean = new LogBean("UserRelationsAction::getInfo", userRelationMd.toKeyString(),
				userRelationMd.toParamsString(), "参数初始化.");
		ResultDataBean<UserFriendInfoBean> result = new ResultDataBean<UserFriendInfoBean>();
		if (StringUtil.isNull(userRelationMd.getUserId()) || StringUtil.isNull(userRelationMd.getFriendUserId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			//UserCarBrandDomain userCarBrand = this.userCarService.getUserCarInfo(userRelationMd.getFriendUserId()) ;
			userFriendService.setLogbean(logbean);
			ResultDataBean<UserFriendDomain> data = userFriendService.getFriendInfo(
					Long.parseLong(userRelationMd.getUserId()), Long.parseLong(userRelationMd.getFriendUserId()));
			if (StringUtil.equals(data.getCode(), "000")) {
				UserFriendInfoBean userFriend = new UserFriendInfoBean(data.getData());
				result.setData(userFriend);
			}
			result.setMsgCode(data.getCode(), data.getMsg());
		} catch (Exception e) {
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("获取朋友信息异常：", e);
		} finally {
			LYLogUtil.info(log, logbean);
			XStream xs = XStreamUtil.getXStream(userRelationMd.getReturnType(), "getInfo");
			xs.alias("result", ResultDataBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userRelationMd.getReturnType());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public String del() {
		LogBean logbean = new LogBean("UserRelationsAction::getInfo", userRelationMd.toKeyString(),
				userRelationMd.toParamsString(), "参数初始化.");
		ResultDataBean<UserFriendBean> result = new ResultDataBean<UserFriendBean>();
		if (StringUtil.isNull(userRelationMd.getUserId()) || StringUtil.isNull(userRelationMd.getFriendUserId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			userFriendService.setLogbean(logbean);
			ResultDataBean<String> data = (ResultDataBean<String>) userFriendService.delFriend(
					Long.parseLong(userRelationMd.getUserId()), Long.parseLong(userRelationMd.getFriendUserId()));
			result.setMsgCode(data.getCode(), data.getMsg());
		} catch (Exception e) {
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("获取朋友信息异常：", e);
		} finally {
			LYLogUtil.info(log, logbean);
			XStream xs = XStreamUtil.getXStream(userRelationMd.getReturnType(), "del");
			xs.alias("result", ResultDataBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userRelationMd.getReturnType());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public String updateTag() {
		LogBean logbean = new LogBean("UserRelationsAction::updateTag", userRelationMd.toKeyString(),
				userRelationMd.toParamsString(), "参数初始化.");
		ResultDataBean<UserFriendBean> result = new ResultDataBean<UserFriendBean>();
		if (StringUtil.isNull(userRelationMd.getUserId()) || StringUtil.isNull(userRelationMd.getFriendUserId())
				|| StringUtil.isNull(userRelationMd.getTag())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			userFriendService.setLogbean(logbean);
			ResultDataBean<String> data = (ResultDataBean<String>) userFriendService.updateFriendTag(
					Long.parseLong(userRelationMd.getUserId()), Long.parseLong(userRelationMd.getFriendUserId()),
					userRelationMd.getTag());
			result.setMsgCode(data.getCode(), data.getMsg());
		} catch (Exception e) {
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("获取朋友信息异常：", e);
		} finally {
			LYLogUtil.info(log, logbean);
			XStream xs = XStreamUtil.getXStream(userRelationMd.getReturnType(), "updateTag");
			xs.alias("result", ResultDataBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userRelationMd.getReturnType());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public String updateLabel() {
		LogBean logbean = new LogBean("UserRelationsAction::updateLabel", userRelationMd.toKeyString(),
				userRelationMd.toParamsString(), "参数初始化.");
		ResultDataBean<UserFriendBean> result = new ResultDataBean<UserFriendBean>();
		if (StringUtil.isNull(userRelationMd.getUserId()) || StringUtil.isNull(userRelationMd.getLabel())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			userFriendService.setLogbean(logbean);
			ResultDataBean<String> data = (ResultDataBean<String>) userFriendService.updateFriendLabel(
					Long.parseLong(userRelationMd.getUserId()), Long.parseLong(userRelationMd.getFriendUserId()),
					userRelationMd.getLabel());
			result.setMsgCode(data.getCode(), data.getMsg());
		} catch (Exception e) {
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("获取朋友信息异常：", e);
		} finally {
			LYLogUtil.info(log, logbean);
			XStream xs = XStreamUtil.getXStream(userRelationMd.getReturnType(), "updateLabel");
			xs.alias("result", ResultDataBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userRelationMd.getReturnType());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public String blacklist() {
		LogBean logbean = new LogBean("UserRelationsAction::updateLabel", userRelationMd.toKeyString(),
				userRelationMd.toParamsString(), "参数初始化.");
		ResultDataBean<UserFriendBean> result = new ResultDataBean<UserFriendBean>();
		if (StringUtil.isNull(userRelationMd.getUserId()) || StringUtil.isNull(userRelationMd.getFriendUserId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			userFriendService.setLogbean(logbean);
			ResultDataBean<String> data = (ResultDataBean<String>) userFriendService.addBlacklist(
					Long.parseLong(userRelationMd.getUserId()), Long.parseLong(userRelationMd.getFriendUserId()));
			result.setMsgCode(data.getCode(), data.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("获取朋友信息异常：", e);
		} finally {
			LYLogUtil.info(log, logbean);
			XStream xs = XStreamUtil.getXStream(userRelationMd.getReturnType(), "blacklist");
			xs.alias("result", ResultDataBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userRelationMd.getReturnType());
		}
		return null;
	}

	public String getDailyList() {
		LogBean logbean = new LogBean("UserRelationsAction::getDailyList", userRelationMd.toKeyString(),
				userRelationMd.toParamsString(), "参数初始化.");
		ResultDataCollectionBean<UserFriendBean> result = new ResultDataCollectionBean<UserFriendBean>();
		if (StringUtil.isNull(userRelationMd.getUserId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			userFriendService.setLogbean(logbean);
			ResultDataBean<List<UserFriendDomain>> data = userFriendService.getDailyFriendList(Long
					.parseLong(userRelationMd.getUserId()));
			if (StringUtil.equals(data.getCode(), "000")) {
				List<UserFriendBean> userFriendList = new ArrayList<UserFriendBean>();
				for (UserFriendDomain userFriendDomain : data.getData()) {
					UserFriendBean userFriend = new UserFriendBean(userFriendDomain);
					userFriendList.add(userFriend);
				}
				result.setData(userFriendList);
			}
			result.setMsgCode(data.getCode(), data.getMsg());
		} catch (Exception e) {
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("获取朋友列表异常：", e);
		} finally {
			LYLogUtil.info(log, logbean);
			XStream xs = XStreamUtil.getXStream(userRelationMd.getReturnType(), "getInfoList");
			xs.alias("result", ResultDataBean.class);
			xs.alias("row", UserFriendBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userRelationMd.getReturnType());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public String auth() {
		LogBean logbean = new LogBean("UserRelationsAction::auth", userRelationMd.toKeyString(),
				userRelationMd.toParamsString(), "参数初始化.");
		ResultDataBean<UserFriendBean> result = new ResultDataBean<UserFriendBean>();
		if (StringUtil.isNull(userRelationMd.getUserId()) || StringUtil.isNull(userRelationMd.getFriendUserId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			userFriendService.setLogbean(logbean);
			ResultDataBean<String> data = (ResultDataBean<String>) userFriendService.auth(userRelationMd);
			result.setMsgCode(data.getCode(), data.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("获取朋友信息异常：", e);
		} finally {
			LYLogUtil.info(log, logbean);
			XStream xs = XStreamUtil.getXStream(userRelationMd.getReturnType(), "blacklist");
			xs.alias("result", ResultDataBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userRelationMd.getReturnType());
		}
		return null;
	}

	public String getMapList() {
		LogBean logbean = new LogBean("UserRelationsAction::getMapList", userRelationMd.toKeyString(),
				userRelationMd.toParamsString(), "参数初始化.");
		ResultDataCollectionBean<UserFriendMapBean> result = new ResultDataCollectionBean<UserFriendMapBean>();
		if (StringUtil.isNull(userRelationMd.getUserId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			userFriendService.setLogbean(logbean);
			ResultDataBean<List<UserFriendDomain>> data = userFriendService.getFriendList(Long.parseLong(userRelationMd
					.getUserId()));
			if (StringUtil.equals(data.getCode(), "000")) {
				List<UserFriendMapBean> userFriendList = new ArrayList<UserFriendMapBean>();
				for (UserFriendDomain userFriendDomain : data.getData()) {
					UserFriendMapBean userFriend = new UserFriendMapBean(userFriendDomain);
					userFriendList.add(userFriend);
				}
				result.setData(userFriendList);
			}
			result.setMsgCode(data.getCode(), data.getMsg());
		} catch (Exception e) {
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("获取朋友列表异常：", e);
		} finally {
			LYLogUtil.info(log, logbean);
			XStream xs = XStreamUtil.getXStream(userRelationMd.getReturnType(), "getInfoList");
			xs.alias("result", ResultDataBean.class);
			xs.alias("row", UserFriendMapBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userRelationMd.getReturnType());
		}
		return null;
	}

	public String getInfoMap() {
		LogBean logbean = new LogBean("UserRelationsAction::getInfoMap", userRelationMd.toKeyString(),
				userRelationMd.toParamsString(), "参数初始化.");
		ResultDataBean<UserFriendMapBean> result = new ResultDataBean<UserFriendMapBean>();
		if (StringUtil.isNull(userRelationMd.getUserId()) || StringUtil.isNull(userRelationMd.getFriendUserId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			userFriendService.setLogbean(logbean);
			ResultDataBean<UserFriendDomain> data = userFriendService.getFriendInfo(
					Long.parseLong(userRelationMd.getUserId()), Long.parseLong(userRelationMd.getFriendUserId()));
			if (StringUtil.equals(data.getCode(), "000")) {
				UserFriendMapBean userFriend = new UserFriendMapBean(data.getData());
				result.setData(userFriend);
			}
			result.setMsgCode(data.getCode(), data.getMsg());
		} catch (Exception e) {
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("获取朋友信息异常：", e);
		} finally {
			LYLogUtil.info(log, logbean);
			XStream xs = XStreamUtil.getXStream(userRelationMd.getReturnType(), "getInfo");
			xs.alias("result", ResultDataBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userRelationMd.getReturnType());
		}
		return null;
	}

	/**
	 * 是否好友
	 * 
	 * @return
	 */
	public String isFriend() {
		if (StringUtils.isEmpty(userRelationMd.getUserId()) || StringUtils.isEmpty(userRelationMd.getFriendUserId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		ResultDataBean<Boolean> data = new ResultDataBean<Boolean>();
		try {
			boolean b = userFriendService.isFriend(userRelationMd.getUserId(), userRelationMd.getFriendUserId());
			data.setCode(RespCode.SUCCESS.getCode());
			data.setData(b);
		} catch (Exception e) {
			log.error("", e);
			data.setCode(RespCode.ERROR.getCode());
			data.setMsg("系统繁忙");
		}
		XStream xs = XStreamUtil.getXStream(userRelationMd.getReturnType(),"UserRelationsAction", "isFrend",userRelationMd.getV());
		xs.alias("result", ResultDataBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(data), userRelationMd.getReturnType());
		return null;
	}

	@Override
	public UserRelationsMd getModel() {
		return userRelationMd;
	}

	public IUserFriendService getUserFriendService() {
		return userFriendService;
	}

	public void setUserFriendService(IUserFriendService userFriendService) {
		this.userFriendService = userFriendService;
	}

	public IUserCarsService getUserCarService() {
		return userCarService;
	}

	public void setUserCarService(IUserCarsService userCarService) {
		this.userCarService = userCarService;
	}
	

}
