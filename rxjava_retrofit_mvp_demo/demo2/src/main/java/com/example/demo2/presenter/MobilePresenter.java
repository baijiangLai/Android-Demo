package com.example.demo2.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.demo2.MyApplication;
import com.example.demo2.bean.Mobile;
import com.example.demo2.model.MobileModel;
import com.example.demo2.utils.RxJavaUtil;
import com.example.demo2.view.IView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

@SuppressWarnings("all")
public class MobilePresenter extends IPresenter {

    private static final String TAG = MobilePresenter.class.getSimpleName();
    private Mobile mMobile;
    private IView mIView;

    public MobilePresenter(IView IView) {
        mIView = IView;
    }

    //进行网络请求
    @Override
    public void getMobileInformation() {
        String phoneNum = mIView.getInput();
        if (TextUtils.isEmpty(phoneNum)){
            return;
        }

        MobileModel mobileModel = MobileModel.getInstance();
        Observable<Mobile> observable = mobileModel.search(phoneNum);

        observable.doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                addDisposable(disposable);
            }
        });
        observable = RxJavaUtil.toSubscribe(observable);
        observable.subscribe(new Observer<Mobile>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Mobile mobile) {
                mIView.setCity(mobile.getResult().getCity());
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e.getMessage());
                Toast.makeText(MyApplication.getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Log.i("TAG", "onComplete: ");
            }
        });

    }
}
