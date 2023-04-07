package com.lixiang.rxjava_retrofit_mvp_demo.util;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author laibaijiang
 * @date 2023/4/7
 */
public class RetrofitManager {
    private Retrofit retrofit;
    private volatile static RetrofitManager retrofitManager;

    public static RetrofitManager getInstance(){
        if (retrofitManager == null){
            synchronized (RetrofitManager.class){
                if (retrofitManager == null){
                    retrofitManager = new RetrofitManager();
                }
            }
        }
        return retrofitManager;
    }

    private RetrofitManager(){
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public <T> T createService(Class<T> service){
        return retrofit.create(service);
    }


}
