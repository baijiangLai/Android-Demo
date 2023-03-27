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