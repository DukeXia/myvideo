package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.pojo.Video;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/10.
 */
@Repository
public class VideoDao extends BaseDao{

    public void insert(Video video){
        getSqlMapClientTemplate().insert("Video.insert",video);
    }

    public List<Video> getList(Video video){
        return getSqlMapClientTemplate().queryForList("Video.getList",video);
    }

    public Integer getCount(Video video){
        return (Integer)getSqlMapClientTemplate().queryForObject("Video.getCount",video);
    }

    public Video get(Video video){
        return (Video)getSqlMapClientTemplate().queryForObject("Video.get",video);
    }

    public Integer remove(Long id){

        return (Integer)getSqlMapClientTemplate().delete("Video.remove",id);
    }

}
