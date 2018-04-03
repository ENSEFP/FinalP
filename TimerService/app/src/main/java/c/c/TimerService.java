package c.c;

import android.app.IntentService;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by chenxiaojie on 2018-03-27.
 */

public class TimerService extends IntentService {
    public TimerService() {
        super("Timer Service");

    }

    String user_name = "sd";
    String pass_word = "fff";
    String typel = "login";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("timer", "Timer Service has Started.");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        return START_STICKY;
    }


    @Override
    protected void onHandleIntent(Intent intent) {

            ResultReceiver receiver = intent.getParcelableExtra("receiver");
            int time = intent.getIntExtra("time", 0);
            for (int i = 0; i < time; i++) {
                Log.i("timer", "i = " + i);
                Toast.makeText(this, "Hello" + i, Toast.LENGTH_SHORT).show();
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString("message", "Counting done...");

            receiver.send(1234, bundle);
    }
}

