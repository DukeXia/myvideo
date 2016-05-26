package com.raycloud.listener;

import com.raycloud.constant.WebContextConstant;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/3/12.
 */
public class InitServletContext implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("启动中..");
        WebContextConstant.webRealPath = servletContextEvent.getServletContext().getRealPath("/");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
