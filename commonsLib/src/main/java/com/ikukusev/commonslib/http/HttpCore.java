package com.ikukusev.commonslib.http;


import com.loopj.android.http.AsyncHttpClient;

/**
 * Created by Ivan on 3/12/2015.
 */
public class HttpCore {


    public static AsyncHttpClient httpClient = new AsyncHttpClient();

    static {
        httpClient.setConnectTimeout(10000);
    }

    public static void setConnectionTimeOut(int timeOut) {
        httpClient.setConnectTimeout(timeOut);
    }

}
