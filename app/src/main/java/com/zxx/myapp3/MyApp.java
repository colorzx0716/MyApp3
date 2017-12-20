package com.zxx.myapp3;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * App
 */

public class MyApp extends Application {
    public static Context context;

    //内存泄漏
    public static RefWatcher getRefWatcher(Context context) {
        MyApp application = (MyApp) context.getApplicationContext();
        return application.refWatcher;
    }

    //内存泄漏
    private RefWatcher refWatcher;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        //内存泄漏
        refWatcher = LeakCanary.install(this);
    }
}
