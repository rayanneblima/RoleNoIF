package com.example.rayanne.myapplication.Menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.rayanne.myapplication.R;

public class PagMenu extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagmenu);
        iniciarTeste();
        iniciarAgro();
        iniciarTour();
        agendarVisita();
    }

    private void iniciarTeste(){
        Button btn_TV = findViewById(R.id.btn_TV);

        btn_TV.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PagMenu.this, Teste_Vocacional.class);
                startActivity(intent);
            }
        });
    }

    private void iniciarAgro(){
        Button btn_Agro = (Button) findViewById(R.id.btn_Agro);

        btn_Agro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PagMenu.this, PaginaAgro.class);
                startActivity(intent);
            }
        });
    }

    private void iniciarTour(){
        Button btn_Tour = (Button) findViewById(R.id.btn_Tour);

        btn_Tour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PagMenu.this, Tour.class);
                startActivity(intent);
            }
        });
    }

    private void agendarVisita(){
        Button btn_Visita = (Button) findViewById(R.id.btn_Visita);

        btn_Visita.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PagMenu.this, AgendarVisita.class);
                startActivity(intent);
            }
        });
    }

}
