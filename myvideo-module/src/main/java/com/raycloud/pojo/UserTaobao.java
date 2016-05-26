package com.raycloud.pojo;

import java.util.Date;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/2/2.
 */
public class UserTaobao {

    private Long id;

    private Long taobao_id;

    private String taobao_nick;

    private String session_id;

    private String is_vip;

    private Long shop_id;

    private String shop_type;

    private String db_config;

    private Date modified;

    private Date created;

    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTaobao_id() {
        return taobao_id;
    }

    public void setTaobao_id(Long taobao_id) {
        this.taobao_id = taobao_id;
    }

    public String getTaobao_nick() {
        return taobao_nick;
    }

    public void setTaobao_nick(String taobao_nick) {
        this.taobao_nick = taobao_nick;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getIs_vip() {
        return is_vip;
    }

    public void setIs_vip(String is_vip) {
        this.is_vip = is_vip;
    }

    public Long getShop_id() {
        return shop_id;
    }

    public void setShop_id(Long shop_id) {
        this.shop_id = shop_id;
    }

    public String getShop_type() {
        return shop_type;
    }

    public void setShop_type(String shop_type) {
        this.shop_type = shop_type;
    }

    public String getDb_config() {
        return db_config;
    }

    public void setDb_config(String db_config) {
        this.db_config = db_config;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
