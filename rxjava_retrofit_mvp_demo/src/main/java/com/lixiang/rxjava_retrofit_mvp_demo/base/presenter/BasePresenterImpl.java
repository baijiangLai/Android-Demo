package com.lixiang.rxjava_retrofit_mvp_demo.base.presenter;

/**
 * @author laibaijiang
 * @date 2023/4/6
 */

import com.lixiang.rxjava_retrofit_mvp_demo.base.view.IView;

/**
 * 目的：在该类中做一些基础的事，比如：加载失败后的提示等，做一个抽象
 */
public class BasePresenterImpl implements Ipresenter {
    private IView iView;

    public BasePresenterImpl(IView iView) {
        this.iView = iView;
    }

    @Override
    public void beforeRequest(int requestTag) {
        iView.showProgress(requestTag);
    }

    @Override
    public void requestComplete(int requestTag) {
        iView.hideProgress(requestTag);
    }

    @Override
    public void requestSuccess(Object callBack, int requestTag) {
        iView.loadDataSuccess(callBack,requestTag);
    }

    @Override
    public void requestError(Throwable e, int requestTag) {
        iView.loadDataError(e,requestTag);
    }
}
