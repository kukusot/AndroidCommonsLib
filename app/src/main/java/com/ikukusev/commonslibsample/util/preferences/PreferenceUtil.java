package com.ikukusev.commonslibsample.util.preferences;

import com.ikukusev.commonslib.prefrences.BasePreferenceUtil;
import com.ikukusev.commonslibsample.models.TestObject;
import com.ikukusev.commonslibsample.models.TestRestObject;

import info.metadude.android.typedpreferences.BooleanPreference;
import info.metadude.android.typedpreferences.StringPreference;

/**
 * Created by Ivan on 9/8/2015.
 */
public class PreferenceUtil extends BasePreferenceUtil {

    public static StringPreference namePreference() {
        return stringPreference("name", "default name");
    }

    public static ModelPreference<TestObject> testObject() {
        return new ModelPreference<>(TestObject.class);
    }

}
