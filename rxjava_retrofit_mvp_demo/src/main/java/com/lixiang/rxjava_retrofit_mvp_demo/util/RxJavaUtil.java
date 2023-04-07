package com.lixiang.rxjava_retrofit_mvp_demo.util;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author laibaijiang
 * @date 2023/4/7
 */
public class RxJavaUtil {
    public static <T> Observable toSubscribe(Observable<T> observable){
        return observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
