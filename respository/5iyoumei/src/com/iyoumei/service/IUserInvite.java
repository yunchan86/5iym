package com.iyoumei.service;

import com.iyoumei.bean.CodeMsgBean;
import com.iyoumei.modeldriver.InviteMd;
import com.iyoumei.modeldriver.VerifyMd;
import com.iyoumei.util.bean.LogBean;

public interface IUserInvite {
	/**
	 * 好友添加邀请
	 * @param md
	 * @return
	 * @throws Exception
	 */
	public CodeMsgBean invite(InviteMd md) throws Exception;
	
	/**
	 * 好友邀请通过/拒绝操作
	 * @param md
	 * @return
	 * @throws Exception
	 */
	public CodeMsgBean verify(VerifyMd md) throws Exception;
	
	public void setLogbean(LogBean logbean) ;//日志操作的处理
}
