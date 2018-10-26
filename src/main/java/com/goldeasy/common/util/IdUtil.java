package com.goldeasy.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

public class IdUtil {

    /**
     * 格式：yyyymmddhhMMssSSS+2位随机，可以用来生成编号
     * @return
     */
    public static String generateyyyymmddhhMMssSSSAnd2Random(){
        LocalDateTime localDateTime = LocalDateTime.now();
        return getDateTimeAsString(localDateTime,"yyMMddHHmmssSSS")+(new Random().nextInt(900)+100);
    }

    /**
     * 获取格式化的uuid
     * @return
     */
    public static String getFromatUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getDateTimeAsString(LocalDateTime localDateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDateTime.format(formatter);
    }

}
