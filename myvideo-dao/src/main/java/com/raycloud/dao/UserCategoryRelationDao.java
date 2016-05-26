package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.pojo.UserCategoryRelation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/16.
 */
@Repository
public class UserCategoryRelationDao extends BaseDao {

    public void insert(UserCategoryRelation userCategoryRelation){
        getSqlMapClientTemplate().insert("UserCategoryRelation.insert",userCategoryRelation);
    }

    public List<UserCategoryRelation> getList(UserCategoryRelation userCategoryRelation){
        return getSqlMapClientTemplate().queryForList("UserCategoryRelation.getList",userCategoryRelation);
    }

    public Integer getCount(UserCategoryRelation userCategoryRelation){
        return (Integer)getSqlMapClientTemplate().queryForObject("UserCategoryRelation.getCount",userCategoryRelation);
    }

    public UserCategoryRelation get(UserCategoryRelation userCategoryRelation){
        return (UserCategoryRelation)getSqlMapClientTemplate().queryForObject("UserCategoryRelation.get",userCategoryRelation);
    }

    public void updateArticleNum(UserCategoryRelation userCategoryRelation){
        getSqlMapClientTemplate().update("UserCategoryRelation.updateArticleNum",userCategoryRelation);
    }

}
