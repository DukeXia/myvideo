package com.raycloud.util;

import java.text.SimpleDateFormat;

/**
 * Created by linjunjie on 2015/12/17 (linjunjie@raycloud.com).
 */
public class SimpleDateFormatThreadLocal {

    private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>();

    public static SimpleDateFormat getSimpleDateFormat(){
        SimpleDateFormat sdf = simpleDateFormatThreadLocal.get();
        if(sdf == null) {
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            simpleDateFormatThreadLocal.set(sdf);
        }
        return sdf;
    }

    public static ThreadLocal<SimpleDateFormat> getSimpleDateFormatThreadLocal() {
        return simpleDateFormatThreadLocal;
    }

    public static void setSimpleDateFormatThreadLocal(ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal) {
        SimpleDateFormatThreadLocal.simpleDateFormatThreadLocal = simpleDateFormatThreadLocal;
    }
}
