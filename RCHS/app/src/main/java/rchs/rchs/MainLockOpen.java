package rchs.rchs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainLockOpen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lock_open);

        String url = "http://www.cmledu.com";
        WebView webb = (WebView) this.findViewById(R.id.webView);
        webb.setWebViewClient(new WebViewClient());
        webb.loadUrl(url);


    }




}
