package com.example.controlsystem;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class MyService extends Service {

    String username = "h";
    String password = "s";
    String type = "login";
    String login_url = "http://192.168.4.2/esp/notification.php";

    Context context = this;
    AlertDialog alertDialog;


    public MyService() {
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            //Log.i("MyService", "Serverisdsd000");
            //Toast.makeText(context, "OnStartCommand...",Toast.LENGTH_SHORT).show();
            alertDialog.setMessage("hhhl");
            alertDialog.show();
        }

    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Toast.makeText(this, "OnStartCommand...",Toast.LENGTH_SHORT).show();

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++){
                    long futureTime = System.currentTimeMillis() + 1000;
                    while(System.currentTimeMillis() < futureTime){
                        synchronized(this){
                            try{

                                Log.i("MyService", "Serverisdsd");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        handler.sendEmptyMessage(0);
                    }

                }
            }
        };

        Thread buckysThread = new Thread(r);
        buckysThread.start();
        return Service.START_STICKY;
    }


    @Override
    public void onDestroy() {
        Toast.makeText(this, "OnDestroy...",Toast.LENGTH_SHORT).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return  null;
    }
}
