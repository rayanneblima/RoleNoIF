package com.example.rayanne.myapplication.Menu;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.rayanne.myapplication.Contas.TelaLogin;
import com.example.rayanne.myapplication.Contas.TelaPerfil;
import com.example.rayanne.myapplication.R;
import com.facebook.AccessToken;

public class PagMenu extends AppCompatActivity {
    //TODO: conferir o private (segurança) dos campos
    //TODO: mudar ordem dos botoes dando enfase na Tour

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagmenu);
        iniciarTeste();
        iniciarCursos();
        iniciarTour();
        agendarVisita();
    }

    //Menu de "3 pontinhos"
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.user_profile){
            //TODO: obter o perfil do usuario
            Intent intent = new Intent(this, TelaPerfil.class);
            startActivity(intent);
        }
        else{
            //TODO: DESLOGAR USUARIO DO FB OU DA CONTA
            finish();
        }
        return super.onOptionsItemSelected(item);
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

    private void iniciarCursos(){
        Button btn_Cursos = findViewById(R.id.btn_Cursos);

        btn_Cursos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PagMenu.this, PaginaCursos.class);
                startActivity(intent);
            }
        });
    }

    private void iniciarTour(){
        Button btn_Tour = findViewById(R.id.btn_Tour);

        btn_Tour.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PagMenu.this, Tour.class);
                startActivity(intent);
            }
        });
    }

    private void agendarVisita(){
        Button btn_Visita = findViewById(R.id.btn_Visita);

        btn_Visita.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PagMenu.this, AgendarVisita.class);
                startActivity(intent);
            }
        });
    }

    public void onBackPressed(){
        popup_Cancel();
    }

    public void popup_Cancel() {
        //Cria o gerador do AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //define a mensagem
        builder.setMessage("Deseja fechar o aplicativo?");
        //define um botão como positivo
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });
        //define um botão como negativo.
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
            }
        });
        //cria o AlertDialog
        //atributo da classe.
        AlertDialog alerta = builder.create();
        //Exibe
        alerta.show();
    }

}
