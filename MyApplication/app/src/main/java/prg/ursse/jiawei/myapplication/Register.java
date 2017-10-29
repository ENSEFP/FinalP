package prg.ursse.jiawei.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Created by david on 2017/10/29.
 */

public class Register extends Activity{

    EditText EditEmail, EditPassword, EditPassword2;
    String email, password, password2;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditEmail = (EditText) findViewById(R.id.email);
        EditPassword = (EditText) findViewById(R.id.password);
        EditPassword2 = (EditText) findViewById(R.id.password);


    }

    public void userReg(View view){
        email = EditEmail.getText().toString();
        password = EditPassword.getText().toString();
        password2 = EditPassword2.getText().toString();
        String method = "register";
        BackgoundWorker bw = new BackgoundWorker(this);
        bw.execute(method,email,password,password2);
        finish();
    }
}
