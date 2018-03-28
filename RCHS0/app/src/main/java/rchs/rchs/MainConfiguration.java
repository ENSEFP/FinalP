package rchs.rchs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;

public class MainConfiguration extends AppCompatActivity {


    private ImageView back_configuration;
    private AutoCompleteTextView configuration0, configuration1, configuration2, configuration3, configuration4, configuration5;
    Button btn0, btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_configuration);

        //configuration0 = (AutoCompleteTextView) findViewById(R.id.editText0);
        configuration1 = (AutoCompleteTextView) findViewById(R.id.editText1);
        configuration2 = (AutoCompleteTextView) findViewById(R.id.editText2);
        configuration3 = (AutoCompleteTextView) findViewById(R.id.editText3);
        //configuration4 = (AutoCompleteTextView) findViewById(R.id.editText4);
        //configuration5 = (AutoCompleteTextView) findViewById(R.id.editText5);

//        btn0 = (Button) findViewById(R.id.button0);
//
//        btn0.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String temp0 = btnShowSavedClicked0();
//                Intent intent = new Intent(MainConfiguration.this, MainConfigurationUp.class);
//                intent.putExtra("temp", temp0);
//                startActivity(intent);
//            }
//        });

        btn1 = (Button) findViewById(R.id.button1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String temp0 = btnShowSavedClicked0();
                String temp1 = btnShowSavedClicked1();
                Intent intent = new Intent(MainConfiguration.this, MainConfigurationDown.class);
//                intent.putExtra("temp0", temp0);
                intent.putExtra("temp1", temp1);
                startActivity(intent);
            }
        });

        btn2 = (Button) findViewById(R.id.button2);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp2 = btnShowSavedClicked2();
                Intent intent = new Intent(MainConfiguration.this, MainConfigurationAbove.class);
                intent.putExtra("temp", temp2);
                startActivity(intent);
            }
        });

        btn3 = (Button) findViewById(R.id.button3);

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp3 = btnShowSavedClicked3();
                Intent intent = new Intent(MainConfiguration.this, MainConfigurationBelow.class);
                intent.putExtra("temp", temp3);
                startActivity(intent);
            }
        });

//        btn4 = (Button) findViewById(R.id.button4);
//
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String temp4 = btnShowSavedClicked4();
//                String temp5 = btnShowSavedClicked5();
//                Intent intent = new Intent(MainConfiguration.this, MainConfigurationTime.class);
//                intent.putExtra("temp", temp4);
//                intent.putExtra("temp0", temp5);
//                startActivity(intent);
//            }
//        });



        //AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        //myAlert.setMessage(temp)
                //.create();
        //myAlert.show();


        back_configuration();

    }

    public void back_configuration(){
        back_configuration = (ImageView) findViewById(R.id.back_configuration);
        back_configuration.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent0 = new Intent(MainConfiguration.this, MainActivity.class);
                startActivity(intent0);
            }
        });
    }

    public String btnShowSavedClicked0(){
        String temp = configuration0.getText().toString();
        return temp;
    }

    public String btnShowSavedClicked1(){
        String temp = configuration1.getText().toString();
        return temp;
    }

    public String btnShowSavedClicked2(){
        String temp = configuration2.getText().toString();
        return temp;
    }

    public String btnShowSavedClicked3(){
        String temp = configuration3.getText().toString();
        return temp;
    }

    public String btnShowSavedClicked4(){
        String temp = configuration4.getText().toString();
        return temp;
    }

    public String btnShowSavedClicked5(){
        String temp = configuration5.getText().toString();
        return temp;
    }


}
