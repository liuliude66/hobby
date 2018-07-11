package com.forum.jobs.model;

import android.os.Handler;
import android.text.TextUtils;

import com.forum.base.model.AccountModel;
import com.forum.base.model.BaseModel;
import com.forum.base.model.ILoginModelManager;
import com.forum.base.presenter.OnLoginFinishedListener;
import com.forum.base.utils.AccountHelper;
import com.forum.base.utils.LogUtils;
import com.forum.base.utils.ToastUtils;
import com.forum.jobs.service.ApiManagerService;
import com.forum.jobs.service.ApiRepository;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;

/**
 * Created by DELL on 2018/7/10.
 */

public class LoginModelManager implements ILoginModelManager {

    @Override
    public void login(AccountModel account, final OnLoginFinishedListener listener) {
        final String username = account.getUsername();
        final String password = account.getPassword();
        //TODO 执行网络请求登录
        /**ApiRepository.get().login(username, password)
         .subscribeOn(Schedulers.io())
         .unsubscribeOn(Schedulers.io())
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe(new DisposableSubscriber<BaseModel<AccountModel>>() {

        @Override public void onNext(BaseModel<AccountModel> baseModel) {
        LogUtils.error( "onNext--->code-->" + baseModel.code);
        LogUtils.error( "onNext--->msg-->" + baseModel.msg);
        }

        @Override public void onError(Throwable t) {
        LogUtils.error( "onError--->" + t.getMessage());
        }

        @Override public void onComplete() {
        LogUtils.debug( "onComplete--->");
        }
        });**/
        ApiRepository.get().getSessionId().flatMap(new Function<BaseModel<SessionModel>, Flowable<BaseModel<AccountModel>>>() {
            @Override
            public Flowable<BaseModel<AccountModel>> apply(BaseModel<SessionModel> baseModel) throws Exception {
                LogUtils.debug("apply--->" + baseModel.msg);
                if (baseModel.code == 0) {
                    AccountHelper.get().putSession(baseModel.data.sessionId);
                    return ApiRepository.get().login(username, password);
                } else {
                    throw new RuntimeException("返回结果异常");
                }
            }
        }).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new DisposableSubscriber<BaseModel<AccountModel>>() {
            @Override
            public void onNext(BaseModel<AccountModel> baseModel) {
                LogUtils.debug("onNext--->" + baseModel.code);
                LogUtils.debug("onNext--->" + baseModel.msg);
            }

            @Override
            public void onError(Throwable t) {
                LogUtils.debug("onError--->" + t.getMessage());
            }

            @Override
            public void onComplete() {
                LogUtils.debug("onComplete--->");
            }
        });
    }
}
