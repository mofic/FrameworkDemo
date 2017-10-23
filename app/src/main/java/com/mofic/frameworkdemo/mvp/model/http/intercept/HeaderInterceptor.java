package com.mofic.frameworkdemo.mvp.model.http.intercept;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import com.mofic.frameworkdemo.app.App;
import com.mofic.frameworkdemo.app.Constants;
import com.mofic.frameworkdemo.mvp.model.prefs.SpImpl;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author lanweining
 * @date 2017/10/22
 */

public class HeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        SpImpl sp = new SpImpl();
        String token = sp.getString(Constants.ACCESS_TOKEN, "");
        String version = "";
        try {
            PackageInfo info = App.getInstance().getPackageManager().getPackageInfo(
                    App.getInstance().getPackageName(), PackageManager.GET_CONFIGURATIONS);
            version = String.valueOf(info.versionCode);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        if (!TextUtils.isEmpty(token)) {
            builder.header("token", token);
        }
        request = builder.header("version", version)
                .build();
        return chain.proceed(request);
    }
}

