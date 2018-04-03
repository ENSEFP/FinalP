package com.example.fpapp.Activities;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.fpapp.R;


public class MainPage extends AppCompatActivity {

    private TextView textViewName;

    int count=0;

    private ImageView led, fan, configuration, lock, view_s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        textViewName = (TextView) findViewById(R.id.name);
        String nameFromIntent = getIntent().getStringExtra("EMAIL");
        textViewName.setText("Welcome");


        //Thread for notification
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

                                if((count % 8) == 0){
                                    //sendNotification ();
                                    sendSomething();
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


        led();
        fan();
        configuration();
        lock();
        view_s();
    }

    public void led(){
        led = (ImageView) findViewById(R.id.led);
        led.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent0 = new Intent(MainPage.this, MainLed.class);
                startActivity(intent0);
            }
        });
    }

    public void fan(){
        fan = (ImageView) findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent1 = new Intent(MainPage.this, MainFan.class);
                startActivity(intent1);
            }
        });
    }

    public void configuration(){
        configuration = (ImageView) findViewById(R.id.configuration);
        configuration.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent2 = new Intent(MainPage.this, MainConfiguration.class);
                startActivity(intent2);
            }
        });
    }

    public void lock(){
        lock = (ImageView) findViewById(R.id.lock);
        lock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent3 = new Intent(MainPage.this, MainLock.class);
                startActivity(intent3);
            }
        });
    }

    public void view_s(){
        view_s = (ImageView) findViewById(R.id.view_s);
        view_s.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent3 = new Intent(MainPage.this, MainView.class);
                startActivity(intent3);
            }
        });
    }


    public void sendSomething(){
        String username = "hhh";
        String password = "jjj";
        String type = "login";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, username, password);
    }

}

