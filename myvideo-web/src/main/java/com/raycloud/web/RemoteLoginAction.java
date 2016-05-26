package com.raycloud.web;

import com.raycloud.request.Request;
import com.raycloud.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * 处理远程登录，爬取信息操作
 * Created by linjunjie on 2015/12/6 (linjunjie@raycloud.com).
 */
@Controller
@RequestMapping("/parse")
public class RemoteLoginAction {

    /**
     * 通过cookie进行登陆
     * @param request
     * @param cookie
     * @return
     */
    @RequestMapping("/cookieLogin")
    @ResponseBody
    public Response remoteLogin(Request request,String cookie){
        Response response = new Response(request);
        System.out.println(UUID.randomUUID());

        return response;
    }
}
