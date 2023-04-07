package com.lixiang.rxjava_retrofit_mvp_demo.base;

import android.app.Application;
import android.content.Context;

/**
 * @author laibaijiang
 * @date 2023/4/7
 */
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
