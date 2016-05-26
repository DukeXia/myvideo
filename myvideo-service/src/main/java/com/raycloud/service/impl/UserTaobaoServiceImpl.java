package com.raycloud.service.impl;

import com.raycloud.dao.UserTaobaoDao;
import com.raycloud.exception.ServiceException;
import com.raycloud.pojo.UserTaobao;
import com.raycloud.service.BaseService;
import com.raycloud.service.UserTaobaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/2/2.
 */
@Service("userTaobaoService")
public class UserTaobaoServiceImpl extends BaseService implements UserTaobaoService {


    @Autowired
    private UserTaobaoDao userTaobaoDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addUser(UserTaobao user) throws ServiceException {
        userTaobaoDao.addUser(user);
    }


}
