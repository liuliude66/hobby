package com.forum.jobs.req;

/**
 * Created by DELL on 2018/7/11.
 */

public class LoginReq {
    //用户账户（4位-16位数字或字母）
    public String username;
    //密码
    public String password;

    public LoginReq(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
