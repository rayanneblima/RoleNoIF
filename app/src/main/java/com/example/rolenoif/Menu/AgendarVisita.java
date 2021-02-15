package com.example.rolenoif.Menu;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.rolenoif.R;

public class AgendarVisita extends AppCompatActivity {
    //TODO: definir pra onde serao enviadas as respostas do formulario

    private WebView mWebView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita);
        exibirForm();
    }

    @SuppressLint("SetJavaScriptEnabled")
    private void exibirForm() {
        mWebView = findViewById(R.id.webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSfIMU-N4Z5TvrgYxEytMatgxAJPZ4U5L88BSZEYCORK7onzFw/viewform?usp=sf_link");
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){}
            @Override
            public void onPageFinished(WebView view, String url){}
        });

    }

    @Override
    public void onBackPressed() {
        if(mWebView.canGoBack()) mWebView.goBack();
        else super.onBackPressed();
    }

}

