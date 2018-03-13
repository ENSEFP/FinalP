package rchs.rchs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainLed extends AppCompatActivity {


    private ImageView back_led;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_led);


        back_led();

    }

    public void back_led(){
        back_led = (ImageView) findViewById(R.id.back_led);
        back_led.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent0 = new Intent(MainLed.this, MainActivity.class);
                startActivity(intent0);
            }
        });
    }


}
