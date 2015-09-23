package com.ikukusev.commonslib.http;


import android.os.Bundle;
import android.util.Log;


import com.ikukusev.commonslib.logger.KLog;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.apache.http.Header;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ivan on 3/12/2015.
 */
public abstract class HttpRequest<T> {


    public static final int PARSER_ERROR_CODE = 900;


    private HttpCallback<T> callback;
    private static RequestMethod method = RequestMethod.POST;
    private Map<String, String> paramsMap = new HashMap<>();
    protected RequestParams params = new RequestParams();

    private static String HOST;

    public static void setHOST(String host) {
        HOST = host;
    }


    public HttpRequest(HttpCallback<T> callback) {
        this.callback = callback;
    }

    protected String getAbsoluteUrl(String relativeUrl) {
        return HOST + relativeUrl;
    }

    public abstract String getUrl();


    public abstract void prepareParams();

    protected final void addParam(String key, String value) {
        paramsMap.put(key, value);
    }

    protected final void addParamsFromBundle(Bundle bundle) {
        for (String key : bundle.keySet()) {
            addParam(key, bundle.getString(key));
        }
    }




    private TextHttpResponseHandler responseHandler = new TextHttpResponseHandler() {
        @Override
        public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
            callback.onHttpError(statusCode);
            KLog.e("on request fail " + responseString);
        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, String responseString) {
            KLog.e("on request success " + responseString);
            T response = null;
            try {
                response = parse(responseString);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (response != null) {
                callback.onSuccess(response, statusCode);
            } else {
                callback.onHttpError(PARSER_ERROR_CODE);
            }

        }
    };

    public abstract T parse(String responseString) throws Exception;

    protected void addAdditionalParams() {
    }

    public final void execute() {
        prepareParams();
        params = new RequestParams(paramsMap);
        addAdditionalParams();
        Log.e(getClass().getSimpleName() + " params", params.toString());
        switch (method) {
            case GET:
                HttpCore.httpClient.get(getUrl(), params, responseHandler);
                break;
            case POST:
                HttpCore.httpClient.post(getUrl(), params, responseHandler);
                break;

        }
    }
}
