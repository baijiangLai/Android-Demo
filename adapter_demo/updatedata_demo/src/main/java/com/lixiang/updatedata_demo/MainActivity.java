package com.lixiang.updatedata_demo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lixiang.updatedata_demo.adapter.MyAdapter;
import com.lixiang.updatedata_demo.bean.Data;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ListView list_one;
    private TextView txt_empty;
    private Button btn_add;
    private Button btn_add_to_5th;
    private Button btn_remove;
    private Button btn_clear;
    private MyAdapter mAdapter = null;
    private List<Data> mData = null;
    private Context mContext = null;
    private int flag = 1;
    private Data mData_5 = null;   //用来临时放对象的

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        mData = new LinkedList<>();
        mAdapter = new MyAdapter((LinkedList<Data>) mData,mContext);
        bindViews();

    }

    private void bindViews(){

        list_one = (ListView) findViewById(R.id.list_one);
        txt_empty = (TextView) findViewById(R.id.txt_empty);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add_to_5th = (Button) findViewById(R.id.btn_add_to_5th);
        btn_remove = (Button) findViewById(R.id.btn_remove2);
        btn_clear = (Button) findViewById(R.id.btn_clear);

        txt_empty.setText("暂无数据~");

        list_one.setAdapter(mAdapter);
        list_one.setEmptyView(txt_empty);
        btn_add.setOnClickListener(this);
        btn_add_to_5th.setOnClickListener(this);
        btn_remove.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
    }


    private void updateListItem(int postion,Data mData){
        int visiblePosition = list_one.getFirstVisiblePosition();
        View v = list_one.getChildAt(postion - visiblePosition);
        ImageView img = (ImageView) v.findViewById(R.id.img_icon);
        TextView tv = (TextView) v.findViewById(R.id.txt_content);
        img.setImageResource(mData.getImgId());
        tv.setText(mData.getContext());
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                if(flag == 5){
                    mData_5 = new Data(R.mipmap.ic_icon_qitao,"给猪哥跪了~~~ x " + flag);
                    mAdapter.add(mData_5);
                }else{
                    mAdapter.add(new Data(R.mipmap.ic_icon_qitao,"给猪哥跪了~~~ x " + flag));
                }
                flag++;
                break;
            case R.id.btn_add_to_5th:
                //position从0开始算的
                mAdapter.add(4,new Data(R.mipmap.ic_icon_qitao,"在第五列给猪哥跪了~~~ x " + flag));
                flag++;
                break;
            case R.id.btn_remove2:
                if (mData.isEmpty()){
                    return;
                }
                mAdapter.remove(mData.size() - 1);
                break;
            case R.id.btn_clear:
                mAdapter.clear();
                break;
        }
    }
}