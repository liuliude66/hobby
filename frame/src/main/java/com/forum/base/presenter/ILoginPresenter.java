package com.forum.base.presenter;

import com.forum.base.model.AccountModel;

/**
 * Created by DELL on 2018/7/10.
 */

public interface ILoginPresenter {
    void validateCredentials(AccountModel account);
}
