package com.raycloud.dao;

import com.raycloud.dao.common.BaseDao;
import com.raycloud.pojo.Article;
import com.raycloud.pojo.Board;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/10.
 */
@Repository
public class BoardDao extends BaseDao{

    public void insert(Board board){
        getSqlMapClientTemplate().insert("Board.insert",board);
    }

    public List<Board> getList(Board board){

        return getSqlMapClientTemplate().queryForList("Board.getList",board);
    }

    public Integer getCount(Board board){

        return  (Integer)getSqlMapClientTemplate().queryForObject("Board.getCount",board);
    }

    public Board get(){

        return null;
    }

    public Integer delete(){

        return null;
    }

}
