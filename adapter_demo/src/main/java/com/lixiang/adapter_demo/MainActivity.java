package com.lixiang.adapter_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
@SuppressWarnings("all")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //要显示的数据
        String[] strs = {"基神","B神","翔神","曹神","J神"};
        //创建ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_expandable_list_item_1, strs);
        //获取ListView对象，通过调用setAdapter方法为ListView设置Adapter设置适配器
        ListView list_test = (ListView) findViewById(R.id.list_test);
        list_test.setAdapter(adapter);
    }
}