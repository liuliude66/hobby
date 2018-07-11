package com.forum.jobs.service;

import com.forum.base.model.AccountModel;
import com.forum.base.model.BaseModel;
import com.forum.jobs.model.SessionModel;
import com.forum.jobs.req.LoginReq;

import io.reactivex.Flowable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by DELL on 2018/7/11.
 */

public interface ApiManagerService {

    @POST("passport/distribute_sessionid.do")
    Flowable<BaseModel<SessionModel>> getSessionId();

    @POST("/account/login.do")
    Flowable<BaseModel<AccountModel>> login(@Body LoginReq req);

}
