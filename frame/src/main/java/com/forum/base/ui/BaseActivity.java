package com.forum.base.ui;

import android.app.Activity;
import android.os.Bundle;

import com.forum.base.view.IBaseView;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;

/**
 * 基础库 on 2018/7/10.
 */

public abstract class BaseActivity extends RxFragmentActivity implements IBaseView {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResourceLayout());
        initView();
    }

    //获取当前加载的layout-id
    protected abstract int getResourceLayout();

    //初始化当前view控件
    protected abstract void initView();

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
