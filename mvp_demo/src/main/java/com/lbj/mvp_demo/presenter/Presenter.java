package com.lbj.mvp_demo.presenter;

import android.text.TextUtils;

import com.lbj.mvp_demo.view.IView;
import com.lbj.mvp_demo.model.UserService;

public class Presenter implements IPresenter {
    private IView mView;
    public Presenter(IView view){
        this.mView = view;
    }
    @Override
    public void search() {
        String mViewInputString = mView.getInputString();
        if (TextUtils.isEmpty(mViewInputString)){
            return;
        }

        int hashCode = mViewInputString.hashCode();

        UserService userService = new UserService();

        String res = "Result: " + mViewInputString + "-" + userService.search(hashCode);

        mView.setResultString(res);
    }
}
