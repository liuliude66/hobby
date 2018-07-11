package com.forum.jobs.ui;

import com.forum.base.model.AccountModel;
import com.forum.base.presenter.ILoginPresenter;
import com.forum.base.ui.BaseActivity;
import com.forum.jobs.presenter.LoginPresenterImpl;
import com.forum.jobs.view.ILoginView;

/**
 * Created by DELL on 2018/7/10.
 */

public class LoginActivity extends BaseActivity implements ILoginView {

    ILoginPresenter mIBasePresenter;

    @Override
    protected int getResourceLayout() {
        return 0;
    }

    @Override
    protected void initView() {
        mIBasePresenter = new LoginPresenterImpl(this);
        AccountModel account = new AccountModel();
        mIBasePresenter.validateCredentials(account);
    }

    @Override
    public void setUsernameError() {

    }

    @Override
    public void setPasswordError() {

    }

    @Override
    public void showSuccess() {

    }
}
