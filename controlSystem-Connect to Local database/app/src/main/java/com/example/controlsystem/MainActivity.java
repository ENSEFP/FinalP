package com.example.controlsystem;


import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    EditText UsernameEt, PasswordEt;


    Context context = this;
    AlertDialog alertDialog;

    private Timer timerAsync;
    private TimerTask timerTaskAsync;
    private String username;
    private String password;
    private String type;
    /**
     * 网络访问
     */
    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsernameEt = (EditText) findViewById(R.id.etUserName);
        PasswordEt = (EditText) findViewById(R.id.etPassword);


//        Intent i = new Intent(this, MyService.class);
//        startService(i);


//        Toast.makeText(this, "Job Scheduled...",Toast.LENGTH_SHORT).show();
//        Log.i("MyService", "Serverisdsd000");
//        alertDialog.setMessage("hhhl");
//        alertDialog.show();
//        Thread thread = new Thread(new Runnable(){
//            @Override
//            public void run(){
//            }
//        });
//        thread.start();

        //轮询任务
        retrofit = initRetrofit();
        intervalJob();

    }

    /**
     * 初始化请求
     */
    private Retrofit initRetrofit() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.writeTimeout(20, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.connectTimeout(20, TimeUnit.SECONDS);
        OkHttpClient client = builder.build();
        Retrofit.Builder retrofitBuilder = new Retrofit.Builder();
        //        http://192.168.2.45:9999/ 这个是你服务器地址和端口号
        retrofitBuilder.baseUrl("http://192.168.2.45:9090/");
        retrofitBuilder.client(client);
        retrofitBuilder.addConverterFactory(GsonConverterFactory.create());
        retrofitBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync());
        return retrofitBuilder.build();
    }

    /**
     * 每隔1秒发送一次请求
     */
    private void intervalJob() {
        RxTimerUtil.interval(5, new RxTimerUtil.IRxNext() {
            @Override
            protected void doNext(long number) {
                Log.d("执行任务", "第" + number + "次");
                Toast.makeText(MainActivity.this, "执行任务" + "第" + number + "次", Toast.LENGTH_SHORT).show();
//                sendRequest();   //测试用的接口
                login(UsernameEt.getText().toString(), PasswordEt.getText().toString());
            }
        });
    }

    /***
     * 登陆可以用这个接口
     *
     * @param username
     * @param password
     */
    private void login(String username, String password) {
        retrofit.create(ApiService.class).login(username, password)
                .subscribeOn(Schedulers.io()) //网络请求工作在子线程
                .unsubscribeOn(Schedulers.io()) //在子线程解除任务绑定
                .observeOn(AndroidSchedulers.mainThread()) //切换到主线程进行UI操作
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ResponseBody body) {
                        String s = null;
                        try {
                            s = body.string().toString();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        notifyUser(s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        notifyUser("账户信息出错了。");
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    //发起请求
    private void sendRequest() {
        retrofit.create(ApiService.class).getAuthorModel()
                .subscribeOn(Schedulers.io()) //网络请求工作在子线程
                .unsubscribeOn(Schedulers.io()) //在子线程解除任务绑定
                .observeOn(AndroidSchedulers.mainThread()) //切换到主线程进行UI操作
                .subscribe(new Observer<Meizi>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //请求开始
                    }

                    @Override
                    public void onNext(Meizi s) {
                        //判断数据，如果成功
                        notifyUser(s.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        //失败处理
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        //请求结束
                    }
                });
    }

    private void notifyUser(String s) {
        Log.d("获取到的数据", s);
        Toast.makeText(this, "任务结果：" + s, Toast.LENGTH_SHORT).show();
    }


    public void OnLogin(View view) {
        username = UsernameEt.getText().toString();
        password = PasswordEt.getText().toString();
        type = "login";
        final Handler handler = new Handler();
        timerAsync = new Timer();
        timerTaskAsync = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        try {
                            BackgroundWorker backgroundWorker = new BackgroundWorker(context);
                            backgroundWorker.execute(type, username, password);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        };
        timerAsync.schedule(timerTaskAsync, 0, 4000);


    }


}