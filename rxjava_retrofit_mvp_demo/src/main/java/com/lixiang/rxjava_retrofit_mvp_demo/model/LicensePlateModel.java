package com.lixiang.rxjava_retrofit_mvp_demo.model;

import com.lixiang.rxjava_retrofit_mvp_demo.api.LicensePlateApi;
import com.lixiang.rxjava_retrofit_mvp_demo.bean.LicensePlate;
import com.lixiang.rxjava_retrofit_mvp_demo.constant.Constants;
import com.lixiang.rxjava_retrofit_mvp_demo.contract.ILicenseContract;
import com.lixiang.rxjava_retrofit_mvp_demo.util.RetrofitManager;

import io.reactivex.Observable;

/**
 * @author laibaijiang
 * @date 2023/4/7
 */
public class LicensePlateModel implements ILicenseContract.ILicenseModel {

    public static final String TAG = LicensePlateModel.class.getSimpleName();

    private volatile static LicensePlateModel licensePlateModel;

    //single
    private LicensePlateModel(){

    }

    public static LicensePlateModel getInstance(){
        if (licensePlateModel == null){
            synchronized (LicensePlateModel.class){
                if (licensePlateModel == null){
                    licensePlateModel = new LicensePlateModel();
                }
            }
        }
        return licensePlateModel;
    }

    @Override
    public Observable<LicensePlate> getLicensePlate(String carno) {
        return RetrofitManager.getInstance().createService(LicensePlateApi.class).getInformation(carno,Constants.KEY);
    }
}
