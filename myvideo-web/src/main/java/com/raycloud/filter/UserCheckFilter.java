package com.raycloud.filter;

import com.raycloud.constant.UserConstant;
import com.raycloud.exception.ServiceException;
import com.raycloud.pojo.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
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
        String uri = request.getRequestURI();
        if("/admin/".equals(uri)){
            /*Cookie[] cookies = request.getCookies();
            for(Cookie c : cookies){
                if(UserConstant.USER_INFO_KEY.equals(c.getName())){
                    //判断是否存在
                    chain.doFilter(req,resp);
                    return;
                }
            }*/
            User user = (User)request.getSession().getAttribute(UserConstant.USER_INFO_KEY);
            if(user != null){
                chain.doFilter(req, resp);
            }
            //throw new ServiceException("权限不足",902);
        }else {
            chain.doFilter(req, resp);
        }
    }

    @Override
    public void destroy() {

    }
}
