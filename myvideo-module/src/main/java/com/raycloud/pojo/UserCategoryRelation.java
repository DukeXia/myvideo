package com.raycloud.pojo;

import com.raycloud.pojo.common.BasePojo;

import java.io.Serializable;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/16.
 */
public class UserCategoryRelation extends BasePojo implements Serializable{

    private static final long serialVersionUID = 6621901122927961895L;

    private Long id;

    private Long categoryId;

    private String username;

    private Integer articleNum;



    /**
     * 分类名：category.name
     */
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(Integer articleNum) {
        this.articleNum = articleNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
