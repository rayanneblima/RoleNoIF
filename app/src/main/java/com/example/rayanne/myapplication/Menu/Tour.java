package com.example.rayanne.myapplication.Menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.rayanne.myapplication.R;

public class Tour extends AppCompatActivity {

    private WebView mWebView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);
        exibirTour();
    }

    private void exibirTour() {
        mWebView = findViewById(R.id.webview);
        /*WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl("https://kuula.co/share/7Y0Gn?fs=1&vr=0&thumbs=1&chromeless=0&logo=0");
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
*/
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        //mWebView.loadUrl("http://google.com");
        String html = "<html>";
        html += "<body>";
        html += "<script src=\"https://static.kuula.io/embed.js\" data-kuula=\"https://kuula.co/share/7Y0Gn?fs=1&vr=0&thumbs=1&chromeless=0&logo=0\" data-width=\"100%\" data-height=\"100%\"></script>";
        html += "</body></html>";

        mWebView.loadData(html,"text/html", "UTF-8");


    }

    @Override
    // Detectar cuando se presiona el botón de retroceso
    public void onBackPressed() {
        if(mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }


}
