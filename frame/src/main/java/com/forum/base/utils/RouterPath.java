package com.forum.base.utils;

/**
 * Created by Administrator on 2018\4\3 0003.
 * 描述：模块路由 路径定义
 */

public interface RouterPath {
    /**
     * 登录
     */
    String PATH_LOGIN = "/wwc/login";
    /**
     * 注册
     */
    String PATH_REGISTER = "/wwc/register";
    /**
     * 充值
     */
    String PATH_RECHARGE = "/wwc/recharge";
    /**
     * 刷新余额
     */
    String REFRESH_BALANCE = "/wwc/refreshBalance";
    /**
     * 首页
     */
    String PATH_MAIN = "/wwc/homePage";
    /**
     * 用户服务协议
     */
    String PATH_USER_AGREEMENT = "/wwc/agreement";
}
