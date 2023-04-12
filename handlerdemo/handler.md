# Handler
Android不允许耗时任务在主线程中进行操作，规定只能由主线程才能处理UI。通过Handler通知主线程处理UI。

![handler]()

## sendMessage()
- 新建 Handler 对象，覆写 handleMessage(Message) 方法。
```java
//创建 Handler对象，并关联主线程消息队列
mHandler = new Handler(Looper.getMainLooper()) {
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
            ···略···
        }
    }
};
```
- 新建 Message 对象，设置其携带的数据。
```java
Bundle bundle = new Bundle();
bundle.putInt(CURRENT_PROCESS_KEY, i);
Message msg = new Message();
msg.setData(bundle);
msg.what = 2;
```
- 在子线程中通过 Handler.sendMessage(Message) 方法发送信息。
```java
mHandler.sendMessage(msg)
```
- 在 Handler 的 handleMessage(Message msg) 方法中处理消息，通知主线程作出相对应的 UI 工作。
```java
mHandler = new Handler(Looper.getMainLooper()) {
@Override
public void handleMessage(Message msg) {
        super.handleMessage(msg);
        //根据信息编码及数据做出相对应的处理
        switch (msg.what) {
        case 1:
        //更新 TextView UI
        mDisplayTv.setText("CustomChildThread starting!");
        break;
        case 2:
        //获取 ProgressBar 的进度，然后显示进度值
        Bundle bundle = msg.getData();
        int process = bundle.getInt(CURRENT_PROCESS_KEY);
        mProgressBar.setProgress(process);
        break;
default:
        break;
        }
        }
        };
```


## post()
Handler还支持post(Runnable)方法传递消息，通知主线程做出相对应的UI工作。
```java
/**
 * 将可运行的 Runnable 添加到消息队列。Runnable 将在该 Handler 相关的线程上运行处理。
 * The runnable will be run on the thread to which this handler is attached.
 */
new Handler().post(new Runnable() {
    @Override
    public void run() {
        //更新处理 UI 工作
    }
});
```

## obtainMessage()
obtainMessage() 方法与 sendMessage() 方法很相似，通过 mHandler.obtainMessage().sendToTarget() 发送信息。

该方法与 sendMessage() 的区别就是你不用额外去创建一个 Message 对象。

```java
//指定 what 用于区分，通过 Message.what 获得
public final Message obtainMessage(int what);

//传递obj参数，通过 Message.obj 获得
public final Message obtainMessage(int what, @Nullable Object obj)

//传递arg1 arg2参数，通过 Message.arg1 Message.arg2 获得
public final Message obtainMessage(int what, int arg1, int arg2)
```