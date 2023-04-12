package com.example.demo2.presenter;

import com.example.demo2.bean.Mobile;
import com.example.demo2.view.IView;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author laibaijiang
 * @date 2023/4/12
 * 做数据处理
 */
public abstract class IPresenter<V extends IView> {
    abstract void getMobileInformation();

    private CompositeDisposable mCompositeDisposable;
    private V mView;

    public void attachView(V view) {
        this.mView = view;
    }

    public void detachView(){
        mView = null;
        if (mCompositeDisposable == null){
            mCompositeDisposable.dispose();
        }
    }

    public V getView(){
        return mView;
    }

    public void addDisposable(Disposable disposable){
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()){
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }
}
