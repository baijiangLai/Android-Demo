package com.lixiang.rxjava_retrofit_mvp_demo.base;

/**
 * @author laibaijiang
 * @date 2023/4/7
 */
public abstract class BaseMvpActivity<V extends  BaseView, P extends BasePresenter> extends BaseActivity {
    private P presenter;

    protected void initPresenter(){
        presenter = createPresenter();
        if (presenter != null){
            presenter.attachView((V)this);
        }
    }

    protected abstract P createPresenter();

    protected P getPresenter(){
        return presenter;
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (presenter != null){
            presenter.detachView();
        }
    }
}
