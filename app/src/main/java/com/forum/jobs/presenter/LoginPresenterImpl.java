package com.forum.jobs.presenter;

import com.forum.base.model.AccountModel;
import com.forum.base.model.ILoginModelManager;
import com.forum.base.model.LoginModelManager;
import com.forum.base.presenter.ILoginPresenter;
import com.forum.base.presenter.OnLoginFinishedListener;
import com.forum.jobs.view.ILoginView;

/**
 * 登录处理器接口实现 on 2018/7/10.
 */

public class LoginPresenterImpl implements ILoginPresenter, OnLoginFinishedListener {

    private ILoginView loginView;
    private ILoginModelManager loginModel;

    public LoginPresenterImpl(ILoginView loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModelManager();
    }

    @Override
    public void validateCredentials(AccountModel account) {
        if (loginView != null) {
            loginView.showProgress();
        }
        loginModel.login(account, this);
    }

    @Override
    public void onUsernameError() {
        if (loginView != null) {
            loginView.setUsernameError();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null) {
            loginView.showSuccess();
        }
    }
}
