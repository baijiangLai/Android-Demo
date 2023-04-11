package com.lixiang.rxjava_retrofit_mvp_demo.view;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lixiang.rxjava_retrofit_mvp_demo.R;
import com.lixiang.rxjava_retrofit_mvp_demo.base.BaseMvpActivity;
import com.lixiang.rxjava_retrofit_mvp_demo.base.MyApplication;
import com.lixiang.rxjava_retrofit_mvp_demo.contract.IPoetryContract;
import com.lixiang.rxjava_retrofit_mvp_demo.presenter.PoetryPresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseMvpActivity<MainActivity, PoetryPresenter> implements IPoetryContract.IPoetryView {

    @BindView(R.id.btn_get_poetry)
    Button btnGetPoetry;
    @BindView(R.id.tv_poetry_author)
    TextView tvPoetryAuthor;
//    @BindView(R.id.btn_goto_fragment)
//    Button btnGotoFragment;
//    @BindView(R.id.ll)
//    LinearLayout ll;

    @Override
    protected void initViews() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected PoetryPresenter createPresenter() {
        return PoetryPresenter.getInstance();
    }

    @Override
    public void searchSuccess(String author) {
        tvPoetryAuthor.setText(author);
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

    @OnClick({R.id.btn_get_poetry})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get_poetry:
                getPresenter().getPoetry();
                break;
            default:
                break;
        }
    }
}