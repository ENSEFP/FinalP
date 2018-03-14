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


    private ImageView back_led, open_bedroom, close_bedroom, open_living_room, close_living_room, open_kitchen, close_kitchen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_led);

        back_led();
        open_bedroom_led();
        close_bedroom_led();
        open_living_led();
        close_living_led();
        open_kitchen_led();
        close_kitchen_led();


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

    public void open_bedroom_led(){
        open_bedroom = (ImageView) findViewById(R.id.bedroom_open);
        open_bedroom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent1 = new Intent(MainLed.this, MainLedBedroomOpen.class);
                startActivity(intent1);
            }
        });
    }

    public void close_bedroom_led(){
        close_bedroom = (ImageView) findViewById(R.id.bedroom_close);
        close_bedroom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent2 = new Intent(MainLed.this, MainLedBedroomClose.class);
                startActivity(intent2);
            }
        });
    }

    public void open_living_led(){
        open_living_room = (ImageView) findViewById(R.id.living_room_open);
        open_living_room.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent3 = new Intent(MainLed.this, MainLedLivingRoomOpen.class);
                startActivity(intent3);
            }
        });
    }

    public void close_living_led(){
        close_living_room = (ImageView) findViewById(R.id.living_room_close);
        close_living_room.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent4 = new Intent(MainLed.this, MainLedLivingRoomClose.class);
                startActivity(intent4);
            }
        });
    }

    public void open_kitchen_led(){
        open_kitchen = (ImageView) findViewById(R.id.kitchen_open);
        open_kitchen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent5 = new Intent(MainLed.this, MainLedKitchenOpen.class);
                startActivity(intent5);
            }
        });
    }

    public void close_kitchen_led(){
        close_kitchen = (ImageView) findViewById(R.id.kitchen_close);
        close_kitchen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent6 = new Intent(MainLed.this, MainLedKitchenClose.class);
                startActivity(intent6);
            }
        });
    }


}
