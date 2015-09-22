package com.ikukusev.commonslibsample.util.preferences;

import com.bluelinelabs.logansquare.LoganSquare;
import com.ikukusev.commonslib.prefrences.BaseModelPreference;

/**
 * Created by Ivan on 9/8/2015.
 */
public class ModelPreference<T> extends BaseModelPreference<T> {

    public ModelPreference(Class<T> clazz) {
        super(clazz);
    }

    public ModelPreference(Class<T> clazz, String key) {
        super(clazz, key);
    }

    @Override
    public String serialize(T t) throws Exception {
        return LoganSquare.serialize(t);
    }

    @Override
    public T parse(String jsonString) throws Exception {
        return LoganSquare.parse(jsonString, clazz);
    }
}
