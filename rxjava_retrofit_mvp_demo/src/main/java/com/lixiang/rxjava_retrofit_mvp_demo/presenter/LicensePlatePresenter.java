package com.lixiang.rxjava_retrofit_mvp_demo.presenter;

import android.util.Log;

import com.lixiang.rxjava_retrofit_mvp_demo.base.BasePresenter;
import com.lixiang.rxjava_retrofit_mvp_demo.bean.LicensePlate;
import com.lixiang.rxjava_retrofit_mvp_demo.contract.ILicenseContract;
import com.lixiang.rxjava_retrofit_mvp_demo.model.LicensePlateModel;
import com.lixiang.rxjava_retrofit_mvp_demo.util.RxJavaUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @author laibaijiang
 * @date 2023/4/7
 */
@SuppressWarnings("all")
public class LicensePlatePresenter extends BasePresenter<ILicenseContract.ILicensePlateView> implements ILicenseContract.ILicensePlatePresenter {

    private static final String TAG = LicensePlatePresenter.class.getSimpleName();
    private LicensePlate mLicensePlate;
    private LicensePlateModel mLicensePlateModel;

    @Override
    public void getLicensePlate(String carno) {
        Observable<LicensePlate> observable = mLicensePlateModel.getLicensePlate(carno).doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                addDisposable(disposable);
            }
        });

        observable = RxJavaUtil.toSubscribe(observable);
        observable.subscribe(new Observer<LicensePlate>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(LicensePlate licensePlate) {
                mLicensePlate = licensePlate;
            }

            @Override
            public void onError(Throwable e) {
                getMVPView().onError(e.getMessage());
                Log.e(TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                if (mLicensePlate != null){
                    getMVPView().search(mLicensePlate.getResult().getCity());
                }
            }
        });
    }
}
