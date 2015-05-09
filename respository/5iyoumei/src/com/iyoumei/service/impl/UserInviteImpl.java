package com.iyoumei.service.impl;

import javax.annotation.Resource;

import com.iyoumei.bean.CodeMsgBean;
import com.iyoumei.entity.UserInviteDomain;
import com.iyoumei.gearman.client.AbsClientJob;
import com.iyoumei.gearman.client.CommonWorker;
import com.iyoumei.gearman.client.EvaluateUpClient;
import com.iyoumei.gearman.client.FacJobClient;
import com.iyoumei.gearman.client.InviteClient;
import com.iyoumei.mapper1.UserInviteMapper;
import com.iyoumei.modeldriver.InviteMd;
import com.iyoumei.modeldriver.VerifyMd;
import com.iyoumei.service.IUserInvite;
import com.iyoumei.util.bean.LogBean;
import com.iyoumei.util.enumcollection.RespCode;
import com.wuwaikeji.luyou.common.StringUtil;

public class UserInviteImpl implements IUserInvite {
	@Resource(type = UserInviteMapper.class)
	private UserInviteMapper userInviteMapper ;
	private LogBean logbean = null;
	
	@Override
	public CodeMsgBean invite(InviteMd md) throws Exception {
		CodeMsgBean bean=new CodeMsgBean();
		UserInviteDomain domain=new UserInviteDomain(); 
		domain.setInvitingUserId(md.getSourceUser());
		domain.setInvitedUserId(md.getTargetUser());
		domain.setMessage(md.getMessage());
		//判断是否5分钟内的重复请求，如果是则不做处理
		int repeat=userInviteMapper.checkInvited01Relation(domain);
		if(repeat>0){
			bean.setCode(RespCode.FRIEND_REPETE_INVITE.getCode());
			bean.setMsg(RespCode.FRIEND_REPETE_INVITE.getDetail());
			return bean;
		}
		//判断是否已经为好友,如果是好友则直接返回
		int relation00=userInviteMapper.checkInvited00Relation(domain);
		if(relation00>0){
			bean.setCode(RespCode.FRIEND_ALREADY.getCode());
			bean.setMsg(RespCode.FRIEND_ALREADY.getDetail());
			return bean;
		}
		
		UserInviteDomain selDomain = userInviteMapper.selectByUserId(domain.getInvitingUserId(), domain.getInvitedUserId()) ;
		if(selDomain!=null) {
			bean.setCode(RespCode.FRIEND_ADD_APPLIED.getCode());
			bean.setMsg(RespCode.FRIEND_ADD_APPLIED.getDetail());
			return bean;
		}
		//添加邀请记录
		userInviteMapper.insert(domain);
		
		bean.setCode(RespCode.SUCCESS.getCode());
		bean.setMsg(RespCode.SUCCESS.getDetail());
		
		//TODO 将添加请求转发给Gearman，处理消息推送
		FacJobClient.submitBackground(new InviteClient(), CommonWorker.WORKER_COMMON_NAME, CommonWorker.FUNCTION_INVITE, 
				new String[]{"from="+md.getSourceUser(),"to="+md.getTargetUser(),"module_id="+CommonWorker.MODULE_INVITE_REQUEST});
		return bean;
	}

	@Override
	public CodeMsgBean verify(VerifyMd md) throws Exception {
		CodeMsgBean bean=new CodeMsgBean();
		UserInviteDomain domain=new UserInviteDomain(); 
		domain.setInvitedUserId(md.getSourceUser());
		domain.setInvitedUserId(md.getTargetUser());
		domain.setStatus(md.getAuthStatus());

		//判断是否已经为好友,如果是好友则直接返回
		int relation00=userInviteMapper.checkInvited00Relation(domain);
		if(relation00>0){
			bean.setCode(RespCode.FRIEND_ALREADY.getCode());
			bean.setMsg(RespCode.FRIEND_ALREADY.getDetail());
			return bean;
		}
		
		//添加邀请记录
		userInviteMapper.update(domain);
		
		bean.setCode(RespCode.SUCCESS.getCode());
		bean.setMsg(RespCode.SUCCESS.getDetail());
		
		//TODO 将通过认证的请求转发给Gearman，处理消息推送
		String module = "" ;
		if(StringUtil.equals(md.getAuthStatus(), "00")) module = CommonWorker.MODULE_INVITE_AGREE ;
		else if(StringUtil.equals(md.getAuthStatus(), "02"))module = CommonWorker.MODULE_INVITE_REFUSE ;
		FacJobClient.submitBackground(new InviteClient(), CommonWorker.WORKER_COMMON_NAME, CommonWorker.FUNCTION_INVITE, 
				new String[]{"from="+md.getSourceUser(),"to="+md.getTargetUser(),"module_id="+module});
		return bean;
	}

	public void setUserInviteMapper(UserInviteMapper userInviteMapper) {
		this.userInviteMapper = userInviteMapper;
	}
	
	public void setLogbean(LogBean logbean) {
		this.logbean = logbean;
	}

}
