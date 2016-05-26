package com.raycloud.pojo;

import com.raycloud.pojo.common.BasePojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/10.
 */
public class Board extends BasePojo implements Serializable{
    private static final long serialVersionUID = 1095147117213746717L;

    private Long id;
    private String content;//留言内容
    private Long articleId;//文章id
    private String headPhotoUrl;//头像
    private String username;//用户
    private Date created;
    private Date modified;
    private Integer status;

    public Board orderByCreated(boolean desc){
        orderFields.add(new OrderField("created",desc == true ? "desc":""));
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getHeadPhotoUrl() {
        return headPhotoUrl;
    }

    public void setHeadPhotoUrl(String headPhotoUrl) {
        this.headPhotoUrl = headPhotoUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
