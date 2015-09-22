package com.ikukusev.commonslibsample.app;

import android.app.Application;

import com.ikukusev.commonslib.CommonsCore;

/**
 * Created by Ivan on 9/22/2015.
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CommonsCore.init(this);
    }
}
