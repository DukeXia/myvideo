package com.raycloud.response;

import com.raycloud.pojo.Article;
import com.raycloud.util.DateUtil;

import java.text.SimpleDateFormat;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/11.
 */
public class ViewContentDetail {

    /**
     * title : 第一篇文章
     * imageUrl : http://www.baidu.com/1.jpg
     * author : SKT
     * created : 2016-05-09
     * category : 科技
     * redNum : 1588
     * content : 欢迎大家来到我的博客，我的博客成立于2015-12-12
     */

    private String title;
    private String imageUrl;
    private String author;
    private String created;
    private String category;
    private Long redNum;
    private String content;
    private Integer split;

    public void toContentDetailResponse(Article article,Integer split){
        this.title = article.getTitle();
        this.imageUrl = article.getHeadPhotoUrl();
        this.author = article.getAuthor();
        this.created = DateUtil.getDateTime(article.getCreated(),"yyyy-MM-dd HH:mm:ss");
        new SimpleDateFormat();
        this.category = article.getCategory();
        this.redNum = article.getReadNum();
        this.content = article.getContent();
        this.split = split;
    }

    public Integer getSplit() {
        return split;
    }

    public void setSplit(Integer split) {
        this.split = split;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getRedNum() {
        return redNum;
    }

    public void setRedNum(Long redNum) {
        this.redNum = redNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
