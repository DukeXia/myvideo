package com.raycloud.request;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/6/3.
 */
public class UploadVideoRequest extends Request {

    private String title;

    private MultipartFile video;

    private Long categoryId;

    private String desc;

    private MultipartFile pic;

    public MultipartFile getPic() {
        return pic;
    }

    public void setPic(MultipartFile pic) {
        this.pic = pic;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public MultipartFile getVideo() {
        return video;
    }

    public void setVideo(MultipartFile video) {
        this.video = video;
    }
}
