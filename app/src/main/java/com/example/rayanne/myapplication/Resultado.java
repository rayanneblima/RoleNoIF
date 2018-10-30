package com.example.rayanne.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        mostraCurso();
        paginaCurso();

    }

    //Mostra o Curso pelo resultado do Teste Vocacional
    private void mostraCurso() {
        TextView txt_Result = (TextView) findViewById(R.id.txt_Result);
        //Pega a intent de outra activity
        Intent intent = getIntent();
        //Recuperei a string da outra activity
        String curso = intent.getStringExtra("Curso");
        txt_Result.setText("" + curso + "!");
    }

    //Botões que direciona o usuário para a área do curso
    private void paginaCurso() {

        //Curso Tec. em Agropecuária
        ImageButton imgBtn_TecAgro = (ImageButton) findViewById(R.id.imgBtn_TecAgro);
        imgBtn_TecAgro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resultado.this, PaginaAgro.class);
                startActivity(intent);
            }
        });
    }


    public void onBackPressed(){
        Intent intent = new Intent(Resultado.this, Teste_Vocacional.class);
        startActivity(intent);
    }
}