package com.forum.base.utils;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;


/**
 * Created by Administrator on 2018\4\10 0010.
 * 描述：
 */

public class ToastUtils {

    private static Toast mToast;
    private static Handler mHandler = new Handler(Looper.getMainLooper());

    public static void showToast(CharSequence message) {
        show(message, Toast.LENGTH_SHORT);
    }

    public static void showToast(CharSequence message, int duration) {
        show(message, duration);
    }

    /**
     * 主线程中调用系统Toast方法
     *
     * @param message  显示文本
     * @param duration 显示时长
     */
    private static void show(final CharSequence message, final int duration) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (mToast == null) {
                    mToast = Toast.makeText(ProductFlavorsHelper.get().getApplication(), message, duration);
                    mToast.show();
                } else {
                    mToast.setText(message);
                    mToast.show();
                }
            }
        });
    }
}
