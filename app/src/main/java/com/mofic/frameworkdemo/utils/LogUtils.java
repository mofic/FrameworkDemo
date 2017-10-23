package com.mofic.frameworkdemo.utils;

import com.mofic.frameworkdemo.BuildConfig;
import com.mofic.frameworkdemo.app.Constants;
import com.orhanobut.logger.Logger;

/**
 * @author lanweining
 * @date 2017/10/22
 */

public class LogUtils {

    private static boolean isDebug = BuildConfig.DEBUG;
    private static final String TAG = Constants.PACKAGE_NAME;

    public static void e(String tag, Object o) {
        if (isDebug) {
            Logger.e(tag, o);
        }
    }

    public static void e(Object o) {
        e(TAG, o);
    }

    public static void w(String tag, Object o) {
        if (isDebug) {
            Logger.w(tag, o);
        }
    }

    public static void w(Object o) {
        w(TAG, o);
    }

    public static void i(String tag, Object o) {
        if (isDebug) {
            Logger.i(tag, o);
        }
    }

    public static void i(Object o) {
        i(TAG, o);
    }

    public static void d(String tag, Object o) {
        if (isDebug) {
            Logger.d(tag, o);
        }
    }

    public static void d(Object o) {
        d(TAG, o);
    }
}
