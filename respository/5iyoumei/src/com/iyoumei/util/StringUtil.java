package com.iyoumei.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

import com.iyoumei.exception.BusinessException;

/**
 * 操作String的相关操作
 * @author 上善若水
 * 2011-11-28
 */
public class StringUtil {
	/**
	 * 判断str1与str2两个字符串是否相等，相等为true，否则为false
	 * @param str1
	 * @param str2
	 * @return  true or false
	 */
	public static boolean equals(String str1,String str2) {
		boolean b = false ;
		if(str1==null&&str2==null) b = true ;
		else if((str1==null&&str2!=null)||(str1!=null&&str2==null)) {
			b = false ;
		}else if(str1!=null&&str1.trim().equals(str2.trim())) {
			b = true ;
		}else {
			b = false ;
		}
		return b ;
	}
	/**
	 * 判断字符串是否为空，即判断字符串是否为null或者是""字符串等操作
	 * @param str
	 * @return 为空时返回true，否则返回false
	 */
	public static boolean isNull(String str) {
		boolean b = false ;
		if(str==null||str.trim().equals("")) {
			b = true ;
		}
		return b ;
	}
	/**
	 * 判断字符串str中是否含有subStr
	 * @param str
	 * @param subStr
	 * @return
	 */
	public static boolean isPart(String str,String subStr) {
		boolean b = false ;
		if(str==null||subStr==null) {
			b = false ;
		}else {
			int index = str.indexOf(subStr)  ;
			if(index>=0) b = true ;
		}
		return b ;
	}
	/**
	 * 字符的编码转换s
	 * @param str
	 * @param fromCharset
	 * @param toCharset
	 * @return
	 */
	public static String setCharset(String str,String fromCharset,String toCharset) {
		if(str == null) return null ;
		try {
			str = new String(str.getBytes(fromCharset),toCharset) ;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str ;
	}
	/**
	 * 判断字符是否为数字,不包含小数点
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		boolean b = true ;
		for (int i = str.length(); --i >= 0;) {
			int chr = str.charAt(i);
			if (chr < 48 || chr > 57)
			return false;
		}
		return b ;
	}
	/**
	 * 判断是否为数字，包含小数点
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		boolean b = false ;
		if(StringUtil.isNull(str)) return b ;
		b = Pattern.matches("^(0|[1-9]{1}[0-9]{0,}+)(.[0-9]{1,}){0,1}+", str.toLowerCase());  
		return b ;
	}
	/**
	 * 判断是否为email格式
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		boolean b = false ;
		if(StringUtil.isNull(str)) return b ;
		b = Pattern.matches("^(\\w+@(\\w+|-){1,}\\.\\w+){1}", str.toLowerCase());  
		return b ;
	}
	/**
	 * 手机是否合法
	 * @param mobile
	 * @return
	 */
	public static boolean isMobile(String mobile) {
		boolean b = false ;
		if(StringUtil.isNull(mobile)) return b;
		if (Pattern.compile("^((\\+{0,1}(86|086)){0,1})1[0-9]{10}").matcher(mobile).matches()) {
			b = true ;
		}
		return b ;
	}
	/**
	 * 判断字符串是否是HTTP的格式
	 * @param str
	 * @return
	 */
	public static boolean isHTTPURL(String str) {
		boolean b = false ;
		if(StringUtil.isNull(str)) return b ;
		if(str.indexOf("?")!=-1) {
			return b ;
		}
		b = Pattern.matches("^(http|https)://\\w+((.\\w+)|/){1,}", str.toLowerCase());  
		return b ;
	}
	/**
	 * 判断字符串是否为日期格式，格式以type变量为准，如type="-"，则为yyyy-MM-dd的格式
	 * @param str
	 * @param type
	 * @return
	 */
	public static boolean isDateFormat(String str,String type) {
		boolean b = false ;
		if(StringUtil.isNull(str)) return b ;
		b = Pattern.matches("[1-9][0-9]{3}"+type+"(0[1-9]|1[0-2])"+type+"(0[1-9]|[1-2][0-9]|3[0-1])", str.toLowerCase());  
		return b ;
	}
	/**
	 * 生成随机数，当指定的参数小于0时默认为6位
	 * @param length
	 * @return
	 */
	public static String generateRandom(int length) {
		StringBuffer sb = new StringBuffer() ;
		if(length<=0) length=6 ;
		for(int i=0;i<length;i++){
			int random = (int)(Math.random()*10) ;
			sb.append(random) ;
		}
		return sb.toString() ;
	}
	/**
	 * 生成随机数，当指定的参数小于0时默认为6位,所生成的随机数不包含在列表中
	 * @param length
	 * @return
	 */
	public static String generateRandom(int length,List list) {
		
		StringBuffer sb = new StringBuffer() ;
		if(length<=0) length=6 ;
		for(int i=0;i<length;i++){
			int random = (int)(Math.random()*10) ;
			sb.append(random) ;
		}
		if(list==null||list.size()==0) return sb.toString() ;
		else {
			if(list.contains(sb.toString())) {
				System.out.println("run："+1);
				return generateRandom(length,list) ;
			}
		}
		return sb.toString() ;
	}
	/**
	 * 生成UUID数据
	 * @return
	 */
	public static String generateUUID() {
		String result = null ;
		try {
			
			UUID uuid = UUID.randomUUID() ;
			result = uuid.toString() ;
			result = result.replace("-", "") ;
		}catch(Exception e) {
			throw new BusinessException("生成UUID发生异常：",e) ;
		}
		return result ;
	}
	/**
	 * 生成随机字符串数据
	 * @param length
	 * @return
	 */
	public static String generateRandomString(int length) {
		String arr[] = {
				"0","1","2","3","4","5","6","7","8","9"
				,"A","B","C","D","E","F","G","H","I","J"
				,"K","L","M","N","O","P","Q","R","S","T"
				,"U","V","W","X","Y","Z"
				,"a","b","c","d","e","f","g","h","i","j"
				,"k","l","m","n","o","p","q","r","s","t"
				,"u","v","w","x","y","z"
		} ;
		StringBuffer sb = new StringBuffer() ;
		int size = arr.length ;
		if(length<=0) length=6 ;
		for(int i=0;i<length;i++){
			int random = (int)(Math.random()*size) ;
			sb.append(arr[random]) ;
		}
		return sb.toString() ;
	}
	/**
	 * 将字符串元转换为分
	 * @param cny
	 * @return
	 */
	public static long exchangeCNY2Fen(String cny) {
		if(cny==null||cny.trim().equals("")) {
			return -1l ;
		}else if(!StringUtil.isNumber(cny)) {
			return -2l ;
		}
		DecimalFormat format = new DecimalFormat("0.00") ;
		long fen = -1l;
		try {
			fen = (long)(format.parse(cny).floatValue()*100);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fen ;
	}
	/**
	 * 将分转换为元
	 * @param fen
	 * @return
	 */
	public static double exangeFen2CNY(String fen) {
		if(StringUtil.isNull(fen)) {
			return -1 ;
		}else if(!StringUtil.isNumeric(fen)) {
			return -2 ;
		}
		double cny = Double.parseDouble(fen)/100 ;
		return cny ;
	}
	/**
	 * 将一定格式的字符串转换为Map数据的格式，如key1=value1;key2=value2
	 * @param keyval       带格式的字符串
	 * @param valSign      键值对分隔符如上述的“=”
	 * @param valkeySign   相邻键值对分隔符如上述的“;”
	 * @return
	 */
	public static Map<String,String> keyval2Map(String keyval,String valSign,String valkeySign) {
		Map<String,String> map = new HashMap<String,String>() ;
		String comments = "[数据为:"+keyval+",解析的格式为：@key1"+valSign+"@value1]";
		if(isNull(valkeySign)) comments = "[数据为:"+keyval+",解析的格式为：@key1"+valSign+"@value1"+valkeySign+"@key2"+valSign+"@value2]";
		try{
			if(isNull(valSign))throw new BusinessException("解析数据发生异常"+comments) ;
			String keyvalArr[] = keyval.split("\\"+valkeySign) ;
			for(int i=0;i<keyvalArr.length;i++) {
				String kv[] = keyvalArr[i].split("\\"+valSign) ;
				map.put(kv[0], kv[1]) ;
			}
		}catch(Exception e) {
			throw new BusinessException("解析数据发生异常"+comments+":",e) ;
		}
		return map ;
	}
	/**
	 * 将一定格式的字符串转换为Map数据的格式，如key1=$value1;key2=$value2
	 * @param keyval       带格式的字符串
	 * @param valSign      键值对分隔符如上述的“=”
	 * @param tagValue	         如上述的“$”
	 * @param valkeySign   相邻键值对分隔符如上述的“;”
	 * @return Map<String,String>
	 * 			key1:value1
	 * 			key2:value2
	 */
	public static Map<String,String> keyval2Map(String keyval,String valSign,String tagValue,String valkeySign) {
		Map<String,String> map = new HashMap<String,String>() ;
		String comments = "[数据为:"+keyval+",解析的格式为：@key1"+valSign+tagValue+"@value1]";
		if(isNull(valkeySign)) comments = "[数据为:"+keyval+",解析的格式为：@key1"+valSign+tagValue+"@value1"+valkeySign+"@key2"+valSign+tagValue+"@value2]";
		try{
			if(isNull(valSign))throw new BusinessException("解析数据发生异常"+comments) ;
			String keyvalArr[] = keyval.split("\\"+valkeySign) ;
			for(int i=0;i<keyvalArr.length;i++) {
				String kv[] = keyvalArr[i].split("\\"+valSign) ;
				map.put(kv[0], kv[1].substring(1)) ;
			}
		}catch(Exception e) {
			throw new BusinessException("解析数据发生异常"+comments+":",e) ;
		}
		return map ;
	}
	
	/**
	 * 将一定格式的字符串转换为Map数据的格式，如key1=$value1&key2=$value2;key3=$value3&key4=$value4
	 * @param keyval       带格式的字符串
	 * @param valSign      键值对分隔符如上述的“=”
	 * @param tagValue	         如上述的“$”
	 * @param valkeySign   相邻键值对分隔符如上述的“&”
	 * @param listSign   相邻键值对分隔符如上述的“;”
	 * @return List<Map<String,String>>
	 * 		<br/>
	 * 		List1	key1:value1
	 * 				key2:value2
	 * 		<br/>
	 * 		List2	key3:value3
	 * 				key4:value4
	 */
	public static List<Map<String,String>> keyval2MapList(String keyval,String valSign,String tagValue,String valkeySign,String listSign) {
		List<Map<String,String>> list = new ArrayList<Map<String,String>>() ;
		String comments = "[数据为:"+keyval+",解析的格式为：@key1"+valSign+tagValue+"@value1]";
		if(isNull(valkeySign)) comments = "[数据为:"+keyval+",解析的格式为：@key1"+valSign+tagValue+"@value1"+valkeySign+"@key2"+valSign+tagValue+"@value2]";
		try{
			if(isNull(valSign))throw new BusinessException("解析数据发生异常"+comments) ;
			String keyvalList[] = keyval.split("\\"+listSign) ;
			for(int j=0;j<keyvalList.length;j++) {
				String keyvalArr[] = keyvalList[j].split("\\"+valkeySign) ;
				Map<String,String> map = new HashMap<String,String>() ;
				for(int i=0;i<keyvalArr.length;i++) {
					String kv[] = keyvalArr[i].split("\\"+valSign) ;
					map.put(kv[0], kv[1].substring(1)) ;
				}
				list.add(map) ;
			}
		}catch(Exception e) {
			throw new BusinessException("解析数据发生异常"+comments+":",e) ;
		}
		return list ;
	}
	
	/**
	 * 将所有的map数据转化为http访问时参数的形式
	 * @param map	Map<String,String>格式的数据
	 * @return
	 */
	public static String map2params(Map<String,String> map) {
		StringBuffer result = new StringBuffer() ;
		if(map==null) return result.toString() ;
		Iterator<String> it = map.keySet().iterator() ;
		int i=0;
		while(it.hasNext()) {
			String key = it.next() ;
			String value = map.get(key) ;
			if(i==0) result.append(key+"="+value) ;
			else result.append("&"+key+"="+value) ;
			i++ ;
		}
		return result.toString() ;
	}
	
	public static void main(String[] args) {
//		System.out.println(StringUtil.isNumber("15.000"));
//		System.out.println(StringUtil.isEmail("yunchan86@16-3.com"));
//		System.out.println(StringUtil.isHTTPURL("http://www.yacol.com/ss/s?asd=12"));
//		System.out.println(isDateFormat("2011-01-25","-"));
//		System.out.println(isPart("true:","true"));
//		System.out.println(StringUtil.exangeFen2CNY("101"));
//		System.out.println(StringUtil.exchangeCNY2Fen("1.23"));
//		System.out.println(StringUtil.generateUUID());
		List list = new ArrayList() ;
//		list.add("0");
//		list.add("1") ;
//		list.add("2") ;
//		list.add("3") ;
//		list.add("4") ;
//		list.add("5") ;
		String ss = StringUtil.generateRandom(1, list) ;
		System.out.println(ss);
		float f = 123423424.234324f ;
		BigDecimal bd = new BigDecimal(String.valueOf(f)) ;
		bd.setScale(10,BigDecimal.ROUND_HALF_UP) ;
		f = bd.floatValue() ;
		System.out.println(f);
		System.out.println(StringUtil.isNumeric("10"));
	}
}
