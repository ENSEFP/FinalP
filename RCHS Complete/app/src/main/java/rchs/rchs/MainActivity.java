package rchs.rchs;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ImageView led, fan, configuration, lock, view_s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Intent intent0 = new Intent(MainActivity.this, MainLed.class);
                startActivity(intent0);
            }
        });
    }

    public void fan(){
        fan = (ImageView) findViewById(R.id.fan);
        fan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent1 = new Intent(MainActivity.this, MainFan.class);
                startActivity(intent1);
            }
        });
    }

    public void configuration(){
        configuration = (ImageView) findViewById(R.id.configuration);
        configuration.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent2 = new Intent(MainActivity.this, MainConfiguration.class);
                startActivity(intent2);
            }
        });
    }

    public void lock(){
        lock = (ImageView) findViewById(R.id.lock);
        lock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent3 = new Intent(MainActivity.this, MainLock.class);
                startActivity(intent3);
            }
        });
    }

    public void view_s(){
        view_s = (ImageView) findViewById(R.id.view_s);
        view_s.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent3 = new Intent(MainActivity.this, MainView.class);
                startActivity(intent3);
            }
        });
    }


}

