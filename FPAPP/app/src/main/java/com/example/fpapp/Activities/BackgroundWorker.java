package com.example.fpapp.Activities;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import com.example.fpapp.R;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by chenxiaojie on 2018-04-02.
 */

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    private Notification notification;
    private NotificationManager notificationManager;



    BackgroundWorker(Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "http://192.168.4.2/esp/notification.php";
        if(true) {
            try {
                String user_name = params[1];
                String password = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("user_name","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&"
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
//        alertDialog = new AlertDialog.Builder(context).create();
//        alertDialog.setTitle("Login Statusa");

        //Log.i("iii", "hhhh");

    }

    @Override
    protected void onPostExecute(String result) {
//        alertDialog.setMessage(result);
//        alertDialog.show();
        //Log.i("iii", "hhhh111");
        //Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
        Log.i("iii", "hhhh111");
        if(result == null){
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
        }else if(Integer.parseInt(result) == 1){
            sendNotification(result);
        }


    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }


    public void sendNotification (String result){
        //Log.i("iii", "hhhh");
        notification = new Notification.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)//设置小图标
                .setContentTitle("任务结果")
                .setContentText("Hello World " + result)
                .build();
        //PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, new Intent(this, MainActivity.class), 0);
        //notification.contentIntent = pendingIntent;
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }

}

