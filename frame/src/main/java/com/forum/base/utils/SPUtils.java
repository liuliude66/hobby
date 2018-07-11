package com.forum.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;

import java.util.Set;

/**
 * SharedPreferences工具类
 */

public class SPUtils {

    private static SharedPreferences sPreferences;

    public static void init(Context context) {
        sPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void putStringSet(String key, @Nullable Set<String> value) {
        sPreferences.edit().putStringSet(key, value).apply();
    }

    public static Set<String> getStringSet(String key, @Nullable Set<String> defValue) {
        return sPreferences.getStringSet(key, defValue);
    }

    public static void putString(String key, @Nullable String value) {
        sPreferences.edit().putString(key, value).apply();
    }

    public static String getString(String key, @Nullable String defValue) {
        return sPreferences.getString(key, defValue);
    }

    public static void putBoolean(String key, boolean value) {
        sPreferences.edit().putBoolean(key, value).apply();
    }

    public static boolean getBoolean(String key, boolean defValue) {
        return sPreferences.getBoolean(key, defValue);
    }

    public static void putLong(String key, long value) {
        sPreferences.edit().putLong(key, value).apply();
    }

    public static long getLong(String key, long defValue) {
        return sPreferences.getLong(key, defValue);
    }

    public static void remove(String key) {
        sPreferences.edit().remove(key).apply();
    }

}
