package com.forum.base.presenter;

/**
 * 用户登录后的返回监听器 2018/7/10.
 */

public interface OnLoginFinishedListener {
    void onUsernameError();
    void onPasswordError();
    void onSuccess();
}
