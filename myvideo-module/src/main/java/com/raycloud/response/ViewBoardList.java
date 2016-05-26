package com.raycloud.response;

import com.raycloud.pojo.Board;
import com.raycloud.pojo.SubBoard;
import com.raycloud.util.DateUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/11.
 */
public class ViewBoardList {

    /**
     * boardList : [{"id":1,"content":"支持楼主！","author":"周杰伦","created":"2016-02-28","imageUrl":"http://www.fdfd.com/1.jpg","subBoardList":[{"id":2,"content":"我回复了1号楼主！","author":"二珂1","created":"2016-05-12","imageUrl":"http://www.fdfd.com/1.jpg"},{"id":3,"content":"我回复了1号楼主！","author":"二珂2","created":"2016-03-12","imageUrl":"http://www.fdfd.com/1.jpg"}]},{"id":8,"content":"支持楼主！","author":"林俊杰","created":"2016-01-12","imageUrl":"http://www.fdfd.com/1.jpg","subBoardList":[{"id":1,"content":"支持楼主,回复需要20个字顶！！","author":"善良又自大的昂","created":"2016-01-12","imageUrl":"http://www.fdfd.com/1.jpg"}]}]
     * total : 100
     */

    private Integer total;
    /**
     * id : 1
     * content : 支持楼主！
     * author : 周杰伦
     * created : 2016-02-28
     * imageUrl : http://www.fdfd.com/1.jpg
     * subBoardList : [{"id":2,"content":"我回复了1号楼主！","author":"二珂1","created":"2016-05-12","imageUrl":"http://www.fdfd.com/1.jpg"},{"id":3,"content":"我回复了1号楼主！","author":"二珂2","created":"2016-03-12","imageUrl":"http://www.fdfd.com/1.jpg"}]
     */

    private List<BoardListBean> boardList = new ArrayList<BoardListBean>();

    public void toViewBoardListResponse(List<Board> boardList,List<SubBoard> subBoardList){
        BoardListBean boardListBean = null;
        this.boardList = new ArrayList<BoardListBean>();
        for(Board b : boardList){
            boardListBean = new BoardListBean();
            boardListBean.setId(b.getId());
            boardListBean.setAuthor(b.getUsername());
            boardListBean.setContent(b.getContent());
            boardListBean.setCreated(DateUtil.getDateTime(b.getCreated(),"yyyy-MM-dd HH:mm:ss"));
            boardListBean.setImageUrl(b.getHeadPhotoUrl());
            Iterator<SubBoard> iterator = subBoardList.iterator();
            while(iterator.hasNext()){
                SubBoard s = iterator.next();
                if(b.getId().longValue() == s.getBoardId().longValue()){
                    SubBoardListBean sub = new SubBoardListBean();
                    sub.setAuthor(s.getUsername());
                    sub.setContent(s.getContent());
                    sub.setCreated(DateUtil.getDateTime(s.getCreated(), "yyyy-MM-dd HH:mm:ss"));
                    sub.setImageUrl(s.getHeadPhotoUrl());
                    boardListBean.getSubBoardList().add(sub);
                    iterator.remove();
                }
            }
            this.boardList.add(boardListBean);
        }
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<BoardListBean> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<BoardListBean> boardList) {
        this.boardList = boardList;
    }

    public class BoardListBean {
        private Long id;
        private String content;
        private String author;
        private String created;
        private String imageUrl;
        /**
         * id : 2
         * content : 我回复了1号楼主！
         * author : 二珂1
         * created : 2016-05-12
         * imageUrl : http://www.fdfd.com/1.jpg
         */

        private List<SubBoardListBean> subBoardList = new ArrayList<SubBoardListBean>();

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

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public List<SubBoardListBean> getSubBoardList() {
            return subBoardList;
        }

        public void setSubBoardList(List<SubBoardListBean> subBoardList) {
            this.subBoardList = subBoardList;
        }


    }

    public class SubBoardListBean {
        private int id;
        private String content;
        private String author;
        private String created;
        private String imageUrl;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }
}
