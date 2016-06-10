package com.raycloud.web;

import com.raycloud.pojo.Video;
import com.raycloud.request.Request;
import com.raycloud.request.UploadVideoRequest;
import com.raycloud.request.VideoGetRequest;
import com.raycloud.request.VideoListGetRequest;
import com.raycloud.response.Response;
import com.raycloud.response.ViewCategoryList;
import com.raycloud.response.ViewPreVideoList;
import com.raycloud.response.ViewVideoList;
import com.raycloud.service.impl.PublicService;
import com.raycloud.util.BooleanStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by on 2016/5/10.
 */
@Controller
public class PublicAction extends BaseAction {

    @Autowired
    private PublicService publicService;

    /**
     * 获取视频列表
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/getVideoList")
    public Response getVideoList(VideoListGetRequest request)throws Exception{
        Response response = new Response(request);
        System.out.println("获取视频列表");
        if(request.getCategoryNum() != null && request.getVideoNum() != null){
            ViewPreVideoList viewPreVideoList = publicService.getPreVideo(request);
            response.setData(viewPreVideoList);
        }else {
            ViewVideoList viewVideoList = publicService.getVideoList(request);
            response.setData(viewVideoList);
        }
        return response;
    }

    /**
     * 获取单一的视频信息
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getVideo")
    public Response getVideo(VideoGetRequest request)throws Exception{
        Response response = new Response(request);
        System.out.println("获取视频");
        ViewVideoList.VideoListBean v = publicService.getVideo(request);
        response.setData(v);
        return response;
    }

    /**
     * 获取分类列表
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getCategoryList")
    public Response getCategoryList(Request request)throws Exception{
        Response response = new Response(request);
        System.out.println("获取分类列表");
        ViewCategoryList viewCategoryList = publicService.getCategoryList();
        response.setData(viewCategoryList);
        return response;
    }

    /**
     * 上传视频
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/uploadVideo")
    public Response uploadVideo(UploadVideoRequest request)throws Exception{
        Response response = new Response(request);
        System.out.println("正在上传");
        boolean status = false;
        publicService.uploadVideo(request,getUser());
        response.setData(new BooleanStatusResponse(status = true));
        return response;
    }



    

}
