package com.example.demo2;

import android.app.Application;
import android.content.Context;

/**
 * @author laibaijiang
 * @date 2023/4/12
 */
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
