package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.pojo.Board;
import com.raycloud.pojo.SubBoard;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/10.
 */
@Repository
public class SubBoardDao extends BaseDao{

    public void insert(SubBoard subBoard){
        getSqlMapClientTemplate().insert("SubBoard.insert",subBoard);
    }

    public List<SubBoard> getList(SubBoard subBoard){

        return getSqlMapClientTemplate().queryForList("SubBoard.getList",subBoard);
    }

    public SubBoard get(){

        return null;
    }

    public Integer delete(){

        return null;
    }

}
