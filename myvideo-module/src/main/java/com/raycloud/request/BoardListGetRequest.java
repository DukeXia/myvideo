package com.raycloud.request;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/10.
 */
public class BoardListGetRequest extends RequestList{

    private static final long serialVersionUID = 4191006743079566521L;
    //文章id
    private Long articleId;

    private String username;

    private Integer split;

    public Integer getSplit() {
        return split;
    }

    public void setSplit(Integer split) {
        this.split = split;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
}
