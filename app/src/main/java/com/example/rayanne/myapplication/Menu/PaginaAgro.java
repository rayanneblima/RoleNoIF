package com.example.rayanne.myapplication.Menu;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rayanne.myapplication.ConteudoAgro.CarreiraAgro;
import com.example.rayanne.myapplication.ConteudoAgro.ConverseAgro;
import com.example.rayanne.myapplication.ConteudoAgro.DepoimentosAgro;
import com.example.rayanne.myapplication.ConteudoAgro.MateriasAgro;
import com.example.rayanne.myapplication.ConteudoAgro.SeisCoisasAgro;
import com.example.rayanne.myapplication.R;

public class PaginaAgro extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agro);

        iniciarSeisCoisasAgro();
        iniciarCarreiraAgro();
        iniciarMateriasAgro();
        iniciarDepoimentosAgro();
        iniciarRotinaAgro();
        iniciarConverseAgro();
    }

    private void iniciarCarreiraAgro(){
        Button btn_CarreiraAgro = findViewById(R.id.btn_CarreiraAgro);

        btn_CarreiraAgro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaginaAgro.this, CarreiraAgro.class);
                startActivity(intent);
            }
        });
    }

    private void iniciarMateriasAgro(){
        Button btn_materiasAgro = findViewById(R.id.btn_materiasAgro);

        btn_materiasAgro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaginaAgro.this, MateriasAgro.class);
                startActivity(intent);
            }
        });
    }

    private void iniciarDepoimentosAgro(){
        Button btnDepoimentos = findViewById(R.id.btnDepoimentos);

        btnDepoimentos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaginaAgro.this, DepoimentosAgro.class);
                startActivity(intent);
            }
        });
    }

    private void iniciarSeisCoisasAgro(){
        Button btn6Coisas = findViewById(R.id.btn6Coisas);

        btn6Coisas.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaginaAgro.this, SeisCoisasAgro.class);
                startActivity(intent);
            }
        });
    }

    private void iniciarRotinaAgro(){
        Button btnRotina = findViewById(R.id.btnRotina);

        btnRotina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Popup customizado
                MyCustomAlertDialog();
            }
        });
    }

    private void iniciarConverseAgro(){
        Button btnConverse = findViewById(R.id.btnConverse);

        btnConverse.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PaginaAgro.this, ConverseAgro.class);
                startActivity(intent);
            }
        });
    }

    public void MyCustomAlertDialog(){
        final Dialog MyDialog = new Dialog(this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.activity_rotinagro);

        Button back = MyDialog.findViewById(R.id.back);
        Button next = MyDialog.findViewById(R.id.next);
        Button close = MyDialog.findViewById(R.id.close);

        final ImageView foto = MyDialog.findViewById(R.id.foto);
        final TextView descricao = MyDialog.findViewById(R.id.descricao);

        final int[] img = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5,
                R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9};

        final String[] desc = {"Alunos participando da I Mostra de Cursos e Profissões", "Aula de Fruticultura (3º ano)",
                "Disciplina de Agricultura I (a turma estava cursando o 1º ano", "Disciplina de Introdução aos Estudos e Práticas em Agropecuária (IEPA) do 1º ano de curso",
                "Disciplina de Zootecnia I (matéria do 2º ano)", "Equipe Agro3B recebendo medalha na Olimpíada Brasileira de Agropecuária",
                "Evento GeAgro - palestra sobre tangerina Ponkan", "Medalha de bronze conquistada na Olimpíada Brasileira de Agropecuária",
                "Prova prática da Olimpíada - Inseminação Artificial"};

        final int[] posicao = {0};

        foto.setImageResource(img[posicao[0]]);
        descricao.setText(desc[posicao[0]]);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posicao[0]++;
                if(posicao[0] > 8) posicao[0] = 0;
                Log.d("Test", "" + posicao[0]);
                foto.setImageResource(img[posicao[0]]);
                descricao.setText(desc[posicao[0]]);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                posicao[0]--;
                if(posicao[0] < 0) posicao[0] = 8;
                Log.d("Test", "" + posicao[0]);
                foto.setImageResource(img[posicao[0]]);
                descricao.setText(desc[posicao[0]]);
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog.cancel();
            }
        });

        MyDialog.show();
    }

}
