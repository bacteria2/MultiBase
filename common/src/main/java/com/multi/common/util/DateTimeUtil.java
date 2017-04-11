package com.multi.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author IonCannon
 * @date 2017/4/9
 * @decription : content
 */
public class DateTimeUtil {
    /**
     * @param format 时间格式 yyyy-MM-hh HH:mm:ss.SSS
     *
     */
    public static String currentTimeString(String format){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }

}
