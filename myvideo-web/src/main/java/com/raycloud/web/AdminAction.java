package com.raycloud.web;

import com.raycloud.service.impl.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/6/7.
 */
@Controller
@RequestMapping("/admin/")
public class AdminAction {

    @Autowired
    private PublicService publicService;

    /**
     * 删除一个分类
     */
    @ResponseBody
    @RequestMapping("delCategory")
    public void delCategory(){

    }

    /**
     * 删除一个视频
     */
    @ResponseBody
    @RequestMapping("delVideo")
    public void delVideo(){

    }

}
