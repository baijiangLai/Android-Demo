# MVP是什么
1. 全称：Model-View-Presenter
2. Model:数据处理部分
3. Presenter:逻辑处理部分
4. View:界面显示部分

## 结构图
![结构图](https://github.com/baijiangLai/Android-Demo/blob/master/images/mvp/mvp.png)


# 总结
因为自己最近做的一个项目中第一次使用到mvp的架构，组内同事给讲了一下为什么要使用mvp，意思很简单，在P层将所有的数据进行封装处理好之后，
最后将数据发送给V层，这样如果之后接口改动或者其他什么因素需要更改代码，那么之后P层代码需要更改。
如果在P层不做任何逻辑处理，那么之后接口改动之后，所有的代码都将进行一次更改(累死)