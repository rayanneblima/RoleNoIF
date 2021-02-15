package com.example.rolenoif.Menu;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.example.rolenoif.R;

public class Tour extends AppCompatActivity {
    //TODO: conferir o private (segurança) dos campos
    //TODO: incrementar com todas as imagens e videos possiveis (galeria chamando um poupop de exibiçao)


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exibirTour();

        //setContentView(R.layout.activity_tour2);
        //exibirVideo();
    }

    private void exibirTour() {
        Button btnRotina = findViewById(R.id.btnRotina);

        btnRotina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Popup customizado na mesma pagina
               // MyCustomAlertDialog();
            }
        });
    }

//    @Override
    // Detectar cuando se presiona el botón de retroceso
   /* public void onBackPressed() {
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
