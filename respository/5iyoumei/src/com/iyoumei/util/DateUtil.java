package com.iyoumei.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.iyoumei.exception.BusinessException;

/**
 * 操作时间的公共类
 * @author 上善若水
 */
public class DateUtil {
	/**
	 * 
	 * @param type 日期的类型，如"-"则表示yyyy-MM-dd等
	 * @param date 时间对象
	 * @return
	 */
	public static String getDateString(String type,Date date) {
		if(StringUtil.isNull(type)) type = "" ;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy"+type+"MM"+type+"dd HH:mm:ss") ;
		String result = sdf.format(date) ;
		return result ;
	}
	/**
	 * 获取当前年的yyyy格式
	 * @return
	 */
	public static String getNowYearString() {
		String result = "" ;
		Calendar cal = Calendar.getInstance() ;
		int year = cal.get(Calendar.YEAR) ;
		result = ""+year ;
		return result ;
	}
	/**
	 * 获取当前月的MM格式
	 * @return
	 */
	public static String getNowMonthOfYearString() {
		String result = "" ;
		Calendar cal = Calendar.getInstance() ;
		int month = cal.get(Calendar.MONTH)+1 ;
		if(month<10) result = "0"+month ;
		else result = ""+month ;
		return result ;
	}
	/**
	 * 获取本月日志的dd格式数据
	 * @return
	 */
	public static String getNowDayOfMonthString() {
		String result = "" ;
		Calendar cal = Calendar.getInstance() ;
		int day = cal.get(Calendar.DAY_OF_MONTH) ;
		if(day<10) result = "0"+day ;
		else result = ""+day ;
		return result ;
	}
	/**
	 * 重新设置时间
	 * @param date 时间对象
	 * @param milliSecond 毫秒
	 * @return
	 */
	public static Date setDate(Date date,long milliSecond) {
		if(date == null) date = new Date() ;
		date.setTime(date.getTime()+milliSecond) ;
		return date ;
	}
	/**
	 * 对时间格式的字符串转换为时间
	 * @param type
	 * @param str
	 * @return
	 */
	public static Date getDate(String type,String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy"+type+"MM"+type+"dd HH:mm:ss") ;
		if(StringUtil.isNull(str)) return null ;
		Date date;
		try {
			date = sdf.parse(str);
		} catch (Exception e) {
			throw new BusinessException("获取时间处理格式时发生异常：",e) ;
		}
		return date ;
	}
	/**
	 * 获取两个时间相差的天数
	 * @param minDate
	 * @param maxDate
	 * @return
	 */
	public static int differDays(Date minDate,Date maxDate) {
		int days = 0 ;
		if(minDate==null||maxDate==null) return days ;
		if(minDate.after(maxDate)) {
			Date temp = minDate ;
			minDate = maxDate ;
			maxDate = temp ;
		}
		long minMilSec = minDate.getTime() ;
		long maxMilSec = maxDate.getTime() ;
		long differMilSec = maxMilSec - minMilSec ;
		days = (int)(differMilSec/(1000*60*60*24)) ;
		return days ;
	}
	
	/**
	 * 获取两个时间相差的天数
	 * @param minDate
	 * @param maxDate
	 * @return
	 */
	public static int differDaysContainNow(Date minDate,Date maxDate) {
		int days = 0 ;
		if(minDate==null||maxDate==null) return days ;
		if(minDate.after(maxDate)) {
			Date temp = minDate ;
			minDate = maxDate ;
			maxDate = temp ;
		}
		long minMilSec = minDate.getTime() ;
		long maxMilSec = maxDate.getTime() ;
		long differMilSec = maxMilSec - minMilSec ;
		if(differMilSec%(1000*60*60*24)==0) 
			days = (int)(differMilSec/(1000*60*60*24)) ;
		else days = (int)(differMilSec/(1000*60*60*24)) +1 ;
		return days ;
	}
	/**
	 * 校验当前或需要判断的时间是否在startTime与endTime之间。
	 * @param startTime 开始时间字符串  yyyy-MM-dd HH:mm:ss
	 * @param endTime 结束时间字符串  yyyy-MM-dd HH:mm:ss
	 * @param now  当前时间,为空时默认当前时间
	 * @return -1：异常，0：正常，1：超期（过期），2：超前（未到期）
	 */
	public static String verifyStartEndTime(String startTime,String endTime,Date now) {
		String result = "-1" ;
		if(now==null) now = new Date() ;
		if(StringUtil.isNull(startTime)&&StringUtil.isNull(endTime)) //两个都为null
			result = "0" ;
		else if(StringUtil.isNull(startTime)&&!StringUtil.isNull(endTime)) {//startTime为null 但endTime不为null
			if(StringUtil.equals(endTime, "0000-00-00 00:00:00")||now.before(DateUtil.getDate("-", endTime))) result = "0" ;
			else result = "1" ;//超期
		}else if(StringUtil.isNull(endTime)&&!StringUtil.isNull(startTime)) {//startTime不为null，但endTime为null
			Date start = DateUtil.getDate("-", startTime) ;
			if((!StringUtil.equals(startTime, "0000-00-00 00:00:00"))&&now.before(start)) result = "2" ;//超前
			else result = "0" ;
		}else if((!StringUtil.isNull(startTime))&&(!StringUtil.isNull(endTime))) {//startTime、endTime不为null
			Date start = DateUtil.getDate("-", startTime) ;
			Date end = DateUtil.getDate("-", endTime) ;
			if((!StringUtil.equals(endTime, "0000-00-00 00:00:00"))&&now.before(start)) result = "2" ;//超前
			else {
				if(now.before(end)) result = "0" ;
				else result = "1" ;
			}
		}
		return result ;
	}
	
	public static String getDayStartTime(String type,Date date) {
		String datetime = null ;
		if(date==null) date = new Date() ;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		datetime = sdf.format(date) + " 00:00:00" ;
		return datetime ;
	}
	
	public static String getDayEndTime(String type,Date date) {
		String datetime = null ;
		if(date==null) date = new Date() ;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		datetime = sdf.format(date) + " 23:59:59" ;
		return datetime ;
	}
	
	public static String getWeekStartTime(String type,Date date) {
		String datetime = null ;
		if(date==null) date = new Date() ;
		int dayOfweek = getWeekDay(date) ;
		int later = 0 ;
		later = dayOfweek -1 ;
		date.setTime(date.getTime() - later*24*60*60*1000);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		datetime = sdf.format(date) + " 00:00:00" ;
		return datetime ;
	}
	
	public static String getWeekEndTime(String type,Date date) {
		String datetime = null ;
		if(date==null) date = new Date() ;
		int dayOfweek = getWeekDay(date) ;
		date.setTime(date.getTime()+((7-dayOfweek)*24*60*60*1000));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;
		datetime = sdf.format(date) + " 23:59:59" ;
		return datetime ;
	}
	
	/**
	 * 获取星期，1-7分别为星期一到星期日
	 * @param date
	 * @return
	 */
	private static int getWeekDay(Date date) {
		int dayOfweek = 0 ;
		Locale local = new Locale("zh", "CN"); 
		Calendar c = Calendar.getInstance(local); 
		c.setTime(date);
		if(c.get(Calendar.DAY_OF_WEEK)==1) dayOfweek = 7 ;
		else dayOfweek = c.get(Calendar.DAY_OF_WEEK) -1 ;
		//System.out.println(dayOfweek);
		return dayOfweek ;
	}
}
