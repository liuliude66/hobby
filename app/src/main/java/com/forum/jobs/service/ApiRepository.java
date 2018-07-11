package com.forum.jobs.service;

import android.accounts.Account;

import com.forum.base.http.RetrofitFactory;
import com.forum.base.model.AccountModel;
import com.forum.base.model.BaseModel;
import com.forum.base.utils.AccountHelper;
import com.forum.jobs.model.SessionModel;
import com.forum.jobs.req.LoginReq;

import io.reactivex.Flowable;

/**
 * Created by DELL on 2018/7/11.
 */

public class ApiRepository {

    private ApiRepository() {
    }

    private static class SingletonHolder {
        static ApiRepository INSTANCE = new ApiRepository();
    }

    public static ApiRepository get() {
        return SingletonHolder.INSTANCE;
    }

    private ApiManagerService getApiService() {
        return RetrofitFactory.get().create(AccountHelper.get().isVisitorAccount(), ApiManagerService.class);
    }

    /**
     * 请求sessionId
     */
    public Flowable<BaseModel<SessionModel>> getSessionId() {
        return getApiService().getSessionId();
    }

    /**
     * 登录
     *
     * @param account  用户账户（4位-16位数字或字母）
     * @param password 密码(6位-12位数字或字母)
     */
    public Flowable<BaseModel<AccountModel>> login(String account, String password) {
        return getApiService().login(new LoginReq(account, password));
    }
}
