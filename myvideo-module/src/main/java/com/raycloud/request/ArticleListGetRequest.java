package com.raycloud.request;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/10.
 */
public class ArticleListGetRequest extends RequestList {

    private static final long serialVersionUID = -1611097016334597646L;
    //根据标题模糊搜索
    private String title;
    //根据分类id来搜索
    private Long categoryId;
    //根据时间来搜索
    private String created;
    //根据用户搜索
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
