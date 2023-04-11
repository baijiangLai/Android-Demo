package com.lixiang.rxjava_retrofit_mvp_demo.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.lixiang.rxjava_retrofit_mvp_demo.R;
import com.lixiang.rxjava_retrofit_mvp_demo.base.BaseFragment;
import com.lixiang.rxjava_retrofit_mvp_demo.base.MyApplication;
import com.lixiang.rxjava_retrofit_mvp_demo.contract.IPoetryContract;
import com.lixiang.rxjava_retrofit_mvp_demo.presenter.PoetryPresenter;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author laibaijiang
 * @date 2023/4/7
 */

public class MainFragment extends BaseFragment<PoetryPresenter> implements IPoetryContract.IPoetryView {

    @BindView(R.id.btn_get_poetry)
    Button btnGetPoetry;
    @BindView(R.id.tv_poetry_author)
    TextView tvPoetryAuthor;

    @Override
    public View initView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public PoetryPresenter initPresenter() {
        return PoetryPresenter.getInstance();
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void onError(String result) {
        Toast.makeText(MyApplication.getContext(), result, Toast.LENGTH_SHORT).show();

    }

    @OnClick(R.id.btn_get_poetry)
    public void onViewClicked() {
        getPresenter().getPoetry();
    }

    @Override
    public void searchSuccess(String author) {
        tvPoetryAuthor.setText(author);
    }
}
