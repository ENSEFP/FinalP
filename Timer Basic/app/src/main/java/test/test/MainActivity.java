package test.test;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    int count=0;
    private Notification notification;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView=(TextView)findViewById(R.id.textView);



        Thread t = new Thread(){
            @Override
            public void run() {
                while(!isInterrupted()){
                    try{
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                count++;
                                textView.setText(String.valueOf(count));

                                if((count % 8) == 0){
                                    sendNotification();
                                }

                            }
                        });
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();

    }

    public void sendNotification (){
        Log.i("iii", "Hello");
        notification = new Notification.Builder(MainActivity.this)
                .setSmallIcon(R.mipmap.ic_launcher)//设置小图标
                .setContentTitle("任务结果")
                .setContentText("hihwoo")
                .build();
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, new Intent(this, MainActivity.class), 0);
        notification.contentIntent = pendingIntent;
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(0, notification);
    }
}
