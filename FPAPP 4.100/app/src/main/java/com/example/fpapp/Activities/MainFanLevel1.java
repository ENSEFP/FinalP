package com.example.fpapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.example.fpapp.R;

public class MainFanLevel1 extends AppCompatActivity {

    private ImageView level1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fan_level1);

        String url = "http://192.168.4.100/esp/fan.php?fan=1";
        WebView webb = (WebView) this.findViewById(R.id.webView);
        webb.getSettings().setJavaScriptEnabled(true);
        webb.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webb.loadUrl(url);

        back_fan();

    }

    public void back_fan(){
        level1 = (ImageView) findViewById(R.id.back_fan);
        level1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent0 = new Intent(MainFanLevel1.this, MainFan.class);
                startActivity(intent0);
            }
        });
    }
}
