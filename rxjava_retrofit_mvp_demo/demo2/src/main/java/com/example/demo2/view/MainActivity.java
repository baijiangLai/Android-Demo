package com.example.demo2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo2.R;
import com.example.demo2.presenter.IPresenter;
import com.example.demo2.presenter.MobilePresenter;

public class MainActivity extends AppCompatActivity implements IView{

    private Button btnSubmit;
    private EditText inputText;
    private TextView resText;
    private MobilePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        mPresenter = new MobilePresenter(this);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getMobileInformation();
            }
        });
    }

    private void initView() {
        btnSubmit = findViewById(R.id.btn_query);
        inputText = findViewById(R.id.edit_mobile);
        resText = findViewById(R.id.tv_city);
    }

    @Override
    public String getInput() {
        return inputText.getText().toString();
    }

    @Override
    public void setCity(String city) {
        resText.setText(city);
    }
}