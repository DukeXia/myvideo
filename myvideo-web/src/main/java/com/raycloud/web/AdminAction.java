package com.raycloud.web;

import com.raycloud.request.CategoryAddRequest;
import com.raycloud.request.CategoryDeleteRequest;
import com.raycloud.request.VideoDeleteRequest;
import com.raycloud.response.Response;
import com.raycloud.service.impl.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/6/7.
 */
@Controller
@RequestMapping("/admin")
public class AdminAction {

    @Autowired
    private PublicService publicService;

    /**
     * 删除一个分类
     */
    @ResponseBody
    @RequestMapping("/delCategory")
    public Response delCategory(CategoryDeleteRequest request)throws Exception{
        Response response = new Response(request);
        publicService.deleteCategory(request);

        return response;
    }

    @ResponseBody
    @RequestMapping("/addCategory")
    public Response addCategory(CategoryAddRequest request)throws Exception{
        Response response = new Response(request);
        publicService.addCategory(request);

        return response;
    }

    /**
     * 删除一个视频
     */
    @ResponseBody
    @RequestMapping("/delVideo")
    public Response delVideo(VideoDeleteRequest request)throws Exception{
        Response response = new Response(request);
        publicService.deleteVideo(request);

        return response;
    }

}
