package com.raycloud.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/4/28.
 */
public class UserCheckFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)resp;
        //拦截的逻辑
        /*Map map = request.getParameterMap();
        Collection collection = map.values();
        Iterator iterator = collection.iterator();
        while(iterator.hasNext()){
            String[] strs = (String[])iterator.next();
            for(int i=0;i<strs.length;i++){
                System.out.println("过滤前："+strs[i]);
                strs[i] = new String(strs[i].getBytes("ISO8859-1"),"UTF-8");
                System.out.println("过滤后："+strs[i]);
            }
        }
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");*/
        //放行
        chain.doFilter(req,resp);
    }

    @Override
    public void destroy() {

    }
}
