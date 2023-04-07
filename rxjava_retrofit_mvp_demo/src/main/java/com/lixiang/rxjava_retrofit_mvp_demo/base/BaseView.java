package com.lixiang.rxjava_retrofit_mvp_demo.base;

/**
 * @author laibaijiang
 * @date 2023/4/7
 */
public interface BaseView {

    /**
     * 显示进度框
     */
    void showProgressDialog();

    /**
     * 关闭进度框
     */
    void hideProgressDialog();

    /**
     * 出错信息的回调
     *
     * @param result 错误信息
     */
    void onError(String result);

}
