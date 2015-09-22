package com.ikukusev.commonslib.http;

/**
 * Created by Ivan on 3/12/2015.
 */
public interface HttpCallback<T> {

    public void onSuccess(T t, int statusCode);

    public void onHttpError(int statusCode);


}
