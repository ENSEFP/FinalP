package rchs.rchs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class MainFanLevel0 extends AppCompatActivity {


    private ImageView level0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fan_level0);

        String url = "http://192.168.4.2/esp/fan.php?fan=0";
        WebView webb = (WebView) this.findViewById(R.id.webView);
        webb.setWebViewClient(new WebViewClient());
        webb.loadUrl(url);

        back_fan();

    }

    public void back_fan(){
        level0 = (ImageView) findViewById(R.id.back_fan);
        level0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent0 = new Intent(MainFanLevel0.this, MainFan.class);
                startActivity(intent0);
            }
        });
    }
}
