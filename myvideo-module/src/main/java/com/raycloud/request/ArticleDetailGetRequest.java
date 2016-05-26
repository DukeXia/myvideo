package com.raycloud.request;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/10.
 */
public class ArticleDetailGetRequest extends Request {
    private static final long serialVersionUID = -7899062748978655075L;
    //根据id来搜索
    private Long id;
    //根据用户名搜索
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
