package com.forum.base.utils;

import android.text.TextUtils;

import com.alibaba.android.arouter.launcher.ARouter;
import com.forum.base.http.BaseConstants;
import com.forum.base.http.Callable;
import com.forum.base.model.AccountModel;

/**
 * Created by Administrator on 2018\4\3 0003.
 * 描述：
 */

public class AccountHelper {

    private String imei;
    private AccountModel mUser;


    private AccountHelper() {
        imei = DeviceUtils.getIMEI(ProductFlavorsHelper.get().getApplication());
    }

    private static class SingletonHolder {

        static AccountHelper INSTANCE = new AccountHelper();
    }

    public static AccountHelper get() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * @return IMEI码
     */
    public String getIMEI() {
        return imei;
    }

    /**
     * @return 是否已登录
     */
    public boolean isLogin() {
        return !TextUtils.isEmpty(getSession()) && getUser() != null;
    }

    public void setIsVisitorAccount(boolean isVisitor) {
        MemoryCacheUtil.getInstance().put(BaseConstants.KEY_IS_VISITOR_ACCOUNT, isVisitor);
    }

    /**
     * @return 是否试玩(游客)账号
     * 是否游客账号 的判定值 直接保存在内存Memory中不存到 SharedPreference中
     * 便于每次试玩退出应用后 清除掉试玩状态 下次进入时继续提示用户登录
     */
    public boolean isVisitorAccount() {
        Object memory = MemoryCacheUtil.getInstance().get(BaseConstants.KEY_IS_VISITOR_ACCOUNT);
        return memory != null && (boolean) memory;
    }

    public void putSession(String session) {
        MemoryCacheUtil.getInstance().put(BaseConstants.KEY_SESSION_ID, session);
        if (!isVisitorAccount()) {
            SPUtils.putString(BaseConstants.KEY_SESSION_ID, session);
        } else {
            SPUtils.putString(BaseConstants.KEY_SESSION_ID, "");
        }
    }

    public String getSession() {
        String session = (String) MemoryCacheUtil.getInstance().get(BaseConstants.KEY_SESSION_ID);
        if (TextUtils.isEmpty(session)) {
            session = SPUtils.getString(BaseConstants.KEY_SESSION_ID, "");
        }
        return session;
    }

    /**
     * 登录后执行
     */
    public void afterLogin(Callable callable) {
        if (isLogin()) {
            callable.call();
        } else {
            //跳转到登录页面
            ToastUtils.showToast("尚未登录，请您前去登录");
            ARouter.getInstance().build(RouterPath.PATH_LOGIN).navigation();
        }
    }

    public void saveUser(AccountModel user) {
        mUser = user;
        if (!isVisitorAccount()) {
            SPUtils.putString(BaseConstants.KEY_USER_INFO, JsonUtil.toJson(user));
        } else {
            SPUtils.putString(BaseConstants.KEY_USER_INFO, null);
        }
    }

    public AccountModel getUser() {
        if (mUser == null) {
            //如果内存没有, 在从SharedPreference中拿
            mUser = JsonUtil.fromJson(SPUtils.getString(BaseConstants.KEY_USER_INFO, null), AccountModel.class);
        }
        return mUser;
    }

    public String getUsername() {
        AccountModel user = getUser();
        return user == null ? "" : user.getUsername();
    }

    /*public void setBalance(double balance) {
        UserModel user = getUser();
        if (user != null) {
            user.balance = balance;
        }
    }

    public double getBalance() {
        UserModel user = getUser();
        return user == null ? 0 : user.balance;
    }*/

    /**
     * 正式账号登录后执行
     */
    public void afterPaidAccountLogin(Callable callable) {
        if (!isLogin()) {
            //跳转到登录页面
            ARouter.getInstance().build(RouterPath.PATH_LOGIN).navigation();
            ToastUtils.showToast("尚未登录，请您前去登录");
        } else if (isVisitorAccount()) {
            //提示用户 需要登录正式账号
            ToastUtils.showToast("请登录正式账号!");
        } else {
            callable.call();
        }
    }

    /**
     * 退出登录
     */
    public void reset() {
        putSession("");
        setIsVisitorAccount(false);
        saveUser(null);
        SPUtils.getString(BaseConstants.KEY_SP_PASSWORD, "");
    }
}
