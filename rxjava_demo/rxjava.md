# RxJava
[学习地址](https://www.jianshu.com/p/0cd258eecf60)
[推荐demo地址](https://github.com/nanchen2251/RxJava2Examples)

步骤：

第一步：初始化 Observable

第二步：初始化 Observer

第三步：建立订阅关系 

---

## 线程切换
### subScribeOn
subscribeOn 用于指定 `subscribe()` 时所发生的线程

### observeOn
observeOn 方法用于指定下游 `Observer` 回调发生的线程。

----
- 简单地说，`subscribeOn()` 指定的就是发射事件的线程，`observerOn()` 指定的就是订阅者接收事件的线程。
- 多次指定发射事件的线程**只有第一次**指定的有效，也就是说多次调用 subscribeOn() 只有第一次的有效，其余的会被忽略。
- 但多次指定订阅者接收线程是可以的，也就是说**每调用一次 `observerOn()`，下游的线程就会切换一次**。

### 常见的
Schedulers.io() 代表io操作的线程, 通常用于网络,读写文件等io密集型的操作；

Schedulers.computation() 代表CPU计算密集型的操作, 例如需要大量计算的操作；

Schedulers.newThread() 代表一个常规的新线程；

AndroidSchedulers.mainThread() 代表Android的主线程

---
## 操作符
### map
```
map操作符可以将一个 Observable 对象通过某种关系转换为另一个Observable 对象

```

### concat
```
concat 可以做到不交错的发射两个甚至多个 Observable 的发射事件，并且只有前一个 Observable 终止(onComplete) 后才会订阅下一个 Observable。
```

当出现功能需要先做什么再做什么的时候就可以考虑使用该操作符
### flatMap

```
flatMap 操作符可以将一个发射数据的 Observable 变换为多个 Observables ，然后将它们发射的数据合并后放到一个单独的 Observable
```
**注意：    flatMap并不保证事件的顺序**




### zip
```
zip 操作符可以将多个 Observable 的数据结合为一个数据源再发射出去。
```
当两个或者多个流需要合并为一个流的时候，考虑使用该操作符。

自己使用过该操作符将两个操作流合入为最终的一个流(Jar、So)，最后将信息进行回传

### interval

```
interval 操作符可以将需要重复轮询任务或者定时多久执行的任务进行实现
```

自己使用过比如项目中会10min轮询获取数据