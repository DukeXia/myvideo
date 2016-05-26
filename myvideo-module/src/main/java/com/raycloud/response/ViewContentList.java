package com.raycloud.response;

import com.raycloud.pojo.Article;
import com.raycloud.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/10.
 */
public class ViewContentList {



    private Integer total;

    private List<ContentListBean> contentList;

    public void toContentListResponse(List<Article> articleList){
        ContentListBean contentListBean = null;
        contentList = new ArrayList<ContentListBean>();
        for(Article a : articleList){
            contentListBean = new ContentListBean();
            contentListBean.setId(a.getId());
            contentListBean.setUsername(a.getUsername());
            contentListBean.setAuthor(a.getAuthor());
            contentListBean.setBoardNum(a.getBoardNum());
            contentListBean.setCategory(a.getCategory());
            String str = a.getContent().replaceAll("<([^>]*)>","");
            contentListBean.setContent(str.substring(0,str.length() <= 200 ? str.length() : 200));
            contentListBean.setCreated(DateUtil.getDateTime(a.getCreated(),"yyyy-MM-dd HH:mm:ss"));
            contentListBean.setImageUrl(a.getHeadPhotoUrl());
            contentListBean.setTitle(a.getTitle());
            contentListBean.setReadNum(a.getReadNum());
            contentList.add(contentListBean);
        }
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<ContentListBean> getContentList() {
        return contentList;
    }

    public void setContentList(List<ContentListBean> contentList) {
        this.contentList = contentList;
    }

    public static class ContentListBean {
        private Long id;
        private String title;
        private String author;
        private String created;
        private String category;
        private Long readNum;
        private String imageUrl;
        private String content;
        private Integer boardNum;
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

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
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

        public Long getReadNum() {
            return readNum;
        }

        public void setReadNum(Long readNum) {
            this.readNum = readNum;
        }



        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public Integer getBoardNum() {
            return boardNum;
        }

        public void setBoardNum(Integer boardNum) {
            this.boardNum = boardNum;
        }
    }
}
