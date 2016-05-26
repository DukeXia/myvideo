package com.raycloud.web;

import com.raycloud.request.ArticleListGetRequest;
import com.raycloud.request.Request;
import com.raycloud.response.Response;
import com.raycloud.response.ViewContentList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/13.
 */
@Controller
public class ForwardAction extends BaseAction {


    @ResponseBody
    @RequestMapping("/{username}")
    public ModelAndView forward(@PathVariable("username")String username)throws Exception{
        ModelAndView modelAndView = new ModelAndView("/index");
        System.out.println("跳转到入口:"+username);

        return modelAndView;  //请求转发 到index.jsp页面，外人无法看到跳转到了index.jsp
    }
}
