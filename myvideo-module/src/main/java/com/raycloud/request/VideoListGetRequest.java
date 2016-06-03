package com.raycloud.request;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/6/3.
 */
public class VideoListGetRequest extends RequestList {

    private static final long serialVersionUID = 2915919176335383732L;

    private String title;

    private Long categoryId;

    private String username;

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
