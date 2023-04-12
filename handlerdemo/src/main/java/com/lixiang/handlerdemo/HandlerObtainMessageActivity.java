package com.lixiang.handlerdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class HandlerObtainMessageActivity extends AppCompatActivity {
    private TextView mDisplayTv;
    private Handler mHandler;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_obtain_message);

        TextView titleTv = findViewById(R.id.title_tv);
        titleTv.setText("Handler + Thread");

        mDisplayTv = findViewById(R.id.display_tv);
        mProgressBar = findViewById(R.id.test_handler_progress_bar);

        mHandler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        //更新 TextView UI
                        mDisplayTv.setText("Handler obtainMessage() Test!!");
                        break;
                    case 2:
                        //更新进度条
                        int process = (int) msg.obj;
                        mProgressBar.setProgress(process);
                        break;
                }
            }
        };

        Button clickBtn = findViewById(R.id.click_btn);
        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myThread myThread = new myThread();
                myThread.start();
            }
        });
    }


    class myThread extends Thread {
        @Override
        public void run() {

            //发送第一条消息，开始执行异步任务
            mHandler.obtainMessage(1).sendToTarget();

            //模拟耗时任务
            for (int i = 0; i < 101; i++) {
                try {
                    Thread.sleep(100);
                    mHandler.obtainMessage(2,i).sendToTarget();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}