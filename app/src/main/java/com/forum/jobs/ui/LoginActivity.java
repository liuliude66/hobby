package com.forum.jobs.ui;

import android.view.View;

import com.forum.base.model.AccountModel;
import com.forum.base.presenter.ILoginPresenter;
import com.forum.base.ui.BaseActivity;
import com.forum.jobs.R;
import com.forum.jobs.presenter.LoginPresenterImpl;
import com.forum.jobs.view.ILoginView;

/**
 * Created by DELL on 2018/7/10.
 */

public class LoginActivity extends BaseActivity implements ILoginView {

    ILoginPresenter mIBasePresenter;

    @Override
    protected int getResourceLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        mIBasePresenter = new LoginPresenterImpl(this);
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountModel account = new AccountModel();
                account.setUsername("lilei001");
                account.setPassword("123456");
                mIBasePresenter.validateCredentials(account);
            }
        });
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
