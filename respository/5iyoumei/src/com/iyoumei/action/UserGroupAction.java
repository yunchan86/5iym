package com.iyoumei.action;

import java.util.ArrayList;
import java.util.List;

import com.iyoumei.bean.GroupInfoBean;
import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.bean.ResultDataCollectionBean;
import com.iyoumei.modeldriver.UserGroupInfoMd;
import com.iyoumei.service.IUserGroupManagerService;
import com.iyoumei.util.StringUtil;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;

public class UserGroupAction extends ParentAction implements ModelDriven<UserGroupInfoMd> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserGroupInfoMd userGroupInfoMd = new UserGroupInfoMd();
	private IUserGroupManagerService userGroupManagerService;

	@SuppressWarnings("unchecked")
	public String execute() {
		GroupInfoBean bean = null;
		ResultDataBean<GroupInfoBean> result = new ResultDataBean<GroupInfoBean>();
		if (StringUtil.isNull(userGroupInfoMd.getUserId()) || StringUtil.isNull(userGroupInfoMd.getGroupname())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			bean = new GroupInfoBean();
			bean.setCreateUserId(Long.parseLong(userGroupInfoMd.getUserId()));
			bean.setGroupDesc(userGroupInfoMd.getDesc());
			bean.setGroupName(userGroupInfoMd.getGroupname());
			result = (ResultDataBean<GroupInfoBean>) userGroupManagerService.create(bean);
			if (!StringUtil.equals(result.getCode(), "00")) {
				bean = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			bean = null;
		} finally {
			XStream xs = XStreamUtil.getXStream(userGroupInfoMd.getReturnType(), "UserGroupAction");
			xs.alias("result", ResultDataBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userGroupInfoMd.getReturnType());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public String del() {
		GroupInfoBean bean = null;
		ResultDataBean<String> result = new ResultDataBean<String>();
		if (StringUtil.isNull(userGroupInfoMd.getUserId()) || StringUtil.isNull(userGroupInfoMd.getGroupId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			bean = new GroupInfoBean();
			bean.setCreateUserId(Long.parseLong(userGroupInfoMd.getUserId()));
			bean.setGroupDesc(userGroupInfoMd.getDesc());
			bean.setGroupName(userGroupInfoMd.getGroupname());
			result = (ResultDataBean<String>) userGroupManagerService.del(Long.parseLong(userGroupInfoMd.getUserId()),
					Long.parseLong(userGroupInfoMd.getGroupId()));
			if (!StringUtil.equals(result.getCode(), "00")) {
				bean = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			bean = null;
		} finally {
			XStream xs = XStreamUtil.getXStream(userGroupInfoMd.getReturnType(), "list");
			xs.alias("result", ResultDataBean.class);
			xs.alias("row", GroupInfoBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userGroupInfoMd.getReturnType());
		}
		return null;
	}

	public String list() {
		GroupInfoBean bean = null;
		ResultDataCollectionBean<GroupInfoBean> result = new ResultDataCollectionBean<GroupInfoBean>();
		if (StringUtil.isNull(userGroupInfoMd.getUserId()) || StringUtil.isNull(userGroupInfoMd.getGroupname())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			bean = new GroupInfoBean();
			bean.setCreateUserId(Long.parseLong(userGroupInfoMd.getUserId()));
			bean.setGroupDesc(userGroupInfoMd.getDesc());
			bean.setGroupName(userGroupInfoMd.getGroupname());
			ResultDataBean<List<GroupInfoBean>> serviceResult = (ResultDataBean<List<GroupInfoBean>>) userGroupManagerService
					.getGroupList(Long.parseLong(userGroupInfoMd.getUserId()));
			result.setMsgCodeData(serviceResult.getCode(), serviceResult.getMsg(), serviceResult.getData());
			if (!StringUtil.equals(result.getCode(), "00")) {
				bean = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			bean = null;
		} finally {
			XStream xs = XStreamUtil.getXStream(userGroupInfoMd.getReturnType(), "list");
			xs.alias("result", ResultDataBean.class);
			xs.alias("row", GroupInfoBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userGroupInfoMd.getReturnType());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public String addMember() {
		ResultDataBean<String> result = new ResultDataBean<String>();
		if (StringUtil.isNull(userGroupInfoMd.getUserId()) || StringUtil.isNull(userGroupInfoMd.getGroupId())
				|| StringUtil.isNull(userGroupInfoMd.getMemberId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			result = (ResultDataBean<String>) userGroupManagerService.addMember(
					Long.parseLong(userGroupInfoMd.getUserId()), Long.parseLong(userGroupInfoMd.getGroupId()),
					Long.parseLong(userGroupInfoMd.getMemberId()));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			XStream xs = XStreamUtil.getXStream(userGroupInfoMd.getReturnType(), "addMember");
			xs.alias("result", ResultDataBean.class);
			xs.alias("row", GroupInfoBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userGroupInfoMd.getReturnType());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public String addMembers() {
		ResultDataBean<String> result = new ResultDataBean<String>();
		if (StringUtil.isNull(userGroupInfoMd.getUserId()) || StringUtil.isNull(userGroupInfoMd.getGroupId())
				|| StringUtil.isNull(userGroupInfoMd.getMemberIds())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			List<Long> list = new ArrayList<Long>();
			String arrId[] = userGroupInfoMd.getMemberIds().split("\\;");
			for (String id : arrId) {
				list.add(Long.parseLong(id));
			}
			result = (ResultDataBean<String>) userGroupManagerService.addBatchMember(
					Long.parseLong(userGroupInfoMd.getUserId()), Long.parseLong(userGroupInfoMd.getGroupId()), list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			XStream xs = XStreamUtil.getXStream(userGroupInfoMd.getReturnType(), "addMember");
			xs.alias("result", ResultDataBean.class);
			xs.alias("row", GroupInfoBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userGroupInfoMd.getReturnType());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public String delMember() {
		ResultDataBean<String> result = new ResultDataBean<String>();
		if (StringUtil.isNull(userGroupInfoMd.getUserId()) || StringUtil.isNull(userGroupInfoMd.getGroupId())
				|| StringUtil.isNull(userGroupInfoMd.getMemberId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			result = (ResultDataBean<String>) userGroupManagerService.delMember(
					Long.parseLong(userGroupInfoMd.getUserId()), Long.parseLong(userGroupInfoMd.getGroupId()),
					Long.parseLong(userGroupInfoMd.getMemberId()));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			XStream xs = XStreamUtil.getXStream(userGroupInfoMd.getReturnType(), "addMember");
			xs.alias("result", ResultDataBean.class);
			xs.alias("row", GroupInfoBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userGroupInfoMd.getReturnType());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public String delMembers() {
		ResultDataBean<String> result = new ResultDataBean<String>();
		if (StringUtil.isNull(userGroupInfoMd.getUserId()) || StringUtil.isNull(userGroupInfoMd.getGroupId())
				|| StringUtil.isNull(userGroupInfoMd.getMemberIds())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		try {
			List<Long> list = new ArrayList<Long>();
			String arrId[] = userGroupInfoMd.getMemberIds().split("\\;");
			for (String id : arrId) {
				list.add(Long.parseLong(id));
			}
			result = (ResultDataBean<String>) userGroupManagerService.delBatchMember(
					Long.parseLong(userGroupInfoMd.getUserId()), Long.parseLong(userGroupInfoMd.getGroupId()), list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			XStream xs = XStreamUtil.getXStream(userGroupInfoMd.getReturnType(), "addMember");
			xs.alias("result", ResultDataBean.class);
			xs.alias("row", GroupInfoBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request, response, xs.toXML(result), userGroupInfoMd.getReturnType());
		}
		return null;
	}

	@Override
	public UserGroupInfoMd getModel() {
		return userGroupInfoMd;
	}

	public IUserGroupManagerService getUserGroupManagerService() {
		return userGroupManagerService;
	}

	public void setUserGroupManagerService(IUserGroupManagerService userGroupManagerService) {
		this.userGroupManagerService = userGroupManagerService;
	}

}
