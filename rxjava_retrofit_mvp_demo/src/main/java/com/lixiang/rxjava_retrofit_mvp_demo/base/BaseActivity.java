package com.lixiang.rxjava_retrofit_mvp_demo.base;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import butterknife.ButterKnife;

/**
 * @author laibaijiang
 * @date 2023/4/7
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initPresenter();
        initViews();
        ButterKnife.bind(this);
    }

    protected abstract int getLayoutId();

    protected abstract void initViews();

    protected abstract void initPresenter();

    protected void startFragment(int id, Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(id,fragment);
        fragmentTransaction.commit();
    }
}
