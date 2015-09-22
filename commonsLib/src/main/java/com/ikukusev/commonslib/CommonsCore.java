package com.ikukusev.commonslib;

import android.content.Context;

/**
 * Created by Ivan on 3/16/2015.
 */
public class CommonsCore {

    private static Context context;

    public static void init(Context context) {
        if (CommonsCore.context == null) {
            CommonsCore.context = context.getApplicationContext();
        }
    }

    public static Context getContext() {
        return context;
    }
}
