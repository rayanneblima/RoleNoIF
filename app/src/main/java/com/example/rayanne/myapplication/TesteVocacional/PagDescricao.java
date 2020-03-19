package com.example.rayanne.myapplication.TesteVocacional;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rayanne.myapplication.ConteudoAgro.MateriasAgro;
import com.example.rayanne.myapplication.Menu.PaginaAgro;
import com.example.rayanne.myapplication.R;

import static android.content.Intent.getIntent;

public class PagDescricao extends AppCompatActivity {
    //TODO: conferir o private (segurança) dos campos

    private DescricaoCursos DescricaoCursos = new DescricaoCursos();

    private TextView txtCurso;
    private TextView txtDuracao;
    private TextView txtVagas;
    private TextView txtModalidade;
    private TextView txtQuem;
    private TextView txtDesc;
    private TextView txtEtc;
    private ImageView imgCurso;
    private Button btnAgroMenu;
    private Button btnMaterias;
    private RatingBar rtBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_descricao);
        inicializar();
        pegaCurso();
    }

    private void inicializar() {
        txtCurso = findViewById(R.id.txtCurso);
        txtDuracao = findViewById(R.id.txtDuracao);
        txtVagas = findViewById(R.id.txtVagas);
        txtModalidade = findViewById(R.id.txtModalidade);
        txtQuem = findViewById(R.id.txtQuem);
        txtDesc = findViewById(R.id.txtDesc);
        txtEtc = findViewById(R.id.txtEtc);
        imgCurso = findViewById(R.id.imgCurso);
        btnAgroMenu = findViewById(R.id.btnAgroMenu);
        btnMaterias = findViewById(R.id.btnMaterias);
        rtBar = findViewById(R.id.rtBar);
        rtBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

            }
        });

    }

    private void paraAgro(){
        txtDuracao.setVisibility(View.GONE);
        txtVagas.setVisibility(View.GONE);
        txtModalidade.setVisibility(View.GONE);
        txtQuem.setVisibility(View.GONE);
        txtEtc.setVisibility(View.GONE);
        btnMaterias.setVisibility(View.GONE);
        rtBar.setVisibility(View.GONE);
        btnAgroMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nomeCurso = DescricaoCursos.nomeCursos[0];
                Intent intent = new Intent(PagDescricao.this, PaginaAgro.class);
                intent.putExtra("Curso", nomeCurso);
                startActivity(intent);
            }
        });

    }

    private void pegaCurso(){
        //Pega a intent de outra activity
        final Intent intent = getIntent();
        //Recuperei a string da outra activity
        String nomeCurso = intent.getStringExtra("Curso");
        Toast.makeText(PagDescricao.this, "Info: " + nomeCurso, Toast.LENGTH_SHORT).show();

        if (nomeCurso.equals(com.example.rayanne.myapplication.TesteVocacional.DescricaoCursos.getnomeCursos(0))){
            paraAgro();
        }

        else if (nomeCurso.equals(com.example.rayanne.myapplication.TesteVocacional.DescricaoCursos.getnomeCursos(1))){
            txtCurso.setText(com.example.rayanne.myapplication.TesteVocacional.DescricaoCursos.getnomeCursos(1));
            txtDesc.setText(com.example.rayanne.myapplication.TesteVocacional.DescricaoCursos.getdescricaoCursos(1));
            ocultarCampos();
            imgCurso.setBackgroundResource(R.drawable.tal);
            btnMaterias.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String nomeCurso = DescricaoCursos.nomeCursos[1];
                    Intent intent = new Intent(PagDescricao.this, MateriasAgro.class);
                    intent.putExtra("Curso", nomeCurso);
                    startActivity(intent);
                }
            });

        }

        else if (nomeCurso.equals(com.example.rayanne.myapplication.TesteVocacional.DescricaoCursos.getnomeCursos(2))){
            txtCurso.setText(com.example.rayanne.myapplication.TesteVocacional.DescricaoCursos.getnomeCursos(2));
            txtDesc.setText(com.example.rayanne.myapplication.TesteVocacional.DescricaoCursos.getdescricaoCursos(2));
            ocultarCampos();
            imgCurso.setBackgroundResource(R.drawable.ti);
            btnMaterias.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String nomeCurso = DescricaoCursos.nomeCursos[2];
                    Intent intent = new Intent(PagDescricao.this, MateriasAgro.class);
                    intent.putExtra("Curso", nomeCurso);
                    startActivity(intent);
                }
            });

        }

        else if (nomeCurso.equals(com.example.rayanne.myapplication.TesteVocacional.DescricaoCursos.getnomeCursos(3))){
            txtCurso.setText(com.example.rayanne.myapplication.TesteVocacional.DescricaoCursos.getnomeCursos(3));
            txtDesc.setText(com.example.rayanne.myapplication.TesteVocacional.DescricaoCursos.getdescricaoCursos(3));
            ocultarCampos();
            imgCurso.setBackgroundResource(R.drawable.tmb);
            btnMaterias.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String nomeCurso = DescricaoCursos.nomeCursos[3];
                    Intent intent = new Intent(PagDescricao.this, MateriasAgro.class);
                    intent.putExtra("Curso", nomeCurso);
                    startActivity(intent);
                }
            });

        }

        else if (nomeCurso.equals(com.example.rayanne.myapplication.TesteVocacional.DescricaoCursos.getnomeCursos(4))){
            txtCurso.setText(com.example.rayanne.myapplication.TesteVocacional.DescricaoCursos.getnomeCursos(4));
            txtDesc.setText(com.example.rayanne.myapplication.TesteVocacional.DescricaoCursos.getdescricaoCursos(4));
            ocultarCampos();
            imgCurso.setBackgroundResource(R.drawable.tz);
            btnMaterias.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    String nomeCurso = DescricaoCursos.nomeCursos[4];
                    Intent intent = new Intent(PagDescricao.this, MateriasAgro.class);
                    intent.putExtra("Curso", nomeCurso);
                    startActivity(intent);
                }
            });

        }else Toast.makeText(PagDescricao.this, "ERRO", Toast.LENGTH_SHORT).show();

    }

    private void ocultarCampos(){
        txtDuracao.setVisibility(View.VISIBLE);
        txtVagas.setVisibility(View.VISIBLE);
        txtModalidade.setVisibility(View.VISIBLE);
        txtQuem.setVisibility(View.VISIBLE);
        txtEtc.setVisibility(View.VISIBLE);
        btnAgroMenu.setVisibility(View.GONE);
        btnMaterias.setVisibility(View.VISIBLE);
    }

}
