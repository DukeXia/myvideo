package com.raycloud.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.raycloud.constant.ResponseResultConstant;
import com.raycloud.constant.UserConstant;
import com.raycloud.dao.UserDao;
import com.raycloud.exception.InvalidSessionException;
import com.raycloud.exception.ServiceException;
import com.raycloud.pojo.User;
import com.raycloud.request.UserLoginRequest;
import com.raycloud.request.UserRegisterRequest;
import com.raycloud.response.ViewUserLoginInfo;
import com.raycloud.session.Session;
import com.raycloud.util.DataBaseUtil;
import com.raycloud.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Random;

/**
 * Created by linjunjie on 2016/1/25 (linjunjie@raycloud.com).
 */
@Service("userService")
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private Session session;

    /**
     * 添加用户
     *
     * @throws com.raycloud.exception.ServiceException
     */
    public void addUser(User user) throws ServiceException {
        //userDao.addUser(user);
        System.out.println("addUser Service方法" + userDao);
    }

    /**
     * 用户登陆
     * @throws ServiceException
     */
    public ViewUserLoginInfo login(UserLoginRequest request,HttpServletRequest httpRequest,
                      HttpServletResponse httpResponse) throws ServiceException{
        User user = new User();
        user.setUsername(request.getUsername());
        if((user = userDao.get(user)) != null){
            if(!MD5Utils.toHexString(MD5Utils.encodeByMD5(request.getPassword().getBytes())).equals(user.getPassword())){
                throw new ServiceException(request.getUsername()+"密码错误!", ResponseResultConstant.USER_PASSWORD_ERROR);
            }
            //添加新的路由规则
            if(user.getDbConfig().getUserCategoryRelationDbId() == null){
                user.getDbConfig().setUserCategoryRelationDbId(DataBaseUtil.getDBId(user.getId(),User.DbConfig.USER_CATEGORY_RELATION_NUM));
                //更新路由规则
                user.setConfigRule(JSONObject.toJSONString(user.getDbConfig()));
                User updateConfigUser = new User();
                updateConfigUser.setId(user.getId());
                updateConfigUser.setConfigRule(user.getConfigRule());
                userDao.update(updateConfigUser);
            }
            try {
                session.setAttribute(httpRequest,httpResponse, UserConstant.USER_INFO_KEY,user);
            } catch (InvalidSessionException e) {
                e.printStackTrace();
                return null;
            }
            httpRequest.getSession().setAttribute("nick",user.getUsername());
            ViewUserLoginInfo viewUserLoginInfo = new ViewUserLoginInfo();
            viewUserLoginInfo.setUsername(user.getUsername());
            return viewUserLoginInfo;
        }
        return null;
    }

    /**
     * 判断是否能注册
     * @return
     */
    public boolean canRegister(String username)throws ServiceException{
        User user = new User();
        user.setUsername(username);
        if((user = userDao.get(user))==null){
            return true;
        }
        return false;
    }

    @Transactional(rollbackFor = ServiceException.class,propagation = Propagation.REQUIRED)
    public void register(UserRegisterRequest request,HttpServletRequest httpRequest)throws ServiceException{
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(MD5Utils.toHexString(MD5Utils.encodeByMD5(request.getPassword().getBytes())));
        user.setNick(request.getNick());
        user.setHeadPhotoUrl("/resources/img/img"+ (int)(Math.random()*3+1)+".png");
        user.setAddress(request.getAddress());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        //user.setConfigRule(JSONObject.toJSONString(new User.DbConfig()));
        user.setCreated(new Date());
        user.setStatus(1);
        try {
            userDao.addUser(user);
            user.setConfigRule(JSONObject.toJSONString(new User.DbConfig(user.getId())));
            userDao.update(user);
            httpRequest.getSession().setAttribute("nick", user.getUsername());
            httpRequest.getSession().setAttribute(UserConstant.USER_INFO_KEY,user);
        }catch(Exception e){
            throw new ServiceException("创建用户失败",ResponseResultConstant.USER_NOT_EXISTS,e);
        }
    }

}
