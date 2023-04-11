package com.lixiang.rxjava_retrofit_mvp_demo.api;

import com.lixiang.rxjava_retrofit_mvp_demo.bean.PoetryEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author laibaijiang
 * @date 2023/4/11
 */


public interface GetPoetryEntity {
    /**
     * 获取古诗词
     *
     * @return 古诗词
     */
    @GET("all.json")
    Observable<PoetryEntity> getPoetry();
}
