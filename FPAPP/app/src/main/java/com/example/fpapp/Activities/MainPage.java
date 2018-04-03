package com.example.fpapp.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Switch;

import android.content.Intent;

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


    }



}
