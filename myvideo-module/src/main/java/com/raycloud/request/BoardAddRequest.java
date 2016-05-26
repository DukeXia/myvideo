package com.raycloud.request;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/10.
 */
public class BoardAddRequest extends Request {

    private static final long serialVersionUID = 4160940924973220161L;

    private Long articleId;

    private String username;

    private Integer split;

    private Long boardId;

    private String content;

    private String targetUsername;//回复的目标用户

    public String getTargetUsername() {
        return targetUsername;
    }

    public void setTargetUsername(String targetUsername) {
        this.targetUsername = targetUsername;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getBoardId() {
        return boardId;
    }

    public void setBoardId(Long boardId) {
        this.boardId = boardId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSplit() {
        return split;
    }

    public void setSplit(Integer split) {
        this.split = split;
    }
}
