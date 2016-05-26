package com.raycloud.util;

/**
 * Created by linjunjie on 2015/11/28 (linjunjie@raycloud.com).
 */
public class BooleanStatusResponse {

    Boolean status = false;

    public BooleanStatusResponse(Boolean status){
        this.status = status;
    }


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
