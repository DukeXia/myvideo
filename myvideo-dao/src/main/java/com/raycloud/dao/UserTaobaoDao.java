package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.pojo.UserTaobao;
import org.springframework.stereotype.Repository;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/2/2.
 */
@Repository
public class UserTaobaoDao extends BaseDao {

    public void addUser(UserTaobao user){
        getSqlMapClientTemplate().insert("userTaobao.addUserTaobao",user);
    }


}
