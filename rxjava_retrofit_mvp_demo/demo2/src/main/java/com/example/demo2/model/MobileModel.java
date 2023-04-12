package com.example.demo2.model;

import com.example.demo2.api.MobileApi;
import com.example.demo2.bean.Mobile;
import com.example.demo2.constants.Constant;
import com.example.demo2.utils.RetrofitManager;

import io.reactivex.Observable;

public class MobileModel implements IMobile {
    private volatile static MobileModel model;
    private MobileModel() {

    }

    public static MobileModel getInstance() {
        if (model == null){
            synchronized (MobileModel.class) {
                if (model == null){
                    model = new MobileModel();
                }
            }
        }
        return model;
    }

    @Override
    public Observable<Mobile> search(String num) {
        return RetrofitManager.getInstance().createService(MobileApi.class).getMobileInformation(num, Constant.KEY,"json");
    }
}
