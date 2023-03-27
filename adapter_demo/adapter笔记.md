# adapter
1. adapter翻译过来就是适配器，作用：帮助填充数据的中间桥梁。
简单理解：将各种数据以合适的形式显示到view上,提供给用户看！(展示数据的位置)
2. BaseAdapter：抽象类，实际开发中我们会继承这个类并且重写相关方法，用得最多的一个Adapter！

## MVC
1. 全称：Model-View-Controller 
2. Model(数据) ---> Controller(以什么方式显示到)---> View(用户界面)
3. Model：通常可以理解为数据,负责执行程序的核心运算与判断逻辑,,通过view获得用户 输入的数据,然后根据从数据库查询相关的信息,最后进行运算和判断,再将得到的结果交给view来显示
4. view:用户的操作接口,说白了就是GUI,应该使用哪种接口组件,组件间的排列位置与顺序都需要设计
5. Controller:控制器,作为model与view之间的枢纽,负责控制程序的执行流程以及对象之间的一个互动

### MVC结构图
![mvc结构图](https://github.com/baijiangLai/Android-Demo/blob/master/images/mvc/mvc.png)

adapter的位置就处于controller的地方


## Adapter结构图
![adapter结构图](https://github.com/baijiangLai/Android-Demo/blob/master/images/adapter/adapter.png)


# 总结
## 直接使用给出的adapter(ArrayAdapter、SimpleAdapter)
步骤：
1. 创建xxx.xml文件，在里面设计好布局
2. 在activity_main.xml文件中直接使用设计好的xxx.xml(布局文件)
```xml
    <ListView
        android:id="@+id/list_test"
        android:layout_height="match_parent"
        android:layout_width="match_parent"
        android:entries="@array/myarray"/>
```
3. 代码中将数据与adapter进行关联：
```java
        ListView listView = (ListView) findViewById(R.id.list_test);
        listView.setAdapter(myAdapter);
```
4. 创建对应的adapter，同时将数据设置进去