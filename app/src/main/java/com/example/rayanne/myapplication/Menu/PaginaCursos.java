package com.example.rayanne.myapplication.Menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.rayanne.myapplication.R;
import com.example.rayanne.myapplication.TesteVocacional.DescricaoCursos;
import com.example.rayanne.myapplication.TesteVocacional.PagDescricao;

public class PaginaCursos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursostec);
        paginaCurso();
    }

    //Botões que direcionam o usuário para a área do curso
    private void paginaCurso() {
        //Curso Tec. em Agropecuária
        Button btnAgro = findViewById(R.id.btnAgro);
        btnAgro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeCurso = DescricaoCursos.nomeCursos[0];
                Intent intent = new Intent(PaginaCursos.this, PagDescricao.class);
                intent.putExtra("Curso", nomeCurso);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        //Curso Tec. em Alimentos
        Button btnAlim = findViewById(R.id.btnAlim);
        btnAlim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeCurso = DescricaoCursos.nomeCursos[1];
                Intent intent = new Intent(PaginaCursos.this, PagDescricao.class);
                intent.putExtra("Curso", nomeCurso);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        //Curso Tec. em Info
        Button btnInf = findViewById(R.id.btnInf);
        btnInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeCurso = DescricaoCursos.nomeCursos[2];
                Intent intent = new Intent(PaginaCursos.this, PagDescricao.class);
                intent.putExtra("Curso", nomeCurso);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        //Curso Tec. em MeiB
        Button btnMeiB = findViewById(R.id.btnMeiB);
        btnMeiB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeCurso = DescricaoCursos.nomeCursos[3];
                Intent intent = new Intent(PaginaCursos.this, PagDescricao.class);
                intent.putExtra("Curso", nomeCurso);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });

        //Curso Tec. em Zoo
        Button btnZoo = findViewById(R.id.btnZoo);
        btnZoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeCurso = DescricaoCursos.nomeCursos[4];
                Intent intent = new Intent(PaginaCursos.this, PagDescricao.class);
                intent.putExtra("Curso", nomeCurso);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }

    public void onBackPressed(){
        Intent intent = new Intent(PaginaCursos.this, PagMenu.class);
        startActivity(intent);
        finish();
    }
}
