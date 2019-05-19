package com.example.rayanne.myapplication.Menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.rayanne.myapplication.R;

public class Tour extends AppCompatActivity {
    //TODO: conferir o private (segurança) dos campos
    //TODO: incrementar com todas as imagens e videos possiveis (galeria chamando um poupop de exibiçao)

    private WebView mWebView1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //setContentView(R.layout.activity_tour);
        //exibirTour();

        setContentView(R.layout.activity_tour2);
        exibirVideo();
    }

    /* private void exibirTour() {
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
       /* WebSettings webSettings = mWebView.getSettings();
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
    }*/

    private void exibirVideo(){
        WebView mWebView1 = findViewById(R.id.webview1);
        WebSettings webSettings = mWebView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        String html = "<html>";
        html += "<body>";
        html += "<center><iframe width=\"match_parent\" height=\"wrap_content\" src=\"https://www.youtube.com/embed/piiDBySYwKc\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
        html += "</center></body></html>";

        mWebView1.loadData(html,"text/html", "UTF-8");

    }
}
