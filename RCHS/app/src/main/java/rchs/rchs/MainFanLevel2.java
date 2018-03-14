package rchs.rchs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

public class MainFanLevel2 extends AppCompatActivity {

    private ImageView level2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fan_level2);

        String url = "http://www.cmledu.com";
        WebView webb = (WebView) this.findViewById(R.id.webView);
        webb.setWebViewClient(new WebViewClient());
        webb.loadUrl(url);

        back_fan();

    }

    public void back_fan(){
        level2 = (ImageView) findViewById(R.id.back_fan);
        level2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent0 = new Intent(MainFanLevel2.this, MainFan.class);
                startActivity(intent0);
            }
        });
    }
}
