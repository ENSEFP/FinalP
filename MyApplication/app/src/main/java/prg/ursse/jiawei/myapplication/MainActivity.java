package prg.ursse.jiawei.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    String openStatus,closeStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void userReg (View view){
        startActivity(new Intent(this,Register.class));
    }
    public void OnOpen (View view){
        openStatus = "1";

    }

    public void OnClose (View view){

    }
}

