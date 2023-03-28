package com.lixiang.withcheckbox_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.lixiang.withcheckbox_demo.adapter.ContactListAdapter;
import com.lixiang.withcheckbox_demo.bean.Person;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Person> mData = null;
    private Context mContext;
    private ContactListAdapter mAdapter = null;
    private ListView list_item;

    private LinearLayout ly_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;
        list_item = (ListView) findViewById(R.id.item_contact);

        //动态加载顶部View和底部View
//        final LayoutInflater inflater = LayoutInflater.from(this);
//        View headView = inflater.inflate(R.layout.view_header,null,false);
//        View footView = inflater.inflate(R.layout.view_footer, null, false);


        mData = new LinkedList<>();
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));
        mData.add(new Person("狗说", "1"));


        //添加表头和表尾需要写在setAdapter方法调用之前！！！
//        list_animal.addHeaderView(headView);
//        list_animal.addFooterView(footView);

        mAdapter = new ContactListAdapter((LinkedList<Person>) mData, mContext);
        list_item.setAdapter(mAdapter);
    }
}