package rchs.rchs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class MainLedKitchenOpen extends AppCompatActivity {

    private ImageView back_led;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_led_kitchen_open);

        String url = "http://192.168.4.2/esp/kitchen_led.php?kitchen_led=1";
        WebView webb = (WebView) this.findViewById(R.id.webView);
        webb.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webb.loadUrl(url);

        back_led_open();

    }

    public void back_led_open(){
        back_led = (ImageView) findViewById(R.id.back_led_open);
        back_led.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent0 = new Intent(MainLedKitchenOpen.this, MainLed.class);
                startActivity(intent0);
            }
        });
    }
}
