package com.raycloud.web;



import com.raycloud.constant.UserConstant;
import com.raycloud.exception.InvalidSessionException;
import com.raycloud.exception.ServiceException;
import com.raycloud.pojo.User;
import com.raycloud.request.Request;
import com.raycloud.request.UserLoginRequest;
import com.raycloud.request.UserRegisterRequest;
import com.raycloud.response.Response;

import com.raycloud.response.ViewUserLoginInfo;
import com.raycloud.service.impl.UserService;
import com.raycloud.util.BooleanStatusResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by linjunjie on 2016/1/25 (linjunjie@raycloud.com).
 */
@Controller
@RequestMapping("/user")
public class UserAction extends BaseAction{

    @Autowired
    private UserService userService;

    /**
     * 注册用户
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/register")
    public Response register(UserRegisterRequest request)throws Exception {
        Response response = new Response(request);
        System.out.println("注册用户");
        boolean status = false;
        userService.register(request,getRequest());
        ViewUserLoginInfo viewUserLoginInfo = new ViewUserLoginInfo();
        viewUserLoginInfo.setUsername(request.getUsername());
        response.setData(viewUserLoginInfo);
        return response;
    }

    /**
     * 用户登陆
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/login")
    public Response login(UserLoginRequest request)throws Exception {
        Response response = new Response(request);
        System.out.println("用户登陆");
        ViewUserLoginInfo viewUserLoginInfo = userService.login(request,getRequest(),getResponse());
        if(viewUserLoginInfo != null){
            response.setMessage("登陆成功!");
            response.setData(viewUserLoginInfo);
        }else{
            response.setMessage("登陆失败!");
            response.setResult("202");
        }
        return response;
    }


    @RequestMapping("/logout")
    public ModelAndView logout()throws Exception {
        System.out.println("用户注销");
        String referer = getRequest().getHeader("referer");
        int index = referer.lastIndexOf("/");
        referer = index == -1 ? "" : referer.substring(index+1);
        User user = null;
        try {
            user = getUser();
        }catch(InvalidSessionException e){
            return new ModelAndView("redirect:/jsp/login.jsp");
        }finally {
            getRequest().getSession().removeAttribute(UserConstant.USER_INFO_KEY);
            getRequest().getSession().removeAttribute("nick");
        }
        if("persCenter.jsp".equals(referer)){
            return new ModelAndView("redirect:/"+user.getUsername());
        }
        return new ModelAndView("redirect:/"+referer);
    }

    /**
     * 是否能注册
     * @param request
     * @param username
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/canRegister")
    public Response canRegister(Request request,String username)throws Exception {
        System.out.println("是否可以注册");
        Response response = new Response(request);
        boolean status = false;
        if(true == userService.canRegister(username)){
            status = true;
        }
        response.setData(new BooleanStatusResponse(status));
        return response;
    }

}
