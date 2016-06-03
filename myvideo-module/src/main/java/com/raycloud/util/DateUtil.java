package com.raycloud.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间转换器
 * Created by linjunjie on 2015/12/17 (linjunjie@raycloud.com).
 */
public class DateUtil {
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String SLASH_DATETIME_FORMAT = "yyyy/MM/dd HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String SLASH_DATE_FORMAT = "yyyy/MM/dd";

    /**
     * 时间周期,以年为周期，以月为周期...等等
     */
    public enum date_interval{
        YEAR,
        MONTH,
        DAY,
        HOUR,
        MINUTES,
        SECONDES
    }
    /**
     * 获得这种格式：pattern
     */
    public static String getDateTime(Date date,String pattern){
        if(date==null){
            return "";
        }
        //获得当前线程的SimpleDateFormate
        SimpleDateFormat simpleDateFormat = SimpleDateFormatThreadLocal.getSimpleDateFormat();
        simpleDateFormat.applyPattern(pattern);
        //转换并返回值
        return simpleDateFormat.format(date);
    }

    /**
     * 获得这种格式：pattern 的Date类型
     * @param date
     * @return
     */
    public static Date getDateTime(String date,String pattern) throws Exception{
        if(date==null){
            return null;
        }
        //获得当前线程的SimpleDateFormate
        SimpleDateFormat simpleDateFormat = SimpleDateFormatThreadLocal.getSimpleDateFormat();
        //转换并返回值
        return simpleDateFormat.parse(date);
    }

    /**
     * 根据当前时间，传入一个时间周期，获取活动的开始时间
     */
    public static Date getStartTime(date_interval date_interval){
        Calendar calendar = Calendar.getInstance();
        switch(date_interval){
            case YEAR:
                calendar.set(calendar.get(Calendar.YEAR),0,1,0,0,0);
                break;
            case MONTH:
                calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),1,0,0,0);
                break;
            case DAY:
                calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE),0,0,0);
                break;
            case HOUR:
                calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE),calendar.get(Calendar.HOUR_OF_DAY),0,0);
                break;
            case MINUTES:
                calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE),calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),0);
                break;
            case SECONDES:
                calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE),calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND));
                break;
        }
        System.out.println(calendar.getTime());
        return calendar.getTime();
    }

    /**
     * 根据当前时间，传入一个时间周期，获取活动的结束时间
     */
    public static Date getEndTime(date_interval date_interval){
        Calendar calendar = Calendar.getInstance();
        switch(date_interval){
            case YEAR:
                calendar.set(calendar.get(Calendar.YEAR)+1,0,1,0,0,0);
                break;
            case MONTH:
                calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1,1,0,0,0);
                break;
            case DAY:
                calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE)+1,0,0,0);
                break;
            case HOUR:
                calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE),calendar.get(Calendar.HOUR_OF_DAY)+1,0,0);
                break;
            case MINUTES:
                calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE),calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE)+1,0);
                break;
            case SECONDES:
                calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DATE),calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),calendar.get(Calendar.SECOND)+1);
                break;
        }
        System.out.println(calendar.getTime());
        return null;
    }

    /**
     * 获取当前的时间
     * @return
     */
    public static Long getCurrentTime(String username){
        synchronized (username.intern()){
            return System.currentTimeMillis();
        }
    }


    public static void main(String[] args){

        System.out.println(DateUtil.getDateTime(new Date(), DateUtil.DATETIME_FORMAT));
        getStartTime(date_interval.YEAR);
        getStartTime(date_interval.MONTH);
        getStartTime(date_interval.DAY);
        getStartTime(date_interval.HOUR);
        getStartTime(date_interval.MINUTES);
        getStartTime(date_interval.SECONDES);
        System.out.println(Calendar.getInstance().get(Calendar.YEAR));

        getEndTime(date_interval.YEAR);
        getEndTime(date_interval.MONTH);
        getEndTime(date_interval.DAY);
        getEndTime(date_interval.HOUR);
        getEndTime(date_interval.MINUTES);
        getEndTime(date_interval.SECONDES);
    }
}
