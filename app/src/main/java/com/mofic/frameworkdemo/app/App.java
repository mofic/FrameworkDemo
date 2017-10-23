package com.mofic.frameworkdemo.app;

import android.app.Application;

/**
 * @author lanweining
 * @date 2017/10/22
 */

public class App extends Application {

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        InitializeService.start(this);
    }
}
