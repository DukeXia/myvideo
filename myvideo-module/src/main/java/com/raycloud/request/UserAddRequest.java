package com.raycloud.request;

import java.util.Date;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/2/2.
 */
public class UserAddRequest extends Request {

    private Long id;

    private Long taobao_id;

    private String taobao_nick;

    private String session_id;

    private Date created;

    private Date modified;

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
}
