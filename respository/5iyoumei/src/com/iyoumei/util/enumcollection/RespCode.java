package com.iyoumei.util.enumcollection;

/**
 * 返回值代码
 * 
 * @author Jeff
 * 
 */
public enum RespCode {

	/**
	 * 成功
	 */
	SUCCESS("000", "成功"), REPEAT("001", "重复操作"),
	/**
	 * 手机号相关错误
	 */
	MOBILE_REGISTED("100", "手机号已经被注册"), MOBILE_FORMAT_ERROR("101", "手机号格式错误"), MOBILE_NOREGISTER("102", "手机号尚未注册"),
	/**
	 * 手机号验证码相关
	 */
	AUTH_CODE_ERROR("200", "手机验证码错误"), NEED_RESEND("201", "所有验证码都已失效，需要重新发送"), SEND_FAIL("202", "发送失败"),
	/**
	 * 账户相关
	 */
	USERNAME_OR_PWD_ERROR("300", "用户名或密码错误"), PWD_ERROR("301", "密码错误"), SESSION_EXPIRED("302", "登录超时"), ACCOUNT_LOCKED(
			"303", "账户被锁定"), ACCOUNT_FROZEN("304", "账户被冻结"),
	/**
	 * 好友及群组管理相关,状态均已FRIEND开头
	 */
	FRIEND_ALREADY("400", "已经是好友，无须重复操作"), FRIEND_REPETE_INVITE("401", "已经发送好友添加请求，5分钟内请勿重复发送"), HX_REG_FAILE("403",
			"环信账户注册失败"), FRIEND_ERROR("404", "朋友错误。"), FRIEND_NOT_EXISTS("405", "朋友不存在"), FRIEND_HX_ERROR("406",
			"环信账户异常"), FRIEND_INFO_ERROR("407", "获取用户信息错误"), FRIEDN_LIST_ERROR("408", "获取朋友列表错误."), FRIEND_DELETE_ERROR(
			"408", "删除用户失败."),FRIEND_ADD_APPLIED("409","已经申请过添加好友请求。"),
	/**
	 * 消息信息
	 */
	MSG_SEND_ERROR("601", "发送消息失败."),
	/**
	 * 群组管理
	 */
	GROUP_EXISTS("701", "群已经存在"), GROUP_USER_EXISTS("702", "用户已经在群中"), GROUP_CREATE_ERROR("703", "群创建错误."), GROUP_NOT_EXISTS(
			"704", "群不存在。"), GROUP_USER_CREATE_ERROR("705", "群创建用户失败"), GROUP_ERROR("799", "群操作错误"),
	/**
	 * 用户信息
	 */
	USER_NOT_EXISTS("505", "用户不存在"),
	/**
	 * 系统错误
	 */
	ILLEGAL_FILETYPE("900", "文件格式非法"), DATA_OUTOF_LIMIT("901", "数据大小越界"), NO_PRIVILEGE("902", "没有权限"), ERROR("999",
			"系统错误");

	private String code;
	private String detail;

	private RespCode(String code, String detail) {
		this.code = code;
		this.detail = detail;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
