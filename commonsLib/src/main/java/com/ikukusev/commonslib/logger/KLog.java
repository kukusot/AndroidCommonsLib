package com.ikukusev.commonslib.logger;

import android.util.Log;

/**
 * Created by Ivan on 3/16/2015.
 */
public class KLog {

    private static String TAG = "KLog";
    private static boolean writeLogs = true;

    public static void setEnabled(boolean enabled) {
        writeLogs = enabled;
    }

    public static void setTAG(String TAG) {
        KLog.TAG = TAG;
    }

    public static void d(String logMessage) {
        if (writeLogs) Log.d(TAG, logMessage);
    }

    public static void e(String logMessage) {
        if (writeLogs) Log.e(TAG, logMessage);
    }

    public static void i(String logMessage) {
        if (writeLogs) Log.i(TAG, logMessage);
    }


}
