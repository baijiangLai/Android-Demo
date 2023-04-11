package com.lixiang.rxjava_retrofit_mvp_demo.base;

/**
 * @author laibaijiang
 * @date 2023/4/7
 */

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * presenter的基类，compositeDisposable主要用途是及时取消订阅，防止内存泄露
 */

public abstract class BasePresenter<V extends BaseView> {
    //将所有正在处理的Subscription都添加到CompositeSubscription中。统一退出的时候注销观察
    private CompositeDisposable mCompositeDisposable;
    private V baseView;

    /**
     * 和View绑定
     *
     * @param baseView
     */
    public void attachView(V baseView) {
        this.baseView = baseView;
    }

    /**
     * 解绑View,该方法在BaseMvpActivity类中被调用
     */
    public void detachView() {
        baseView = null;
        // 在界面退出等需要解绑观察者的情况下调用此方法统一解绑，防止Rx造成的内存泄漏
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }

    /**
     * 获取View
     *
     * @return view
     */
    public V getMvpView() {
        return baseView;
    }

    /**
     * 将Disposable添加,在每次网络访问之前初始化时进行添加操作
     *
     * @param subscription subscription
     */
    public void addDisposable(Disposable subscription) {
        //csb 如果解绑了的话添加 sb 需要新的实例否则绑定时无效的
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }

}

