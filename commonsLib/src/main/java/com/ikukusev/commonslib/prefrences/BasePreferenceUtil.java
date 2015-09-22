package com.ikukusev.commonslib.prefrences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.ikukusev.commonslib.CommonsCore;

import java.util.HashMap;
import java.util.Map;

import info.metadude.android.typedpreferences.BooleanPreference;
import info.metadude.android.typedpreferences.DoublePreference;
import info.metadude.android.typedpreferences.FloatPreference;
import info.metadude.android.typedpreferences.IntPreference;
import info.metadude.android.typedpreferences.LongPreference;
import info.metadude.android.typedpreferences.StringPreference;

/**
 * Created by Ivan on 3/16/2015.
 */
public class BasePreferenceUtil {
    protected static SharedPreferences preferences;

    protected static Map<String, Object> preferenceMap = new HashMap<>();

    static {
        preferences = PreferenceManager.getDefaultSharedPreferences(CommonsCore.context);
    }


    public static BooleanPreference booleanPreference(String key, boolean defaultValaue) {
        if (!preferenceMap.containsKey(key)) {
            preferenceMap.put(key, new BooleanPreference(preferences, key, defaultValaue));
        }
        return (BooleanPreference) preferenceMap.get(key);
    }

    public static BooleanPreference booleanPreference(String key) {
        if (!preferenceMap.containsKey(key)) {
            preferenceMap.put(key, new BooleanPreference(preferences, key));
        }
        return (BooleanPreference) preferenceMap.get(key);
    }

    public static IntPreference intPreference(String key, int defaultValue) {
        if (!preferenceMap.containsKey(key)) {
            preferenceMap.put(key, new IntPreference(preferences, key, defaultValue));
        }
        return (IntPreference) preferenceMap.get(key);
    }

    public static IntPreference intPreference(String key) {
        if (!preferenceMap.containsKey(key)) {
            preferenceMap.put(key, new IntPreference(preferences, key));
        }
        return (IntPreference) preferenceMap.get(key);
    }

    public static LongPreference longPreference(String key, int defaultValue) {
        if (!preferenceMap.containsKey(key)) {
            preferenceMap.put(key, new LongPreference(preferences, key, defaultValue));
        }
        return (LongPreference) preferenceMap.get(key);
    }

    public static LongPreference longPreference(String key) {
        if (!preferenceMap.containsKey(key)) {
            preferenceMap.put(key, new IntPreference(preferences, key));
        }
        return (LongPreference) preferenceMap.get(key);
    }


    public static StringPreference stringPreference(String key) {
        if (!preferenceMap.containsKey(key)) {
            preferenceMap.put(key, new StringPreference(preferences, key));
        }
        return (StringPreference) preferenceMap.get(key);
    }

    public static StringPreference stringPreference(String key, String defaultValue) {
        if (!preferenceMap.containsKey(key)) {
            preferenceMap.put(key, new StringPreference(preferences, key, defaultValue));
        }
        return (StringPreference) preferenceMap.get(key);
    }


    public static DoublePreference doublePreference(String key, int defaultValue) {
        if (!preferenceMap.containsKey(key)) {
            preferenceMap.put(key, new DoublePreference(preferences, key, defaultValue));
        }
        return (DoublePreference) preferenceMap.get(key);
    }

    public static DoublePreference doublePreference(String key) {
        if (!preferenceMap.containsKey(key)) {
            preferenceMap.put(key, new IntPreference(preferences, key));
        }
        return (DoublePreference) preferenceMap.get(key);
    }


    public static FloatPreference floatPreference(String key, int defaultValue) {
        if (!preferenceMap.containsKey(key)) {
            preferenceMap.put(key, new FloatPreference(preferences, key, defaultValue));
        }
        return (FloatPreference) preferenceMap.get(key);
    }


    public static FloatPreference floatPreference(String key) {
        if (!preferenceMap.containsKey(key)) {
            preferenceMap.put(key, new FloatPreference(preferences, key));
        }
        return (FloatPreference) preferenceMap.get(key);
    }







}
