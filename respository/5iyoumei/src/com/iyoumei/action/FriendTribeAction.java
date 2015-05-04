package com.iyoumei.action;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.MemoryCacheImageInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import sun.misc.BASE64Decoder;

import com.iyoumei.bean.CodeMsgBean;
import com.iyoumei.bean.ResultDataBean;
import com.iyoumei.bean.ResultDataCollectionBean;
import com.iyoumei.domain.UserCircleMsgChainDomain;
import com.iyoumei.domain.UserCircleMsgMainDomain;
import com.iyoumei.domain.UserCircleMsgPicturesDomain;
import com.iyoumei.domain.UserFriendDomain;
import com.iyoumei.gearman.client.EvaluateUpClient;
import com.iyoumei.gearman.client.FacJobClient;
import com.iyoumei.modeldriver.FriendTribeMd;
import com.iyoumei.service.IFriendTribeService;
import com.iyoumei.service.IUserFriendService;
import com.iyoumei.util.LYLogUtil;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.bean.LogBean;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;

public class FriendTribeAction extends ParentAction implements ModelDriven<FriendTribeMd> {
	private static final long serialVersionUID = -5169752818804920569L;
	private static Log logger = LogFactory.getLog(FriendTribeAction.class);
	private IFriendTribeService friendTribeService;
	private IUserFriendService userFriendService;
	private FriendTribeMd md = new FriendTribeMd();

