package com.goldeasy.common.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期相关的工具类
 */
public class DateTimeUtil {
    /**
     * jdk8时间转换为Date
     * @param localDateTime jdk8 时间
     * @return
     */
    public static Date toDate(LocalDateTime localDateTime){
        return new Date().from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     *  jdk8时间转换为Date
     * @param localDate jdk8时间
     * @return
     */
    public static Date toDate(LocalDate localDate){
        return new Date().from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    /**
     * Date转换为jdk8时间
     * @param date
     * @return
     */
    public static LocalDateTime toLocalDateTime(Date date){
       return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * 当前日期加day天
     * @param day
     * @return
     */
    public static String addDay(Long day){
      return   LocalDate.now().plusDays(day).toString();
    }


}
