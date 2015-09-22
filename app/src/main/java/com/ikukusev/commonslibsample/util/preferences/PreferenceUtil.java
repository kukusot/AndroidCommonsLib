package com.ikukusev.commonslibsample.util.preferences;

import com.ikukusev.commonslib.prefrences.BasePreferenceUtil;
import com.ikukusev.commonslibsample.models.TestRestObject;

import info.metadude.android.typedpreferences.BooleanPreference;

/**
 * Created by Ivan on 9/8/2015.
 */
public class PreferenceUtil extends BasePreferenceUtil {

    public static ModelPreference<TestRestObject> model() {
        return new ModelPreference<TestRestObject>(TestRestObject.class);
    }

    public static ModelPreference<TestRestObject> model2() {
        return new ModelPreference<TestRestObject>(TestRestObject.class, "model_2");
    }

}
