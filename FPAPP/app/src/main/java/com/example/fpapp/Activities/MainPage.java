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

    private ImageView led, fan, configuration, lock;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        textViewName = (TextView) findViewById(R.id.name);
        String nameFromIntent = getIntent().getStringExtra("EMAIL");
        textViewName.setText("Welcome");

        led();
        fan();
        configuration();
        lock();
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


}

