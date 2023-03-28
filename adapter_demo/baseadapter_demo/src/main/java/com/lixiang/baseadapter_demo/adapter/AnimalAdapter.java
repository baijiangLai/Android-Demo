package com.lixiang.baseadapter_demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lixiang.baseadapter_demo.R;
import com.lixiang.baseadapter_demo.bean.Animal;

import java.util.List;

/**
 * @author laibaijiang
 * @date 2023/3/27
 */
@SuppressWarnings("all")
public class AnimalAdapter extends BaseAdapter {

    private Context context;
    private List<Animal> data;

    public AnimalAdapter(Context context, List<Animal> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        //最后返回的视图
        //inflate()每次都要加载一次xml，其实这个convertView是系统提供给我们的可供服用的View的缓存对象
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_list_animal, parent, false);
            holder = new ViewHolder();
            holder.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
            holder.txt_aName = (TextView) convertView.findViewById(R.id.txt_aName);
            holder.txt_aSpeak = (TextView) convertView.findViewById(R.id.txt_aSpeak);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        //对应数据
        holder.img_icon.setBackgroundResource(data.get(position).getIcon());
        holder.txt_aName.setText(data.get(position).getName());
        holder.txt_aSpeak.setText(data.get(position).getSpeak());

        return convertView;
    }

    static class ViewHolder{
        ImageView img_icon;
        TextView txt_aName;
        TextView txt_aSpeak;
    }
}
