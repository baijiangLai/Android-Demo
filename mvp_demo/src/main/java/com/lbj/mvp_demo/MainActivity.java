package com.lbj.mvp_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

@SuppressWarnings("all")
public class MainActivity extends AppCompatActivity implements IView{

    private Button btnSubmit;
    private EditText inputText;
    private TextView resText;
    private IPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();
    }

    private void initData() {
        mPresenter = new Presenter(this);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.search();
            }
        });
    }

    private void initView() {
        btnSubmit = findViewById(R.id.btn_submit);
        inputText = findViewById(R.id.edit_query);
        resText = findViewById(R.id.text_res);
    }

    @Override
    public String getInputString() {
        return inputText.getText().toString();
    }

    @Override
    public void setResultString(String string) {
        resText.setText(string);
    }
}