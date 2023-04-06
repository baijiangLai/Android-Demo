package com.lixiang.retrofit_demo.api;

import com.lixiang.retrofit_demo.bean.LicensePlate;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author laibaijiang
 * @date 2023/4/6
 */
public interface LicensePlateApi {
    @GET("fapigw/carlocation/query")
    Call<LicensePlate> getInformation(@Query("carno") String carno, @Query("key") String key);
}
