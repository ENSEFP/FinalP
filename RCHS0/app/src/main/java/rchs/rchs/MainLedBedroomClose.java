package rchs.rchs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class MainLedBedroomClose extends AppCompatActivity {

    private ImageView back_led;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_led_bedroom_close);

        String url = "http://192.168.4.2/esp/bedroom_led.php?bedroom_led=0";
        WebView webb = (WebView) this.findViewById(R.id.webView);
        webb.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webb.loadUrl(url);

        back_led_close();

    }

    public void back_led_close(){
        back_led = (ImageView) findViewById(R.id.back_led_close);
        back_led.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent0 = new Intent(MainLedBedroomClose.this, MainLed.class);
                startActivity(intent0);
            }
        });
    }
}
