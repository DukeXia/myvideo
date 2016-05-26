package com.raycloud.pojo;

import com.alibaba.fastjson.JSONObject;
import com.raycloud.pojo.common.BasePojo;
import com.raycloud.util.DataBaseUtil;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/10.
 */
public class Article extends BasePojo implements Serializable {

    private static final long serialVersionUID = -8828751498987592013L;
    private Long id;
    private String configRule;//json路由规则,一般是对留言信息的路由
    private String username;
    private String title;
    private String content;
    private String headPhotoUrl;//文章头部图片
    private Long readNum;//阅读量
    private String author;//作者
    private Long categoryId;//分类id
    private String category;//分类名
    private Integer boardNum;//留言数(包括子留言)
    private Date created;//创建时间
    private Date modified;//修改时间
    private Integer status;//状态 1 可用
    private DbConfig dbConfig;//路由规则对象

    /**
     * 路由规则对象
     */
    public static class DbConfig{
        private static final int BOARD_NUM = 5;//留言表
        private static final int SUB_BOARD_NUM = 5;//子留言表
        public DbConfig(){

        }
        private DbConfig(long id){
            boardDbId = DataBaseUtil.getDBId(id,BOARD_NUM);
            subBoardDbId = DataBaseUtil.getDBId(id,SUB_BOARD_NUM);
        }
        private int boardDbId;
        private int subBoardDbId;

        public int getBoardDbId() {
            return boardDbId;
        }

        public void setBoardDbId(int boardDbId) {
            this.boardDbId = boardDbId;
        }

        public int getSubBoardDbId() {
            return subBoardDbId;
        }

        public void setSubBoardDbId(int subBoardDbId) {
            this.subBoardDbId = subBoardDbId;
        }
    }
    /**结束 ====*/

    public String getConfigRule() {
        return configRule;
    }

    public void setConfigRule(String configRule) {
        this.configRule = configRule;
        this.dbConfig = JSONObject.parseObject(configRule,DbConfig.class);
    }

    public DbConfig getDbConfig() {
        if(dbConfig == null){
            synchronized (dbConfig){
                if(dbConfig == null && StringUtils.isNotBlank(configRule)){
                    dbConfig = JSONObject.parseObject(configRule,DbConfig.class);
                }
            }
        }
        return dbConfig;
    }

    public Article orderByCreated(boolean desc){
        orderFields.add(new OrderField("created",desc == true ? "desc":""));
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHeadPhotoUrl() {
        return headPhotoUrl;
    }

    public void setHeadPhotoUrl(String headPhotoUrl) {
        this.headPhotoUrl = headPhotoUrl;
    }

    public Long getReadNum() {
        return readNum;
    }

    public void setReadNum(Long readNum) {
        this.readNum = readNum;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getBoardNum() {
        return boardNum;
    }

    public void setBoardNum(Integer boardNum) {
        this.boardNum = boardNum;
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

    public void setDbConfig(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }
}
