package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by linjunjie on 2016/1/5 (linjunjie@raycloud.com).
 */
@Repository
public class UserDao extends BaseDao{


    public List<User> getUserList(User user){
        return getSqlMapClientTemplate().queryForList("User.getUserList",user);
    }

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user){
        getSqlMapClientTemplate().insert("User.addUser",user);
    }

    /**
     * 获取用户
     * @param user
     * @return
     */
    public User get(User user){
        return (User)getSqlMapClientTemplate().queryForObject("User.get",user);
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    public Integer update(User user){
        return  getSqlMapClientTemplate().update("User.update",user);
    }

}
