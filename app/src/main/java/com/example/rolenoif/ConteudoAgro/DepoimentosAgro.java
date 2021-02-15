package com.example.rolenoif.ConteudoAgro;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.rolenoif.R;

public class DepoimentosAgro extends AppCompatActivity {
    // TODO: conferir o private (segurança) dos campos

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depoagro);
        exibirVideo1();
        exibirVideo2();
    }

    private void exibirVideo1(){
        WebView mWebView1 = findViewById(R.id.webview1);
        WebSettings webSettings = mWebView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        String html = "<html>";
        html += "<body>";
        html += "<center><iframe width=\"match_parent\" height=\"wrap_content\" src=\"https://www.youtube.com/embed/46cpiJ_2xtw\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
        html += "</center></body></html>";

        mWebView1.loadData(html,"text/html", "UTF-8");

    }

    private void exibirVideo2(){
        WebView mWebView2 = findViewById(R.id.webview2);
        WebSettings webSettings = mWebView2.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        String html = "<html>";
        html += "<body>";
        html += "<center><iframe width=\"match_parent\" height=\"wrap_content\" src=\"https://www.youtube.com/embed/HtRqY2Oa3X0\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
        html += "</center></body></html>";

        mWebView2.loadData(html,"text/html", "UTF-8");

    }


}
