package com.example.rayanne.myapplication.ConteudoAgro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.rayanne.myapplication.R;

public class SeisCoisasAgro extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seiscoisasagro);
        exibirIntro();
        exibirVideo1();
        exibirVideo2();
        exibirVideo3();
        exibirVideo4();
        exibirVideo5();
        exibirVideo6();
    }

    private void exibirIntro(){
        WebView mWebView0 = findViewById(R.id.webview0);
        WebSettings webSettings = mWebView0.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        String html = "<html>";
        html += "<body>";
        html += "<center><iframe width=\"match_parent\" height=\"wrap_content\" src=\"https://www.youtube.com/embed/4rSNZRt754A?start=1\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe></iframe>";
        html += "</center></body></html>";

        mWebView0.loadData(html,"text/html", "UTF-8");

    }

    private void exibirVideo1(){
        WebView mWebView1 = findViewById(R.id.webview1);
        WebSettings webSettings = mWebView1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        String html = "<html>";
        html += "<body>";
        html += "<center><iframe width=\"match_parent\" height=\"wrap_content\" src=\"https://www.youtube.com/embed/2M4hgbUvti8\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
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
        html += "<center><iframe width=\"match_parent\" height=\"wrap_content\" src=\"https://www.youtube.com/embed/4WCuG7mtCbI\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
        html += "</center></body></html>";

        mWebView2.loadData(html,"text/html", "UTF-8");

    }

    private void exibirVideo3(){
        WebView mWebView3 = findViewById(R.id.webview3);
        WebSettings webSettings = mWebView3.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        String html = "<html>";
        html += "<body>";
        html += "<center><iframe width=\"match_parent\" height=\"wrap_content\" src=\"https://www.youtube.com/embed/G9GmbzJzRkM\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
        html += "</center></body></html>";

        mWebView3.loadData(html,"text/html", "UTF-8");

    }

    private void exibirVideo4(){
        WebView mWebView4 = findViewById(R.id.webview4);
        WebSettings webSettings = mWebView4.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        String html = "<html>";
        html += "<body>";
        html += "<center><iframe width=\"match_parent\" height=\"wrap_content\" src=\"https://www.youtube.com/embed/64z6zhX6Scw\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
        html += "</center></body></html>";

        mWebView4.loadData(html,"text/html", "UTF-8");

    }

    private void exibirVideo5(){
        WebView mWebView5 = findViewById(R.id.webview5);
        WebSettings webSettings = mWebView5.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        String html = "<html>";
        html += "<body>";
        html += "<center><iframe width=\"match_parent\" height=\"wrap_content\" src=\"https://www.youtube.com/embed/WDBo9OwQOaQ\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
        html += "</center></body></html>";

        mWebView5.loadData(html,"text/html", "UTF-8");

    }

    private void exibirVideo6(){
        WebView mWebView6 = findViewById(R.id.webview6);
        WebSettings webSettings = mWebView6.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        String html = "<html>";
        html += "<body>";
        html += "<center><iframe width=\"match_parent\" height=\"wrap_content\" src=\"https://www.youtube.com/embed/qZX_XyA2EEI\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
        html += "</center></body></html>";

        mWebView6.loadData(html,"text/html", "UTF-8");

    }
}
