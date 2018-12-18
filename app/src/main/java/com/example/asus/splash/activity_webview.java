package com.example.asus.splash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class activity_webview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        getSupportActionBar().setTitle("Arsenal Website");
        WebView webView=(WebView) findViewById(R.id.web1);
        webView.loadUrl("http://www.arsenal.com/home");
    }
}
