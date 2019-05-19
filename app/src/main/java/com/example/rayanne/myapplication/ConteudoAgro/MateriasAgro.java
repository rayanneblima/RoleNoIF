package com.example.rayanne.myapplication.ConteudoAgro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.rayanne.myapplication.R;

public class MateriasAgro extends AppCompatActivity {
    // TODO: conferir o private (segurança) dos campos

    private LinearLayout lyt_btnPerg1;
    private LinearLayout lyt_btnPerg2;
    private LinearLayout lyt_btnPerg3;

    private boolean show1;
    private boolean show2;
    private boolean show3;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materiasagro);
        exibirVideo();
        mostraConteudo();
    }

    private void exibirVideo(){
        WebView mWebView = findViewById(R.id.webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);
        String html = "<html>";
        html += "<body>";
        html += "<center><iframe width=\"match_parent\" height=\"wrap_content\" src=\"https://www.youtube.com/embed/oAR2BI7vr3U\" frameborder=\"0\" allow=\"accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture\" allowfullscreen></iframe>";
        html += "</center></body></html>";

        mWebView.loadData(html,"text/html", "UTF-8");

    }

    private void mostraConteudo() {
        Button btn_Perg1 = findViewById(R.id.btn_Perg1);

        btn_Perg1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                lyt_btnPerg1 = findViewById(R.id.lyt_btnPerg1);
                if(show1){
                    lyt_btnPerg1.setVisibility(View.GONE);
                    show1 = false;
                }else{
                    lyt_btnPerg1.setVisibility(View.VISIBLE);
                    show1 = true;
                }
            }
        });

        Button btn_Perg2 = findViewById(R.id.btn_Perg2);

        btn_Perg2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                lyt_btnPerg2 = findViewById(R.id.lyt_btnPerg2);
                if(show2){
                    lyt_btnPerg2.setVisibility(View.GONE);
                    show2 = false;
                }else{
                    lyt_btnPerg2.setVisibility(View.VISIBLE);
                    show2 = true;
                }
            }
        });

        Button btn_Perg3 = findViewById(R.id.btn_Perg3);

        btn_Perg3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                lyt_btnPerg3 = findViewById(R.id.lyt_btnPerg3);
                if(show3){
                    lyt_btnPerg3.setVisibility(View.GONE);
                    show3 = false;
                }else{
                    lyt_btnPerg3.setVisibility(View.VISIBLE);
                    show3 = true;
                }
            }
        });
        
    }

}
