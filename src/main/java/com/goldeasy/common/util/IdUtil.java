package com.goldeasy.common.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class IdUtil {

    /**
     * 格式：yyyymmddhhMMssSSS+2位随机，可以用来生成编号
     * @return
     */
    public static String generateyyyymmddhhMMssSSSAnd2Random(){
        LocalDateTime localDateTime = LocalDateTime.now();

        long idNum = localDateTime.getYear() * 1000000000000000l
                + localDateTime.getMonthValue() * 10000000000000l
                + localDateTime.getDayOfMonth() * 100000000000l
                + localDateTime.getHour() * 1000000000l
                + localDateTime.getMinute() * 10000000l
                + localDateTime.getSecond() * 100000
                + Instant.now().toEpochMilli() * 100
                + (int)(Math.random() * 100);
        return String.valueOf(idNum);
    }

    /**
     * 获取格式化的uuid
     * @return
     */
    public static String getFromatUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
