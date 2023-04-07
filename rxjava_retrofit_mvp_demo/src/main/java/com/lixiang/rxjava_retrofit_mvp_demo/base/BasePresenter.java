package com.lixiang.rxjava_retrofit_mvp_demo.base;

/**
 * @author laibaijiang
 * @date 2023/4/7
 */

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * presenter的基类
 */
public abstract class BasePresenter<V extends BaseView> {

    private CompositeDisposable compositeDisposable;
    private V baseView;

    public void attachView(V baseView){
        this.baseView = baseView;
    }

    //在界面退出等需要解绑观察者的情况下调用此方法统一解绑，防止Rx造成的内存泄漏
    public void detachView(){
        baseView = null;
        if (compositeDisposable != null){
            compositeDisposable.dispose();
        }
    }

    public V getMVPView(){
        return baseView;
    }


    public void addDisposable(Disposable disposable){
        if (compositeDisposable == null || compositeDisposable.isDisposed()){
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }
}
