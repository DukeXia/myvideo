package com.raycloud.request;

import java.util.Date;

/**
 * Created by linjunjie(490456661@qq.com) on 2016/4/28.
 */
public class UserLoginRequest extends Request {

    private String username;

    private String password;

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
}
