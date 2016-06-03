package com.raycloud.response;

import com.raycloud.pojo.Video;
import com.raycloud.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/10.
 */
public class ViewVideoList {

    public void toVideoResponse(List<Video> videoList){
        videoBeanList = new ArrayList<VideoListBean>();
        VideoListBean videoListBean = null;
        for(Video video : videoList){
            videoListBean = new VideoListBean();
            videoListBean.setId(video.getId());
            videoListBean.setUsername(video.getUsername());
            videoListBean.setTitle(video.getTitle());
            videoListBean.setDesc(video.getDesc());
            videoListBean.setCategory(video.getCategory());
            videoListBean.setUrl(video.getUrl());
            videoListBean.setCreated(DateUtil.getDateTime(video.getCreated(), "yyyy-MM-dd HH:mm:ss"));
            videoBeanList.add(videoListBean);
        }
    }

    /**
     * videoList : [{"id":1,"username":"qq444","title":"","desc":"描述","url":"...","category":"喜剧","created":"2015/12/20"}]
     * total : 100
     */

    private int total;
    /**
     * id : 1
     * username : qq444
     * title :
     * desc : 描述
     * url : ...
     * category : 喜剧
     * created : 2015/12/20
     */

    private List<VideoListBean> videoBeanList;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<VideoListBean> getVideoBeanList() {
        return videoBeanList;
    }

    public void setVideoBeanList(List<VideoListBean> videoBeanList) {
        this.videoBeanList = videoBeanList;
    }

    public static class VideoListBean {
        private Long id;
        private String username;
        private String title;
        private String desc;
        private String url;
        private String category;
        private String created;

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

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }
    }
}
