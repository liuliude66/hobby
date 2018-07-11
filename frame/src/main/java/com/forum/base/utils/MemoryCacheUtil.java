package com.forum.base.utils;

import android.support.v4.util.LruCache;

/**
 * Created by Administrator on 2018\4\5 0005.
 * 描述：一些保存在
 */

public class MemoryCacheUtil {

    private LruCache<String, Object> mMemoryCache;

    private MemoryCacheUtil() {
        long maxSize = Runtime.getRuntime().maxMemory() / 1024 / 8;
        mMemoryCache = new LruCache<>((int) maxSize);
    }

    private static class SingletonHolder {
        static MemoryCacheUtil INSTANCE = new MemoryCacheUtil();
    }

    public static MemoryCacheUtil getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void put(String key, Object value) {
        mMemoryCache.put(key, value);
    }

    public Object get(String key) {
        return mMemoryCache.get(key);
    }
}
