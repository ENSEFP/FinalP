package rchs.rchs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class MainLockOpen extends AppCompatActivity {

    private ImageView back_lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lock_open);

        String url = "http://192.168.4.2/esp/door.php?door=1";
        WebView webb = (WebView) this.findViewById(R.id.webView);
        webb.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webb.loadUrl(url);

        back_lock_open();

    }

    public void back_lock_open(){
        back_lock = (ImageView) findViewById(R.id.back_lock_open);
        back_lock.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent0 = new Intent(MainLockOpen.this, MainLock.class);
                startActivity(intent0);
            }
        });
    }



}
