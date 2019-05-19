package com.example.rayanne.myapplication.ConteudoAgro;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.rayanne.myapplication.R;

public class ConverseAgro extends AppCompatActivity {
    // TODO: intent do wpp abrindo diretamente na conversa do numero (verificar se ja tem o contato adicionado)
    // TODO: conferir o private (segurança) dos campos

    String txtCel1 = "032999344934";
    String txtCel2 = "032991210097";
    String txtCel3 = "032984303678";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converseagro);
        chamarContato1();
        chamarContato2();
        chamarContato3();
    }


    public void chamarContato1(){
        //Facebook
        Button btnFb1 = findViewById(R.id.btnFb1);
        btnFb1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent facebookIntent = getOpenFacebookIntent1(ConverseAgro.this);
                startActivity(facebookIntent);
            }
        });

        //Pegar o telefone e abrir tela preenchida
        Button btnCel1 = findViewById(R.id.btnCel1);
        btnCel1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:"+txtCel1);
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

    }

    public void chamarContato2(){
        //Facebook
        Button btnFb2 = findViewById(R.id.btnFb2);
        btnFb2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent facebookIntent = getOpenFacebookIntent2(ConverseAgro.this);
                startActivity(facebookIntent);
            }
        });

        //Pegar o telefone e abrir tela preenchida
        Button btnCel2 = findViewById(R.id.btnCel2);
        btnCel2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:"+txtCel2);
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

    }

    public void chamarContato3(){
        //Facebook
        Button btnFb3 = findViewById(R.id.btnFb3);
        btnFb3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent facebookIntent = getOpenFacebookIntent3(ConverseAgro.this);
                startActivity(facebookIntent);
            }
        });

        //Pegar o telefone e abrir tela preenchida
        Button btnCel3 = findViewById(R.id.btnCel3);
        btnCel3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:"+txtCel3);
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

    }

    //Abrir Facebook
    public static Intent getOpenFacebookIntent1(ConverseAgro context) {

       try {
          context.getPackageManager()
              .getPackageInfo("com.facebook.katana", 0); //Checa se o facebook está instalado.
          return new Intent(Intent.ACTION_VIEW,
          Uri.parse("fb://page/cinthia.martins.3950")); //Interação com a uri do fb.
          }catch (Exception e) {
          return new Intent(Intent.ACTION_VIEW,
          Uri.parse("https://www.facebook.com/cinthia.martins.3950")); //Página desejada.
          }
    }

    //Abrir Facebook
    public static Intent getOpenFacebookIntent2(ConverseAgro context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0); //Checa se o facebook está instalado.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://page/raphaela.guimaraes.1069")); //Interação com a uri do fb.
        }catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/raphaela.guimaraes.1069")); //Página desejada.
        }
    }

    //Abrir Facebook
    public static Intent getOpenFacebookIntent3(ConverseAgro context) {

        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.katana", 0); //Checa se o facebook está instalado.
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("fb://page/giselecosta.15")); //Interação com a uri do fb.
        }catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.facebook.com/giselecosta.15")); //Página desejada.
        }
    }

}

