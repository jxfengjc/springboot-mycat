package com.example.drapdf;




import org.springframework.util.StringUtils;

import java.math.RoundingMode;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author rpmcc
 * @version 1.0
 * @date 2019/3/7
 * @description msg
 */
public class DateUtil {
    /**
     * 英文简写（默认）如：01
     */
    public static String FORMAT_DAY = "MM月dd日";
    /**
     * 英文简写（默认）如：2010-12-01
     */
    public static String FORMAT_SHORT = "yyyy-MM-dd";

    /**
     * 20.06.19
     */
    public static String FORMAT_SHORT_POINT = "yy.MM.dd";
    public static String FORMAT_LONG_POINT = "yyYY.MM.dd HH:mm";
    /**
     * 英文简写（默认）如：2010-12-01
     */
    public static String FORMAT_YD = "yyyy-MM";
    /**
     * 英文简写（默认）如：201012
     */
    public static String FORMAT_YD2 = "yyyyMM";
    /**
     * 英文全称 如：2010-12-01 23:15:06
     */
    public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";

    /**
     * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
     */
    public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";

    /**
     * 到分的时间格式 如：yyyy-MM-dd HH:mm
     */
    public static String FORMAT_YMDHM = "yyyy-MM-dd HH:mm";

    /**
     * 月日时分格式 如：MM-dd HH:mm
     */
    public static String FORMAT_MDHM = "MM-dd HH:mm";

    /**
     * 月日时分格式 如：MM-dd
     */
    public static String FORMAT_MD = "MM-dd ";

    /**
     * 时分秒格式 如：HH:mm:ss
     */
    public static String FORMAT_HMS = "HH:mm:ss";

    /**
     * 时分格式 如：HH:mm
     */
    public static String FORMAT_HM = "HH:mm";

    /**
     * 斜杠分割的时间格式 如:yyyy/MM/dd/HH/mm/ss
     */
    public static String FORMAT_SLASH = "yyyy/MM/dd/HH/mm/ss";

    /**
     * 斜杠分割的时间格式（只有年月日） 如：2010/12/01
     */
    public static String FORMAT_SLASH_SHORT = "yyyy/MM/dd";
    public static String FORMAT_SLASH_SHORT2 = "yyyyMMdd";

    /**
     * 无间隔时间格式 如：yyyyMMddHHmmss
     */
    public static String FORMAT_NOGAP = "yyyyMMddHHmmss";

    /**
     * 无间隔时间格式 ru：HHmm
     */
    public static String FORMAT_NOGAP_SHORT = "HHmm";

    /**
     * 中文简写 如：2010年12月01日
     */
    public static String FORMAT_SHORT_CN = "yyyy年MM月dd";
    public static String FORMAT_SHORT_CN2 = "yyyy年MM月dd日";

    /**
     * 中文全称 如：2010年12月01日 23时15分06秒
     */
    public static String FORMAT_LONG_CN = "yyyy年MM月dd日 HH时mm分ss秒";

    /**
     * 半中文 如：2010年12月01日 23：15：06
     */
    public static String FORMAT_LONG_HALF_CN = "yyyy年MM月dd日 HH:mm:ss";

    /**
     * 精确到毫秒的完整中文时间
     */
    public static String FORMAT_FULL_CN = "yyyy年MM月dd日 HH时mm分ss秒SSS毫秒";

    /**
     * 直播计数格式（直播间人数计数key所需）
     */
    public static String FORMAT_LIVE_COUNT = "yyyy_MM_dd_HH_mm_ss";

    /**
     * 获取年
     */
    public static String FORMAT_YEAR = "yyyy";

    /**
     * 获取月
     */
    public static String FORMAT_MONTH = "MM";
    /**
     * 获取小时
     */
    public static String FORMAT_HOUR = "HH";

    /**
     * 星期一
     */
    public static String MONDAY = "星期一";
    public static String SATURDAY = "星期六";
    public static String SUNDAY = "星期日";

    private static final long ONE_MINUTE = 60000L;
    private static final long ONE_HOUR = 3600000L;
    private static final long ONE_DAY = 86400000L;
    private static final long ONE_WEEK = 604800000L;

