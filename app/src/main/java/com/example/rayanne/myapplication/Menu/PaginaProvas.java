package com.example.rayanne.myapplication.Menu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.example.rayanne.myapplication.R;

public class PaginaProvas extends AppCompatActivity {
    // TODO: conferir o private (segurança) dos campos

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagprovas);
        exibirProva19();
        exibirProva18();
        exibirProva17();

    }


    private void exibirProva19(){
        Button btnP19 = findViewById(R.id.btnP19);

        btnP19.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://rolenoifapp.000webhostapp.com/prova2019.pdf"));
                startActivity(intent);
            }
        });

    }

    private void exibirProva18(){
        Button btnP18 = findViewById(R.id.btnP18);

        btnP18.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://rolenoifapp.000webhostapp.com/prova2018.pdf"));
                startActivity(intent);
            }
        });

    }

    private void exibirProva17(){
        Button btnP17 = findViewById(R.id.btnP17);

        btnP17.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://rolenoifapp.000webhostapp.com/prova2017.pdf"));
                startActivity(intent);
            }
        });

    }



}

