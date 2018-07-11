package com.forum.base.utils;

import android.util.Log;

import com.forum.base.BuildConfig;

/**
 * Created by DELL on 2018/7/11.
 */

public class LogUtils {

    private final static String TAG = "LogUtils";

    public static void debug(String message) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, message);
        }
    }

    public static void error(String message) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, message);
        }
    }

    public static void warn(String message) {
        if (BuildConfig.DEBUG) {
            Log.w(TAG, message);
        }
    }

    public static void info(String message) {
        if (BuildConfig.DEBUG) {
            Log.i(TAG, message);
        }
    }
}
