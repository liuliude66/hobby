package com.forum.base.view;

/**
 * Created by DELL on 2018/7/10.
 */

public interface IBaseView {
    //login是个耗时操作，我们需要给用户一个友好的提示，一般就是操作ProgressBar
    void showProgress();

    void hideProgress();
}
