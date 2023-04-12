package com.example.demo2.api;

import com.example.demo2.bean.Mobile;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MobileApi {

    @GET("mobile/get")
    Observable<Mobile> getMobileInformation(@Query("phone") String phone, @Query("key") String key, @Query("dtype") String dtype);
}
