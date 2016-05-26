package com.raycloud.aop;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;

/**
 * 这是一个通过配置文件来的切面拦截类
 * Created by linjunjie(490456661@qq.com) on 2016/4/30.
 */
public class CheckPrivilegeAOP{


    public void check(){
        System.out.println("----这是配置的aop,正在验证...");
    }
}
