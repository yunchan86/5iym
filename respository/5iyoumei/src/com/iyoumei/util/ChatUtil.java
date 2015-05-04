package com.iyoumei.util;

import java.util.HashMap;
import java.util.Map;

public class ChatUtil {

	public static Map<String,String> getChatExt(String ext) {
		if(StringUtil.isNull(ext)) return null ;
		Map<String,String> map = new HashMap<String,String>() ;
		String arr[] = ext.split("\\&") ;
		for(int i=0;i<arr.length;i++) {
			String keyvalue[] = arr[i].split("\\=") ;
			map.put(keyvalue[0], keyvalue[1]) ;
		}
		return map ;
	}
}
