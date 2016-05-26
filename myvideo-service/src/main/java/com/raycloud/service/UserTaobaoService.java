package com.raycloud.service;

import com.raycloud.exception.ServiceException;
import com.raycloud.pojo.UserTaobao;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/2/2.
 */
public interface UserTaobaoService {



    public void addUser(UserTaobao user)throws ServiceException;

}