	/**
	 * 发布消息（不含图片）
	 * 
	 * @return
	 */
	public String publish() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (!"post".equalsIgnoreCase(request.getMethod())) {
			UtilMethods.responseMessage(request, response, "必须post方式提交");
			return null;
		}
		CodeMsgBean bean = new CodeMsgBean();
		try {
			String publish = friendTribeService.publishAndGetMsgId(md.getUserId(), md.getContent());

			bean.setCode(RespCode.SUCCESS.getCode());
			bean.setMsg(publish);
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
		}
		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "FriendTribeAction", "publish");
		xs.alias("result", CodeMsgBean.class);
		xs.aliasField("msgId", CodeMsgBean.class, "msg");
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 保存图片
	 * 
	 * @return
	 */
	public String saveIcon() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (!"post".equalsIgnoreCase(request.getMethod())) {
			UtilMethods.responseMessage(request, response, "必须post方式提交");
			return null;
		}
		CodeMsgBean bean = new CodeMsgBean();
		boolean validate = true;
		String iconUrl = null;
		// 处理图片上传及保存
		try {
			BASE64Decoder b64Decoder = new BASE64Decoder();
			if (md.getPicData() == null)
				return null;
			byte[] imageDataArr = b64Decoder.decodeBuffer(md.getPicData());

			if (imageDataArr.length > 150 * 1024) {// 图片大小不能超过150k
				bean.setCode(RespCode.DATA_OUTOF_LIMIT.getCode());
				bean.setMsg("上传文件太大");
				validate = false;
			}
			String ext = null;
			if (validate) {
				ByteArrayInputStream bais = new ByteArrayInputStream(imageDataArr);
				MemoryCacheImageInputStream is = new MemoryCacheImageInputStream(bais);
				Iterator<ImageReader> it = ImageIO.getImageReaders(is);

				if (!it.hasNext()) {// 非图片文件
					validate = false;
					bean.setCode(RespCode.ILLEGAL_FILETYPE.getCode());
					bean.setMsg("非图片文件");
				} else {
					// Use the first reader
					ImageReader reader = it.next();
					// Close stream
					bais.close();
					// Return the format name
					ext = reader.getFormatName() == null ? "" : reader.getFormatName().toLowerCase();
				}
			}
			// 验证后缀名是否合法
			if (validate && !ext.endsWith("png") && !ext.endsWith("jpeg") && !ext.endsWith("jpg")) {
				bean.setCode(RespCode.ILLEGAL_FILETYPE.getCode());
				bean.setMsg("图片格式错误");
				validate = false;
			}
			// 保存
			if (validate) {
				String picUrl = friendTribeService.savePicture(md.getMsgId(), imageDataArr, ext);
				bean.setCode(RespCode.SUCCESS.getCode());
				bean.setMsg(picUrl);
			}
		} catch (Exception e) {
			logger.error("系统错误", e);
			bean.setCode(RespCode.ERROR.getCode());
			UtilMethods.responseMessage(request, response, RespCode.ERROR.getCode());
		}

		bean.setMsg(iconUrl);
		XStream xStream = XStreamUtil.getXStream(md.getReturnType(), "FriendTribeAction", "saveIcon", bean.getCode(),
				md.getV());
		xStream.alias("result", CodeMsgBean.class);
		if (bean.getCode().equals(RespCode.SUCCESS.getCode()))
			xStream.aliasField("picUrl", CodeMsgBean.class, "msg");
		xStream.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xStream.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 评论/回复评论
	 * 
	 * @return
	 */
	public String reply() {

		HttpServletRequest request = ServletActionContext.getRequest();
		if (!"post".equalsIgnoreCase(request.getMethod())) {
			UtilMethods.responseMessage(request, response, "必须post方式提交");
			return null;
		}
		// 验证参数是否合法
		if (StringUtils.isEmpty(md.getMsgId()) || StringUtils.isEmpty(md.getContent())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		CodeMsgBean bean = new CodeMsgBean();
		try {
			String replyId = friendTribeService.replyAndGetReplyId(md.getUserId(), md.getMsgId(), md.getReplyId(),
					md.getContent());

			bean.setCode(RespCode.SUCCESS.getCode());
			bean.setMsg(replyId);
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
		}
		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "FriendTribeAction", bean.getCode(), "publish");
		xs.alias("result", CodeMsgBean.class);
		if (bean.getCode().equals(RespCode.SUCCESS.getCode()))
			xs.aliasField("replyId", CodeMsgBean.class, "msg");
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 点赞
	 * 
	 * @return
	 */
	public String like() {
		// 验证参数是否合法
		if (StringUtils.isEmpty(md.getMsgId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		CodeMsgBean bean = new CodeMsgBean();
		try {
			boolean success = friendTribeService.like(md.getUserId(), md.getMsgId());
			if (success){
				bean.setCode(RespCode.SUCCESS.getCode());
			}
			else
				bean.setCode(RespCode.REPEAT.getCode());
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
		}
		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "FriendTribeAction", "publish");
		xs.alias("result", CodeMsgBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 取消赞
	 * 
	 * @return
	 */
	public String cancleLike() {
		// 验证参数是否合法
		if (StringUtils.isEmpty(md.getMsgId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		CodeMsgBean bean = new CodeMsgBean();
		try {
			friendTribeService.cancleLike(md.getUserId(), md.getMsgId());
			bean.setCode(RespCode.SUCCESS.getCode());
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
		}
		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "FriendTribeAction", "publish");
		xs.alias("result", CodeMsgBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 删除消息（只有消息发布人和可以删除）
	 * 
	 * @return
	 */
	public String delMsg() {
		// 验证参数是否合法
		if (StringUtils.isEmpty(md.getMsgId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		CodeMsgBean bean = new CodeMsgBean();
		try {
			boolean flag = friendTribeService.delMsg(md.getUserId(), md.getMsgId());
			if (flag)
				bean.setCode(RespCode.SUCCESS.getCode());
			else
				bean.setCode(RespCode.NO_PRIVILEGE.getCode());
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
		}
		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "FriendTribeAction", "delMsg");
		xs.alias("result", CodeMsgBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 删除评论（消息发布人和评论人都可以删除）
	 * 
	 * @return
	 */
	public String delReply() {
		// 验证参数是否合法
		if (StringUtils.isEmpty(md.getReplyId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		CodeMsgBean bean = new CodeMsgBean();
		try {
			boolean flag = friendTribeService.delReply(md.getUserId(), md.getReplyId());
			if (flag)
				bean.setCode(RespCode.SUCCESS.getCode());
			else
				bean.setCode(RespCode.NO_PRIVILEGE.getCode());
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
		}
		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "FriendTribeAction", "delReply");
		xs.alias("result", CodeMsgBean.class);
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 获取消息列表
	 * 
	 * @return
	 */
	public String getMsgList() {
		ResultDataCollectionBean<UserCircleMsgMainDomain> result = new ResultDataCollectionBean<UserCircleMsgMainDomain>();
		try {
			// 加载朋友圈信息
			List<UserCircleMsgMainDomain> list = friendTribeService.list(md.getUserId(), md.getMsgId(), md.getOrientation(), 10);

			result.setCode(RespCode.SUCCESS.getCode());
			result.setData(list);
			result.setMsg("");
		} catch (Exception e) {
			logger.error("", e);
			result.setCode(RespCode.ERROR.getCode());
			result.setMsg("系统错误");
		}
		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "FriendTribeAction", "getMsgList");
		xs.alias("result", ResultDataCollectionBean.class);
		xs.alias("chainItem", UserCircleMsgChainDomain.class);
		xs.omitField(UserCircleMsgChainDomain.class, "messageId");
		xs.omitField(UserCircleMsgChainDomain.class, "replyType");
		xs.alias("picItem", UserCircleMsgPicturesDomain.class);
		xs.omitField(UserCircleMsgPicturesDomain.class, "messageId");
		xs.aliasSystemAttribute(null, "class");
		xs.registerConverter(new DateConverter("yyyyMMddHHmmss", null, TimeZone.getTimeZone("GMT+8")));

		UtilMethods.responseMessage(request, response, xs.toXML(result), md.getReturnType());
		return null;
	}
	/**
	 * 获取某人发布的消息列表
	 * 
	 * @return
	 */
	public String getUserMsgList() {
		ResultDataCollectionBean<UserCircleMsgMainDomain> result = new ResultDataCollectionBean<UserCircleMsgMainDomain>();
		try {
			String viewUserId = null;
			if (!StringUtils.isEmpty(md.getViewUserId()))
				viewUserId = md.getViewUserId();

			boolean loadMsgList = true;// 是否加载朋友圈列表控制阀
			// 判断用户关系
			if (!md.getUserId().equals(viewUserId)) {
				LogBean logbean = new LogBean("FriendTribeAction::getMsgList", md.getUserId(), md.getViewUserId(),
						"参数初始化.");
				userFriendService.setLogbean(logbean);
				ResultDataBean<UserFriendDomain> friendInfo = userFriendService.getFriendInfo(
						Long.parseLong(md.getUserId(), 10), Long.parseLong(md.getViewUserId(), 10));
				if (RespCode.SUCCESS.getCode().equals(friendInfo.getCode())) {
					UserFriendDomain data = friendInfo.getData();
					if (data.getUserRelation().getIsBlacklist())
						loadMsgList = false;
				} else if (RespCode.FRIEND_INFO_ERROR.getCode().equals(friendInfo.getCode())) {
					LYLogUtil.error(logger, logbean);
					throw new Exception(logbean.getException());
				} else
					loadMsgList = false;
			}
			// 加载朋友圈信息
			List<UserCircleMsgMainDomain> list = null;
			if (loadMsgList)
				list = friendTribeService.userMsglist(viewUserId, md.getMsgId(), md.getOrientation(), 10);
			else
				list = new ArrayList<UserCircleMsgMainDomain>(1);

			result.setCode(RespCode.SUCCESS.getCode());
			result.setData(list);
			result.setMsg("");
		} catch (Exception e) {
			logger.error("", e);
			result.setCode(RespCode.ERROR.getCode());
			result.setMsg("系统错误");
		}
		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "FriendTribeAction", "getMsgList");
		xs.alias("result", ResultDataCollectionBean.class);
		xs.alias("chainItem", UserCircleMsgChainDomain.class);
		xs.omitField(UserCircleMsgChainDomain.class, "messageId");
		xs.omitField(UserCircleMsgChainDomain.class, "replyType");
		xs.alias("picItem", UserCircleMsgPicturesDomain.class);
		xs.omitField(UserCircleMsgPicturesDomain.class, "messageId");
		xs.aliasSystemAttribute(null, "class");
		xs.registerConverter(new DateConverter("yyyyMMddHHmmss", null, TimeZone.getTimeZone("GMT+8")));

		UtilMethods.responseMessage(request, response, xs.toXML(result), md.getReturnType());
		return null;
	}

	/**
	 * 获取单条消息
	 * 
	 * @return
	 */
	public String getMsg() {
		if (StringUtils.isEmpty(md.getMsgId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		ResultDataBean<UserCircleMsgMainDomain> result = new ResultDataBean<UserCircleMsgMainDomain>();
		try {
			UserCircleMsgMainDomain domain = friendTribeService.getMsg(md.getUserId(), md.getMsgId());
			result.setCode(RespCode.SUCCESS.getCode());
			result.setData(domain);
			result.setMsg("");
		} catch (Exception e) {
			logger.error("", e);
			result.setCode(RespCode.ERROR.getCode());
			result.setMsg("系统错误");
		}
		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "FriendTribeAction", "getMsg");
		xs.alias("result", ResultDataBean.class);
		xs.alias("chainItem", UserCircleMsgChainDomain.class);
		xs.omitField(UserCircleMsgChainDomain.class, "messageId");
		xs.omitField(UserCircleMsgChainDomain.class, "replyType");
		xs.alias("picItem", UserCircleMsgPicturesDomain.class);
		xs.omitField(UserCircleMsgPicturesDomain.class, "messageId");
		xs.aliasSystemAttribute(null, "class");
		xs.registerConverter(new DateConverter("yyyyMMddHHmmss", null, TimeZone.getTimeZone("GMT+8")));

		UtilMethods.responseMessage(request, response, xs.toXML(result), md.getReturnType());
		return null;
	}

	@Override
	public FriendTribeMd getModel() {
		return md;
	}

	public void setFriendTribeService(IFriendTribeService friendTribeService) {
		this.friendTribeService = friendTribeService;
	}

	public void setUserFriendService(IUserFriendService userFriendService) {
		this.userFriendService = userFriendService;
	}

}
