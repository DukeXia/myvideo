package com.raycloud.web.test;

import org.mvel2.MVEL;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/4/14.
 */
public class Main {

    public static void main(String args[]){
        String str = "a == 4 && b >= 10";
        Map<String,Object > map = new HashMap<String, Object>();
        map.put("a",4);
        map.put("b",11);
        Boolean res = (Boolean)MVEL.eval(str,map);
        System.out.println(res);
    }
}
