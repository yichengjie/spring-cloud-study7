package com.yicj.hello.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author yicj
 * @Since 2023/11/27 22:09
 */
public class CommonUtils {

    public static ZonedDateTime parseZoneDataTime(LocalDateTime dateTime, String timeZone){
        ZoneId zoneId = ZoneId.of(timeZone);
//        TimeZone tz = TimeZone.getTimeZone(zoneId);
//        Calendar calendar = Calendar.getInstance(tz) ;
//        int year = calendar.get(Calendar.YEAR);			// 年
//        int month = calendar.get(Calendar.MONTH)+1;		// 月
//        int day = calendar.get(Calendar.DAY_OF_MONTH);	// 日
//        int house = calendar.get(Calendar.HOUR_OF_DAY);	// 时
//        int minutes = calendar.get(Calendar.MINUTE);	// 分
//        int seconds = calendar.get(Calendar.SECOND);	// 秒

        int year = dateTime.getYear() ;			// 年
        int month = dateTime.getMonthValue();		// 月
        int day = dateTime.getDayOfMonth();	// 日
        int house = dateTime.getHour();	// 时
        int minutes = dateTime.getMinute();	// 分
        int seconds = dateTime.getSecond();	// 秒

        // 创建指定时区的当前日期时间
        return ZonedDateTime.now(zoneId)
                .withYear(year)
                .withMonth(month)
                .withDayOfMonth(day)
                .withHour(house)
                .withMinute(minutes)
                .withSecond(seconds)
                ;
    }
}
