package rchs.rchs;

import android.content.Context;
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

public class MainLock extends AppCompatActivity {


    private ImageView back_lock, open_lock, close_lock;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lock);


        back_lock();
        open_lock();
        close_lock();
    }

    public void back_lock(){
        back_lock = (ImageView) findViewById(R.id.back_lock);
        back_lock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent0 = new Intent(MainLock.this, MainActivity.class);
                startActivity(intent0);
            }
        });
    }

    public void open_lock(){
        open_lock = (ImageView) findViewById(R.id.open);
        open_lock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String lock = "1";
                String password = "1";
                String type = "lock";
                backgroundWorkLock backgroundWorker = new backgroundWorkLock(context);
                backgroundWorker.execute(type, lock, password);
            }
        });
    }

    public void close_lock(){
        close_lock = (ImageView) findViewById(R.id.close);
        close_lock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String lock = "0";
                String password = "0";
                String type = "lock";
                backgroundWorkLock backgroundWorker = new backgroundWorkLock(context);
                backgroundWorker.execute(type, lock, password);
            }
        });
    }


}
