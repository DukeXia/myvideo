package com.raycloud.dao.common;

import com.alibaba.cobar.client.CobarSqlMapClientDaoSupport;
import com.alibaba.cobar.client.CobarSqlMapClientTemplate;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by linjunjie on 2015/12/1 (linjunjie@raycloud.com).
 */
public class BaseDao extends CobarSqlMapClientDaoSupport /*extends SqlMapClientDaoSupport */{


    @Autowired
    public void setSqlMapClientForAutowired(SqlMapClient sqlMapClient){
        super.setSqlMapClient(sqlMapClient);
    }

    @Autowired
    @Qualifier("sqlMapClientTemplate")
    private CobarSqlMapClientTemplate cobarSqlMapClientTemplate ;

    //@Autowired
    private SqlMapClientTemplate sqlMapClientTemplate;

    @PostConstruct
    public void initSqlMapClient() {
//        super.setSqlMapClient(sqlMapClient);
        //注入cobar的template
        super.setSqlMapClientTemplate( cobarSqlMapClientTemplate );
        //注入普通的sqlTemplate
        //super.setSqlMapClientTemplate(sqlMapClientTemplate);
    }


    private final static int BATCH_SIZE = 1000;

    /**
     * 批量增
     * statement: xx-sqlmap.xml中sql的id
     * list,插入的集合
     * @param statement
     * @param list
     */
    public void addBatch(final String statement,final List list) throws SQLException{
        if(!CollectionUtils.isEmpty(list)){
            getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {
                @Override
                public Object doInSqlMapClient(SqlMapExecutor sqlMapExecutor) throws SQLException {
                    sqlMapExecutor.startBatch();
                    for(int i=0,len=list.size();i<len;i++){
                        sqlMapExecutor.insert(statement,list.get(i));
                        if(i!=0&&i%BATCH_SIZE==0){
                            sqlMapExecutor.executeBatch();
                        }
                    }
                    sqlMapExecutor.executeBatch();
                    return null;
                }
            });
        }
    }

    /**
     * 批量删除
     * @param statement
     * @param list
     * @throws java.sql.SQLException
     */
    public void deleteBatch(final String statement,final List list) throws SQLException{
        if(!CollectionUtils.isEmpty(list)){
            getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {
                @Override
                public Object doInSqlMapClient(SqlMapExecutor sqlMapExecutor) throws SQLException {
                    sqlMapExecutor.startBatch();
                    for(int i=0,len=list.size();i<len;i++){
                        sqlMapExecutor.delete(statement,list.get(i));
                        if(i!=0&&i%BATCH_SIZE==0){
                            sqlMapExecutor.executeBatch();
                        }
                    }
                    sqlMapExecutor.executeBatch();
                    return null;
                }
            });
        }
    }

    /**
     * 批量更新
     * @param statement
     * @param list
     * @throws java.sql.SQLException
     */
    public void updateBatch(final String statement,final List list) throws SQLException{
        if(!CollectionUtils.isEmpty(list)){
            getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {
                @Override
                public Object doInSqlMapClient(SqlMapExecutor sqlMapExecutor) throws SQLException {
                    sqlMapExecutor.startBatch();
                    for(int i=0,len=list.size();i<len;i++){
                        sqlMapExecutor.update(statement, list.get(i));
                        if(i!=0&&i%BATCH_SIZE==0){
                            sqlMapExecutor.executeBatch();
                        }
                    }
                    sqlMapExecutor.executeBatch();
                    return null;
                }
            });
        }
    }

    public CobarSqlMapClientTemplate getCobarSqlMapClientTemplate() {
        return cobarSqlMapClientTemplate;
    }

    public void setCobarSqlMapClientTemplate(CobarSqlMapClientTemplate cobarSqlMapClientTemplate) {
        this.cobarSqlMapClientTemplate = cobarSqlMapClientTemplate;
    }
}
