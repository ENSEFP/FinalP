package com.example.fpapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.example.fpapp.R;

public class MainView extends AppCompatActivity {

    private ImageView view_s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_view);
        String url = "http://192.168.4.2/esp/detail.php";
        WebView webb = (WebView) this.findViewById(R.id.webView);
        webb.setWebViewClient(new WebViewClient());
        webb.loadUrl(url);

        back_lock_close();

    }

    public void back_lock_close() {
        view_s = (ImageView) findViewById(R.id.back_view);
        view_s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent0 = new Intent(MainView.this, MainLock.class);
                startActivity(intent0);
            }
        });
    }
}
