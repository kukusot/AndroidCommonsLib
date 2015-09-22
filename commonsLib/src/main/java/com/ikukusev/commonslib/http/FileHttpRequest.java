package com.ikukusev.commonslib.http;


/**
 * Created by Ivan on 3/12/2015.
 */
public abstract class FileHttpRequest<T> extends HttpRequest<T> {

    public FileHttpRequest(HttpCallback<T> callback) {
        super(callback);
    }

    @Override
    protected void addAdditionalParams() {
        try {
            addFiles();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void addFiles() throws Exception;
}
