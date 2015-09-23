package com.ikukusev.commonslib.util;

import android.os.Bundle;
import android.support.annotation.AnimRes;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by Ivan on 9/23/2015.
 */
public class FragmentUtil {


    public static void replaceFragment(Class<? extends Fragment> clazz, FragmentManager manager, @IdRes int containerId, @Nullable Bundle arguments) {
        String backStateName = clazz.getName();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);
        if (!fragmentPopped && manager.findFragmentByTag(backStateName) == null) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            try {
                Fragment fragment = clazz.newInstance();
                fragment.setArguments(arguments);
                ft.replace(containerId, fragment, backStateName);
                ft.addToBackStack(backStateName);
                ft.commit();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void replaceFragment(Class<? extends Fragment> clazz, FragmentManager manager, @IdRes int containerId, @Nullable Bundle arguments, @AnimRes int enterAnim, @AnimRes int exitAnim, @AnimRes int popEnterAnim, @AnimRes int popExitAnim) {
        String backStateName = clazz.getName();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);
        if (!fragmentPopped && manager.findFragmentByTag(backStateName) == null) { //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.setCustomAnimations(enterAnim, exitAnim, popEnterAnim, popExitAnim);
            try {
                Fragment fragment = clazz.newInstance();
                fragment.setArguments(arguments);
                ft.replace(containerId, fragment, backStateName);
                ft.addToBackStack(backStateName);
                ft.commit();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addFragmentToContainer(Fragment fragment, FragmentManager manager, @IdRes int containerId) {
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(containerId, fragment);
        transaction.commit();
    }
}
