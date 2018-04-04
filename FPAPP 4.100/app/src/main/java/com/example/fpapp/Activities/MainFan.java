package com.example.fpapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import com.example.fpapp.R;

public class MainFan extends AppCompatActivity {


    private ImageView back_fan, level0, level1, level2, level3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fan);

        back_fan();
        level0_fan();
        level1_fan();
        level2_fan();
        level3_fan();

    }

    public void back_fan(){
        back_fan = (ImageView) findViewById(R.id.back_fan);
        back_fan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent0 = new Intent(MainFan.this, MainPage.class);
                startActivity(intent0);
            }
        });
    }

    public void level0_fan(){
        level0 = (ImageView) findViewById(R.id.level1);
        level0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent1 = new Intent(MainFan.this, MainFanLevel0.class);
                startActivity(intent1);
            }
        });
    }

    public void level1_fan(){
        level1 = (ImageView) findViewById(R.id.level2);
        level1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent2 = new Intent(MainFan.this, MainFanLevel1.class);
                startActivity(intent2);
            }
        });
    }

    public void level2_fan(){
        level2 = (ImageView) findViewById(R.id.level3);
        level2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent3 = new Intent(MainFan.this, MainFanLevel2.class);
                startActivity(intent3);
            }
        });
    }

    public void level3_fan(){
        level3 = (ImageView) findViewById(R.id.level4);
        level3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent4 = new Intent(MainFan.this, MainFanLevel3.class);
                startActivity(intent4);
            }
        });
    }


}
