package com.forum.jobs.req;

/**
 * Created by DELL on 2018/7/11.
 */

public class LoginReq {
    //用户账户（4位-16位数字或字母）
    public String account;
    //密码
    public String password;

    public LoginReq(String account, String password) {
        this.account = account;
        this.password = password;
    }
}
