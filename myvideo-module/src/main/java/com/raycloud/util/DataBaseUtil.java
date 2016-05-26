package com.raycloud.util;

/**
 * 用来放一些静态常量，数据库的分表前缀
 * Created by linjunjie on 2016/1/6 (linjunjie@raycloud.com).
 */
public class DataBaseUtil {

    private final static String EXCHANGE_LOG = "EXCHANGE_LOG";

    private final static String ACTIVITY = "ACTIVITY";
    /**我们是根据淘宝ID来
     * 取余计算分表号
     * @param taobaoId
     * @param num
     * @return
     */
    public static int getDBId(Long taobaoId,Integer num){
        return ((int)(taobaoId%num));
    }
}


