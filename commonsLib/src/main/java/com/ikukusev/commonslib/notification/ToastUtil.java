package com.ikukusev.commonslib.notification;


import android.widget.Toast;

import com.ikukusev.commonslib.CommonsCore;


/**
 * Created by Ivan on 3/16/2015.
 */
public class ToastUtil {


    public static void showToast(String message) {
        Toast.makeText(CommonsCore.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public static void showToast(int messageResId) {
        Toast.makeText(CommonsCore.getContext(), messageResId, Toast.LENGTH_SHORT).show();
    }

    public static void shotLongToast(String message) {
        Toast.makeText(CommonsCore.getContext(), message, Toast.LENGTH_LONG).show();
    }

    public static void showLongToast(int messageResId) {
        Toast.makeText(CommonsCore.getContext(), messageResId, Toast.LENGTH_LONG).show();
    }


}
