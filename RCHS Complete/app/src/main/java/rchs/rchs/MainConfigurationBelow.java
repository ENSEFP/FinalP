package rchs.rchs;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class MainConfigurationBelow extends AppCompatActivity {

    private ImageView config;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_configuration_below);
        /*
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage(getIntent().getStringExtra("temp"))
                .create();
        myAlert.show();
*/
        String url = "http://192.168.4.2/esp/temperture_too_low.php?temperture_too_low=" + getIntent().getStringExtra("temp");

//        AlertDialog.Builder myAlert0 = new AlertDialog.Builder(this);
//        myAlert0.setMessage(url)
//                .create();
//        myAlert0.show();

        WebView webb = (WebView) this.findViewById(R.id.webView);
        webb.setWebViewClient(new WebViewClient());
        webb.loadUrl(url);

        back_fan();

    }

    public void back_fan(){
        config = (ImageView) findViewById(R.id.back_config);
        config.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent0 = new Intent(MainConfigurationBelow.this, MainConfiguration.class);
                startActivity(intent0);
            }
        });
    }
}
