package com.iyoumei.util.weizhang;

import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.iyoumei.bean.ResultDataCollectionBean;
import com.iyoumei.domain.WzInfoDomain;
import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.enumcollection.RespCode;

public class WzQueryUtil {
	/**
	 * 车首页：http://www.cheshouye.com/appkey_reg.html <br>
	 * 注册信息 <br>
	 * 联系人：马志强 <br>
	 * 手机号：15001039090<br>
	 * QQ ：353119305 <br>
	 * 产品名称：www.iluyou.com.cn <br>
	 * 域名：www.iluyou.com.cn<br>
	 * 管理密码：luyou2014
	 */
	private static String appId = "461";
	private static String appKey = "56d0e9ebe12b1eaaf1ece627dd54beb9";
	private static Map<Integer, String> statusMap = new HashMap<>(20);
	static {
		statusMap.put(1002, "系统繁忙，请稍后重试");// app_id有误
		statusMap.put(1003, "系统繁忙，请稍后重试");// sign加密有误
		statusMap.put(1004, "输入数据有误");// 车牌号，汽车类型，违章城市 等字段不能为空
		statusMap.put(1005, "请输入正确的数据");// carInfo有误
		statusMap.put(2000, "恭喜，您尚无违章记录");// 正常(无违章记录)
		statusMap.put(2001, "");// 正常（有违章记录）
		statusMap.put(5000, "请求超时，请稍后重试");// 请求超时，请稍后重试
		statusMap.put(5001, "交管局系统连线忙碌中，请稍后再试");// 交管局系统连线忙碌中，请稍后再试
		statusMap.put(5002, "恭喜，当前城市交管局暂无您的违章记录");// 恭喜，当前城市交管局暂无您的违章记录
		statusMap.put(5003, "数据异常，请重新查询");// 数据异常，请重新查询
		statusMap.put(5004, "系统繁忙，请稍后重试");// 数据异常，请重新查询
		statusMap.put(5005, "系统繁忙，请稍后重试");// 车辆查询数量超过限制
		statusMap.put(5006, "系统繁忙，请稍后重试");// 你访问的速度过快, 请后再试
		statusMap.put(5008, "请输入正确的数据");// 输入的车辆信息有误，请查证后重新输入
	}
	/**
	 * 违章日期格式化
	 */
	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 查询违章信息
	 * 
	 * @param hphm
	 *            车牌号码
	 * @param classno
	 *            车架号
	 * @param engineno
	 *            发动机号
	 * @param registno
	 *            证书编号
	 * @param cityid
	 *            违章查询城市ID
	 * @param carType
	 * 
	 * @return
	 * @throws Exception
	 */
	public static ResultDataCollectionBean<WzInfoDomain> queryWzInfo(String hphm, String classno, String engineno,
			String registno, String cityId) throws Exception {
		String carType = "02";// 车类型（01：大型车，02：小型车)暂时只支持02

		String carInfo = "{hphm=" + (StringUtils.isEmpty(hphm) ? "" : hphm) + "&classno="
				+ (StringUtils.isEmpty(classno) ? "" : classno) + "&engineno="
				+ (StringUtils.isEmpty(engineno) ? "" : engineno) + "&registno="
				+ (StringUtils.isEmpty(registno) ? "" : registno) + "&city_id="
				+ (StringUtils.isEmpty(cityId) ? "" : cityId) + "&car_type="
				+ (StringUtils.isEmpty(carType) ? "02" : carType)+"}";
		String timestamp = System.currentTimeMillis() + "";
		String sign = genSign(carInfo, timestamp);
		String params = "timestamp=" + timestamp + "&car_info=" + URLEncoder.encode(carInfo, "utf-8") + "&sign=" + sign + "&app_id=" + appId;
//		System.out.println(params);
		String wzDetail = UtilMethods.requestHttpUrl("http://www.cheshouye.com/api/weizhang/query_task?"+ params);
//		System.out.println(wzDetail);
		JSONObject json = JSONObject.fromObject(wzDetail);

		ResultDataCollectionBean<WzInfoDomain> result = new ResultDataCollectionBean<>();
		int status = json.getInt("status");
		String msg = statusMap.get(status);
		result.setMsg(msg);
		if (status == 1004 || status == 1005 || status == 2000 || status == 2001 || status == 5002 || status == 5008)
			result.setCode(RespCode.SUCCESS.getCode());
		else
			result.setCode(RespCode.ERROR.getCode());
		List<WzInfoDomain> list = new LinkedList<>();

		statusMap.put(2001, "");// 正常（有违章记录）
		if (status == 2001) {
			JSONArray historys = json.getJSONArray("historys");

			for (int i = 0; i < historys.size(); i++) {
				JSONObject detail = historys.getJSONObject(i);
				WzInfoDomain domain = new WzInfoDomain();
				domain.setCarId(detail.getInt("car_id"));
				domain.setCityId(detail.getInt("city_id"));
//				domain.setCityName(detail.getString("city_name"));
				domain.setCode(detail.getString("code"));
				domain.setFen(detail.getInt("fen"));
				domain.setId(detail.getInt("id"));
				domain.setInfo(detail.getString("info"));
				domain.setMoney(detail.getInt("money"));
				domain.setOccurArea(detail.getString("occur_area"));
				domain.setOccurDate(df.parse(detail.getString("occur_date")));
				domain.setOfficer(detail.getString("officer"));
				domain.setProvinceId(detail.getInt("province_id"));
				domain.setStatus(detail.getString("status"));
				list.add(domain);
			}
		}
		result.setData(list);
		return result;
	}

	/**
	 * 生成违章查询签名
	 * 
	 * @param carInfo
	 *            车信息
	 * @param timestamp
	 *            时间戳
	 * @return
	 * @throws Exception
	 */
	private static String genSign(String carInfo, String timestamp) throws Exception {
		String signStr = appId + carInfo + timestamp + appKey;
		return UtilMethods.md5(signStr);
	}

	public static void main(String[] args) throws Exception {
		queryWzInfo("鄂AHN353", "314033", "", "", "133");
//		queryWzInfo("鄂AHN353", "", "314033", "", "133");

	}

}
