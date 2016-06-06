package com.raycloud.request;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/6/3.
 */
public class VideoListGetRequest extends RequestList {

    private static final long serialVersionUID = 2915919176335383732L;

    private String title;

    private Long categoryId;

    private String username;

    //获取categoryNum个分类的视频信息
    private Integer categoryNum;
    //每个分类显示videoNum个分类的视频信息
    private Integer videoNum;

    public Integer getCategoryNum() {
        return categoryNum;
    }

    public void setCategoryNum(Integer categoryNum) {
        this.categoryNum = categoryNum;
    }

    public Integer getVideoNum() {
        return videoNum;
    }

    public void setVideoNum(Integer videoNum) {
        this.videoNum = videoNum;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
