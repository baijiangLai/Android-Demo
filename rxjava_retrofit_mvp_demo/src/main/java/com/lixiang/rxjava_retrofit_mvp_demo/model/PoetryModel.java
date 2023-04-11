package com.lixiang.rxjava_retrofit_mvp_demo.model;

import com.lixiang.rxjava_retrofit_mvp_demo.api.GetPoetryEntity;
import com.lixiang.rxjava_retrofit_mvp_demo.bean.PoetryEntity;
import com.lixiang.rxjava_retrofit_mvp_demo.contract.IPoetryContract;
import com.lixiang.rxjava_retrofit_mvp_demo.util.RetrofitManager;

import io.reactivex.Observable;

/**
 * @author laibaijiang
 * @date 2023/4/11
 */
public class PoetryModel implements IPoetryContract.IPoetryModel {

    private PoetryModel() {

    }

    public static PoetryModel getInstance() {
        return Inner.instance;
    }

    private static class Inner {
        private static final PoetryModel instance = new PoetryModel();
    }

    /**
     * 获取古诗词
     *
     * @return 古诗词
     */
    @Override
    public Observable<PoetryEntity> getPoetry() {
        return RetrofitManager.getInstance().createRs(GetPoetryEntity.class).getPoetry();
    }
}
