package com.mofic.frameworkdemo.mvp.model.http.response;

/**
 * @author lanweining
 * @date 2017/10/22
 */


public class HttpResponse<T> {
    private int resultCode;
    private T entity;
    private String resultMsg;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}

