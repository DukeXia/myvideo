package com.raycloud.response;

import com.raycloud.pojo.Video;
import com.raycloud.util.DateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/6/7.
 */
public class ViewPreVideoList extends ListResponse {


    public void toResponse(List<Video> videos){
        List<PreVideoListBean> preVideoListBean = new ArrayList<PreVideoListBean>();
        PreVideoListBean preVideoBean = null;
        for(Video v : videos){
            preVideoBean = new PreVideoListBean();
            preVideoBean.setUsername(v.getUsername());
            preVideoBean.setUrl(v.getUrl());
            preVideoBean.setPic(v.getPic());
            preVideoBean.setId(v.getId());
            preVideoBean.setCategory(v.getCategory());
            preVideoBean.setCreated(DateUtil.getDateTime(v.getCreated(), "yyyy-MM-dd HH:mm:ss"));
            preVideoBean.setDesc(v.getDesc());
            preVideoBean.setTitle(v.getTitle());
            preVideoListBean.add(preVideoBean);
        }
        preVideoList.add(preVideoListBean);
    }
    /**
     * id : 1
     * username : qq444
     * title :
     * desc : 描述
     * url : ...
     * pic : ...
     * category : 喜剧
     * created : 2015/12/20
     */

    private List<List<PreVideoListBean>> preVideoList = new ArrayList<List<PreVideoListBean>>();

    public List<List<PreVideoListBean>> getPreVideoList() {
        return preVideoList;
    }

    public void setPreVideoList(List<List<PreVideoListBean>> preVideoList) {
        this.preVideoList = preVideoList;
    }

    public static class PreVideoListBean {
        private Long id;
        private String username;
        private String title;
        private String desc;
        private String url;
        private String pic;
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

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
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
