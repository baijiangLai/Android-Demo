package com.lixiang.retrofit_demo.api;

import com.lixiang.retrofit_demo.bean.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author laibaijiang
 * @date 2023/4/3
 */
public interface WeatherServiceApi {
        //获取天气信息
        @GET("simpleWeather/query")
        Call<Weather> getInformation(@Query("city") String city, @Query("key") String key);
}
