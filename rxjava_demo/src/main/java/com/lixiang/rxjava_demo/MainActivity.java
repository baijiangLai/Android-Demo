package com.lixiang.rxjava_demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

@SuppressWarnings("all")
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "RxJavaMainActivity";
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private StringBuffer buffer = new StringBuffer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        btn4 = findViewById(R.id.btn4);
        btn4.setOnClickListener(this);

        btn5 = findViewById(R.id.btn5);
        btn5.setOnClickListener(this);

        btn6 = findViewById(R.id.btn6);
        btn6.setOnClickListener(this);

        btn7 = findViewById(R.id.btn7);
        btn7.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                rxjavaInit();
                break;
            case R.id.btn2:
                threadSwitch();
                break;
            case R.id.btn3:
                map();
                break;
            case R.id.btn4:
                concat();
                break;
            case R.id.btn5:
                flatmap();
                break;
            case R.id.btn6:
                zip();
                break;
            case R.id.btn7:
                interval();
                break;
        }
    }

    private void flatmap() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                        e.onNext(1);
                        e.onNext(2);
                        e.onNext(3);
                    }
                })
                .flatMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(@NonNull Integer integer) throws Exception {
                        List<String> list = new ArrayList<>();
                        for (int i = 0; i < 3; i++) {
                            list.add("I am value " + integer);
                        }
                        int delayTime = (int) (1 + Math.random() * 10);
                        return Observable.fromIterable(list).delay(delayTime, TimeUnit.MILLISECONDS);
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        Log.e(TAG, "flatMap : accept : " + s + "\n");
                    }
                });
    }

    private void interval() {
        Observable.interval(3, 2, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()) // 由于interval默认在新线程，所以我们应该切回主线程
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(@NonNull Long aLong) throws Exception {
                        Log.e(TAG, "interval :" + aLong + " at " + TimeUtil.getNowStrTime() + "\n");
                    }
                });
    }

    private void zip() {
        Observable.zip(getStringObservable()
                        , getIntegerObservable()
                        , new BiFunction<String, Integer, String>() {
                            @Override
                            public String apply(@NonNull String s, @NonNull Integer integer) throws Exception {
                                return s + integer;
                            }
                        })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
//                        buffer.append("zip : accept : " + s + "\n");
                        Log.e(TAG, "zip : accept : " + s + "\n");
                    }
                });
    }

    private Observable<String> getStringObservable() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                if (!e.isDisposed()) {
                    Log.e(TAG, "String emit : A \n");
                    e.onNext("A");
//                    buffer.append("String emit : A \n");

                    Log.e(TAG, "String emit : B \n");
                    e.onNext("B");
//                    buffer.append("String emit : B \n");

                    Log.e(TAG, "String emit : C \n");
                    e.onNext("C");
//                    buffer.append("String emit : C \n");

                    Log.e(TAG, "String emit : D \n");
                    e.onNext("D");
//                    buffer.append("String emit : D \n");

                    Log.e(TAG, "String emit : E \n");
                    e.onNext("E");
//                    buffer.append("String emit : E \n");
                }
            }
        });
    }

    private Observable<Integer> getIntegerObservable() {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                if (!e.isDisposed()) {
                    Log.e(TAG, "Integer emit : 1 \n");
                    e.onNext(1);
//                    buffer.append("Integer emit : 1 \n");

                    Log.e(TAG, "Integer emit : 2 \n");
                    e.onNext(2);
//                    buffer.append("Integer emit : 2 \n");

                    Log.e(TAG, "Integer emit : 3 \n");
                    e.onNext(3);
//                    buffer.append("Integer emit : 3 \n");

                    Log.e(TAG, "Integer emit : 4 \n");
                    e.onNext(4);
//                    buffer.append("Integer emit : 4 \n");

                    Log.e(TAG, "Integer emit : 5 \n");
                    e.onNext(5);
//                    buffer.append("Integer emit : 5 \n");
                }
            }
        });
    }

    private void concat() {
        Observable<Integer> source1 = Observable.just(1, 2, 3);
        Observable<Integer> source2 = Observable.just(4, 5, 6);
        Observable.concat(source1, source2)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.i(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i(TAG, "onError: " + e);
                    }

                    @Override
                    public void onComplete() {
                        Log.i(TAG, "onComplete: ");
                    }
                });
    }

    private void map() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(@NonNull Integer integer) throws Exception {
                return "This is result " + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                buffer.append("accept : " + s + "\n");
                Log.e(TAG, "accept : " + s + "\n");
            }
        });
    }

    private void threadSwitch() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                        Log.e(TAG, "Observable thread is : " + Thread.currentThread().getName());
                        e.onNext(1);
                        e.onComplete();
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())

                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        Log.e(TAG, "After observeOn(mainThread)，Current thread is " + Thread.currentThread().getName());
                    }
                })

                .observeOn(Schedulers.io())
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        Log.e(TAG, "After observeOn(io)，Current thread is " + Thread.currentThread().getName());
                    }
                });
    }

    private void rxjavaInit() {
        Observable.create(new ObservableOnSubscribe<Integer>() { // 第一步：初始化Observable
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                Log.e(TAG, "Observable emit 1" + "\n");
                e.onNext(1);
                Log.e(TAG, "Observable emit 2" + "\n");
                e.onNext(2);
                Log.e(TAG, "Observable emit 3" + "\n");
                e.onNext(3);
                e.onComplete();
                Log.e(TAG, "Observable emit 4" + "\n");
                e.onNext(4);
            }
        }).subscribe(new Observer<Integer>() { // 第三步：订阅

            // 第二步：初始化Observer
            private int i;
            private Disposable mDisposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.i(TAG, "onNext: value: " + integer);
                i++;
                if (i == 2) {
                    // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
                    mDisposable.dispose();
                    Log.i(TAG, "onNext : isDisposable :" + mDisposable);
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG, "onError : value : " + e.getMessage() + "\n");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete" + "\n");
            }
        });
    }
}