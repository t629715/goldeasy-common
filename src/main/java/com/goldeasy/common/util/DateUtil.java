package com.goldeasy.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
* @ClassName: DateUtils 
* @Description: 日期工具类
* @author jcwang
* @date 2017年8月23日 下午6:10:29 
*
 */
public class DateUtil {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");

	private static SimpleDateFormat sdf2 = new SimpleDateFormat("HHmmss");
	
	private static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");
	
	/**
	 * 
	 * @Description: 格式化时间为串行，格式:yyyyMMdd
	 * @param date  处理时间
	 * @author jcwang
	 * @date 2017年8月23日 下午6:16:57
	 */
	public static String formatDate(Date date){
		return sdf.format(date);
	}
	
	/**
	 * 
	 * @Description: 格式化时间为串行，格式:yyyy-MM-dd
	 * @param date  处理时间
	 * @author jcwang
	 * @date 2017年8月23日 下午6:16:57
	 */
	public static String formatDateByMidLine(Date date){
		return sdf1.format(date);
	}
	
	/**
	 * 
	 * @Description: 格式化时间为串行，格式:HHmmss
	 * @param date  处理时间
	 * @author jcwang
	 * @date 2017年8月23日 下午6:16:57
	 */
	public static String formatTime(Date date){
		return sdf2.format(date);
	}
	
	/**
	 * 
	 * @Description: 格式化时间为串行，格式:HHmmss
	 * @param date  处理时间
	 * @author jcwang
	 * @date 2017年8月23日 下午6:16:57
	 */
	public static String formatDateTime(Date date){
		return sdf3.format(date);
	}

	/**
	 *
	 * @Method: convertTimeMillisToDate
	 * @Description: 时间毫秒数转成Date
	 * @param timeMillis
	 * @return
	 * @throws
	 */
	public static Date convertTimeMillisToDate(long timeMillis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(timeMillis);
		return calendar.getTime();
	}

	public static String generateOrderNo(String mark){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String orderNo = dateFormat.format(new Date());
		Integer code = (int) ((Math.random() * 9 + 1) * 100000);
		return mark + orderNo + code.toString();
	}
	public static Date addDay(Date date, int day) {
		if (day == 0) {
			return date;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}
}
