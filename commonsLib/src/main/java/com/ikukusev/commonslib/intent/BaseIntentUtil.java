package com.ikukusev.commonslib.intent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Ivan on 3/16/2015.
 */
public class BaseIntentUtil {

    public static void startActivity(Context activity, Class clazz) {
        activity.startActivity(new Intent(activity, clazz));
    }

    public static void startActivity(Activity activity, Class clazz, int flags) {
        Intent intent = new Intent(activity, clazz);
        intent.addFlags(flags);
        activity.startActivity(intent);
    }

    public static void startActivityForResult(Activity activity, Class clazz, int requestCode) {
        activity.startActivityForResult(new Intent(activity, clazz), requestCode);
    }

}
