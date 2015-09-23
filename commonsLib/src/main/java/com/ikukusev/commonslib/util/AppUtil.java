package com.ikukusev.commonslib.util;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

import com.ikukusev.commonslib.CommonsCore;

/**
 * Created by Ivan on 9/23/2015.
 */
public class AppUtil {
    public static boolean isGpsEnabled() {
        return ((LocationManager) CommonsCore.getContext().getSystemService(Context.LOCATION_SERVICE)).isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    public static String getImei() {
        TelephonyManager telephonyManager = (TelephonyManager) CommonsCore.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getDeviceId();
    }

    public static boolean isOnLine() {
        ConnectivityManager connectivityManager = (ConnectivityManager) CommonsCore.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager != null && connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public static boolean isWifiOn() {
        ConnectivityManager connManager = (ConnectivityManager) CommonsCore.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        return mWifi.isConnected();
    }
}
