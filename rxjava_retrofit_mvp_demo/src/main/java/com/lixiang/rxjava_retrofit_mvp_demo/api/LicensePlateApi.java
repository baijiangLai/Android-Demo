package com.lixiang.rxjava_retrofit_mvp_demo.api;


import com.lixiang.rxjava_retrofit_mvp_demo.bean.LicensePlate;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author laibaijiang
 * @date 2023/4/6
 */
public interface LicensePlateApi {
    @GET("fapigw/carlocation/query")
    Observable<LicensePlate> getInformation(@Query("carno") String carno, @Query("key") String key);
}
