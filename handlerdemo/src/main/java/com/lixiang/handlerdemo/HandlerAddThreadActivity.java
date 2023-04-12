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

@SuppressWarnings("all")
public class HandlerAddThreadActivity extends AppCompatActivity {
    public static final String CURRENT_PROCESS_KEY = "CURRENT_PROCESS";
    private TextView mDisplayTv;
    private Handler mHandler;
    private ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_add_thread);
        TextView titleTv = findViewById(R.id.title_tv);
        titleTv.setText("Handler + Thread");

        mDisplayTv = findViewById(R.id.display_tv);
        mProgressBar = findViewById(R.id.test_handler_progress_bar);

        mHandler = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        mDisplayTv.setText("CustomChildThread starting!");
                        break;
                    case 2:
                        //获取进度条进度
                        Bundle bundle = msg.getData();
                        int process = bundle.getInt(CURRENT_PROCESS_KEY);
                        mProgressBar.setProgress(process);
                        break;
                    default:
                        break;
                }
            }
        };

        Button clickBtn = findViewById(R.id.click_btn);
        clickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomChildThread customChildThread = new CustomChildThread();
                customChildThread.start();
            }
        });

    }

    class CustomChildThread extends Thread {
        @Override
        public void run() {
            Message childThreadMessage = new Message();
            childThreadMessage.what = 1;
            mHandler.sendMessage(childThreadMessage);

            //模拟耗时操作
            for (int i = 1; i <= 100; i++) {
                try {
                    Thread.sleep(100);

                    Bundle bundle = new Bundle();
                    bundle.putInt(CURRENT_PROCESS_KEY, i);
                    Message progressBarProcessMsg = new Message();
                    progressBarProcessMsg.setData(bundle);
                    progressBarProcessMsg.what = 2;
                    mHandler.sendMessage(progressBarProcessMsg);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}