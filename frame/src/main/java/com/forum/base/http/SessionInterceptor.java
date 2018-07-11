package com.forum.base.http;

import com.forum.base.BuildConfig;
import com.forum.base.utils.AccountHelper;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Administrator
 * @date 2018\3\26 0026
 * 描述：请求头过滤器
 */

public class SessionInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder()
                .addHeader("content-type", "application/json;charset:utf-8")
                .addHeader("user-agent", getUserAgent())
                .addHeader("x-requested-with", AccountHelper.get().getIMEI())
                .addHeader("sessionid", AccountHelper.get().getSession())
                .addHeader("client-version", BuildConfig.VERSION_NAME);
        return chain.proceed(builder.build());
    }

    /**
     * 解决 java.lang.IllegalArgumentException: Unexpected char 0x7231 at 33 in User-Agent value
     * 中文字符问题, 在一些国产手机上面这个User-Agent里面会包含中文，就会报错
     */
    private static String getUserAgent() {
        String userAgent = "SSC/" + BuildConfig.VERSION_NAME + " (Android; " + android.os.Build.MODEL + "-" + android.os.Build.VERSION.RELEASE + ")";
        StringBuilder sb = new StringBuilder();
        for (int i = 0, length = userAgent.length(); i < length; i++) {
            char c = userAgent.charAt(i);
            boolean invalid = (c <= '\u001f' && c != '\t') || c >= '\u007f';
            if (invalid) {
                sb.append(String.format("\\u%04x", (int) c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
