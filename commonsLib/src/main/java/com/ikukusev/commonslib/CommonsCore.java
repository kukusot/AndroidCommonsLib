package com.ikukusev.commonslib;

import android.content.Context;

/**
 * Created by Ivan on 3/16/2015.
 */
public class CommonsCore {

    public static Context context;

    public static void init(Context context) {
        if (CommonsCore.context == null) {
            CommonsCore.context = context.getApplicationContext();
        }
    }
}
