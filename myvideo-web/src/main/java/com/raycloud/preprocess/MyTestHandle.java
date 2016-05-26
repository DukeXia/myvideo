package com.raycloud.preprocess;

import com.raycloud.util.DateUtil;

import java.util.Date;

/**
 * 定时器的目标类，每隔5秒执行一次
 * Created by linjunjie on 2016/1/5 (linjunjie@raycloud.com).
 */
public class MyTestHandle {

    public void execute(){

       System.out.println("quarz计划任务执行中,5秒一次"+DateUtil.getDateTime(new Date(),"yyyy-MM-dd hh:mm:ss"));
      /*   MemcachedClient cache = null;
        try {
            cache = new MemcachedClient(new InetSocketAddress("127.0.0.1",11211));
        } catch (IOException e) {
            e.printStackTrace();
        }
        cache.set("lin",1000,"junjie在此");
        System.out.println(cache.get("lin"));*/

    }
}
