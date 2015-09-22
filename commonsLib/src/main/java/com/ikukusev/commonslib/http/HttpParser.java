package com.ikukusev.commonslib.http;

/**
 * Created by Ivan on 3/12/2015.
 */
public interface HttpParser<T> {
    public T parse(String responseString) throws Exception;
}
