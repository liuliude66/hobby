package com.forum.base.model;

import android.os.Handler;
import android.text.TextUtils;

import com.forum.base.presenter.OnLoginFinishedListener;

/**
 * Created by DELL on 2018/7/10.
 */

public class LoginModelManager implements ILoginModelManager {

    @Override
    public void login(AccountModel account, final OnLoginFinishedListener listener) {
        final String username = account.getUsername();
        final String password = account.getPassword();
        //TODO 执行网络请求登录


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if (TextUtils.isEmpty(username)) {
                    listener.onUsernameError();//model层里面回调listener
                    error = true;
                }
                if (TextUtils.isEmpty(password)) {
                    listener.onPasswordError();
                    error = true;
                }
                if (!error) {
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
