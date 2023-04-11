package com.lixiang.rxjava_retrofit_mvp_demo.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import butterknife.ButterKnife;

/**
 * BaseActivity 基类活动
 *
 * @author laibaijiang
 * @date 2023/4/7
 * 是module中所有activity的基类
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initPresenter();
        initViews();
        ButterKnife.bind(this);
    }

    /**
     * 抽象方法：实例化Presenter
     */
    protected abstract void initPresenter();

    /**
     * 抽象方法：初始化控件，一般在BaseActivity中通过ButterKnife来绑定，所以该方法内部一般我们初始化界面相关的操作
     *
     * @return 控件
     */
    protected abstract void initViews();

    /**
     * 抽象方法：得到布局id
     *
     * @return 布局id
     */
    protected abstract int getLayoutId();

    /**
     * 启动Fragment
     *
     * @param id       id
     * @param fragment 碎片
     */
    protected void startFragment(int id, Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(id, fragment);
        fragmentTransaction.commit();
    }
}
