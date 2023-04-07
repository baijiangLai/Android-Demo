package com.lixiang.rxjava_retrofit_mvp_demo.contract;

import com.lixiang.rxjava_retrofit_mvp_demo.base.BaseView;
import com.lixiang.rxjava_retrofit_mvp_demo.bean.LicensePlate;

import io.reactivex.Observable;

/**
 * @author laibaijiang
 * @date 2023/4/7
 */
public interface ILicenseContract {

    interface ILicenseModel{
        Observable<LicensePlate> getLicensePlate(String carno);
    }

    interface ILicensePlatePresenter {
        void getLicensePlate(String carno);
    }

    interface ILicensePlateView extends BaseView {
        void search(String licensePlate);
    }
}
