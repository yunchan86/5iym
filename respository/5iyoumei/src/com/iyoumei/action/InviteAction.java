package com.iyoumei.action;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iyoumei.bean.CodeMsgBean;
import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.bean.UserFriendBean;
import com.iyoumei.modeldriver.InviteMd;
import com.iyoumei.modeldriver.VerifyMd;
import com.iyoumei.service.IUserFriendService;
import com.iyoumei.service.IUserInvite;
import com.iyoumei.util.LYLogUtil;
import com.iyoumei.util.StringUtil;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.bean.LogBean;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;

public class InviteAction  extends ParentAction implements ModelDriven<InviteMd>{
	
	private static final long serialVersionUID = -5169752818804920569L;
	private static Log logger = LogFactory.getLog(InviteAction.class);
	private IUserInvite iuserInvite;
	private InviteMd md = new InviteMd();
	private IUserFriendService userFriendService;

	public String invite() {
		LogBean logbean = new LogBean("InviteAction::invite",md.toBasicParamString(),md.toParamsString(),"参数初始化.") ;
		ResultDataBean<String>  result = new ResultDataBean<String>() ;
		if (StringUtil.isNull(md.getSourceUser())||StringUtil.isNull(md.getTargetUser())) {
			UtilMethods.responseMessage(request,response,"参数错误");
			return null;
		}
		try {
			iuserInvite.setLogbean(logbean);
			CodeMsgBean data = iuserInvite.invite(md) ;
			result.setMsgCode(data.getCode(), data.getMsg());
		} catch (Exception e) {
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("获取朋友列表异常：", e);
		} finally {
			LYLogUtil.info(logger, logbean);
			XStream xs = XStreamUtil.getXStream(md.getReturnType(), "invite");
			xs.alias("result", ResultDataBean.class);
			xs.alias("row", UserFriendBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request,response,xs.toXML(result), md.getReturnType());
		}
		return null ;
	}
	
	public String refuse() {
		LogBean logbean = new LogBean("InviteAction::invite",md.toBasicParamString(),md.toParamsString(),"参数初始化.") ;
		ResultDataBean<String>  result = new ResultDataBean<String>() ;
		try {
			VerifyMd vm = new VerifyMd(md) ;
			vm.setAuthStatus("02");
			iuserInvite.setLogbean(logbean);
			CodeMsgBean data = iuserInvite.verify(vm) ;
			result.setMsgCode(data.getCode(), data.getMsg());
		} catch (Exception e) {
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("好友申请拒绝异常：", e);
		} finally {
			LYLogUtil.info(logger, logbean);
			XStream xs = XStreamUtil.getXStream(md.getReturnType(), "refuse");
			xs.alias("result", ResultDataBean.class);
			xs.alias("row", UserFriendBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request,response,xs.toXML(result), md.getReturnType());
		}
		return null ;
	}
	
	public String accept() {
		LogBean logbean = new LogBean("InviteAction::invite",md.toBasicParamString(),md.toParamsString(),"参数初始化.") ;
		ResultDataBean<String>  result = new ResultDataBean<String>() ;
		try {
			userFriendService.addFriend(Long.parseLong(md.getSourceUser()), Long.parseLong(md.getTargetUser())) ;
			VerifyMd vm = new VerifyMd(md) ;
			vm.setAuthStatus("00");
			iuserInvite.setLogbean(logbean);
			CodeMsgBean data = iuserInvite.verify(vm) ;
			result.setMsgCode(data.getCode(), data.getMsg());
		} catch (Exception e) {
			result.setMsgCode(RespCode.ERROR.getCode(), RespCode.ERROR.getDetail());
			logbean.setContentException("好友申请同意异常：", e);
		} finally {
			LYLogUtil.info(logger, logbean);
			XStream xs = XStreamUtil.getXStream(md.getReturnType(), "accept");
			xs.alias("result", ResultDataBean.class);
			xs.alias("row", UserFriendBean.class);
			xs.aliasSystemAttribute(null, "class");
			UtilMethods.responseMessage(request,response,xs.toXML(result), md.getReturnType());
		}
		return null ;
	}

	public void setMd(InviteMd md) {
		this.md = md;
	}
	
	

	public void setIuserInvite(IUserInvite iuserInvite) {
		this.iuserInvite = iuserInvite;
	}

	@Override
	public InviteMd getModel() {
		return md;
	}

	public IUserFriendService getUserFriendService() {
		return userFriendService;
	}

	public void setUserFriendService(IUserFriendService userFriendService) {
		this.userFriendService = userFriendService;
	}
	
	
}
