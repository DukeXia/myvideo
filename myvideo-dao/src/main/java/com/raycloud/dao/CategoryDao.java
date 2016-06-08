package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.pojo.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/16.
 */
@Repository
public class CategoryDao extends BaseDao {

    public void insert(Category category){
        getSqlMapClientTemplate().insert("Category.insert",category);
    }

    public Category get(Category category){
        return (Category)getSqlMapClientTemplate().queryForObject("Category.get",category);
    }

    public List<Category> getList(Category category){
        return getSqlMapClientTemplate().queryForList("Category.getList",category);
    }

    public int getCount(Category category){
        return (Integer)getSqlMapClientTemplate().queryForObject("Category.getCount",category);
    }

    public Integer remove(Long id){
        return (Integer)getSqlMapClientTemplate().delete("Category.remove",id);
    }
}
