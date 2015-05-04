package com.iyoumei.action;

import java.io.ByteArrayInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
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
import com.iyoumei.domain.UserInfoDomain;
import com.iyoumei.modeldriver.UserInfoMd;
import com.iyoumei.service.IUserInfoService;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.iyoumei.util.enumcollection.RespCode;
import com.opensymphony.xwork2.ModelDriven;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;

public class UserInfoAction extends ParentAction implements ModelDriven<UserInfoMd> {
	private static final long serialVersionUID = -5169752818804920569L;
	private static Log logger = LogFactory.getLog(UserInfoAction.class);
	private IUserInfoService userInfoService;

	UserInfoMd md = new UserInfoMd();

	public String getUserInfo() {
		// 验证参数是否合法
		if (md.getUserId() == null || "".equals(md.getUserId())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		ResultDataBean<UserInfoDomain> bean = new ResultDataBean<UserInfoDomain>();
		try {
			UserInfoDomain userInfo = userInfoService.getUserInfo(md.getUserId());

			if (userInfo != null) {
				bean.setCode(RespCode.SUCCESS.getCode());
				bean.setData(userInfo);
			} else {
				bean.setCode(RespCode.ERROR.getCode());
				bean.setMsg("用户信息不存在");
			}
		} catch (Exception e) {
			logger.error("", e);
			bean.setCode(RespCode.ERROR.getCode());
		}
		XStream xs = XStreamUtil.getXStream(md.getReturnType(), "UserInfoAction", "getUserInfo");
		xs.alias("result", ResultDataBean.class);
		xs.omitField(UserInfoDomain.class, "userId");
		xs.omitField(UserInfoDomain.class, "password");
		xs.omitField(UserInfoDomain.class, "status");
		xs.registerConverter(new DateConverter("yyyyMMddHHmmss", null, TimeZone.getTimeZone("GMT+8")));
		xs.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xs.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 更改用户信息
	 * 
	 * @return
	 */
	public String updateUserInfo() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if (!"post".equalsIgnoreCase(request.getMethod())) {
			UtilMethods.responseMessage(request, response, "必须post方式提交");
			return null;
		}
		Map<String, String[]> parameterMap = request.getParameterMap();

		CodeMsgBean bean = new CodeMsgBean();
		try {
			UserInfoDomain userInfo = userInfoService.getUserInfo(md.getUserId());
			if (userInfo != null) {
				DateFormat df = new SimpleDateFormat("yyyyMMdd");
				if (parameterMap.containsKey("nickname"))
					userInfo.setNickname(md.getNickname());
				if (parameterMap.containsKey("signature"))
					userInfo.setSignature(md.getSignature());
				if (parameterMap.containsKey("gender"))
					userInfo.setGender(md.getGender());
				if (parameterMap.containsKey("birthday")) {
					userInfo.setBirthday(df.parse(md.getBirthday()));
				}
				if (parameterMap.containsKey("cityCode")) {
					userInfo.setCityCode(md.getCityCode());
				}
				if (parameterMap.containsKey("districtCode")) {
					userInfo.setDistrictCode(md.getDistrictCode());
				}
				if (parameterMap.containsKey("getDrivingLicenceTime")) {
					userInfo.setGetDrivingLicenceTime(df.parse(md.getGetDrivingLicenceTime()));
				}
				userInfoService.updateUserInfo(userInfo);
				bean.setCode(RespCode.SUCCESS.getCode());
			}
		} catch (Exception e) {
			logger.error("系统错误", e);
			bean.setCode(RespCode.ERROR.getCode());
			bean.setMsg("系统错误");
		}

		XStream xStream = XStreamUtil.getXStream(md.getReturnType(), "UserInfoAction", "updateUserInfo", md.getV());
		xStream.alias("result", CodeMsgBean.class);
		xStream.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xStream.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 更改用户头像 <br>
	 * 新增保存其它图片功能（身份证正面，反面；驾驶证正面，反面）
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
			if (md.getIconData() == null)
				return null;
			byte[] imageDataArr = b64Decoder.decodeBuffer(md.getIconData());
			int maxsize = 0;
			if ("0".equals(md.getIconType()))
				maxsize = 50 * 1024;// 头像大小不能超过50K
			else
				maxsize = 100 * 1024;// 其它图片大小不能超过100K

			if (imageDataArr.length > maxsize) {
				bean.setCode(RespCode.DATA_OUTOF_LIMIT.getCode());
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
				validate = false;
			}
			// 保存
			if (validate) {
				iconUrl = userInfoService.saveIconAndGetUrl(md.getUserId(), imageDataArr, ext, md.getIconType());
				if (iconUrl != null)
					bean.setCode(RespCode.SUCCESS.getCode());
				else
					bean.setCode(RespCode.ERROR.getCode());
			}
		} catch (Exception e) {
			logger.error("系统错误", e);
			bean.setCode(RespCode.ERROR.getCode());
			UtilMethods.responseMessage(request, response, RespCode.ERROR.getCode());
		}

		bean.setMsg(iconUrl);
		XStream xStream = XStreamUtil.getXStream(md.getReturnType(), "UserInfoAction", "saveIcon", md.getV());
		xStream.alias("result", CodeMsgBean.class);
		xStream.aliasField("iconUrl", CodeMsgBean.class, "msg");
		xStream.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xStream.toXML(bean), md.getReturnType());
		return null;
	}

	/**
	 * 修改密码
	 * 
	 * @return
	 */
	public String modifyPwd() {
		// 验证参数是否合法
		if (StringUtils.isEmpty(md.getUserId()) || StringUtils.isEmpty(md.getPwd())
				|| StringUtils.isEmpty(md.getNewPwd())) {
			UtilMethods.responseMessage(request, response, "参数错误");
			return null;
		}
		CodeMsgBean bean = null;
		try {
			bean = userInfoService.modifyPwd(md.getUserId(), md.getPwd(), md.getNewPwd());
		} catch (Exception e) {
			bean = new CodeMsgBean();
			logger.error("系统错误", e);
			bean.setCode(RespCode.ERROR.getCode());
			bean.setMsg("系统错误");
		}

		XStream xStream = XStreamUtil.getXStream(md.getReturnType(), "UserInfoAction", "updateUserInfo", md.getV());
		xStream.alias("result", CodeMsgBean.class);
		xStream.aliasSystemAttribute(null, "class");
		UtilMethods.responseMessage(request, response, xStream.toXML(bean), md.getReturnType());
		return null;
	}

	@Override
	public UserInfoMd getModel() {
		return md;
	}

	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}

}
