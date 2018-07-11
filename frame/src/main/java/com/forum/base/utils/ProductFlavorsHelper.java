package com.forum.base.utils;

import android.app.Application;
import android.text.TextUtils;

import com.forum.base.http.BaseConstants;

/**
 * Created by Administrator on 2018\4\17 0017.
 * 描述：
 */

public class ProductFlavorsHelper {

    private volatile String officialDomain = "";
    private volatile String visitorDomain = "";
    private Application mApplication;

    private ProductFlavorsHelper() {

    }

    private static class SingletonHolder {
        static ProductFlavorsHelper INSTANCE = new ProductFlavorsHelper();
    }

    public static ProductFlavorsHelper get() {
        return SingletonHolder.INSTANCE;
    }

    public void setBaseUrl(String officialDomain, String visitorDomain) {
        this.officialDomain = officialDomain;
        this.visitorDomain = visitorDomain;
        SPUtils.putString(BaseConstants.KEY_NORMAL_DOMAIN, officialDomain);
        SPUtils.putString(BaseConstants.KEY_UNNORMAL_DOMAIN, visitorDomain);
    }

    public String getOfficialDomain() {
        if (TextUtils.isEmpty(officialDomain)) {
            officialDomain = SPUtils.getString(BaseConstants.KEY_NORMAL_DOMAIN, "");
        }
        return officialDomain;
    }

    public String getVisitorDomain() {
        if (TextUtils.isEmpty(visitorDomain)) {
            visitorDomain = SPUtils.getString(BaseConstants.KEY_UNNORMAL_DOMAIN, "");
        }
        return visitorDomain;
    }

    public Application getApplication() {
        return mApplication;
    }

    public void setApplication(Application application) {
        this.mApplication = application;
    }
}
