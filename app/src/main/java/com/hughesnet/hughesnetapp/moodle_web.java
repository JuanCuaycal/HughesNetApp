package com.hughesnet.hughesnetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static android.webkit.CookieManager.getInstance;

public class moodle_web extends AppCompatActivity{
    WebView miVisorWeb;
    String url = "http://www.trainingcomercial.com/moodle/login/index.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moodle_web);



        miVisorWeb = (WebView) findViewById(R.id.webview_moodle);
        final WebSettings ajustesVisorWeb = miVisorWeb.getSettings();



        ajustesVisorWeb.setJavaScriptEnabled(true);
        ajustesVisorWeb.setRenderPriority(WebSettings.RenderPriority.HIGH);
        ajustesVisorWeb.setSupportMultipleWindows(true);
        ajustesVisorWeb.setDomStorageEnabled(true);
        ajustesVisorWeb.setLoadWithOverviewMode(true);
        ajustesVisorWeb.setDomStorageEnabled(true);
        ajustesVisorWeb.setAppCacheEnabled(true);
        miVisorWeb.loadUrl(url);
        miVisorWeb.setWebViewClient(new WebViewClient());


    }
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return true;
        }
    }

}