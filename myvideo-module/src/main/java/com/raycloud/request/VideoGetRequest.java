package com.raycloud.request;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/6/3.
 */
public class VideoGetRequest extends RequestList {


    private static final long serialVersionUID = -1280287279508588757L;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
