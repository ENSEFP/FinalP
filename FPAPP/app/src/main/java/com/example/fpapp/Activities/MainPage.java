package com.example.fpapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Switch;

import android.content.Intent;

import com.example.fpapp.Functions.Camera;
import com.example.fpapp.Functions.Location;
import com.example.fpapp.R;

/**
 * Created by chenxiaojie on 2017-10-29.
 */

public class MainPage extends AppCompatActivity {

    private TextView textViewName;

    private Button location, camera;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        textViewName = (TextView) findViewById(R.id.name);
        String nameFromIntent = getIntent().getStringExtra("EMAIL");
        textViewName.setText("Welcome " + nameFromIntent);

        location();
        camera();
    }

    public void OnOpen(View view) {
        // initiate a Switch
        Switch simpleSwitch = (Switch) findViewById(R.id.open);

        // check current state of a Switch (true or false).
        Boolean switchState = simpleSwitch.isChecked();
        String Temp;
        if(switchState == true){
            Temp = "1";
        }else{
            Temp = "0";
        }

        String type = "open";

        OpenDoor openDoor = new OpenDoor(this);
        openDoor.execute(type, Temp);
    }




    public void location(){
        location = (Button) findViewById(R.id.location);
        location.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent0 = new Intent(MainPage.this, Location.class);
                startActivity(intent0);
            }
        });
    }

    public void camera(){
        camera = (Button) findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent1 = new Intent(MainPage.this, Camera.class);
                startActivity(intent1);
            }
        });
    }



}
