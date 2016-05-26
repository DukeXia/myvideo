package com.raycloud.pojo;

import com.raycloud.pojo.common.BasePojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/5/16.
 */
public class Category extends BasePojo implements Serializable {

    private static final long serialVersionUID = -7039556810192227968L;

    private Long id;

    private String name;

    private Date created;

    private Date modified;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
