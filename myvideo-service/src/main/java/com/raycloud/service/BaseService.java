package com.raycloud.service;

import com.raycloud.dao.UserDao;
import com.raycloud.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/2/2.
 */
public class BaseService {

    @Autowired
    private UserDao userDao;

    protected final Logger logger = Logger.getLogger(this.getClass());

    public User getUser(String username){
        User user = new User();
        user.setUsername(username);
        return userDao.get(user);
    }
}
