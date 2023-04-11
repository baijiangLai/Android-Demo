package com.lixiang.rxjava_retrofit_mvp_demo.contract;

import com.lixiang.rxjava_retrofit_mvp_demo.base.BaseView;
import com.lixiang.rxjava_retrofit_mvp_demo.bean.PoetryEntity;

import io.reactivex.Observable;

/**
 * @author laibaijiang
 * @date 2023/4/7
 */
public interface IPoetryContract {
    interface IPoetryModel {
        /**
         * 得到诗歌
         *
         * @return 诗歌
         */
        Observable<PoetryEntity> getPoetry();
    }

    interface IPoetryPresenter {
        void getPoetry();
    }

    interface IPoetryView extends BaseView {
        /**
         * @param author 作者
         */
        void searchSuccess(String author);
    }
}
