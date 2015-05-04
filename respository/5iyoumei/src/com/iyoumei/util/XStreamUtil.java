package com.iyoumei.util;

import java.io.Writer;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonWriter;

/**
 * @author lijf
 */
public class XStreamUtil {

	private static Map<String, XStream> xsMap = new ConcurrentHashMap<String, XStream>();

	public static XStream getXStreamJson() {
		return new XStream(new JettisonMappedXmlDriver() {
			@Override
			public HierarchicalStreamWriter createWriter(Writer writer) {
				return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
			}

		});
	}

	/**
	 * 获取XStream对象
	 * 
	 * @param type获取类型
	 * @param params
	 *            其它参数
	 * @return
	 */
	public static XStream getXStream(String type, String... params) {
		XStream xs = null;
		if (params == null || params.length == 0) {
			if ("xml".equals(type))
				xs = new XStream();
			else
				xs = new XStream(new JettisonMappedXmlDriver() {
					@Override
					public HierarchicalStreamWriter createWriter(Writer writer) {
						return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
					}

				});
		} else {
			StringBuilder paramSb = new StringBuilder();
			for (String p : params) {
				paramSb.append(p);
			}
			String key = type + paramSb.toString();
			xs = xsMap.get(key);
			if (xs == null) {
				if ("xml".equals(type))
					xs = new XStream();
				else
					xs = new XStream(new JettisonMappedXmlDriver() {
						@Override
						public HierarchicalStreamWriter createWriter(Writer writer) {
							return new JsonWriter(writer, JsonWriter.DROP_ROOT_MODE);
						}

					});
				xsMap.put(key, xs);
			}
		}
		return xs;
	}
}
