package com.forum.base.model;

import com.forum.base.presenter.OnLoginFinishedListener;

/**
 * Created by DELL on 2018/7/10.
 */

public interface ILoginModelManager {
    void login(AccountModel account, OnLoginFinishedListener listener);
}
