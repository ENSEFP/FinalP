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

public class MainLock extends AppCompatActivity {


    private ImageView back_lock, open_lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lock);


        back_lock();
        open_lock();

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
                Intent intent1 = new Intent(MainLock.this, MainLockOpen.class);
                startActivity(intent1);
            }
        });
    }


}
