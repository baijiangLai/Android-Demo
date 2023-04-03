package com.lixiang.retrofit_demo.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author laibaijiang
 * @date 2023/4/3
 */
public class RetrofitUtils {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://apis.juhe.cn/";
    public static <T> T getService(Class<T> serviceClass){
        if (retrofit == null){
            synchronized (RetrofitUtils.class){
                if (retrofit == null){
                    retrofit = new Retrofit.Builder()
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl(BASE_URL)
                            .build();
                }
            }
        }
        return retrofit.create(serviceClass);
    }

    private RetrofitUtils() {

    }
}
