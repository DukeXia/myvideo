package com.raycloud.pojo;

import com.alibaba.fastjson.JSONObject;
import com.raycloud.pojo.common.BasePojo;
import com.raycloud.util.DataBaseUtil;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户信息表
 * Created by linjunjie on 2016/1/5 (linjunjie@raycloud.com).
 */
public class User extends BasePojo implements Serializable {

    private static final long serialVersionUID = -4073824498623601471L;
    /**
     * 自增ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 分表的路由信息,有DBConfig这个类转成json字符串，存储在这个字段
     * 比如：{"activityDBId":1}
     *
     */
    private String configRule;

    private DbConfig dbConfig;
    private String nick;
    private String headPhotoUrl;
    private String birthday;
    private String address;
    private String sex;
    private String phone;
    private String email;
    private Date created;
    private Date modified;
    private Integer status;


    /**
     * 是否根据id排序
     * @param isAsc
     * @return
     */
    public User orderById(boolean isAsc){
        orderFields.add(new OrderField("id",isAsc?"ASC":"DESC"));
        return this;
    }

    public User orderByUsername(boolean isAsc){
        orderFields.add(new OrderField("username",isAsc?"ASC":"DESC"));
        return this;
    }

    public User orderByPassword(boolean isAsc){
        orderFields.add(new OrderField("password",isAsc?"ASC":"DESC"));
        return this;
    }
    /**====================结束**/

    public static class DbConfig{
        public static final int ARTICLE_NUM = 5;
        public static final int USER_CATEGORY_RELATION_NUM = 5;
        private Integer articleDbId;
        private Integer userCategoryRelationDbId;
        public DbConfig(){

        }
        public DbConfig(Long id){
            this.articleDbId = DataBaseUtil.getDBId(id, ARTICLE_NUM);
            this.userCategoryRelationDbId = DataBaseUtil.getDBId(id, USER_CATEGORY_RELATION_NUM);
        }

        public Integer getArticleDbId() {
            return articleDbId;
        }

        public void setArticleDbId(Integer articleDbId) {
            this.articleDbId = articleDbId;
        }

        public Integer getUserCategoryRelationDbId() {
            return userCategoryRelationDbId;
        }

        public void setUserCategoryRelationDbId(Integer userCategoryRelationDbId) {
            this.userCategoryRelationDbId = userCategoryRelationDbId;
        }
    }

    public static void main(String args[]){
        String db = "{\"articleDbId\":2}";
        DbConfig dbConfig1 = JSONObject.parseObject(db, DbConfig.class);
        System.out.println(dbConfig1.getArticleDbId());
    }

    public List<Long> getKeys() {
        return keys;
    }

    public void setKeys(List<Long> keys) {
        this.keys = keys;
    }

    public List<OrderField> getOrderFields() {
        return orderFields;
    }

    public void setOrderFields(List<OrderField> orderFields) {
        this.orderFields = orderFields;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getConfigRule() {
        return configRule;
    }

    public void setConfigRule(String configRule) {
        this.configRule = configRule;
    }

    public DbConfig getDbConfig() {
        if(dbConfig == null){
            synchronized (DbConfig.class){
                if(dbConfig == null && StringUtils.isNotBlank(configRule)){
                    dbConfig = JSONObject.parseObject(configRule,DbConfig.class);
                }
            }
        }
        return dbConfig;
    }

    public void setDbConfig(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getHeadPhotoUrl() {
        return headPhotoUrl;
    }

    public void setHeadPhotoUrl(String headPhotoUrl) {
        this.headPhotoUrl = headPhotoUrl;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
