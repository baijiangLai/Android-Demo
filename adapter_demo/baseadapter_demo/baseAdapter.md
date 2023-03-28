# baseAdapter总结
步骤：
1. 创建实体对象
2. 创建对应xml文件，例如：
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal">

    <!-- 定义一个用于显示头像的ImageView -->
    <ImageView
        android:id="@+id/img_icon"
        android:layout_width="64dp"
        android:layout_height="64dp"
        android:baselineAlignBottom="true"
        android:paddingLeft="8dp" />

    <!-- 定义一个竖直方向的LinearLayout,把QQ呢称与说说的文本框设置出来 -->
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical">

        <TextView
            android:id="@+id/txt_aName"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingLeft="8dp"
            android:textColor="#1D1D1C"
            android:textSize="20sp" />

        <TextView
            android:id="@+id/txt_aSpeak"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:paddingLeft="8px"
            android:textColor="#B4B4B9"
            android:textSize="14sp" />

    </LinearLayout>

</LinearLayout>
```
3. 创建对应的adapter继承BaseAdapter
   1. 最重要就是方法`getView(int position, View convertView, ViewGroup parent)`，在该方法中`convertView`是最终要返回的视图
   ```java
   convertView = LayoutInflater.from(context).inflate(R.layout.item_list_animal,parent,false);
   ```
   2. 将所有的数据进行对应以及设置
   3. 返回`convertView`
4. 最后进行视图展示
```java
listView.setAdapter(adapter);
```

# 模板
界面上有多少个Item，那么getView方法就会被调用多少次！

inflate()每次都要加载一次xml，其实这个convertView是系统提供给我们的可供服用的View 的缓存对象

getView()会被调用多次，那么findViewById不一样得调用多次，而我们的ListView的Item 一般都是一样的布局，我们可以对这里在优化下，我们可以自己定义一个ViewHolder类来对这一部分 进行性能优化！

1. 需要自定义一个ViewHolder(其成员属性与自定义xml文件中的一致)
2. 在`getView()`的时候对convertView进行判断
```java
ViewHolder holder = null;
    if(convertView == null){
        convertView=LayoutInflater.from(mContext).inflate(R.layout.item_list_animal,parent,false);
        holder=new ViewHolder();
        ...
    } else {
        holder = (ViewHolder) convertView.getTag();
    }
```

## 出现的bug
在AnimalAdapter中，向下滑动页面的时候，会出现空指针的异常
```java
java.lang.NullPointerException: Attempt to read from field 'android.widget.ImageView com.lixiang.baseadapter_demo.adapter.AnimalAdapter$ViewHolder.img_icon' on a null object reference
```

经过debug后发现：
缺少`convertView.setTag(holder);`，[相关链接](https://blog.csdn.net/weixin_30387339/article/details/95266350)