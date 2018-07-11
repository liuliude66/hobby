package com.forum.jobs.view;

import com.forum.base.view.IBaseView;

/**
 * 登录界面的接口 on 2018/7/10.
 */

public interface ILoginView extends IBaseView {

    //login当然存在登录成功与失败的处理，失败给出提示
    void setUsernameError();

    void setPasswordError();

    //login成功，也给个提示
    void showSuccess();
}
