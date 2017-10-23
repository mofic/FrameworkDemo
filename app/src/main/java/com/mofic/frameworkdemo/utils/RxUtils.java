package com.mofic.frameworkdemo.utils;

import com.mofic.frameworkdemo.mvp.model.http.ResultCode;
import com.mofic.frameworkdemo.mvp.model.http.exception.ApiException;
import com.mofic.frameworkdemo.mvp.model.http.response.HttpResponse;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author lanweining
 * @date 2017/10/22
 */

public class RxUtils {

    /**
     * 统一线程处理
     */
    public static <T> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * 统一返回结果处理
     */
    public static <T> FlowableTransformer<HttpResponse<T>, HttpResponse<T>> handleResult() {   //compose判断结果
        return new FlowableTransformer<HttpResponse<T>, HttpResponse<T>>() {
            @Override
            public Flowable<HttpResponse<T>> apply(Flowable<HttpResponse<T>> httpResponseFlowable) {
                return httpResponseFlowable.flatMap(new Function<HttpResponse<T>, Flowable<HttpResponse<T>>>() {
                    @Override
                    public Flowable<HttpResponse<T>> apply(HttpResponse<T> httpResponse) {
                        if (httpResponse.getResultCode() == ResultCode.SUCCESS) {
                            return createData(httpResponse);
                        } else {
                            return Flowable.error(new ApiException(httpResponse.getResultMsg(), httpResponse.getResultCode()));
                        }
                    }
                });
            }
        };
    }

    /**
     * 生成Flowable
     */
    public static <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> emitter) throws Exception {
                try {
                    emitter.onNext(t);
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);
    }
}
