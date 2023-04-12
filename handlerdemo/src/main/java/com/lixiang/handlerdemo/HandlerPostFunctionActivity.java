package com.lixiang.handlerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class HandlerPostFunctionActivity extends AppCompatActivity {
    private Handler mHandler;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_post_function);

        TextView titleTv = findViewById(R.id.title_tv);
        titleTv.setText("Handler post() function");

        mProgressBar = findViewById(R.id.test_handler_progress_bar);

        mHandler = new Handler(getMainLooper());

        Button clickBtn = findViewById(R.id.click_btn);
        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //开启子线程，子线程处理UI工作
                ChildThread childThread = new ChildThread();
                childThread.start();
            }
        });
    }

    //子线程

    class ChildThread extends Thread {
        @Override
        public void run() {

            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(100);
                    MyRunnable runnable = new MyRunnable(HandlerPostFunctionActivity.this, i);
                    //post
                    mHandler.post(runnable);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    class MyRunnable implements Runnable {

        private int progressBarValue;
        private WeakReference<HandlerPostFunctionActivity> mWeakReference;


        public MyRunnable(HandlerPostFunctionActivity activity, int value) {
            this.progressBarValue = value;
            this.mWeakReference = new WeakReference<>(activity);
        }

        @Override
        public void run() {
            HandlerPostFunctionActivity activity = mWeakReference.get();
            if (activity != null && !activity.isFinishing()) {
                activity.mProgressBar.setProgress(progressBarValue);
            }
        }
    }

}