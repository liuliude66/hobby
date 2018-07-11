package com.forum.base.http;

import com.forum.base.BuildConfig;
import com.forum.base.utils.ProductFlavorsHelper;
import com.forum.base.utils.SSLSocketUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DELL on 2018/7/11.
 */

public class RetrofitFactory {

    private OkHttpClient mOkHttpClient;
    private Gson mGson;

    private RetrofitFactory() {
        //网络请求日志过滤
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        }
        //初始化OkHttpClient
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(BaseConstants.REQUEST_TIME_OUT_SECOND, TimeUnit.SECONDS)
                .writeTimeout(BaseConstants.REQUEST_TIME_OUT_SECOND, TimeUnit.SECONDS)
                .readTimeout(BaseConstants.REQUEST_TIME_OUT_SECOND, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new SessionInterceptor())
                .retryOnConnectionFailure(true)
                .sslSocketFactory(SSLSocketUtil.getSSLSocketFactory())
                .hostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                }).build();
        mGson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
    }

    private static class SingletonHolder {
        static RetrofitFactory instance = new RetrofitFactory();
    }

    public static RetrofitFactory get() {
        return SingletonHolder.instance;
    }

    /**
     * @param isVisitor 是否是试玩状态
     * @return ApiStore实例
     */
    public <T> T create(boolean isVisitor, Class<T> service) {
        Retrofit retrofit = new Retrofit.Builder()
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(isVisitor ? ProductFlavorsHelper.get().getVisitorDomain() : ProductFlavorsHelper.get().getOfficialDomain())
                .build();
        return retrofit.create(service);
    }
}
