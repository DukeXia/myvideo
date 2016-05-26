package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.pojo.Article;
import com.raycloud.request.ArticleListGetRequest;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/10.
 */
@Repository
public class ArticleDao extends BaseDao{

    public void insert(Article article){
        getSqlMapClientTemplate().insert("Article.insert",article);
    }

    public List<Article> getList(Article article){
        return getSqlMapClientTemplate().queryForList("Article.getList",article);
    }

    public Integer getCount(Article article){
        return (Integer)getSqlMapClientTemplate().queryForObject("Article.getCount",article);
    }

    public Article get(Article article){
        return (Article)getSqlMapClientTemplate().queryForObject("Article.get",article);
    }

    public Integer delete(){

        return null;
    }

    public Integer updateNum(Article article){
        return (Integer)getSqlMapClientTemplate().update("Article.updateNum",article);
    }

}
