package com.example.controlsystem;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

/**
 * @author tyd
 * @Description: TODO
 * @date 2018/3/26
 */

public class RxTimerUtil {

    private static Disposable mDisposable;

    /**
     * second秒后执行next操作
     *
     * @param second
     * @param next
     */
    public static void timer(long second, final IRxNext next) {
        Observable.timer(second, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        mDisposable = disposable;
                    }

                    @Override
                    public void onNext(@NonNull Long number) {
                        if (next != null) {
                            next.doNext(number);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if(next!=null){
                            next.onError(e);
                        }
                    }

                    @Override
                    public void onComplete() {
                        if(next!=null){
                            next.onComplete();
                        }
                    }
                });
    }

    /**
     * 每隔second秒后执行next操作
     *
     * @param second
     * @param next
     */
    public static void interval(long second, final IRxNext next) {
        if (next != null) {
            next.onStart();
        }
        Observable.interval(second, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        mDisposable = disposable;
                    }

                    @Override
                    public void onNext(@NonNull Long number) {
                        if (next != null) {
                            next.doNext(number);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        if(next!=null){
                            next.onError(e);
                        }
                    }

                    @Override
                    public void onComplete() {
                        if(next!=null){
                            next.onComplete();
                        }
                    }
                });
    }


    /**
     * 取消订阅
     */
    public static void cancel() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

    public abstract static class IRxNext {
        protected void onStart(){

        }
        protected abstract void doNext(long number);
        protected void onError(@NonNull Throwable e) {
            cancel();
        }
        protected void onComplete(){
            cancel();
        }
    }
}

