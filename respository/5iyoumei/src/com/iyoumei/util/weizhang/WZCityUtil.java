package com.iyoumei.util.weizhang;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.iyoumei.util.UtilMethods;
import com.iyoumei.util.XStreamUtil;
import com.thoughtworks.xstream.XStream;

public class WZCityUtil {
	public static List<WzProvinceBean> getWzCityList() throws Exception {
		List<WzProvinceBean> list = new ArrayList<WzProvinceBean>();
		String config = UtilMethods.requestHttpUrl("http://www.cheshouye.com/api/weizhang/get_all_config");
		JSONObject json = JSONObject.fromObject(config);
		JSONArray configs = json.getJSONArray("configs");
		if (configs.size() > 0) {
			for (int i = 0; i < configs.size(); i++) {
				WzProvinceBean pBean = new WzProvinceBean();
				list.add(pBean);
				JSONObject pJson = configs.getJSONObject(i);
				pBean.setProvinceId(pJson.getString("province_id"));
				pBean.setProvinceName(pJson.getString("province_name"));
				pBean.setProvinceShortName(pJson.getString("province_short_name"));
				List<WzCityBean> cityList = new ArrayList<WzCityBean>();
				pBean.setCites(cityList);
				JSONArray cityJson = pJson.getJSONArray("citys");
				for (int j = 0; j < cityJson.size(); j++) {
					WzCityBean cBean = new WzCityBean();
					cityList.add(cBean);
					JSONObject cJson = cityJson.getJSONObject(j);
					cBean.setCityId(cJson.getString("city_id"));
					cBean.setCarHead(cJson.getString("car_head"));
					cBean.setCityName(cJson.getString("city_name"));
					cBean.setClassno(cJson.getString("classno"));
					cBean.setEngineno(cJson.getString("engineno"));
					cBean.setRegistno(cJson.getString("registno"));

				}
			}
		}
		return list;
	}

	public static void main(String[] args) throws Exception {
		List<WzProvinceBean> list = getWzCityList();
		for (WzProvinceBean bean : list) {
			System.out.println("#"+bean.getProvinceName());
			for (WzCityBean cBean : bean.getCites()) {
				System.out.println("update city set thirt_party_card='" + cBean.getCityId() + "' ,car_head='"
						+ cBean.getCarHead() + "',engineno='"
						+ cBean.getEngineno() + "',classno='"
						+ cBean.getClassno() + "',registno='"
						+ cBean.getRegistno() + "' where city_name like '"+cBean.getCityName()+"%';");

			}
		}
		// XStream xs = XStreamUtil.getXStream("xml");
		// xs.alias("result", List.class);
		// xs.alias("province", WzProvinceBean.class);
		// xs.alias("city", WzCityBean.class);
		// // xs.omitField(WzProvinceBean.class, "cites");
		// System.out.println(xs.toXML(list));
	}
}
