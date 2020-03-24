package com.example.rayanne.myapplication.Menu;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rayanne.myapplication.Contas.TelaLogin;
import com.example.rayanne.myapplication.Contas.TelaPerfil;
import com.example.rayanne.myapplication.MainActivity;
import com.example.rayanne.myapplication.Others.OnSwipeTouchListener;
import com.example.rayanne.myapplication.Others.SharedPref;
import com.example.rayanne.myapplication.R;
import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

public class PagMenu extends AppCompatActivity {
    //TODO: conferir o private (segurança) dos campos
    //TODO: TROCAR AS FOTOS PRO TOUR

    boolean session;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagmenu);
        iniciarTeste();
        iniciarCursos();
        iniciarProvas();
        iniciarTour();
        agendarVisita();
        SESSION();
    }

    public void SESSION() {
        //Setando FALSE porque é o primeiro login
        session = Boolean.parseBoolean(SharedPref.read(getApplicationContext(), "session", "false"));

        if(!session) {
            //Primeiro login ou logout
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            //Quando o usuario ja logou, assume valor TRUE
            //Toast.makeText(this, "Login já realizado!", Toast.LENGTH_SHORT).show();
        }

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
            Intent intent = new Intent(this, TelaPerfil.class);
            startActivity(intent);
            finish();
        }
        else{
            logout();
        }

        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        LoginManager.getInstance().logOut();
        Intent login = new Intent(PagMenu.this, TelaLogin.class);
        startActivity(login);
        finish();
        SharedPref.save(getApplicationContext(), "session", "false");
    }

    private void iniciarProvas(){
        Button btn_Provas = findViewById(R.id.btn_Provas);

        btn_Provas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PagMenu.this, PaginaProvas.class);
                startActivity(intent);
            }
        });
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
                //Popup customizado na mesma pagina
                MyCustomAlertDialog();
            }
        });
    }

    //TODO: este codigo deve ser feito separado para ser possivel incrementar com k numeros de fotos e com fotos hospedadas no site

    @SuppressLint("ClickableViewAccessibility")
    public void MyCustomAlertDialog(){
        final Dialog MyDialog = new Dialog(this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.activity_tour);

        final TextView qnt = MyDialog.findViewById(R.id.qnt);
        final ImageView foto = MyDialog.findViewById(R.id.foto);
        final TextView descricao = MyDialog.findViewById(R.id.descricao);
        final View viewGroup = MyDialog.findViewById(R.id.viewGroup);
        final int[] img = {R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1,
                R.drawable.img1, R.drawable.img1, R.drawable.img1, R.drawable.img1};

        /*final String[] desc = {"1 Alunos participando da I Mostra de Cursos e Profissões", "2 Aula de Fruticultura (3º ano)",
                "3 Disciplina de Agricultura I (a turma estava cursando o 1º ano", "4 Disciplina de Introdução aos Estudos e Práticas em Agropecuária (IEPA) do 1º ano de curso",
                "5 Disciplina de Zootecnia I (matéria do 2º ano)", "6 Equipe Agro3B recebendo medalha na Olimpíada Brasileira de Agropecuária",
                "7 Evento GeAgro - palestra sobre tangerina Ponkan", "8 Medalha de bronze conquistada na Olimpíada Brasileira de Agropecuária",
                "9 Prova prática da Olimpíada - Inseminação Artificial"};*/

        final int[] posicao = {0};
        final int[] cont = {1};

        qnt.setText("1/9");
        foto.setImageResource(img[posicao[0]]);
        //descricao.setText(desc[posicao[0]]);

        // Na view da foto, ativa "SwipeTouchListener" permitindo detecção do deslize.
        viewGroup.setOnTouchListener(new OnSwipeTouchListener(PagMenu.this) {
            @Override
            public void onSwipeLeft() {
                // Se desliza da direta pra esquerda
                posicao[0]++;
                cont[0]++;
                if(posicao[0] > 8) posicao[0] = 0;
                if(cont[0] > 9) cont[0] = 1;
                qnt.setText(" " + cont[0] + "/9");
                foto.setImageResource(img[posicao[0]]);
                //descricao.setText(desc[posicao[0]]);
            }
            public void onSwipeRight() {
                // Se desliza da esquerda pra direita
                posicao[0]--;
                cont[0]--;
                if(posicao[0] < 0) posicao[0] = 8;
                if(cont[0] < 1) cont[0] = 9;
                qnt.setText(" " + cont[0] + "/9");
                foto.setImageResource(img[posicao[0]]);
                //descricao.setText(desc[posicao[0]]);
            }
        });

        MyDialog.show();
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
