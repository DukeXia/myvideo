package com.raycloud.web;

import com.raycloud.request.*;
import com.raycloud.response.Response;
import com.raycloud.response.ViewCategoryList;
import com.raycloud.response.ViewContentDetail;
import com.raycloud.response.ViewContentList;
import com.raycloud.service.impl.PublicBlogService;
import com.raycloud.util.BooleanStatusResponse;
import com.raycloud.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/10.
 */
@Controller
@RequestMapping("/resources")
public class PublicBlogAction extends BaseAction {

    @Autowired
    private PublicBlogService publicBlogService;

    @Resource
    private com.raycloud.service.PublicBlogService pb;



    /**
     * 获取文章列表
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getContentList")
    public Response getContentList(ArticleListGetRequest request)throws Exception{
        Response response = new Response(request);
        System.out.println("获取文章列表");
        ViewContentList viewContentList = publicBlogService.getContentList(request);
        response.setData(viewContentList);
        return response;
    }

    /**
     * 获取文章内容
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getContentDetail")
    public Response getContentDetail(ArticleDetailGetRequest request)throws Exception{
        Response response = new Response(request);
        System.out.println("获取文章内容");
        ViewContentDetail viewContentDetail = publicBlogService.getContentDetail(request);
        response.setData(viewContentDetail);
        return response;
    }

    /**
     * 添加新文章
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/newArticle")
    public Response newArticle(ArticleInsertRequest request)throws Exception{
        Response response = new Response(request);
        //html过滤
        request.setContent(StringUtil.htmlFilter(request.getContent()));
        //html过滤
        request.setTitle(StringUtil.htmlFilter(request.getTitle()));
        //html过滤
        request.setAuthor(StringUtil.htmlFilter(request.getAuthor()));
        System.out.println("创建新文章");
        request.getContent();
        boolean status = false;
        publicBlogService.insertArticle(request,getUser());
        status = true;
        response.setData(new BooleanStatusResponse(status));
        return response;
    }


    /**
     * 获取留言板列表
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/getBoardList")
    public Response getBoardList(BoardListGetRequest request)throws Exception{
        Response response = new Response(request);
        System.out.println("获取留言板列表");
        response.setData(publicBlogService.getBoardList(request));
        return response;
    }

    /**
     * 留言回复/子留言回复  (有登陆验证)
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/boardReply")
    public Response boardReply(BoardAddRequest request)throws Exception{
        Response response = new Response(request);
        //html过滤
        request.setContent(StringUtil.htmlFilter(request.getContent()));
        Boolean status = false;
        System.out.println("留言添加");
        publicBlogService.boardReply(request,getUser());
        status = true;
        response.setData(new BooleanStatusResponse(status));
        return response;
    }

    /**
     * 添加分类
     * @param request
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/addCategory")
    public Response addCategory(CategoryAddRequest request)throws Exception{
        Response response = new Response(request);
        //html过滤
        request.setName(StringUtil.htmlFilter(request.getName()));
        Boolean status = false;
        System.out.println("分类添加");
        publicBlogService.addCategory(request,getUser());
        response.setData(new BooleanStatusResponse(status=true));
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
    public Response getCategoryList(CategoryListGetRequest request)throws Exception{
        Response response = new Response(request);
        System.out.println("获取分类列表");
        ViewCategoryList viewCategoryList = publicBlogService.getCategoryList(request);
        response.setData(viewCategoryList);
        return response;
    }

    @ResponseBody
    @RequestMapping("/executeWOW")
    public Response executeWOW()throws Exception{
        Response response = new Response();
        pb.executeWOW();
        return response;
    }


}
