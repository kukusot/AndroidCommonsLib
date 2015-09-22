package com.ikukusev.commonslib.prefrences;


/**
 * Created by Ivan on 10-Aug-15.
 */
public abstract class BaseModelPreference<T> {

    protected Class<T> clazz;
    public String key;

    public BaseModelPreference(Class<T> clazz) {
        this.clazz = clazz;
    }

    public BaseModelPreference(Class<T> clazz, String key) {
        this.clazz = clazz;
        this.key = key;
    }

    public T get() {
        String serialized = BasePreferenceUtil.stringPreference(getKey()).get();
        try {
            return parse(serialized);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void set(T t) {
        if (t == null) {
            BasePreferenceUtil.stringPreference(getKey()).set("");
            return;
        }
        try {
            BasePreferenceUtil.stringPreference(getKey()).set(serialize(t));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getKey() {
        return key == null ? clazz.getCanonicalName() : key;
    }

    //Use any json parsing library, or serialize/parse manually
    public abstract String serialize(T t) throws Exception;

    public abstract T parse(String jsonString) throws Exception;
}
