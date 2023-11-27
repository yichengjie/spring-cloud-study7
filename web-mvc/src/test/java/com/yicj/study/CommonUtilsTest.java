package com.yicj.study;

import com.yicj.hello.utils.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author yicj
 * @Since 2023/11/27 21:44
 */
@Slf4j
public class CommonUtilsTest {

    @Test
    public void hello(){
        // GMT+8:00
        ZoneId specifiedTimeZone = ZoneId.of("GMT+9");
        // 创建指定时区的当前日期时间
        ZonedDateTime specifiedDateTime = ZonedDateTime.now(specifiedTimeZone)
                .withYear(2023)
                .withDayOfMonth(27)
                .withHour(23)
                .withMinute(51)
                .withSecond(1)
                ;
        String formatValue = specifiedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("format value : {}", formatValue);
        // 创建当前系统的本地日期时间
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        // 比较日期时间
        if (specifiedDateTime.isAfter(currentDateTime)) {
            System.out.println("指定时区的日期时间在当前日期时间之后");
        } else if (specifiedDateTime.isBefore(currentDateTime)) {
            System.out.println("指定时区的日期时间在当前日期时间之前");
        } else {
            System.out.println("指定时区的日期时间与当前日期时间相同");
        }
    }

    @Test
    public void hello2(){
        String timeZone = "GMT+9" ;
        LocalDateTime localDateTime = LocalDateTime.of(2023, 11, 27, 23, 41, 1);
        ZonedDateTime specifiedDateTime = CommonUtils.parseZoneDataTime(localDateTime, timeZone);
        String formatValue = specifiedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        log.info("format value : {}", formatValue);
        // 创建当前系统的本地日期时间
        ZonedDateTime currentDateTime = ZonedDateTime.now();
        // 比较日期时间
        if (specifiedDateTime.isAfter(currentDateTime)) {
            System.out.println("指定时区的日期时间在当前日期时间之后");
        } else if (specifiedDateTime.isBefore(currentDateTime)) {
            System.out.println("指定时区的日期时间在当前日期时间之前");
        } else {
            System.out.println("指定时区的日期时间与当前日期时间相同");
        }
    }


    @Test
    public void test2(){
        String timeZone = "GMT+9" ;
        ZoneId zoneId = ZoneId.of(timeZone);
        TimeZone tz = TimeZone.getTimeZone(zoneId);
        Calendar zoneCalendar = Calendar.getInstance(tz) ;
        zoneCalendar.setTime(new Date());
        //
        Calendar localCalendar = Calendar.getInstance();
        if (zoneCalendar.after(localCalendar)) {
            System.out.println("指定时区的日期时间在当前日期时间之后");
        } else if (zoneCalendar.before(localCalendar)) {
            System.out.println("指定时区的日期时间在当前日期时间之前");
        } else {
            System.out.println("指定时区的日期时间与当前日期时间相同");
        }
    }
}
