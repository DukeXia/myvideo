package com.raycloud.response;

import com.raycloud.request.Request;

/**
 * Created by linjunjie on 2015/11/28 (linjunjie@raycloud.com).
 */
public class Response {
    //参照raycloud规范来写

    private String api_name = "";

    private String result = "100"; //100表示成功，其他表示失败

    private String message = "";//信息

    private Object data;//业务数据

    public Response(Request request){
        this.api_name = request.getApi_name();
    }

    public Response(){

    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getApi_name() {
        return api_name;
    }

    public void setApi_name(String api_name) {
        this.api_name = api_name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
