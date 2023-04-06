package com.lixiang.rxjava_retrofit_mvp_demo.base.presenter;

/**
 * @author laibaijiang
 * @date 2023/4/6
 */
public interface Ipresenter<T> {
    /**
     * 开始请求之前
     */
    void beforeRequest(int requestTag);

    /**
     * 请求结束
     */
    void requestComplete(int requestTag);

    /**
     * 请求成功
     *
     * @param callBack 根据业务返回相应的数据
     */
    void requestSuccess(T callBack, int requestTag);

    /**
     * 请求失败
     *
     * @param e 失败的原因
     */
    void requestError(Throwable e, int requestTag);

}
