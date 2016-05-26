package com.raycloud.web;

import com.raycloud.constant.ResponseResultConstant;
import com.raycloud.constant.UserConstant;
import com.raycloud.exception.InvalidSessionException;
import com.raycloud.interceptor.ExceptionHandle;
import com.raycloud.pojo.User;
import com.raycloud.request.Request;
import com.raycloud.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;

/**
 * 异常拦截集中处理;
 * 将request和response存储在ThreadLocal中
 * 创建session;
 * Created by Administrator on 2016/1/30.
 */
public class BaseAction implements Serializable{

    private static final long serialVersionUID = 2504336653791589091L;
    private static final ThreadLocal<HttpServletRequest> requestThreadLocal = new ThreadLocal<HttpServletRequest>();
    private static final ThreadLocal<HttpServletResponse> responseThreadLocal = new ThreadLocal<HttpServletResponse>();

     //* 在任何action中的方法执行前，执行这个方法
    @ModelAttribute
    public void setRequestAndResponse(HttpServletRequest request,HttpServletResponse response){
        requestThreadLocal.set(request);
        responseThreadLocal.set(response);
    }

    public HttpServletRequest getRequest(){
        return requestThreadLocal.get();
    }

    public HttpServletResponse getResponse(){
        return responseThreadLocal.get();
    }

    //* 集中处理action抛出的异常
    @ExceptionHandler({Exception.class})
    public void exceptionHandle(HttpServletRequest req,HttpServletResponse resp,Exception e){
        ExceptionHandle.handle(req,resp,e);
    }

    //集中式session,分为memSession和tomcatSession

    //@Qualifier("oscSession")
    @Autowired
    private Session session;

    /**
     *  从session中取出存在里面的用户对象
     * @return
     * @throws com.raycloud.exception.InvalidSessionException
     */
    public User getUser()throws InvalidSessionException {
        User user = (User)session.getAttribute(getRequest(), UserConstant.USER_INFO_KEY);
        if(user == null){
            throw new InvalidSessionException("会话失效invalid-session", ResponseResultConstant.INVALID_SESSION);
        }
        return user;
    }


}