    private static final String ONE_SECOND_AGO = "秒前";
    private static final String ONE_MINUTE_AGO = "分钟前";
    private static final String ONE_HOUR_AGO = "小时前";
    private static final String ONE_DAY_AGO = "天前";
    private static final String ONE_MONTH_AGO = "月前";
    private static final String ONE_YEAR_AGO = "年前";

    /**
     * 获得默认的 date pattern
     */
    public static String getDatePattern() {
        return FORMAT_LONG;
    }

    /**
     * 根据预设格式返回当前日期
     *
     * @param
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static String getNow() {
        return format(new Date());
    }

    public static long getNowTimeStamp() {
        return System.currentTimeMillis();
    }

    /**
     * 根据用户格式返回当前日期
     *
     * @param format 用户格式
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static String getNow(String format) {
        return format(new Date(), format);
    }

    /**
     * 使用预设格式格式化日期
     *
     * @param date 需要格式化的日期
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static String format(Date date) {
        return format(date, getDatePattern());
    }

    /**
     * 使用用户格式格式化日期
     *
     * @param date    需要格式化的日期
     * @param pattern 日期格式
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static String format(Date date, String pattern) {
        String returnValue = "";
        if (date != null && !StringUtils.isEmpty(pattern)) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            returnValue = sdf.format(date);
        }
        return returnValue;
    }

    /**
     * 使用预设格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static Date parse(String strDate) {
        return parse(strDate, getDatePattern());
    }

    public static Date parseGp(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat(DateUtil.FORMAT_YMDHM);
        try {
            return sdf.parse(strDate);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 使用用户格式提取字符串日期
     *
     * @param strDate 日期字符串
     * @param pattern 日期格式
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static Date parse(String strDate, String pattern) {
        if (StringUtils.isEmpty(strDate) || StringUtils.isEmpty(pattern)) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String strToStr(String strDate, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(strDate).toString();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 在日期上增加数个整月
     *
     * @param date 日期
     * @param n    要增加的月数
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    /**
     * 获取某一日期的0点0分0秒和23点59分59秒
     * @param date
     * @param flag
     * @return
     */
    public static String dateToStringBeginOrEnd(Date date,Boolean flag) {
        String time = null;
        SimpleDateFormat dateformat1 = new SimpleDateFormat(getDatePattern());
        Calendar calendar1 = Calendar.getInstance();
        //获取某一天的0点0分0秒 或者 23点59分59秒
        if (flag) {
            calendar1.setTime(date);
            calendar1.set(calendar1.get(Calendar.YEAR), calendar1.get(Calendar.MONTH), calendar1.get(Calendar.DAY_OF_MONTH),
                0, 0, 0);
            Date beginOfDate = calendar1.getTime();
            time = dateformat1.format(beginOfDate);
        }else{
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date);
            calendar1.set(calendar2.get(Calendar.YEAR), calendar2.get(Calendar.MONTH), calendar2.get(Calendar.DAY_OF_MONTH),
                23, 59, 59);
            Date endOfDate = calendar1.getTime();
            time = dateformat1.format(endOfDate);
        }
        return time;
    }
    /**
     * 在日期上增加天数
     *
     * @param date 日期
     * @param n    增加的天数
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加天数
     *
     * @param date 日期
     * @param n    增加的天数
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static Date addHour(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR_OF_DAY, n);
        return cal.getTime();
    }

    /**
     * 在日期上增加分钟
     *
     * @param date 日期
     * @param n    增加的分钟
     * @return
     * @Author byliu
     * @Date 2020/2/25
     */
    public static Date addMinute(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, n);
        return cal.getTime();
    }

    /**
     * 获取精确到毫秒的日期格式
     *
     * @param
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static String getTimeString() {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_FULL);
        Calendar calendar = Calendar.getInstance();
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取日期年份
     *
     * @param date 日期
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static String getYear(Date date) {
        return format(date).substring(0, 4);
    }

    /**
     * 按默认格式的字符串距离今天的天数
     *
     * @param date 日期字符串
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static int countDays(String date) {
        return countDays(date, getDatePattern());
    }

    /**
     * 按用户格式字符串距离今天的天数
     *
     * @param date    日期字符串
     * @param pattern 日期格式
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static int countDays(String date, String pattern) {
        long t = Calendar.getInstance().getTime().getTime();
        Calendar c = Calendar.getInstance();
        c.setTime(parse(date, pattern));
        long t1 = c.getTime().getTime();
        return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
    }

    /**
     * 使用默认格式格式化时间戳
     *
     * @param timestamp
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static String formatTimestamp(long timestamp) {
        return formatTimestamp(timestamp, getDatePattern());
    }

    /**
     * 使用用户格式格式化时间戳
     *
     * @param timestamp 时间戳
     * @param pattern   日期格式
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static String formatTimestamp(long timestamp, String pattern) {
        if (StringUtils.isEmpty(pattern)) {
            throw new BusinessException("日期转化格式异常");
        }
        Date date = new Date(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 获取指定格式的日期
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static Date patternDate(Date date, String pattern) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            return sdf.parse(format(date, pattern));
        } catch (Exception e) {
            return new Date();
        }
    }

    /**
     * 使用预设格式格式化日期 返回日期类型
     *
     * @param date
     * @return
     * @Author hxd
     * @Date 2019/5/8
     */
    public static Date patternDate(Date date) {
        return patternDate(date, getDatePattern());
    }

    /**
     * 发送短信专用 格式化当前日期
     *
     * @param
     * @return
     * @Author qiaowy
     * @Date 2019/4/28
     */
    public static String getSmsNow() {
        String returnValue = "";
        try {
            SimpleDateFormat df = new SimpleDateFormat(getDatePattern());
            df.setTimeZone(TimeZone.getDefault());
            returnValue = df.format(new Date());
        } catch (Exception e) {

        }
        return returnValue;
    }


    /**
     * 格式化日期  上午下午
     * @param time
     * @return
     */
    public static String formatDate(Date time){
        String result="";
        String format1 =format(time, FORMAT_SLASH_SHORT2);
        String format2 =format(new Date(), FORMAT_SLASH_SHORT2);
        if(format2.equals(format1)){
            SimpleDateFormat df = new SimpleDateFormat(FORMAT_HOUR);
            String str = df.format(time);
            int a = Integer.parseInt(str);
            if (a >= 0 && a <= 6) {
                result="凌晨"+format(time,DateUtil.FORMAT_HM);
            }
            if (a > 6 && a <= 12) {
               result="上午"+format(time,DateUtil.FORMAT_HM);
            }
            if (a > 12 && a <= 13) {
                result="中午"+format(time,DateUtil.FORMAT_HM);
            }
            if (a > 13 && a <= 18) {
                result="下午"+format(time,DateUtil.FORMAT_HM);
            }
            if (a > 18 && a <= 24) {
                result="晚上"+format(time,DateUtil.FORMAT_HM);
            }
        }else {
            result=format(time,FORMAT_SHORT);
        }
        return result;
    }
    /**
     * 获取时间差
     *
     * @param date 需要对的时间
     * @return
     * @Author qiaowy
     * @Date 2019/4/28
     */
    public static String toFormatMultiple(Date date) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //参数日期 天数
        int dateDay = calendar.get(Calendar.DATE);
        calendar.setTime(new Date());
        //今天 天数
        int todayDay = calendar.get(Calendar.DATE);

        long delta = System.currentTimeMillis() - date.getTime();
        if (delta < 1L * ONE_MINUTE) {
            long seconds = toSeconds(delta);
            return (seconds <= 0 ? 1 : seconds) + ONE_SECOND_AGO;
        }
        if (delta < 45L * ONE_MINUTE) {
            long minutes = toMinutes(delta);
            return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
        }
        if (delta < 24L * ONE_HOUR) {
            long hours = toHours(delta);
            return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
        }
        //如果日期相差小于48小时 并且 相差天数 小于2
        if (delta < 48L * ONE_HOUR && todayDay - dateDay < 2) {
            return "昨天";
        }
        if (delta < 30L * ONE_DAY) {
            long days = toDays(delta);
            return (days <= 0 ? 1 : days) + ONE_DAY_AGO;
        }
        if (delta < 12L * 4L * ONE_WEEK) {
            long months = toMonths(delta);
            return (months <= 0 ? 1 : months) + ONE_MONTH_AGO;
        } else {
            long years = toYears(delta);
            return (years <= 0 ? 1 : years) + ONE_YEAR_AGO;
        }
    }

    private static long toSeconds(long date) {
        return date / 1000L;
    }

    private static long toMinutes(long date) {
        return toSeconds(date) / 60L;
    }

    private static long toHours(long date) {
        return toMinutes(date) / 60L;
    }

    private static long toDays(long date) {
        return toHours(date) / 24L;
    }

    private static long toMonths(long date) {
        return toDays(date) / 30L;
    }

    private static long toYears(long date) {
        return toMonths(date) / 365L;
    }

    /**
     * 获得某天最大时间
     *
     * @param date
     * @return
     * @Author hxd
     * @Date 2019/4/19
     */
    public static Date getEndOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获得某天最小时间
     *
     * @param date
     * @return
     * @Author hxd
     * @Date 2019/4/19
     */
    public static Date getStartOfDay(Date date) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 买断日期
     *
     * @return
     * @Author qwy
     */
    public static Date getMaxDate() {
        Date date = new Date();
        SimpleDateFormat dateFormat2 = new SimpleDateFormat(getDatePattern());
        try {
            date = dateFormat2.parse("2999-12-30 23:59:59");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 验证日期字符串格式是否正确
     *
     * @param str     要验证的日期字符串
     * @param pattern 正则表达式
     * @return
     * @Author hxd
     * @Date 2019/8/15
     */
    public static boolean isValidDate(String str, String pattern) {
        boolean convertSuccess = true;
        //指定日期格式，注意区分大小写
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            //设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (Exception e) {
            //如果抛出异常，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }

    /**************************************************java8时间类LocalDateTime处理时间***************************************************/

    /**
     * Date转LocalDateTime
     *
     * @param date 日期
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime;
    }

    /**
     * 日期格式化
     *
     * @param date    日期
     * @param pattern 日期格式
     * @return
     * @Author hxd
     * @Date 2019/4/26
     */
    public static String dateFormat(Date date, String pattern) {
        if (StringUtils.isEmpty(pattern)) {
            throw new BusinessException("日期转化格式异常");
        }
        LocalDateTime local = dateToLocalDateTime(date);
        return local.format(DateTimeFormatter.ofPattern(pattern));
    }

    /*************************************************java8时间类LocalDateTime处理时间结束*************************************************/


    /**
     * @Description 两天之间相差多少天
     * @Author yijm
     * @Param
     * @Date 2019/6/21 16:48
     **/
    public static long daysBetween(String sDate, String eDate) {
        return daysBetween(parse(sDate), parse(eDate));
    }

    /**
     * @return long
     * @Author dubl
     * @Description 两天之间相差多少天
     * @Date 2019/11/22 15:08
     * @Param [sDate, eDate]
     **/
    public static long daysBetween(Date sDate, Date eDate) {
        Duration duration = Duration.between(dateToLocalDateTime(sDate), dateToLocalDateTime(eDate));
        //相差时间
        long hours = duration.toHours();
        //获取整数天数之外的小时数
        long hour = hours % 24;
        //获取整数天数
        long days = hours / 24;
        /*
         * 如果整数天数是0天，显示1天
         * 如果整数天数大于1天，四舍五入天数
         */
        if (days == 0) {
            days = 1;
        } else {
            //四舍五入，余数小时数大于等于12小时，相差天数加一天
            if (hour >= 12) {
                days++;
            }
        }
        return days;
    }

    /**
     * @return long
     * @Author dubl
     * @Description 两天之间相差多少天，若为0天显示0天
     * @Date 2019/11/22 15:08
     * @Param [sDate, eDate]
     **/
    public static long daysBetweenforZero(Date sDate, Date eDate) {
        Duration duration = Duration.between(dateToLocalDateTime(sDate), dateToLocalDateTime(eDate));
        //相差时间
        long hours = duration.toHours();
        //获取整数天数之外的小时数
        long hour = hours % 24;
        //获取整数天数
        long days = hours / 24;
        //四舍五入，余数小时数大于等于12小时，相差天数加一天
        if (hour >= 12) {
            days++;
        }
        return days;
    }

    /**
     * @return java.lang.String
     * @Author qwy
     * @Description 获取yyyy-MM-dd'T'HH:mm:ss'Z'格式的当前时间
     * @Date 2019/7/17  17:32
     * @Param []
     **/
    public static String getTimeStamp() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        //server timezone
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat.format(new Date());
    }


    public static String getDiffTime(Date date) {

        return getDifferenceTime(format(date),format(new Date()));
    }

    /**
     * @return java.lang.String
     * @Author qwy
     * @Description 计算两个日期相差多少天多少小时多少分多少秒
     * @Date 2019/7/22  7:58
     * @Param [strTime1, strTime2, timeFormat]
     **/
    public static String getDifferenceTime(String strTime1, String strTime2) {
        if (StringUtils.isEmpty(strTime1) || StringUtils.isEmpty(strTime2)) {
            return "--";
        }
        DateFormat df = new SimpleDateFormat(getDatePattern());
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        long ms = 0;
        try {
            Date one = df.parse(strTime1);
            Date two = df.parse(strTime2);
            long time1 = one.getTime();
            long time2 = two.getTime();
            long diff;
            if (time1 < time2) {
                diff = time2 - time1;
            } else {
                diff = time1 - time2;
            }
            day = diff / (24 * 60 * 60 * 1000);
            hour = (diff / (60 * 60 * 1000) - day * 24);
            min = ((diff / (60 * 1000)) - day * 24 * 60 - hour * 60);
            sec = (diff / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String result = "";
        if (day > 0) {
            result = result + day + "天";
        }
        if (hour > 0) {
            result = result + hour + "小时";
        }
        if (min > 0) {
            result = result + min + "分";
        }
        if(StringUtils.isEmpty(result)){
            result = result + sec + "秒";
        }
        return result;
    }

    /**
     * 将秒数转换为日时分秒
     *
     * @param second
     * @return
     * @author qwy
     */
    public static String secondToTime(long second) {
        String result = "";
        //转换天数
        long days = second / 86400;
        //剩余秒数
        second = second % 86400;
        //转换小时
        long hours = second / 3600;
        //剩余秒数
        second = second % 3600;
        //转换分钟
        long minutes = second / 60;
        //剩余秒数
        second = second % 60;
        if (days > 0) {
            result = days + "天";
        }
        if (hours > 0) {
            result = result + hours + "小时";
        }
        if (minutes > 0) {
            result = result + minutes + "分";
        }
        if (second > 0) {
            result = result + second + "秒";
        }
        return result;
    }
    /**
     * 将秒数转换为日时分
     *
     * @param second
     * @return
     */
    public static String secondToTimeDHM(long second) {
        String result = "";
        //转换天数
        long days = second / 86400;
        //剩余秒数
        second = second % 86400;
        //转换小时
        long hours = second / 3600;
        //剩余秒数
        second = second % 3600;
        //转换分钟
        long minutes = second / 60;
        //剩余秒数
        second = second % 60;
        if (days > 0) {
            result = days + "天";
        }
        if (hours > 0) {
            result = result + hours + "小时";
        }
        if (minutes > 0) {
            result = result + minutes + "分";
        }
        return result;
    }

    /**
     * 将日期转换为日时分秒
     *
     * @param date
     * @param dateStyle
     * @return
     */
    public static String dateToTime(String date, String dateStyle) {
        SimpleDateFormat format = new SimpleDateFormat(dateStyle);
        String result = "";
        try {
            Date oldDate = format.parse(date);
            //输入日期转换为毫秒数
            long time = oldDate.getTime();
            //当前时间毫秒数
            long nowTime = System.currentTimeMillis();
            //二者相差多少毫秒
            long second = nowTime - time;
            //毫秒转换为妙
            second = second / 1000;
            result = secondToTime(second);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * @param oldDate 指定日期
     * @param second  秒数
     * @return
     * @author qiaoweiya
     * @desc 批处理使用，给指定时间相加减指定秒数
     */
    public static Date getNewDate(Date oldDate, long second) {
        Date newDate = null;
        Long timestamp = oldDate.getTime() / 1000;
        long newTimestamp = (timestamp + second) * 1000;
        SimpleDateFormat format = new SimpleDateFormat(getDatePattern());
        String d = format.format(newTimestamp);
        try {
            newDate = format.parse(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }

    /**
     * 获取分钟差
     *
     * @param oneDate 设置为当前系统时间
     * @param twoDate 获取数据库中的时间
     * @return minute
     */
    public static long getMinuteDiff(Date oneDate, Date twoDate) {
        Calendar dateOne = Calendar.getInstance();
        Calendar dateTwo = Calendar.getInstance();
        dateOne.setTime(oneDate);
        dateTwo.setTime(twoDate);
        long timeOne = dateOne.getTimeInMillis();
        long timeTwo = dateTwo.getTimeInMillis();
        long minute;
        minute = (timeOne - timeTwo) / (1000 * 60);
        return minute;
    }

    /**
     * 字符串 转 Date
     *
     * @param time
     * @return
     */
    public static Date strToDate(String time) {

        DateFormat dateFormat = new SimpleDateFormat(DateUtil.FORMAT_LONG);

        //时间
        Date date = null;

        try {
            if (!StringUtils.isEmpty(time)) {
                date = dateFormat.parse(time);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (date == null) {

            dateFormat = new SimpleDateFormat(DateUtil.FORMAT_SHORT);

            try {
                if (!StringUtils.isEmpty(time)) {
                    date = dateFormat.parse(time);
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return date;
    }

    public static Date strToDate(String time, String format) {

        DateFormat dateFormat = new SimpleDateFormat(format);

        //时间
        Date date = null;

        try {
            if (!StringUtils.isEmpty(time)) {
                date = dateFormat.parse(time);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * 将*小时*分*秒转为秒数
     *
     * @param time
     * @return
     */
    public static Integer getSecond(String time) {

        if (StringUtils.isEmpty(time)) {
            return 0;
        }

        String[] times = new String[10];
        String hour = null;
        String minute = null;
        String second = null;

        if (time.contains("小时")) {
            times = time.split("小时");
            hour = times[0];
            if (times.length > 1) {
                time = times[1];
            } else {
                time = "";
            }

        }

        if (time.contains("分")) {
            times = time.split("分");
            minute = times[0];
            if (times.length > 1) {
                time = times[1];
            } else {
                time = "";
            }
        }

        if (time.contains("秒")) {
            second = time.replaceAll("秒", "");
        }

        if (StringUtils.isEmpty(second)) {
            return 0;
        }

        return (StringUtils.isEmpty(hour) ? 0 : Integer.parseInt(hour) * 60 * 60) +
            (StringUtils.isEmpty(minute) ? 0 : Integer.parseInt(minute) * 60) + Integer.parseInt(second);
    }

    /***
     * 两个日期相差多少秒
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getTimeDelta(Date date1, Date date2) {
        //单位是秒
        long timeDelta = (date1.getTime() - date2.getTime()) / 1000;
        return timeDelta > 0 ? (int) timeDelta : (int) Math.abs(timeDelta);
    }

    /***
     * 两个日期相差多少秒,不取绝对值，负数正常返回
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getTimeDelta1(Date date1, Date date2) {
        //单位是秒
        long timeDelta = (date1.getTime() - date2.getTime()) / 1000;
        return (int) timeDelta;
    }

    /**
     * 秒数转化为分钟
     *
     * @param second
     * @param scale
     * @return
     */
    public static String secondToMinute(Integer second, Integer scale) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        //可以设置精确几位小数
        df.setMaximumFractionDigits(scale);
        //模式 例如四舍五入
        df.setRoundingMode(RoundingMode.HALF_UP);
        double accuracyNum = second / 60d;
        return df.format(accuracyNum);
    }


    /***
     * @Author dubl
     * @Description 获取当前时间与第二天零点的时间差，单位秒
     * @Date 2019/11/6 13:19
     * @Param []
     * @return java.lang.Long
     **/
    public static Long getSecondsNextEarlyMorning() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
    }


    /**
     * @return java.util.Date
     * @Author dubl
     * @Description 获取n天前的时间
     * @Date 2019/11/28 14:10
     * @Param [sDate]
     **/
    public static Date getNdayBeforeDate(Date sDate, int n) {
        long time = n * 86400000L;
        return new Date(sDate.getTime() - time);
    }

    public static String getWeekDay(Date date) {
        if (date == null) {
            return null;
        }
        String[] weekDays = new String[]{"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDays[w];
    }
    public static String getWeekDay1(Date date) {
        if (date == null) {
            return null;
        }
        String[] weekDays = new String[]{"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        return weekDays[w];
    }
    public static String getWeekDayCode(Date date){
        if (date == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) -1;
        return String.valueOf(w);
    }
    /**
     * 获取传入日期所在月的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(final Date date) {

        final Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        final int last = cal.getActualMinimum(Calendar.DAY_OF_MONTH);

        cal.set(Calendar.DAY_OF_MONTH, last);

        return cal.getTime();

    }

    /**
     * 获取传入日期所在月的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(final Date date) {

        final Calendar cal = Calendar.getInstance();

        cal.setTime(date);

        final int last = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        cal.set(Calendar.DAY_OF_MONTH, last);

        return cal.getTime();

    }

    /**
     * 获取传入日期所在周的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeek(final Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得传入日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK);//获得传入日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);//根据日历的规则，给传入日期减去星期几与一个星期第一天的差值
        return cal.getTime();

    }

    /**
     * 获取传入日期所在周的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfWeek(final Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);//获得传入日期是一个星期的第几天
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        cal.setFirstDayOfWeek(Calendar.MONDAY);//设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = cal.get(Calendar.DAY_OF_WEEK);//获得传入日期是一个星期的第几天
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);//根据日历的规则，给传入日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, 6);
        return cal.getTime();

    }

    /**
     * 获取传入日期的上一个月
     *
     * @return
     */
    public static Date getLastMonth() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        return DateUtil.patternDate(c.getTime(), FORMAT_YD2);
    }

    /**
     * 判断当前时间是否在[startTime, endTime]区间
     *
     * @param now   当前时间
     * @param start 开始时间
     * @param end   结束时间
     * @return
     * @author zhaom
     */
    public static boolean isEffectiveDate(String now, String start, String end) {

        Date nowTime = strToDate(now, FORMAT_HMS);
        Date startTime = strToDate(start, FORMAT_HMS);
        Date endTime = strToDate(end, FORMAT_HMS);

        if (nowTime.getTime() == startTime.getTime()
            || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar stop = Calendar.getInstance();
        stop.setTime(endTime);

        if (date.after(begin) && date.before(stop)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 当月所有的日期集合
     *
     * @param
     * @return
     * @Author hxd
     * @Date 2020/6/11
     */
    public static List<String> getDayListOfMonth() {
        List<String> list = new ArrayList<>();
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        //当月最大日期
        int day = aCalendar.getActualMaximum(Calendar.DATE);
        for (int i = 1; i <= day; i++) {
            list.add(i + "号");
        }
        return list;
    }

    /**
     * 获取一段时间之内的所有日期时间列表
     *
     * @param begin 开始时间    日期格式：yyyy-MM-dd
     * @param end   结束时间    日期格式：yyyy-MM-dd
     * @return
     * @Author hxd
     * @Date 2020/6/11
     */
    public static List<String> getDayBetweenDates(String begin, String end) {
        if (StringUtils.isEmpty(begin) || StringUtils.isEmpty(end)) {
            return null;
        }
        Date dBegin = parse(begin, FORMAT_SHORT);
        Date dEnd = parse(end, FORMAT_SHORT);
        List<String> lDate = new ArrayList<>();
        lDate.add(format(dBegin, FORMAT_SHORT));
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(format(calBegin.getTime(), FORMAT_SHORT));
        }
        return lDate;
    }

    /**
     * 判断日期是否在某一区间
     *
     * @param testDate
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean isIn(Date testDate, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(testDate);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        return date.after(begin) && date.before(end);
    }

    /**
     * 日期拼接
     * 如2020-08-08 拼接  08:00:00 为  2020-08-08 08:00:00
     *
     * @param date Date类型
     * @param time String类型
     * @return
     */
    public static Date addTime(Date date, String time) {
        Date endDate = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat ds = new SimpleDateFormat("yyyy-MM-dd");
        try {
            endDate = df.parse(ds.format(date) + time);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return endDate;
    }

    /**
     * 日期拼接
     * 如2020-08-08 拼接  08:00:00 为  2020-08-08 08:00:00
     *
     * @param date String类型
     * @param time String类型
     * @return
     */
    public static Date addTime1(String date, String time) {
        Date endDate = new Date();
        StringBuffer sb = new StringBuffer();
        sb.append(date);
        sb.append(" ");
        sb.append(time);
        try {
            endDate = DateUtil.parse(sb.toString(), DateUtil.FORMAT_LONG);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return endDate;
    }

    public static void main(String[] args) {
       Date now = DateUtil.parse("2020-12-31",DateUtil.FORMAT_SHORT);
       System.out.println(DateUtil.format(now,DateUtil.FORMAT_MD));
    }
}
