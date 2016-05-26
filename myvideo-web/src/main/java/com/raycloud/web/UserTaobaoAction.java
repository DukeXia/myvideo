package com.raycloud.web;

import com.raycloud.exception.InvalidSessionException;
import com.raycloud.exception.ServiceException;
import com.raycloud.pojo.UserTaobao;
import com.raycloud.request.UserAddRequest;
import com.raycloud.response.Response;
import com.raycloud.service.UserTaobaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/2/2.
 */
@Controller
@RequestMapping("/taobao/user")
public class UserTaobaoAction extends BaseAction{

    @Autowired
    private UserTaobaoService userTaobaoService;

    @ResponseBody
    @RequestMapping("/addUser")
    public Response addUser(UserAddRequest request) throws ServiceException,InvalidSessionException {
        Response response = new Response(request);
        UserTaobao user = new UserTaobao();
        user.setTaobao_id(request.getTaobao_id());
        user.setTaobao_nick(request.getTaobao_nick());
        user.setSession_id(request.getSession_id());
        userTaobaoService.addUser(user);

        return response;
    }

}
