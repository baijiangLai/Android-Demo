package com.lixiang.withcheckbox_demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lixiang.withcheckbox_demo.R;
import com.lixiang.withcheckbox_demo.bean.Person;

import java.util.List;

/**
 * @author laibaijiang
 * @date 2023/3/28
 */
public class ContactListAdapter extends BaseAdapter implements CompoundButton.OnCheckedChangeListener{

    private List<Person> mData;
    private Context mContext;

    public ContactListAdapter(List<Person> data, Context context) {
        mData = data;
        mContext = context;
    }

    // 定义一个刷新数据的方法
    public void changeData(List<Person> data) {
        mData = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Person getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int index = position;
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.item_contact, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.ly = (RelativeLayout) convertView
                    .findViewById(R.id.lyContactListItem);
            viewHolder.txtName = (TextView) convertView
                    .findViewById(R.id.txtName);
            viewHolder.txtNumber = (TextView) convertView
                    .findViewById(R.id.txtNumber);
            viewHolder.cbxStatus = (CheckBox) convertView
                    .findViewById(R.id.cbxStatus);
            convertView.setTag(viewHolder);
            viewHolder.cbxStatus.setTag(index);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.cbxStatus.setOnCheckedChangeListener(this);
        viewHolder.cbxStatus.setChecked(mData.get(position).getCheckStatus());
        viewHolder.txtName.setText(mData.get(index).getName());
        viewHolder.txtNumber.setText(mData.get(index).getNumber());
        return convertView;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int index = (int)buttonView.getTag();
        if (isChecked)
            mData.get(index).setCheckStatus(true);
        else
            mData.get(index).setCheckStatus(false);
    }


    private class ViewHolder {
        RelativeLayout ly;
        TextView txtName;
        TextView txtNumber;
        CheckBox cbxStatus;
    }
}
